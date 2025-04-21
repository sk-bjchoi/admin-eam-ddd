package com.sk.eadmin.biz.admin.adapter.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sk.eadmin.biz.admin.adapter.web.dto.tmf.TroubleTicketDTO;
import com.sk.eadmin.biz.admin.adapter.web.mapper.TroubleTicketMapper;
import com.sk.eadmin.biz.admin.application.dto.AddCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.ModifyCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.port.usecase.CustomerProblemCommandUsecase;
import com.sk.eadmin.biz.admin.port.usecase.CustomerProblemQueryUsecase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "trouble-ticket", description = "TMF621 Trouble Ticket Management API")
@RestController
@RequestMapping("/tmf-api/v1/customer/troubleTicket")
@RequiredArgsConstructor
public class CustomerProblemTMFController {
    
    private final CustomerProblemCommandUsecase customerProblemCommandUsecase;
    private final CustomerProblemQueryUsecase customerProblemQueryUsecase;

    @Operation(summary = "List or find TroubleTicket objects", 
              description = "List or find TroubleTicket objects")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Success"),
        @ApiResponse(responseCode = "400", description = "Bad Request"),
        @ApiResponse(responseCode = "401", description = "Unauthorized"),
        @ApiResponse(responseCode = "403", description = "Forbidden"),
        @ApiResponse(responseCode = "404", description = "Not Found"),
        @ApiResponse(responseCode = "405", description = "Method Not Allowed"),
        @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    @GetMapping
    public ResponseEntity<List<TroubleTicketDTO>> listTroubleTicket(
            @RequestParam(required = false) String fields,
            @RequestParam(required = false, defaultValue = "0") Integer offset,
            @RequestParam(required = false, defaultValue = "10") Integer limit) {
        
        CustomerProblemRegistInputDTO inputDTO = CustomerProblemRegistInputDTO.builder().build();
        return ResponseEntity.ok(
            customerProblemQueryUsecase.getCustomerProblemRegistList(inputDTO)
                .stream()
                .map(TroubleTicketMapper::toDTO)
                .collect(Collectors.toList())
        );
    }

    @Operation(summary = "Creates a TroubleTicket",
              description = "This operation creates a TroubleTicket entity.")
    @PostMapping
    public ResponseEntity<TroubleTicketDTO> createTroubleTicket(
            @RequestBody TroubleTicketDTO troubleTicket) {
        
        AddCustomerProblemRegistInputDTO inputDTO = AddCustomerProblemRegistInputDTO.builder()
            .customerName(troubleTicket.getName())
            .customerMobile(troubleTicket.getRelatedParties().get(0).getId())
            .requestDesc(troubleTicket.getDescription())
            .problemCode(troubleTicket.getType())
            .problemDegree(TroubleTicketMapper.mapSeverityToInt(troubleTicket.getSeverity()))
            .build();

        customerProblemCommandUsecase.addCustomerProblemRegist(inputDTO);
        
        return new ResponseEntity<>(troubleTicket, HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieves a TroubleTicket by ID",
              description = "This operation retrieves a TroubleTicket entity.")
    @GetMapping("/{id}")
    public ResponseEntity<TroubleTicketDTO> retrieveTroubleTicket(
            @PathVariable String id,
            @RequestParam(required = false) String fields) {
        
        CustomerProblemRegistDetailInfoOutputDTO detailDTO = customerProblemQueryUsecase.getCustomerProblemRegistDetail(Integer.parseInt(id));
        if (detailDTO == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(TroubleTicketMapper.toDTO(detailDTO));
    }

    @Operation(summary = "Updates partially a TroubleTicket",
              description = "This operation updates partially a TroubleTicket entity.")
    @PatchMapping("/{id}")
    public ResponseEntity<TroubleTicketDTO> patchTroubleTicket(
            @PathVariable String id,
            @RequestBody TroubleTicketDTO troubleTicket) {
        
        ModifyCustomerProblemRegistInputDTO inputDTO = ModifyCustomerProblemRegistInputDTO.builder()
            .registID(Integer.parseInt(id))
            .customerName(troubleTicket.getName())
            .customerMobile(troubleTicket.getRelatedParties().get(0).getId())
            .requestDesc(troubleTicket.getDescription())
            .problemCode(troubleTicket.getType())
            .problemDegree(TroubleTicketMapper.mapSeverityToInt(troubleTicket.getSeverity()))
            .build();

        customerProblemCommandUsecase.modifyCustomerProblemRegist(inputDTO);
        
        return ResponseEntity.ok(troubleTicket);
    }

    @Operation(summary = "Deletes a TroubleTicket",
              description = "This operation deletes a TroubleTicket entity.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTroubleTicket(@PathVariable String id) {
        customerProblemCommandUsecase.deleteCustomerProblemRegist(Integer.parseInt(id));
        return ResponseEntity.noContent().build();
    }
}
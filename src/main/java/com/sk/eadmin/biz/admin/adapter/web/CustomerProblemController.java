package com.sk.eadmin.biz.admin.adapter.web;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.eadmin.biz.admin.adapter.web.dto.CustomerProblemRegistDetailInfoResDTO;
import com.sk.eadmin.biz.admin.adapter.web.dto.CustomerProblemRegistReqDTO;
import com.sk.eadmin.biz.admin.adapter.web.dto.CustomerProblemRegistResDTO;
import com.sk.eadmin.biz.admin.application.dto.AddCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.ModifyCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.port.usecase.CustomerProblemCommandUsecase;
import com.sk.eadmin.biz.admin.port.usecase.CustomerProblemQueryUsecase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;

@Tag(name = "customer-problem", description = "고객문의")
@RestController
@RequestMapping("/api/v1/customer/problem-mgmt")
@RequiredArgsConstructor
public class CustomerProblemController {
  private final CustomerProblemCommandUsecase customerProblemCommandUsecase;
  private final CustomerProblemQueryUsecase customerProblemQueryUsecase;

  @Operation(summary = "고객접수문의 리스트 조회", description = "입력조건에 따라 접수된 고객 문의 리스트를 조회한다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
    }
  )
  @GetMapping("/customer-problem")
  public ResponseEntity<List<CustomerProblemRegistResDTO>> getCustomerProblemRegistList(
    @RequestParam(name = "problemCode", required = false)
    @Valid @Pattern(regexp = "^000[1-4]$")
    @Schema(
      description = "문의코드. 0001 - 사용요금관련, 0002 - 통화품질관련, 0003 - 대리점 서비스 관련, 0004 - 해외 로밍 관련",
      name = "problemCode",
      type = "string",
      example = "0001"
    )
    String problemCode,

    @RequestParam(name = "agentRegionCode", required = false)
    @Valid @Pattern(regexp = "^0[1-3]$")
    @Schema(
      description = "담당지역코드. 01 - 서울, 02 - 경기, 03 - 인천",
      name = "agentRegionCode",
      type = "string",
      example = "01"
    )
    String agentRegionCode,

    @RequestParam(name = "progressStatusCode", required = false)
    @Valid @Pattern(regexp = "^0[1-2]$")
    @Schema(
      description = "진행상태코드. 01 - 성공, 02 - 대기",
      name = "progressStatusCode",
      type = "string",
      example = "01"
    )
    String progressStatusCode,

    @Valid
    @Schema(
      description = "요청필터",
      name = "requestFilter",
      type = "string",
      example = "샘플"
    )
    @RequestParam(name = "requestFilter", required = false)
    String requestFilter
  ) {
	 return new ResponseEntity<List<CustomerProblemRegistResDTO>>(new ArrayList<CustomerProblemRegistResDTO>(), HttpStatus.OK);
  }

  @Operation(summary = "고객접수문의 상세 조회", description = "입력조건에 따라 접수된 고객 문의 상세 정보를 조회한다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "OK"),
      @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
    }
  )
  @GetMapping("/customer-problem/{id}")
  public ResponseEntity<CustomerProblemRegistDetailInfoResDTO> getCustomerProblemRegistDetail(
	@Schema(
	  description = "접수ID",
	  name = "id",
	  type = "number",
      example = "1371"
	)
	@PathVariable(name = "id") int registID
) {
    return new ResponseEntity<CustomerProblemRegistDetailInfoResDTO>(
      CustomerProblemRegistDetailInfoResDTO.builder()
        .customerProblemResistResDTO(null)
        .customerProblemMappingAgentResDTO(null).build(),
      HttpStatus.OK
    );
  }
  
  @Operation(summary = "고객접수문의 신규 등록", description = "입력조건에 따라 접수된 고객 문의 정보를 신규 등록 한다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "OK"),
      @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
    }
  )
  @PostMapping("/customer-problem")
  public ResponseEntity<Void> addCustomerProblemRegist(@RequestBody CustomerProblemRegistReqDTO req) {
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
  
  @Operation(summary = "고객접수문의 변경", description = "입력조건에 따라 접수된 고객 문의 정보를 변경 한다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "OK"),
      @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
    }
  )
  @PatchMapping("/customer-problem/{id}")
  public ResponseEntity<Void> modifyCustomerProblemRegist(
    @Schema(
	  description = "접수ID",
	  name = "id",
	  type = "number",
	  example = "1371"
	)
	@PathVariable(name = "id") int registID,
	@Valid @RequestBody CustomerProblemRegistReqDTO req
  ) {
	return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
  
  @Operation(summary = "고객접수문의 삭제", description = "입력조건에 따라 접수된 고객 문의 정보를 삭제한다.")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204", description = "OK"),
      @ApiResponse(responseCode = "403", description = "접속 권한이 없습니다.")
    }
  )
  @DeleteMapping("/customer-problem/{id}")
  public ResponseEntity<Void> deleteCustomerProblemRegist(
	@Schema(
	  description = "접수ID",
	  name = "id",
      type = "number",
      example = "1371"
	)
    @PathVariable(name = "id") int registID
  ) {
	  return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
  
}
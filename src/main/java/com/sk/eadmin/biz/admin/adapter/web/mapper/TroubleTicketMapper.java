package com.sk.eadmin.biz.admin.adapter.web.mapper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Collections;

import com.sk.eadmin.biz.admin.adapter.web.dto.tmf.RelatedPartyDTO;
import com.sk.eadmin.biz.admin.adapter.web.dto.tmf.TroubleTicketDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistOutputDTO;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemTicketEntity;
import com.sk.eadmin.biz.admin.domain.vo.ProblemDegreeVO;
import com.sk.eadmin.biz.admin.domain.vo.ProgressStatusVO;

public class TroubleTicketMapper {
    
    public static TroubleTicketDTO toDTO(CustomerProblemTicketEntity entity) {
        if (entity == null) {
            return null;
        }

        return TroubleTicketDTO.builder()
            .id(String.valueOf(entity.getRegistID()))
            .href("/tmf-api/v1/customer/troubleTicket/" + entity.getRegistID())
            .name(entity.getTicketCustomerInfo().getCustomerName())
            .description(entity.getRequestDescription())
            .severity(mapSeverity(entity.getProblemDegree()))
            .type(entity.getProblemCategory().name())
            .status(mapStatus(entity.getProgressStatus()))
            .creationDate(toOffsetDateTime(entity.getCreatedAt()))
            .relatedParties(Collections.singletonList(
                RelatedPartyDTO.builder()
                    .id(entity.getTicketCustomerInfo().getCustomerMobile())
                    .name(entity.getTicketCustomerInfo().getCustomerName())
                    .role("CUSTOMER")
                    .atType("RelatedParty")
                    .build()
            ))
            .atType("TroubleTicket")
            .build();
    }

    public static TroubleTicketDTO toDTO(CustomerProblemRegistOutputDTO dto) {
        if (dto == null) {
            return null;
        }

        return TroubleTicketDTO.builder()
            .id(dto.getRegId())
            .href("/tmf-api/v1/customer/troubleTicket/" + dto.getRegId())
            .name(dto.getCustNm())
            .description(dto.getReqDesc())
            .severity(mapSeverity(dto.getPrbmDgr()))
            .type(dto.getPrbmCd())
            .status(dto.getPrgsSts())
            .creationDate(toOffsetDateTime(dto.getCrteDttm().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()))
            .atType("TroubleTicket")
            .build();
    }

    public static TroubleTicketDTO toDTO(CustomerProblemRegistDetailInfoOutputDTO dto) {
        if (dto == null) {
            return null;
        }

        return TroubleTicketDTO.builder()
            .id(dto.getCustMbl())
            .href("/tmf-api/v1/customer/troubleTicket/" + dto.getCustMbl())
            .name(dto.getCustNm())
            .description(dto.getReqDesc())
            .severity(mapSeverity(dto.getPrbmDgr()))
            .type(dto.getPrbmCd())
            .status(dto.getPrgsSts())
            .creationDate(toOffsetDateTime(dto.getCrteDttm().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()))
            .atType("TroubleTicket")
            .build();
    }

    public static CustomerProblemTicketEntity toEntity(TroubleTicketDTO dto) {
        if (dto == null) {
            return null;
        }

        CustomerProblemTicketEntity entity = new CustomerProblemTicketEntity();
        entity.createNewTicket(
            dto.getDescription(),
            mapProblemCategory(dto.getType()),
            mapSeverityToInt(dto.getSeverity())
        );

        RelatedPartyDTO customer = dto.getRelatedParties().stream()
            .filter(party -> "CUSTOMER".equals(party.getRole()))
            .findFirst()
            .orElse(null);

        if (customer != null) {
            entity.addCustomerInfo(customer.getName(), customer.getId());
        }

        return entity;
    }

    private static String mapSeverity(ProblemDegreeVO degree) {
        int value = degree.getDegree();
        if (value >= 80) return "CRITICAL";
        if (value >= 60) return "HIGH";
        if (value >= 40) return "MEDIUM";
        return "LOW";
    }

    private static String mapSeverity(int degree) {
        if (degree >= 80) return "CRITICAL";
        if (degree >= 60) return "HIGH";
        if (degree >= 40) return "MEDIUM";
        return "LOW";
    }

    public static int mapSeverityToInt(String severity) {
        switch (severity.toUpperCase()) {
            case "CRITICAL": return 90;
            case "HIGH": return 70;
            case "MEDIUM": return 50;
            case "LOW": return 30;
            default: return 10;
        }
    }

    private static String mapStatus(ProgressStatusVO status) {
        switch (status) {
            case PROGRESS_SUCCESS: return "resolved";
            case PROGRESS_HOLD: return "pending";
            case PROGRESS_COMPLETE: return "completed";
            default: return "acknowledged";
        }
    }

    private static String mapProblemCategory(String type) {
        // 기존 시스템의 문제 카테고리 코드로 매핑
        // 실제 구현시에는 더 상세한 매핑 로직이 필요할 수 있습니다
        return type;
    }

    private static OffsetDateTime toOffsetDateTime(LocalDateTime localDateTime) {
        return localDateTime != null ? localDateTime.atZone(ZoneId.systemDefault()).toOffsetDateTime() : null;
    }
} 
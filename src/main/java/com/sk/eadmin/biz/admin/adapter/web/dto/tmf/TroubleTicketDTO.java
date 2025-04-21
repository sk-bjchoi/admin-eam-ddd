package com.sk.eadmin.biz.admin.adapter.web.dto.tmf;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class TroubleTicketDTO {
    private String id;
    private String href;
    private String name;
    private String description;
    private String severity;
    private String type;
    private String status;
    private OffsetDateTime creationDate;
    private OffsetDateTime targetResolutionDate;
    private OffsetDateTime resolutionDate;
    private String statusChangeReason;
    private OffsetDateTime statusChangeDate;
    
    @JsonProperty("relatedParty")
    private List<RelatedPartyDTO> relatedParties;
    
    @JsonProperty("note")
    private List<NoteDTO> notes;
    
    @JsonProperty("@type")
    private String atType;
    
    @JsonProperty("@baseType")
    private String atBaseType;
    
    @JsonProperty("@schemaLocation")
    private String atSchemaLocation;
} 
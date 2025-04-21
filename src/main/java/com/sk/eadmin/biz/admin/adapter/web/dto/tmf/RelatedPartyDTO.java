package com.sk.eadmin.biz.admin.adapter.web.dto.tmf;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class RelatedPartyDTO {
    private String id;
    private String href;
    private String name;
    private String role;
    
    @JsonProperty("@type")
    private String atType;
    
    @JsonProperty("@baseType") 
    private String atBaseType;
    
    @JsonProperty("@schemaLocation")
    private String atSchemaLocation;
} 
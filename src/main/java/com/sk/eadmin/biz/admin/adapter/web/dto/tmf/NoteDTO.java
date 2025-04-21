package com.sk.eadmin.biz.admin.adapter.web.dto.tmf;

import java.time.OffsetDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Builder;

@Data
@Builder
public class NoteDTO {
    private String id;
    private String author;
    private OffsetDateTime date;
    private String text;
    
    @JsonProperty("@type")
    private String atType;
    
    @JsonProperty("@baseType")
    private String atBaseType;
    
    @JsonProperty("@schemaLocation")
    private String atSchemaLocation;
} 
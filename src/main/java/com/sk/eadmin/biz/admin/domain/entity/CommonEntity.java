package com.sk.eadmin.biz.admin.domain.entity;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public abstract class CommonEntity {
    private String createdBy = "test";
    private LocalDateTime createdAt;
    private String updatedBy = "test";
    private LocalDateTime updatedAt;
}

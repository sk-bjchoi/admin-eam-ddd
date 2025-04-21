package com.sk.eadmin.biz.admin.domain.vo;

import com.sk.eadmin.common.code.CodeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AgentRegionVO implements CodeEnum {
	REGION_SEOUL		("01", "서울"),
	REGION_GYEONGGI		("02", "경기"),
	REGION_INCHEON		("03", "인천");

    private final String code;
    private final String desc;
}

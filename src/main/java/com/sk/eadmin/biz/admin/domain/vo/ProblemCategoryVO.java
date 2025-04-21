package com.sk.eadmin.biz.admin.domain.vo;

import com.sk.eadmin.common.code.CodeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProblemCategoryVO implements CodeEnum {
	CUSTOMER_BILLING		("0001", "사용 요금 관련"),
	CALL_QUALITY			("0002", "통화 품질 관련"),
	AGENCY_SERVICE			("0003", "대리점 서비스 관련"),
	INTERNATIONAL_ROAMING	("0004", "해외 로밍 관련");
	
    private final String code;
    private final String desc;

}



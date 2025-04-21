package com.sk.eadmin.biz.admin.domain.vo;

import com.sk.eadmin.common.code.CodeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProgressStatusVO implements CodeEnum {
	PROGRESS_SUCCESS	("01", "Success"),
	PROGRESS_HOLD		("02", "Hold"),
	PROGRESS_COMPLETE	("03", "Complete");
	
    private final String code;
    private final String desc;

}


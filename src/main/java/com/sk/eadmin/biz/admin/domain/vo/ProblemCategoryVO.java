package com.sk.eadmin.biz.admin.domain.vo;

import com.sk.eadmin.common.code.CodeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProblemCategoryVO implements CodeEnum  {
	TO_DO				("", "");
	
    private final String code;
    private final String desc;

}



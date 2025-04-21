package com.sk.eadmin.biz.admin.domain.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProblemDegreeVO {
	
    private Integer degree;
    private Integer digit;
    private String UOM;
    
    public ProblemDegreeVO(Integer degree) {
        this.degree = degree;
        this.digit = 0;
        this.UOM = "Percent";
    }

}


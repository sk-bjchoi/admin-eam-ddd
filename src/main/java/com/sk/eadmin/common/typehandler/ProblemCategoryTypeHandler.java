package com.sk.eadmin.common.typehandler;

import org.apache.ibatis.type.MappedTypes;

import com.sk.eadmin.biz.admin.domain.vo.ProblemCategoryVO;

@MappedTypes(ProblemCategoryVO.class)
public class ProblemCategoryTypeHandler extends CodeEnumTypeHandler<ProblemCategoryVO> {
    public ProblemCategoryTypeHandler() {
        super(ProblemCategoryVO.class);
    }
}

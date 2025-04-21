package com.sk.eadmin.common.typehandler;

import org.apache.ibatis.type.MappedTypes;

import com.sk.eadmin.biz.admin.domain.vo.ProgressStatusVO;

@MappedTypes(ProgressStatusVO.class)
public class ProgressStatusTypeHandler extends CodeEnumTypeHandler<ProgressStatusVO> {
    public ProgressStatusTypeHandler() {
        super(ProgressStatusVO.class);
    }
}

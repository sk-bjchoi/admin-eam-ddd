package com.sk.eadmin.common.typehandler;

import org.apache.ibatis.type.MappedTypes;

import com.sk.eadmin.biz.admin.domain.vo.AgentRegionVO;

@MappedTypes(AgentRegionVO.class)
public class AgentRegionTypeHandler extends CodeEnumTypeHandler<AgentRegionVO> {
    public AgentRegionTypeHandler() {
        super(AgentRegionVO.class);
    }
}

package com.sk.eadmin.biz.admin.domain.entity;

import com.sk.eadmin.biz.admin.domain.entity.tmf.TMFParty;
import com.sk.eadmin.biz.admin.domain.vo.AgentRegionVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerProblemAgentEntity {
	private String toDo;
}

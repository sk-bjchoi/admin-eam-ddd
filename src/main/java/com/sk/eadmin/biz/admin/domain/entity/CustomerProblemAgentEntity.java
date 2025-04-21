package com.sk.eadmin.biz.admin.domain.entity;

import com.sk.eadmin.biz.admin.domain.entity.tmf.TMFParty;
import com.sk.eadmin.biz.admin.domain.vo.AgentRegionVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerProblemAgentEntity extends TMFParty {
	private String agentID;
	private String agentName;
	private AgentRegionVO agentRegion;
	private String agentIcon;
	
	public void checkAgentAvailable() {
		// To-Do ...
	}

}

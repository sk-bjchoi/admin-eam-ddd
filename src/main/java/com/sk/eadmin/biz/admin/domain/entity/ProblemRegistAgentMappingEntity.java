package com.sk.eadmin.biz.admin.domain.entity;

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
public class ProblemRegistAgentMappingEntity extends CommonEntity {
	private long registID;
	private String agentID;
	private long taskProgressRate;
	
	public void addNewMapping() {
		// To-Do ...
	}

}

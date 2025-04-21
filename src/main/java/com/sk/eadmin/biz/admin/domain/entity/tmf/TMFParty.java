package com.sk.eadmin.biz.admin.domain.entity.tmf;

import java.util.List;

import com.sk.eadmin.biz.admin.domain.entity.CommonEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public abstract class TMFParty extends CommonEntity {
	private String PartyID;
	private List<String> PartyyRoleID;
	
	public void checkParyRole() {
		// To-Do...
	}
}

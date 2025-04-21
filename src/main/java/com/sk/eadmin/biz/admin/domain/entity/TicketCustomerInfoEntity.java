package com.sk.eadmin.biz.admin.domain.entity;

import com.sk.eadmin.common.exception.DomainException;
import com.sk.eadmin.common.exception.ErrorCode;

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
public class TicketCustomerInfoEntity extends CommonEntity {
	private String customerName;
	private String customerMobile;
	
	public void checkValidateCustomerMobile() {
		if (!this.customerMobile.substring(0, 3).equals("010"))
			throw new DomainException(ErrorCode.INVALID_CUSTOMER_MOBILE);
	}

}

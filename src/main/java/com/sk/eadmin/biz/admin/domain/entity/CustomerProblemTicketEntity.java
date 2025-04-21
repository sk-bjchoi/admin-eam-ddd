package com.sk.eadmin.biz.admin.domain.entity;

import java.util.List;

import com.sk.eadmin.biz.admin.domain.vo.ProblemCategoryVO;
import com.sk.eadmin.biz.admin.domain.vo.ProblemDegreeVO;
import com.sk.eadmin.biz.admin.domain.vo.ProgressStatusVO;
import com.sk.eadmin.common.code.CodeEnumUtils;
import com.sk.eadmin.common.exception.DomainException;
import com.sk.eadmin.common.exception.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProblemTicketEntity extends CommonEntity {
	private Long registID;
	private TicketCustomerInfoEntity ticketCustomerInfo;
	private String requestDescription;
	private ProblemCategoryVO problemCategory;
	private ProblemDegreeVO problemDegree;
	private ProgressStatusVO progressStatus;
	private List<String> agentID;

	private static final int HIGH_PRIORITY_THRESHOLD = 70;
	
	public void createNewTicket(String requestDescription, String problemCategoryCode, int problemDegree) {
		this.requestDescription 	= requestDescription;
		this.problemCategory 		= CodeEnumUtils.fromCode(ProblemCategoryVO.class, problemCategoryCode);
		this.problemDegree 			= new ProblemDegreeVO(problemDegree);
		this.progressStatus 		= ProgressStatusVO.PROGRESS_SUCCESS;
	}
	
	public void addCustomerInfo(String customerName, String customerMobile) {
		TicketCustomerInfoEntity custInfo = TicketCustomerInfoEntity.builder()
				.customerName(customerName)
				.customerMobile(customerMobile)
				.build();
		
		// 유효한 고객 핸드폰 번호 여부 체크
		custInfo.checkValidateCustomerMobile();
		
		this.ticketCustomerInfo = custInfo;
	}
	
	public void createUpdateDummyTicket(Long registID, String requestDescription, String problemCategoryCode, int problemDegree) {
		this.registID 				= registID;
		this.requestDescription 	= requestDescription;
		this.problemCategory 		= CodeEnumUtils.fromCode(ProblemCategoryVO.class, problemCategoryCode);
		this.problemDegree 			= new ProblemDegreeVO(problemDegree);
	}
	
	public void checkTicketUpdatable() {
		if(this.progressStatus == ProgressStatusVO.PROGRESS_COMPLETE) 
			throw new DomainException(ErrorCode.CANNOT_UPDATE_TICKET);
	}
	
	public void checkTicketDeletable() {
		if(this.progressStatus == ProgressStatusVO.PROGRESS_COMPLETE) 
			throw new DomainException(ErrorCode.CANNOT_DELETE_TICKET);
	}

    public boolean requiresWarningNotification(int threshold) {
        return (threshold > HIGH_PRIORITY_THRESHOLD);
    }

}

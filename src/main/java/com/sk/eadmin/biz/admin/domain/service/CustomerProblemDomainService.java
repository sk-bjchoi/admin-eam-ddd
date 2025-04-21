package com.sk.eadmin.biz.admin.domain.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemAgentEntity;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemTicketEntity;
import com.sk.eadmin.common.exception.DomainException;
import com.sk.eadmin.common.exception.ErrorCode;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class CustomerProblemDomainService {
	
	public void isTicketReceivable
		(List<CustomerProblemTicketEntity> sameMobileTickets, List<CustomerProblemAgentEntity> availableAgents) {
		// 같은 핸드폰 번호로의 접수 건이 있다면 중복 티켓 에러 
		if(!sameMobileTickets.isEmpty())
			throw new DomainException(ErrorCode.DUPLICATE_TICKET);
		
		// 가용한 담당자가 3명 미만이라면 처리가능 상담원 부족 에러
		if(availableAgents.size() < 3)
			throw new DomainException(ErrorCode.NO_AVAILABLE_AGENT);
	}

}


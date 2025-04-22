package com.sk.eadmin.biz.admin.port.repository;

import java.util.List;
import java.util.Optional;

import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemAgentEntity;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemTicketEntity;

public interface CustomerProblemCommandRepository {
	// uc01-01 고객문의접수 신규 등록	
	void save(CustomerProblemTicketEntity entity);
	
	// uc01-02 고객문의접수 변경
	void update(CustomerProblemTicketEntity entity);
	
	// uc01-03 고객문의접수 삭제
	void delete(Long id);

	// req-02 티켓 접수 가능한 상태인지 체크
	// 동일한 핸드폰 번호로 접수된 티켓이 있는지 체크
	List<CustomerProblemTicketEntity> findCustomerProblemTicketByCustomerMobile(String mobile);
	// 업무 처리가능한 상담원 체크
	List<CustomerProblemAgentEntity> findAvailableAgent();

	// req-04 티켓 수정/삭제 가능한 상태인지 체크
	// 고객문의접수 티켓을 수정 or 삭제하기 위해 기존 저장되어 있는 정보 Load
	Optional<CustomerProblemTicketEntity> findCustomerProblemTicketById(Long id);

}

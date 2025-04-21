package com.sk.eadmin.biz.admin.port.repository;

import java.util.List;
import java.util.Optional;

import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemAgentEntity;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemTicketEntity;

public interface CustomerProblemCommandRepository {
	
	Optional<CustomerProblemTicketEntity> findCustomerProblemTicketById(Long id);
	List<CustomerProblemTicketEntity> findCustomerProblemTicketByCustomerMobile(String mobile);
	List<CustomerProblemAgentEntity> findAvailableAgent();
	
	void save(CustomerProblemTicketEntity entity);
	void update(CustomerProblemTicketEntity entity);
	void delete(Long id);
}

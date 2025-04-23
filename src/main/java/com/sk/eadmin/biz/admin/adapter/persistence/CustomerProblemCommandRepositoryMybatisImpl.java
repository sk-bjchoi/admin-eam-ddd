package com.sk.eadmin.biz.admin.adapter.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sk.eadmin.biz.admin.adapter.persistence.mapper.CustomerProblemCommandMapper;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemAgentEntity;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemTicketEntity;
import com.sk.eadmin.biz.admin.port.repository.CustomerProblemCommandRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerProblemCommandRepositoryMybatisImpl implements CustomerProblemCommandRepository {
	private final CustomerProblemCommandMapper customerProblemCommandMapper;
	
	@Override
	public Optional<CustomerProblemTicketEntity> findCustomerProblemTicketById(Long id) {
		return null;
	}

	@Override
	public List<CustomerProblemTicketEntity> findCustomerProblemTicketByCustomerMobile(String mobile) {
		return null;
	}

	@Override
	public List<CustomerProblemAgentEntity> findAvailableAgent() {
		return null;
	}

	@Override
	public void save(CustomerProblemTicketEntity entity) {
	}
	
	@Override
	public void update(CustomerProblemTicketEntity entity) {
	}
	
	@Override
	public void delete(Long id) {
	}

}

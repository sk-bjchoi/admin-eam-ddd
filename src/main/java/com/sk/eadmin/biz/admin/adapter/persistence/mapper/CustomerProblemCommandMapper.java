package com.sk.eadmin.biz.admin.adapter.persistence.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemAgentEntity;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemTicketEntity;


@Mapper
public interface CustomerProblemCommandMapper {
	
	int addCustomerProblemRegist(CustomerProblemTicketEntity param);
	int modifyCustomerProblemRegist(CustomerProblemTicketEntity param);
	int deleteCustomerProblemRegist(Long id);
	
	Optional<CustomerProblemTicketEntity> findCustomerProblemTicketById(Long id);
	List<CustomerProblemTicketEntity> findCustomerProblemTicketByCustomerMobile(String mobile);
	List<CustomerProblemAgentEntity> findAvailableAgent();
	
}

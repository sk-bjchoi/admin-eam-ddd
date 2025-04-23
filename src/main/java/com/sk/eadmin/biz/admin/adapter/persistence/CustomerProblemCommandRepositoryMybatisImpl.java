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
}

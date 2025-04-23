package com.sk.eadmin.biz.admin.adapter.persistence;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sk.eadmin.biz.admin.adapter.persistence.mapper.CustomerProblemQueryMapper;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemMappingAgentMapperOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistMapperInputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistMapperOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistOutputDTO;
import com.sk.eadmin.biz.admin.port.repository.CustomerProblemQueryRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomerProblemQueryRepositoryMybatisImpl implements CustomerProblemQueryRepository {
	private final CustomerProblemQueryMapper customerProblemQueryMapper;
}

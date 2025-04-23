package com.sk.eadmin.biz.admin.application;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sk.eadmin.biz.admin.application.dto.AddCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.ModifyCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemAgentEntity;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemTicketEntity;
import com.sk.eadmin.biz.admin.domain.service.CustomerProblemDomainService;
import com.sk.eadmin.biz.admin.port.external.ExternalAgentInterface;
import com.sk.eadmin.biz.admin.port.repository.CustomerProblemCommandRepository;
import com.sk.eadmin.biz.admin.port.usecase.CustomerProblemCommandUsecase;
import com.sk.eadmin.common.exception.DomainException;
import com.sk.eadmin.common.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProblemCommandUsecaseImpl implements CustomerProblemCommandUsecase {
	
	private final CustomerProblemCommandRepository customerProblemCommandRepository;
	private final CustomerProblemDomainService customerProblemDomainService;
	private final ExternalAgentInterface externalAgentInterface;
}

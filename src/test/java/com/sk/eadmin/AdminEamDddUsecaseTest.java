package com.sk.eadmin;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sk.eadmin.biz.admin.application.CustomerProblemCommandUsecaseImpl;
import com.sk.eadmin.biz.admin.application.dto.AddCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemAgentEntity;
import com.sk.eadmin.biz.admin.domain.entity.CustomerProblemTicketEntity;
import com.sk.eadmin.biz.admin.domain.service.CustomerProblemDomainService;
import com.sk.eadmin.biz.admin.domain.vo.AgentRegionVO;
import com.sk.eadmin.biz.admin.port.external.ExternalAgentInterface;
import com.sk.eadmin.biz.admin.port.repository.CustomerProblemCommandRepository;
import com.sk.eadmin.common.exception.DomainException;


@ExtendWith(MockitoExtension.class)
class AdminEamDddUsecaseTest {

    @Mock
    private CustomerProblemCommandRepository repository;
    
    @Mock
    private ExternalAgentInterface extInterface;

    private CustomerProblemDomainService domainService = new CustomerProblemDomainService();

    private CustomerProblemCommandUsecaseImpl usecase;

    @BeforeEach
    void setUp() {
        usecase = new CustomerProblemCommandUsecaseImpl(repository, domainService, extInterface);
    }

    @Test
    void addCustomerProblemRegist_정상() {
        // Given

        // When

        // Then
    }

    @Test
    void addCustomerProblemRegist_중복티켓_예외발생() {
        // Given

        // When & Then
    }

    @Test
    void addCustomerProblemRegist_가용에이전트부족_예외발생() {
        // Given

        // When & Then
    }
}

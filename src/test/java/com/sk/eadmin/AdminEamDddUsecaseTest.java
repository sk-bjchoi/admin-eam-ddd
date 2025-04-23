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
        AddCustomerProblemRegistInputDTO dto = AddCustomerProblemRegistInputDTO.builder()
                .customerMobile("01012345678")
                .customerName("홍길동")
                .requestDesc("앱이 자꾸 꺼져요")
                .problemCode("0001")
                .problemDegree(80)
                .build();

        when(repository.findCustomerProblemTicketByCustomerMobile("01012345678"))
                .thenReturn(Collections.emptyList());

        List<CustomerProblemAgentEntity> availableAgents = List.of(
                new CustomerProblemAgentEntity("AG-01", "Agent1", AgentRegionVO.REGION_SEOUL, "1"),
                new CustomerProblemAgentEntity("AG-02", "Agent2", AgentRegionVO.REGION_SEOUL, "1"),
                new CustomerProblemAgentEntity("AG-03", "Agent3", AgentRegionVO.REGION_SEOUL, "1")
        );
        when(repository.findAvailableAgent()).thenReturn(availableAgents);

        // When
        usecase.addCustomerProblemRegist(dto);

        // Then
        verify(repository).save(any(CustomerProblemTicketEntity.class));
    }

    @Test
    void addCustomerProblemRegist_중복티켓_예외발생() {
        // Given
        AddCustomerProblemRegistInputDTO dto = AddCustomerProblemRegistInputDTO.builder()
                .customerMobile("01012345678")
                .customerName("홍길동")
                .requestDesc("앱이 자꾸 꺼져요")
                .problemCode("0001")
                .problemDegree(80)
                .build();
        
        CustomerProblemTicketEntity testEntity = new CustomerProblemTicketEntity();
        testEntity.createNewTicket("그냥 이상해요....", "0001", 50);
        testEntity.addCustomerInfo("홍길동", "01012345678");

        List<CustomerProblemTicketEntity> sameMobileTickets = List.of(testEntity);
        
        // 동일한 핸드 번호로 되어 있는 티켓을 등록하러 하여서 정책 위반
        when(repository.findCustomerProblemTicketByCustomerMobile("01012345678"))
                .thenReturn(sameMobileTickets);

        when(repository.findAvailableAgent()).thenReturn(List.of(
        		new CustomerProblemAgentEntity("AG-01", "Agent1", AgentRegionVO.REGION_SEOUL, "1"),
                new CustomerProblemAgentEntity("AG-02", "Agent2", AgentRegionVO.REGION_SEOUL, "1"),
                new CustomerProblemAgentEntity("AG-03", "Agent3", AgentRegionVO.REGION_SEOUL, "1")
        ));

        // When & Then
        assertThrows(DomainException.class, () -> usecase.addCustomerProblemRegist(dto));
        verify(repository, never()).save(any());
    }

    @Test
    void addCustomerProblemRegist_가용에이전트부족_예외발생() {
        // Given
        AddCustomerProblemRegistInputDTO dto = AddCustomerProblemRegistInputDTO.builder()
                .customerMobile("01000000000")
                .customerName("고객")
                .requestDesc("화면이 안 떠요")
                .problemCode("0001")
                .problemDegree(90)
                .build();

        when(repository.findCustomerProblemTicketByCustomerMobile("01000000000"))
                .thenReturn(Collections.emptyList());

        // agent가 2명뿐이라서 정책 위반
        when(repository.findAvailableAgent()).thenReturn(List.of(
        		new CustomerProblemAgentEntity("AG-01", "Agent1", AgentRegionVO.REGION_SEOUL, "1"),
                new CustomerProblemAgentEntity("AG-02", "Agent2", AgentRegionVO.REGION_SEOUL, "1")
        ));

        // When & Then
        assertThrows(DomainException.class, () -> usecase.addCustomerProblemRegist(dto));
        verify(repository, never()).save(any());
    }
}

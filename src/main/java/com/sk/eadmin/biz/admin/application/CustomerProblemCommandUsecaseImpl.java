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

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProblemCommandUsecaseImpl implements CustomerProblemCommandUsecase {
	
	private final CustomerProblemCommandRepository customerProblemCommandRepository;
	private final CustomerProblemDomainService customerProblemDomainService;
	private final ExternalAgentInterface externalAgentInterface;
	
	@Override
	public void addCustomerProblemRegist(AddCustomerProblemRegistInputDTO param) {
		
		// 1. Ticket 접수 가능 상태 확인
		List<CustomerProblemTicketEntity> sameMobileTickets 
				= customerProblemCommandRepository.findCustomerProblemTicketByCustomerMobile(param.getCustomerMobile());
		List<CustomerProblemAgentEntity> availableAgents
				= customerProblemCommandRepository.findAvailableAgent();
		customerProblemDomainService.isTicketReceivable(sameMobileTickets, availableAgents);
		
		
		// 2. Ticket Entity 생성 
		CustomerProblemTicketEntity entity = new CustomerProblemTicketEntity();
		entity.createNewTicket(param.getRequestDesc(), param.getProblemCode(), param.getProblemDegree());
		entity.addCustomerInfo(param.getCustomerName(), param.getCustomerMobile());
		
		// 3. DB에 저장
		customerProblemCommandRepository.save(entity);
		
		// 4. 불만정도가 70이 넘으면 담당에게 알람
		if(entity.requiresWarningNotification(
			externalAgentInterface.checkCustomerProblemDegree(
				param.getProblemDegree(), param.getRequestDesc(), param.getProblemCode()
			)
		)) {
			externalAgentInterface.sendWarningMessage();
		}
	}
	
	@Override
	public void modifyCustomerProblemRegist(ModifyCustomerProblemRegistInputDTO param) {
		Long regId = Long.valueOf(param.getRegistID());
		
		Optional<CustomerProblemTicketEntity> entity = customerProblemCommandRepository.findCustomerProblemTicketById(regId);
		entity.ifPresent(ticket -> ticket.checkTicketUpdatable());

		
		CustomerProblemTicketEntity updateEntity = new CustomerProblemTicketEntity();
		updateEntity.createUpdateDummyTicket(regId, param.getRequestDesc(), param.getProblemCode(), param.getProblemDegree());
		updateEntity.addCustomerInfo(param.getCustomerName(), param.getCustomerMobile());
		
		customerProblemCommandRepository.update(updateEntity);
		
	}
	
	@Override
	public void deleteCustomerProblemRegist(Integer registID) {
		Long regId = Long.valueOf(registID);
		
		Optional<CustomerProblemTicketEntity> entity = customerProblemCommandRepository.findCustomerProblemTicketById(regId);
		entity.ifPresent(ticket -> ticket.checkTicketDeletable());
		
		customerProblemCommandRepository.delete(regId);
	}
}

package com.sk.eadmin.biz.admin.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistOutputDTO;
import com.sk.eadmin.biz.admin.port.repository.CustomerProblemQueryRepository;
import com.sk.eadmin.biz.admin.port.usecase.CustomerProblemQueryUsecase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerProblemQueryUsecaseImpl implements CustomerProblemQueryUsecase {
	
	private final CustomerProblemQueryRepository customerProblemQueryRepository;
	
	@Override
	public List<CustomerProblemRegistOutputDTO> getCustomerProblemRegistList(CustomerProblemRegistInputDTO param) {
		return customerProblemQueryRepository.getCustomerProblemRegistList(param);
	}
	
	@Override
	public CustomerProblemRegistDetailInfoOutputDTO getCustomerProblemRegistDetail(Integer registID) {
		return customerProblemQueryRepository.getCustomerProblemRegistDetail(registID);
	}
}

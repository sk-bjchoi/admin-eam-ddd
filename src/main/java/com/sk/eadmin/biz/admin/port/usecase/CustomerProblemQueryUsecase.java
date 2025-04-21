package com.sk.eadmin.biz.admin.port.usecase;

import java.util.List;

import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistOutputDTO;

public interface CustomerProblemQueryUsecase {
	// uc01-04 고객접수문의 리스트 조회
	// Input Parameter : CustomerProblemRegistInputDTO (고객접수문의 리스트 조회 입력 파라미터)	
	// Output Parameter : List<CustomerProblemRegistOutputDTO> (고객접수문의 리스트 조회 출력 파라미터)
	public List<CustomerProblemRegistOutputDTO> getCustomerProblemRegistList(CustomerProblemRegistInputDTO param);
	
	// uc01-05 고객접수문의 상세 조회
	// Input Parameter : registID (고객접수문의 아이디)
	// Output Parameter : CustomerProblemRegistDetailInfoOutputDTO (고객접수문의 상세 조회 출력 파라미터)
	public CustomerProblemRegistDetailInfoOutputDTO getCustomerProblemRegistDetail(Integer registID);
}

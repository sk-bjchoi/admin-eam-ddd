package com.sk.eadmin.biz.admin.port.usecase;

import com.sk.eadmin.biz.admin.application.dto.AddCustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.ModifyCustomerProblemRegistInputDTO;

public interface CustomerProblemCommandUsecase {
	// uc01-01 고객접수문의 신규 등록
	// Input Parameter : AddCustomerProblemRegistInputDTO (고객접수문의 신규 등록 입력 파라미터)
	public void addCustomerProblemRegist(AddCustomerProblemRegistInputDTO param);
	
	// uc01-02 고객접수문의 변경
	// Input Parameter : ModifyCustomerProblemRegistInputDTO (고객접수문의 변경 입력 파라미터)
	public void modifyCustomerProblemRegist(ModifyCustomerProblemRegistInputDTO param);
	
	// uc01-03 고객접수문의 삭제
	// Input Parameter : registID (고객접수문의 아이디)	
	public void deleteCustomerProblemRegist(Integer registID);
}

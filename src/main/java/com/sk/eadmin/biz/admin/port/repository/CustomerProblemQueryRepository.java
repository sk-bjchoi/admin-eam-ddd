package com.sk.eadmin.biz.admin.port.repository;

import java.util.List;

import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistDetailInfoOutputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistInputDTO;
import com.sk.eadmin.biz.admin.application.dto.CustomerProblemRegistOutputDTO;

public interface CustomerProblemQueryRepository {
	List<CustomerProblemRegistOutputDTO> getCustomerProblemRegistList(CustomerProblemRegistInputDTO param);
	CustomerProblemRegistDetailInfoOutputDTO getCustomerProblemRegistDetail(int registID);
}

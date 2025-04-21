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

	@Override
	public List<CustomerProblemRegistOutputDTO> getCustomerProblemRegistList(CustomerProblemRegistInputDTO input) {
	    final CustomerProblemRegistMapperInputDTO mapperInput = CustomerProblemRegistMapperInputDTO.builder()
	    	.problemCode(input.getProblemCode())
	    	.agentRegionCode(input.getAgentRegionCode())
	    	.progressStatusCode(input.getProgressStatusCode())
	    	.requestDesc(input.getRequestDesc())
	        .build();
		final List<CustomerProblemRegistMapperOutputDTO> mapperResults = customerProblemQueryMapper.getCustomerProblemRegistList(mapperInput);
		List<CustomerProblemRegistOutputDTO> retList = new ArrayList<CustomerProblemRegistOutputDTO>();
		for (CustomerProblemRegistMapperOutputDTO mapperResult: mapperResults) {
			final CustomerProblemRegistOutputDTO ret = CustomerProblemRegistOutputDTO.builder()
				.regId(mapperResult.getRegId()) 
			    .custNm(mapperResult.getCustNm())
				.crteDttm(mapperResult.getCrteDttm())
				.agntIcn(mapperResult.getAgntIcn())
				.prbmDgr(mapperResult.getPrbmDgr())
				.prgsSts(mapperResult.getPrgsSts()).build();
			retList.add(ret);
		}
	    return retList;
	}

	@Override
	public CustomerProblemRegistDetailInfoOutputDTO getCustomerProblemRegistDetail(int registID) {
		final CustomerProblemRegistMapperOutputDTO problemRegistMapperOutput = customerProblemQueryMapper.getCustomerProblemRegistDetail(registID);
		final List<CustomerProblemMappingAgentMapperOutputDTO> customerProblemMappingAgents = customerProblemQueryMapper.getCustomerProblemMappingAgentList(registID);
		final List<CustomerProblemRegistDetailInfoOutputDTO.Agent> agents = new ArrayList<CustomerProblemRegistDetailInfoOutputDTO.Agent>();
		for (CustomerProblemMappingAgentMapperOutputDTO customerProblemMappingAgent: customerProblemMappingAgents) {
		  final CustomerProblemRegistDetailInfoOutputDTO.Agent retAgent = CustomerProblemRegistDetailInfoOutputDTO.Agent.builder()
		    .agntNm(customerProblemMappingAgent.getAgntNm())
		    .agntRegnCd(customerProblemMappingAgent.getAgntRegnCd())
		    .agentRegnVal(customerProblemMappingAgent.getAgentRegnVal())
			.build();
		  agents.add(retAgent);
		}
	    final CustomerProblemRegistDetailInfoOutputDTO ret = CustomerProblemRegistDetailInfoOutputDTO.builder()
		  .custNm(problemRegistMapperOutput.getCustNm())
		  .reqDesc(problemRegistMapperOutput.getReqDesc())
		  .custMbl(problemRegistMapperOutput.getCustMbl())
		  .prgsSts(problemRegistMapperOutput.getPrgsSts())
		  .prgsStsVal(problemRegistMapperOutput.getPrgsSts())
		  .crteDttm(problemRegistMapperOutput.getCrteDttm())
		  .prbmCd(problemRegistMapperOutput.getPrbmCd())
		  .custPrbm(problemRegistMapperOutput.getCustPrbm())
	      .prbmDgr(problemRegistMapperOutput.getPrbmDgr())
	      .agents(agents).build();
	    return ret;
	}

}

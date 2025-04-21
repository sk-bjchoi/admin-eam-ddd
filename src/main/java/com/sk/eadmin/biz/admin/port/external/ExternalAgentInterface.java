package com.sk.eadmin.biz.admin.port.external;

public interface ExternalAgentInterface {
	Integer checkCustomerProblemDegree(Integer problemDegree, String requestDesc, String problemCode);
	void sendWarningMessage();
}

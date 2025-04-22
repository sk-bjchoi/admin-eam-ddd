package com.sk.eadmin.biz.admin.port.external;

public interface ExternalAgentInterface {
	// req-03 불만 심각도 체크 후 알람 전송
	// EXT-API-01 AI 불만 심각도 체크
	// Input Parameter : problemDegree (고객 불만 정도), requestDesc (요청 상세내용), problemCode (문제 유형)
	// Output Parameter : Integer (불만 심각도)
	Integer checkCustomerProblemDegree(Integer problemDegree, String requestDesc, String problemCode);
	
	// EXT-API-02 심각도 알람 전송
	void sendWarningMessage();
}

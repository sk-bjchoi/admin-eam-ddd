package com.sk.eadmin.biz.admin.adapter.external;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.sk.eadmin.biz.admin.port.external.ExternalAgentInterface;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExternalAgentInterfaceFeignClientImpl implements ExternalAgentInterface {
    private final ExternalAgentFeignClient externalAgentFeignClient;


    @Override
    public Integer checkCustomerProblemDegree(Integer problemDegree, String requestDesc, String problemCode) {
        Map<String, Object> body = Map.of(
                "problemDegree", problemDegree,
                "requestDesc", requestDesc,
                "problemCode", problemCode
        );

        Map<String, Object> response = externalAgentFeignClient.checkProblemDegree(body);
        return (Integer) response.get("score");
    }

    @Override
    public void sendWarningMessage() {
        externalAgentFeignClient.sendWarningMessage();
    }
}
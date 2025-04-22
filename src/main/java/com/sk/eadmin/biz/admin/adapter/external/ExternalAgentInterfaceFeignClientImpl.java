package com.sk.eadmin.biz.admin.adapter.external;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sk.eadmin.biz.admin.port.external.ExternalAgentInterface;

@Component
@FeignClient(name = "external-agent-api", url = "${external-api.base-url}")
public interface ExternalAgentInterfaceFeignClientImpl extends ExternalAgentInterface {

    @PostMapping("/check-problem-degree")
    Map<String, Object> checkProblemDegree(@RequestBody Map<String, Object> body);

    @PostMapping("/send-warning-message")
    void sendWarningMessage();

    @Override
    default Integer checkCustomerProblemDegree(Integer problemDegree, String requestDesc, String problemCode) {
        Map<String, Object> body = Map.of(
                "problemDegree", problemDegree,
                "requestDesc", requestDesc,
                "problemCode", problemCode
        );

        Map<String, Object> response = checkProblemDegree(body);
        return (Integer) response.get("score");
    }
}
package com.sk.eadmin.biz.admin.adapter.external;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.sk.eadmin.biz.admin.port.external.ExternalAgentInterface;

@Component
public class ExternalAgentInterfaceRestTemplateImpl implements ExternalAgentInterface {

    private final RestTemplate restTemplate;

    public ExternalAgentInterfaceRestTemplateImpl(RestTemplateBuilder builder, @Value("${external-api.base-url}") String baseUrl) {
        this.restTemplate = builder.rootUri(baseUrl).build();
    }

    @Override
    public Integer checkCustomerProblemDegree(Integer problemDegree, String requestDesc, String problemCode) {
        Map<String, Object> body = Map.of(
                "problemDegree", problemDegree,
                "requestDesc", requestDesc,
                "problemCode", problemCode
        );

        ResponseEntity<Map> response = restTemplate.postForEntity(
                "/check-problem-degree", body, Map.class
        );

        return (Integer) response.getBody().get("score");
    }

    @Override
    public void sendWarningMessage() {
        restTemplate.postForEntity("/send-warning-message", null, Void.class);
    }
}
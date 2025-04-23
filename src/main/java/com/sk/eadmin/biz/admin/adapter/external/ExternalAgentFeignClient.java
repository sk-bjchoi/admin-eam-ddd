package com.sk.eadmin.biz.admin.adapter.external;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "external-agent-api", url = "${external-api.base-url}")
public interface ExternalAgentFeignClient {
} 
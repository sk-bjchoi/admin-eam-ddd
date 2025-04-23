package com.sk.eadmin.biz.admin.adapter.external;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.sk.eadmin.biz.admin.port.external.ExternalAgentInterface;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ExternalAgentInterfaceFeignClientImpl implements ExternalAgentInterface {
    private final ExternalAgentFeignClient externalAgentFeignClient;
}
package com.sk.eadmin.config.mock;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("localstub") // 개발 시에만
public class WireMockConfig {
/*
    private WireMockServer wireMockServer;

    @PostConstruct
    public void startStubServer() {
        wireMockServer = new WireMockServer(
                WireMockConfiguration.options().port(8085)
        );
        wireMockServer.start();

        WireMock.configureFor("localhost", 8085);

        // ✅ 스텁 등록
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/api/hello"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"message\": \"Hello, World!\" }")));
    }

    @PreDestroy
    public void stopStubServer() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
        }
    }*/
}

/*
public WireMockServer wireMockServer() {
    WireMockConfiguration options = WireMockConfiguration.options()
            .port(8085)
            .usingFilesUnderDirectory("src/main/resources/stubs");

    WireMockServer wireMockServer = new WireMockServer(options);
    wireMockServer.start();
    return wireMockServer;
}*/
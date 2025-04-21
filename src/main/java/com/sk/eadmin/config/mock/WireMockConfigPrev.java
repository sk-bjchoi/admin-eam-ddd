package com.sk.eadmin.config.mock;

//@Configuration
//@Profile("localstub") // 개발 시에만
public class WireMockConfigPrev {
/*
    @PostConstruct
    public void startStubServer() {
        WireMockServer wireMockServer = new WireMockServer(8085); // 포트 고정
        wireMockServer.start();

        // DSL 기반 응답 등록 (check-problem-degree)
        wireMockServer.stubFor(post(urlEqualTo("/check-problem-degree"))
            //.withHeader("Content-Type", containing("application/json"))
            //.withRequestBody(matchingJsonPath("$.problemDegree[?(@ == 80)]"))
            //.withRequestBody(matchingJsonPath("$.problemCode", equalTo("P001")))
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withStatus(200)
                .withBody("""
                    {
                        "score": 85
                    }
                """)));

        // DSL 기반 응답 등록 (check-problem-degree)
        wireMockServer.stubFor(post(urlEqualTo("/send-warning-message"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "application/json")
                .withStatus(200)));
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
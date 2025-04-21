org.springframework.cloud.contract.spec.Contract.make {
    description "Check customer problem degree and return score"

    request {
        method 'POST'
        url '/check-problem-degree'
        body([
            problemDegree : 80,
            requestDesc   : "화면이 안 떠요",
            problemCode   : "P001"
        ])
        headers {
            contentType(applicationJson())
        }
    }

    response {
        status 200
        body([
            score: 85
        ])
        headers {
            contentType(applicationJson())
        }
    }
}

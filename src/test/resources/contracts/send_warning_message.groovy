org.springframework.cloud.contract.spec.Contract.make {
    description "Send warning message to agent"

    request {
        method 'POST'
        url '/send-warning-message'
    }

    response {
        status 200
    }
}
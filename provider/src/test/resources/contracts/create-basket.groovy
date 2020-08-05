package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/basket'
        //body()
        headers {
            contentType('application/json')
        }
    }
    response {
        status CREATED()
        body([
            "basketId": $(anyUuid())
        ])
        headers {
            contentType('application/json')
        }
    }
}
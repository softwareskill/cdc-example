package contracts

org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/basket/063b360b-854a-4f5a-9081-fd0157135d9c/summary'
        body([
            "shippingAddress": [
                "country": "Polska",
                "city": "Warszawa",
                "street": "Podwale",
                "number": "12",
            ]
        ])
        headers {
            contentType('application/json')
        }
    }
    response {
        status OK()
        body([
            "totalPrice": $(anyNumber())
        ])
        headers {
            contentType('application/json')
        }
    }
}
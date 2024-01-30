package com.rest.assured.api.enums;

public enum Endpoint {
    USER_REGISTER_ENDPOINT("/v1/register"),
    USER_LOGIN_ENDPOINT("/v1/login"),
    TRANSFER_ENDPOINT("/v1/transfers"),
    TOPUP_ENDPOINT("/v1/topups")
    ;
    private String endpoint;

    Endpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}

package com.rest.assured.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.net.URL;

public abstract class ApiAction extends RestAssured {

    protected static final String API_HOST = "http://localhost:8080";

    protected URL url;

    public static Response post() {
        return with().post();
    }

}

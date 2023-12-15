package com.rest.assured.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.net.URL;

public class ApiAction extends RestAssured {

    protected static final String API_HOST = "http://localhost:8080";

    protected URL url;

    public static Response post() {
        return with().post();
    }

    public Response Post(String path, String requestBody) {
        RestAssured.baseURI = API_HOST;
        RequestSpecification requestSpecification1 = given();
        return requestSpecification1.body(requestBody).request(Method.POST, path);
    }

}

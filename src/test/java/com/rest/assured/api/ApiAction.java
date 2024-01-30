package com.rest.assured.api;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;

public class ApiAction extends RestAssured {

    protected static final String API_HOST = "http://localhost:8080";

    private Logger LOGGER = LoggerFactory.getLogger(ApiAction.class);

    protected URL url;

    public static Response post() {
        return with().post();
    }

    public Response Post(String path, String requestBody) {
        RestAssured.baseURI = API_HOST;
        RequestSpecification requestSpecification1 = given();
        Response response = requestSpecification1.body(requestBody).request(Method.POST, path);
        LOGGER.info("=== response {}", response.statusCode());
        return response;
    }

}

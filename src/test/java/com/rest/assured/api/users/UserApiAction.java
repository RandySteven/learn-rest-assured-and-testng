package com.rest.assured.api.users;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserApiAction extends RestAssured {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApiAction.class);

    private static final String REGISTER_PATH = "http://localhost:8080/v1/register";

    public static UserApiAction getInstance() {
        return new UserApiAction();
    }
    public Response TestRegisterUser(String requestBodyStr) {
        RequestSpecification requestSpecification1 = given();
        Response response = requestSpecification1.body(requestBodyStr).request(Method.POST, REGISTER_PATH);
        return response;
    }
}

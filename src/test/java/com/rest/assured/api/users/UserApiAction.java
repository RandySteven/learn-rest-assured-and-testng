package com.rest.assured.api.users;

import com.rest.assured.api.ApiAction;
import com.rest.assured.common.CsvReader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UserApiAction extends ApiAction {

    private static final String REGISTER_PATH = "/auth/register";
    private static final String LOGIN_PATH = "/auth/login";

    public static UserApiAction getInstance() {
        return new UserApiAction();
    }
    public Response registerUserAction(String requestBodyStr) {
        return Post(REGISTER_PATH, requestBodyStr);
    }

    public Response loginUserAction(String requestBodyStr) {
        return Post(LOGIN_PATH, requestBodyStr);
    }

}

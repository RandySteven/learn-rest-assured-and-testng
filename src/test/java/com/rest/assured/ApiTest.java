package com.rest.assured;

import com.rest.assured.api.users.UserApiAction;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.junit.runner.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class ApiTest extends RestAssured{


    private static final Logger LOGGER = LoggerFactory.getLogger(ApiTest.class);

    UserApiAction userApiAction = UserApiAction.getInstance();

//    @Test
//    public void TestRegisterUser() throws Exception {
//        Yaml yaml = new Yaml();
//
//        Map<String, Map<String, Object>> dataItems = yaml.load(new FileInputStream("src/test/resources/testcase/user/register/register.data.yaml"));
//        for (Map.Entry<String, Map<String, Object>> entry : dataItems.entrySet()) {
//            String dataId = entry.getKey();
//            Map<String, Object> testData = entry.getValue();
//
//            Map<String, String> userRequest = (Map<String, String>) testData.get("userRequest");
//            int expectedResponseCode = (int) testData.get("expectedResponseCode");
//
//            JSONObject requestBody = new JSONObject(userRequest);
//            String requestBodyStr = requestBody.toString();
//
//            userApiAction.TestRegisterUser(requestBodyStr, dataId, expectedResponseCode);
//        }
//    }



    @Test
    public void TestRegisterUserEmailInvalid() {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Randy Steven");
        user.put("email", "randy.steven");
        user.put("password", "test1234");

        JSONObject requestBody = new JSONObject(user);

        String requestBodyStr = requestBody.toString();

        Response response = userApiAction.TestRegisterUser(requestBodyStr);

        Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR, response.statusCode());
    }

    @Test
    public void TestRegisterUserPasswordInvalid() {
        Map<String, String> user = new HashMap<>();
        user.put("name", "Randy Steven");
        user.put("email", "randy.steven12@gmail.com");
        user.put("password", "");

        JSONObject requestBody = new JSONObject(user);

        String requestBodyStr = requestBody.toString();

        LOGGER.info("=== request : {}", requestBodyStr);

        with()
                .body(requestBodyStr)
                .contentType("application/json")
                .request(Method.POST, "http://localhost:8080/v1/register")
                .then()
                .statusCode(400);
    }

    @Test
    public void TestRegisterUserPasswordEmpty(){
        Map<String, String> user = new HashMap<>();
        user.put("name", "Randy Steven");
        user.put("email", "randy.steven@gmail.com");

        JSONObject requestBody = new JSONObject(user);

        String requestBodyStr = requestBody.toString();

        LOGGER.info("=== request : {}", requestBodyStr);

        with()
                .body(requestBodyStr)
                .contentType("application/json")
                .request(Method.POST, "http://localhost:8080/v1/register")
                .then()
                .statusCode(400);
    }

    public void TestRegisterUserNameEmpty() {

    }
}

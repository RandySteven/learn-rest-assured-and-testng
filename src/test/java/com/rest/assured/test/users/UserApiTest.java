package com.rest.assured.test.users;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.rest.assured.api.users.UserApiAction;
import com.rest.assured.common.CsvReader;
import com.rest.assured.common.VelocityUtil;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserApiTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApiTest.class);

    UserApiAction userApiAction = UserApiAction.getInstance();

    VelocityUtil vu = VelocityUtil.getInstance();

    CsvReader csv = CsvReader.getInstance();

    private static final String CSV_LOGIN_DATA = "src/test/resources/testcase/user/login/login.test.data.csv";
    private static final String CSV_REGISTER_DATA = "src/test/resources/testcase/user/register/register.test.data.csv";

    @Test(dataProvider = "register.test.data.csv")
    public void testRegisterUser(String []registerData) {
        String name = registerData[0];
        String email = registerData[1];
        String password = registerData[2];

        Map<String, String> user = new HashMap<>();
        user.put("name", name);
        user.put("email", email);
        user.put("password", password);

        JSONObject requestBody = new JSONObject(user);
        String requestBodyStr = requestBody.toString();
        LOGGER.info("=== request body : {}", requestBodyStr);

        Response response = userApiAction.registerUserAction(requestBodyStr);

        LOGGER.info("=== response body : {}", response.asString());

        Assert.assertEquals(HttpStatus.SC_INTERNAL_SERVER_ERROR, response.statusCode());
    }

    @Test(dataProvider = "login.test.data.csv")
    public void testLoginUser(String []loginData) throws Exception{
        String email = loginData[0];
        String password = loginData[1];
        int expectedRC = Integer.parseInt(loginData[2]);

        Map<String, String> user = new HashMap<>();
        user.put("email", email);
        user.put("password", password);

        JSONObject requestBody = new JSONObject(user);
        String requestBodyStr = requestBody.toString();
        LOGGER.info("=== request body : {}", requestBodyStr);

        Response response = userApiAction.loginUserAction(requestBodyStr);
        JSONObject responseJson = new JSONObject(response.getBody().asString());

        LOGGER.info("=== response body : {}", response.asString());
        Assert.assertEquals(expectedRC, response.statusCode());

        if(expectedRC == HttpStatus.SC_OK) {
            String message = "Success login user";
            Assert.assertEquals(message, responseJson.get("message"));
        }
    }

    @DataProvider(name = "login.test.data.csv")
    public Object[][] fetchLoginData() throws Exception{
        return csv.readCSVData(CSV_LOGIN_DATA);
    }

    @DataProvider(name = "register.test.data.csv")
    public Object[][] fetchRegisterData() throws Exception{
        return csv.readCSVData(CSV_REGISTER_DATA);
    }
}

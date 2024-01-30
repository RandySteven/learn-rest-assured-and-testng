package com.rest.assured.test.transfer;

import com.rest.assured.api.transfer.TransferApiAction;
import com.rest.assured.common.CsvReader;
import com.rest.assured.common.VelocityUtil;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TransferApiTest {
    TransferApiAction transferApiAction = TransferApiAction.getInstance();

    VelocityUtil vu = VelocityUtil.getInstance();

    CsvReader csv = CsvReader.getInstance();

    private static final String CSV_TRANSFER_DATA = "src/test/resources/testcase/transaction/transfer/transfer.test.data.csv";

    private static final Logger LOGGER = LoggerFactory.getLogger(TransferApiTest.class);

    @Test(dataProvider = "transfer.test.data.csv")
    public void testTransfer(String []transferData) {
        String tc = transferData[0];
        String to = transferData[2];
        String amount = transferData[3];
        String description = transferData[4];
        String expectedResponseCode = transferData[5];

        Map<String, String> transfer = new HashMap<>();
        transfer.put("to", to);
        transfer.put("amount", amount);
        transfer.put("description", description);

        JSONObject requestBody = new JSONObject(transfer);
        String requestBodyStr = requestBody.toString();
        LOGGER.info("=== request body : {}", requestBodyStr);

        Response response = transferApiAction.doTransfer(requestBodyStr);
//        JSONObject responseJson = new JSONObject(response.getBody().asString());

        LOGGER.info("=== response body : {}", response.asString());
        Assert.assertEquals(expectedResponseCode, response.statusCode());
    }

    @DataProvider(name = "transfer.test.data.csv")
    public Object[][] fetchTransferData() throws Exception{
        return csv.readCSVData(CSV_TRANSFER_DATA);
    }
}

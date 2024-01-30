package com.rest.assured.api.transfer;

import com.rest.assured.api.ApiAction;
import io.restassured.response.Response;

public class TransferApiAction extends ApiAction {

    private static final String TRANSFER_ENDPOINT = "/v1/transfers";

    public static TransferApiAction getInstance() {
        return new TransferApiAction();
    }

    public Response doTransfer(String requestBody) {
        return Post(TRANSFER_ENDPOINT, requestBody);
    }

}

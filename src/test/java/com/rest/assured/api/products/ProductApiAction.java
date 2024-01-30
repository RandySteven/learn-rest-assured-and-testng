package com.rest.assured.api.products;

import com.rest.assured.api.ApiAction;
import io.restassured.response.Response;

public class ProductApiAction extends ApiAction {

    private static final String PRODUCT_ENDPOINT = "/products";

    public static ProductApiAction getInstance() {
        return new ProductApiAction();
    }

    public Response createProduct(String requestBody) {
        return Post(PRODUCT_ENDPOINT, requestBody);
    }
}

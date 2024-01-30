package com.rest.assured.test.products;

import com.rest.assured.api.products.ProductApiAction;
import com.rest.assured.common.CsvReader;
import com.rest.assured.common.VelocityUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductApiTest {

    ProductApiAction productApiAction = ProductApiAction.getInstance();

    VelocityUtil vu = VelocityUtil.getInstance();

    CsvReader csv = CsvReader.getInstance();

    private static final String CSV_CREATE_PRODUCT_DATA = "";

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductApiTest.class);

}

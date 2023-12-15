package com.rest.assured.common;

import org.json.JSONObject;

import java.util.Map;

public class VelocityUtil {

    public static VelocityUtil getInstance() {
        return new VelocityUtil();
    }

    public String getToken(JSONObject loginResponse) {
        return (String) loginResponse.get("data");
    }

}

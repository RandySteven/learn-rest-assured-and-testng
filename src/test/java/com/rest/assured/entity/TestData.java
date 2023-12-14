package com.rest.assured.entity;

import java.util.Map;

public class TestData {

    private String dataId;
    private String logicId;
    private String description;
    private Map<String, Map<String, Object>> dataItems;

    public TestData(String dataId, String logicId, String description, Map<String, Map<String, Object>> dataItems) {
        this.dataId = dataId;
        this.logicId = logicId;
        this.description = description;
        this.dataItems = dataItems;
    }

    public TestData() {

    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getLogicId() {
        return logicId;
    }

    public void setLogicId(String logicId) {
        this.logicId = logicId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, Map<String, Object>> getDataItems() {
        return dataItems;
    }

    public void setDataItems(Map<String, Map<String, Object>> dataItems) {
        this.dataItems = dataItems;
    }
}

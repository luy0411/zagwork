package com.zagwork.test.user.microservice.service.test.checker;

import org.json.JSONException;
import org.json.JSONObject;

abstract class JsonChecker {

    JSONObject actualJson;

    JsonChecker(){}
    JsonChecker(JSONObject actualJson) {
        this.actualJson = actualJson;
    }

    abstract void check(Object expected) throws JSONException;

    void setActualJson(JSONObject actualJson) {
        this.actualJson = actualJson;
    }
}

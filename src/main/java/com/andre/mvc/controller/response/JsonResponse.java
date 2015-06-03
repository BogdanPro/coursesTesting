package com.andre.mvc.controller.response;

/**
 * Created by Khemrayev A.K. on 25.05.2015.
 */
public class JsonResponse {
    public static final String SUCCESS = "SUCCESS";
    public static final String ERROR = "ERROR";
    public static final String WARNING = "WARNING";

    private String status;
    private String type;

    public JsonResponse() {}

    public JsonResponse(String status, String type) {
        this.status = status;
        this.type = type;
    }

    public JsonResponse(String status) {
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

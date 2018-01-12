package com.github.phiz71.vertx.swagger.router;

import io.vertx.core.MultiMap;

public class ApiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	private MultiMap headers;
    private int statusCode;
    private String statusMessage;

    public ApiException(int statusCode, String statusMessage) {
        super();
        this.headers = MultiMap.caseInsensitiveMultiMap();
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public ApiException addHeader(ApiHeader header) {
        if (header.getValue() != null)
            this.headers.add(header.getName(), header.getValue());
        else
            this.headers.add(header.getName(), header.getValues());
        return this;
    }

    public ApiException addHeader(String name, String value) {
        this.headers.add(name, value);
        return this;
    }

    public ApiException addHeaders(String name, Iterable<String> values) {
        this.headers.add(name, values);
        return this;
    }

    public MultiMap getHeaders() {
        return headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }
    
    public static final ApiException INTERNAL_SERVER_ERROR = new ApiException(500, "Internal Server Error"); 
}
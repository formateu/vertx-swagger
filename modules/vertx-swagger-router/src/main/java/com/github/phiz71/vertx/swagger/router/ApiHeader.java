package com.github.phiz71.vertx.swagger.router;

public class ApiHeader {

	private String name;
	private String value;
	private Iterable<String> values;

	protected ApiHeader(String name, String value) {
		super();
		this.name = name;
		this.value = value;
		this.values = null;
	}

	protected ApiHeader(String name, Iterable<String> values) {
		super();
		this.name = name;
		this.value = null;
		this.values = values;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public Iterable<String> getValues() {
		return values;
	}

	public static final ApiHeader CONTENT_TYPE_JSON = new ApiHeader("Content-Type", "application/json");
}
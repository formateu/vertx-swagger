package com.github.phiz71.vertx.swagger.router;

import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;

public interface ApiErrorHandler {
	
	public void manageError(Message<JsonObject> message, Throwable cause, String serviceName, Logger logger);

}

package com.github.phiz71.vertx.swagger.router;

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;

public class DefaultApiErrorHandler implements ApiErrorHandler {

	@Override
    public void manageError(Message<JsonObject> message, Throwable cause, String serviceName, Logger logger) {
		int code = ApiException.INTERNAL_SERVER_ERROR.getStatusCode();
        String statusMessage = ApiException.INTERNAL_SERVER_ERROR.getStatusMessage();
        DeliveryOptions deliveryOptions = new DeliveryOptions();
        if (cause instanceof ApiException) {
            code = ((ApiException)cause).getStatusCode();
            statusMessage = ((ApiException)cause).getStatusMessage();
            deliveryOptions.setHeaders(((ApiException)cause).getHeaders());
        } else {
            logUnexpectedError(serviceName, cause, logger);
        }
        deliveryOptions.addHeader(SwaggerRouter.CUSTOM_STATUS_CODE_HEADER_KEY, String.valueOf(code));
        deliveryOptions.addHeader(SwaggerRouter.CUSTOM_STATUS_MESSAGE_HEADER_KEY, statusMessage);

        message.reply(null, deliveryOptions);
    }

    public static void logUnexpectedError(String serviceName, Throwable cause, Logger logger) {
        logger.error("Unexpected error in "+ serviceName, cause);
    }
}

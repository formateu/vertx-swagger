package io.swagger.server.api.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.phiz71.vertx.swagger.router.ApiErrorHandler;
import com.github.phiz71.vertx.swagger.router.DefaultApiErrorHandler;
import com.github.phiz71.vertx.swagger.router.EnumParseException;

import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.reactivex.functions.Consumer;

public class VerticleHelper {

    private Logger logger;
    
    private static ApiErrorHandler apiErrorHandler = new DefaultApiErrorHandler();

    public VerticleHelper(Logger logger) {
        this.logger = logger;
    }

    public VerticleHelper(Class<?> clazz) {
        this.logger = LoggerFactory.getLogger(clazz);
    }
    
    public static void setErrorHandler(ApiErrorHandler apiErrorHandler) {
    	VerticleHelper.apiErrorHandler = apiErrorHandler;
    }
    

    public Consumer<Throwable> getErrorAction(Message<JsonObject> message, String serviceName) {
        return error -> {
            manageError(message, error, serviceName);
        };
    }

    public <T> Consumer<ResourceResponse<T>> getRxResultHandler(Message<JsonObject> message) {
        return result -> {
            DeliveryOptions deliveryOptions = new DeliveryOptions();
            deliveryOptions.setHeaders(result.getHeaders());
            message.reply(result.getResponse(), deliveryOptions);
        };
    }

    public <T> Consumer<ResourceResponse<T>> getRxResultHandler(Message<JsonObject> message, boolean withJsonEncode, TypeReference<T> type) {
        return result -> {
            DeliveryOptions deliveryOptions = new DeliveryOptions();
            deliveryOptions.setHeaders(result.getHeaders());
            if (withJsonEncode) {
                message.reply(Json.encode(result.getResponse()), deliveryOptions);
            } else {
                message.reply(result.getResponse(), deliveryOptions);
            }
        };
    }

    public void manageError(Message<JsonObject> message, Throwable cause, String serviceName) {
        VerticleHelper.apiErrorHandler.manageError(message, cause, serviceName, logger);
    }
    
    public static <T extends Enum<T>> T convertEnum(Class<T> clazz, String value) throws EnumParseException {
    	try {
    		return Enum.valueOf(clazz, value);
    	} catch (IllegalArgumentException e) {
    		throw new EnumParseException(e);
    	}
    }

}
package io.swagger.server.api.verticle;

import com.fasterxml.jackson.core.type.TypeReference;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.ext.auth.User;
import com.github.phiz71.vertx.swagger.router.SwaggerRouter;

import java.util.Map;
import io.swagger.server.api.model.Order;

import io.swagger.server.api.util.VerticleHelper;

public class StoreApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    public static final String DELETEORDER_SERVICE_ID = "deleteOrder";
    public static final String GETINVENTORY_SERVICE_ID = "getInventory";
    public static final String GETORDERBYID_SERVICE_ID = "getOrderById";
    public static final String PLACEORDER_SERVICE_ID = "placeOrder";
    

    private StoreApi service;

    //Handler for deleteOrder
    final Handler<Message<io.vertx.core.json.JsonObject>> deleteOrderHandler = message -> {
        try {
            Long orderId = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getString("orderId"), Long.class);
            service.deleteOrderWithHeader(orderId).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, DELETEORDER_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new StoreApiException.DeleteOrder400Exception(e), DELETEORDER_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, DELETEORDER_SERVICE_ID);
        }
    };

    //Handler for getInventory
    final Handler<Message<io.vertx.core.json.JsonObject>> getInventoryHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            service.getInventoryWithHeader(io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, GETINVENTORY_SERVICE_ID)
            );
        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETINVENTORY_SERVICE_ID);
        }
    };

    //Handler for getOrderById
    final Handler<Message<io.vertx.core.json.JsonObject>> getOrderByIdHandler = message -> {
        try {
            Long orderId = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getString("OrderId"), Long.class);
            service.getOrderByIdWithHeader(orderId).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, GETORDERBYID_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new StoreApiException.GetOrderById400Exception(e), GETORDERBYID_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETORDERBYID_SERVICE_ID);
        }
    };

    //Handler for placeOrder
    final Handler<Message<io.vertx.core.json.JsonObject>> placeOrderHandler = message -> {
        try {
            Order body = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getJsonObject("body").encode(), Order.class);
            service.placeOrderWithHeader(body).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, PLACEORDER_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new StoreApiException.PlaceOrder400Exception(e), PLACEORDER_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, PLACEORDER_SERVICE_ID);
        }
    };

    

    @Override
    public void start() throws Exception {
        service = createServiceImplementation();
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(DELETEORDER_SERVICE_ID).handler(deleteOrderHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(GETINVENTORY_SERVICE_ID).handler(getInventoryHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(GETORDERBYID_SERVICE_ID).handler(getOrderByIdHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(PLACEORDER_SERVICE_ID).handler(placeOrderHandler);
        
    }

    protected StoreApi createServiceImplementation() {
        return new StoreApiImpl(vertx, config());
    }
}

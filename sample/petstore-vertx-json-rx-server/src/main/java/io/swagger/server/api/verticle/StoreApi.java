package io.swagger.server.api.verticle;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.swagger.server.api.model.Order;

import rx.Completable;
import rx.Single;
import io.vertx.rxjava.ext.auth.User;

public interface StoreApi  {
    //deleteOrder
    default Single<ResourceResponse<Void>> deleteOrderWithHeader(Long orderId) { 
    	return deleteOrder(orderId).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Void> deleteOrder(Long orderId) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //getInventory
    default Single<ResourceResponse<JsonObject>> getInventoryWithHeader(User user) { 
    	return getInventory(user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<JsonObject> getInventory(User user) { 
    	return getInventory();
    }
    
    default Single<JsonObject> getInventory() { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //getOrderById
    default Single<ResourceResponse<Order>> getOrderByIdWithHeader(Long orderId) { 
    	return getOrderById(orderId).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Order> getOrderById(Long orderId) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //placeOrder
    default Single<ResourceResponse<Order>> placeOrderWithHeader(Order body) { 
    	return placeOrder(body).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Order> placeOrder(Order body) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
}

package io.swagger.server.api.verticle;

import java.util.Map;
import io.swagger.server.api.model.Order;

import io.swagger.server.api.util.ResourceResponse;

import static io.swagger.server.api.util.ResourceResponseRxWrapper.emptyHeaderWrapper;

import io.reactivex.Single;
import io.vertx.reactivex.ext.auth.User;

public interface StoreApi  {
    //deleteOrder
    default Single<ResourceResponse<Void>> deleteOrderWithHeader(Long orderId) { 
    	return deleteOrder(orderId).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Void> deleteOrder(Long orderId) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //getInventory
    default Single<ResourceResponse<Map<String, Integer>>> getInventoryWithHeader(User user) { 
    	return getInventory(user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Map<String, Integer>> getInventory(User user) { 
    	return getInventory();
    }
    
    default Single<Map<String, Integer>> getInventory() { 
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

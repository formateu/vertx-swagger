package io.swagger.server.api.verticle;

import com.github.phiz71.vertx.swagger.router.ApiException;

public class StoreApiException extends ApiException {

	private static final long serialVersionUID = 1L;

    public StoreApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public StoreApiException(int statusCode, String statusMessage, Throwable cause) {
        super(statusCode, statusMessage, cause);
    }
    
    public static class DeleteOrder400Exception extends StoreApiException {
        private static final long serialVersionUID = 1L;
        
        public DeleteOrder400Exception() {
        	super(400, "Invalid ID supplied");
        }
        
        public DeleteOrder400Exception(Throwable cause) {
        	super(400, "Invalid ID supplied", cause);
        }
    }
    public static class DeleteOrder404Exception extends StoreApiException {
        private static final long serialVersionUID = 1L;
        
        public DeleteOrder404Exception() {
        	super(404, "Order not found");
        }
        
        public DeleteOrder404Exception(Throwable cause) {
        	super(404, "Order not found", cause);
        }
    }
    public static class GetOrderById400Exception extends StoreApiException {
        private static final long serialVersionUID = 1L;
        
        public GetOrderById400Exception() {
        	super(400, "Invalid ID supplied");
        }
        
        public GetOrderById400Exception(Throwable cause) {
        	super(400, "Invalid ID supplied", cause);
        }
    }
    public static class GetOrderById404Exception extends StoreApiException {
        private static final long serialVersionUID = 1L;
        
        public GetOrderById404Exception() {
        	super(404, "Order not found");
        }
        
        public GetOrderById404Exception(Throwable cause) {
        	super(404, "Order not found", cause);
        }
    }
    public static class PlaceOrder400Exception extends StoreApiException {
        private static final long serialVersionUID = 1L;
        
        public PlaceOrder400Exception() {
        	super(400, "Invalid Order");
        }
        
        public PlaceOrder400Exception(Throwable cause) {
        	super(400, "Invalid Order", cause);
        }
    }
    

}
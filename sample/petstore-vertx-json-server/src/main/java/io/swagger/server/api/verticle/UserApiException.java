package io.swagger.server.api.verticle;

import com.github.phiz71.vertx.swagger.router.ApiException;

public class UserApiException extends ApiException {

	private static final long serialVersionUID = 1L;

    public UserApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public UserApiException(int statusCode, String statusMessage, Throwable cause) {
        super(statusCode, statusMessage, cause);
    }
    
    public static class DeleteUser400Exception extends UserApiException {
        private static final long serialVersionUID = 1L;
        
        public DeleteUser400Exception() {
        	super(400, "Invalid username supplied");
        }
        
        public DeleteUser400Exception(Throwable cause) {
        	super(400, "Invalid username supplied", cause);
        }
    }
    public static class DeleteUser404Exception extends UserApiException {
        private static final long serialVersionUID = 1L;
        
        public DeleteUser404Exception() {
        	super(404, "User not found");
        }
        
        public DeleteUser404Exception(Throwable cause) {
        	super(404, "User not found", cause);
        }
    }
    public static class GetUserByName400Exception extends UserApiException {
        private static final long serialVersionUID = 1L;
        
        public GetUserByName400Exception() {
        	super(400, "Invalid username supplied");
        }
        
        public GetUserByName400Exception(Throwable cause) {
        	super(400, "Invalid username supplied", cause);
        }
    }
    public static class GetUserByName404Exception extends UserApiException {
        private static final long serialVersionUID = 1L;
        
        public GetUserByName404Exception() {
        	super(404, "User not found");
        }
        
        public GetUserByName404Exception(Throwable cause) {
        	super(404, "User not found", cause);
        }
    }
    public static class LoginUser400Exception extends UserApiException {
        private static final long serialVersionUID = 1L;
        
        public LoginUser400Exception() {
        	super(400, "Invalid username/password supplied");
        }
        
        public LoginUser400Exception(Throwable cause) {
        	super(400, "Invalid username/password supplied", cause);
        }
    }
    public static class UpdateUser400Exception extends UserApiException {
        private static final long serialVersionUID = 1L;
        
        public UpdateUser400Exception() {
        	super(400, "Invalid user supplied");
        }
        
        public UpdateUser400Exception(Throwable cause) {
        	super(400, "Invalid user supplied", cause);
        }
    }
    public static class UpdateUser404Exception extends UserApiException {
        private static final long serialVersionUID = 1L;
        
        public UpdateUser404Exception() {
        	super(404, "User not found");
        }
        
        public UpdateUser404Exception(Throwable cause) {
        	super(404, "User not found", cause);
        }
    }
    

}
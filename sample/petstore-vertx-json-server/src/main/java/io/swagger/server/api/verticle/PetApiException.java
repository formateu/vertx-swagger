package io.swagger.server.api.verticle;

import com.github.phiz71.vertx.swagger.router.ApiException;

public class PetApiException extends ApiException {

	private static final long serialVersionUID = 1L;

    public PetApiException(int statusCode, String statusMessage) {
        super(statusCode, statusMessage);
    }
    
    public PetApiException(int statusCode, String statusMessage, Throwable cause) {
        super(statusCode, statusMessage, cause);
    }
    
    public static class AddPet405Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public AddPet405Exception() {
        	super(405, "Invalid input");
        }
        
        public AddPet405Exception(Throwable cause) {
        	super(405, "Invalid input", cause);
        }
    }
    public static class DeletePet400Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public DeletePet400Exception() {
        	super(400, "Invalid ID supplied");
        }
        
        public DeletePet400Exception(Throwable cause) {
        	super(400, "Invalid ID supplied", cause);
        }
    }
    public static class DeletePet404Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public DeletePet404Exception() {
        	super(404, "Pet not found");
        }
        
        public DeletePet404Exception(Throwable cause) {
        	super(404, "Pet not found", cause);
        }
    }
    public static class FindPetsByStatus400Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public FindPetsByStatus400Exception() {
        	super(400, "Invalid status value");
        }
        
        public FindPetsByStatus400Exception(Throwable cause) {
        	super(400, "Invalid status value", cause);
        }
    }
    public static class FindPetsByTags400Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public FindPetsByTags400Exception() {
        	super(400, "Invalid tag value");
        }
        
        public FindPetsByTags400Exception(Throwable cause) {
        	super(400, "Invalid tag value", cause);
        }
    }
    public static class GetPetById400Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public GetPetById400Exception() {
        	super(400, "Invalid ID supplied");
        }
        
        public GetPetById400Exception(Throwable cause) {
        	super(400, "Invalid ID supplied", cause);
        }
    }
    public static class GetPetById404Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public GetPetById404Exception() {
        	super(404, "Pet not found");
        }
        
        public GetPetById404Exception(Throwable cause) {
        	super(404, "Pet not found", cause);
        }
    }
    public static class UpdatePet400Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public UpdatePet400Exception() {
        	super(400, "Invalid ID supplied");
        }
        
        public UpdatePet400Exception(Throwable cause) {
        	super(400, "Invalid ID supplied", cause);
        }
    }
    public static class UpdatePet404Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public UpdatePet404Exception() {
        	super(404, "Pet not found");
        }
        
        public UpdatePet404Exception(Throwable cause) {
        	super(404, "Pet not found", cause);
        }
    }
    public static class UpdatePet405Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public UpdatePet405Exception() {
        	super(405, "Validation exception");
        }
        
        public UpdatePet405Exception(Throwable cause) {
        	super(405, "Validation exception", cause);
        }
    }
    public static class UpdatePetWithForm405Exception extends PetApiException {
        private static final long serialVersionUID = 1L;
        
        public UpdatePetWithForm405Exception() {
        	super(405, "Invalid input");
        }
        
        public UpdatePetWithForm405Exception(Throwable cause) {
        	super(405, "Invalid input", cause);
        }
    }
    

}
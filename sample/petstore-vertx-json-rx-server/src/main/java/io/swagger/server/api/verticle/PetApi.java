package io.swagger.server.api.verticle;

import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import java.util.List;
import io.swagger.server.api.model.ModelApiResponse;
import io.swagger.server.api.model.Pet;

import rx.Completable;
import rx.Single;
import io.vertx.rxjava.ext.auth.User;

public interface PetApi  {
    //addPet
    default Single<ResourceResponse<Void>> addPetWithHeader(Pet body, User user) { 
    	return addPet(body, user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Void> addPet(Pet body, User user) { 
    	return addPet(body);
    }
    
    default Single<Void> addPet(Pet body) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //deletePet
    default Single<ResourceResponse<Void>> deletePetWithHeader(Long petId, String apiKey, User user) { 
    	return deletePet(petId, apiKey, user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Void> deletePet(Long petId, String apiKey, User user) { 
    	return deletePet(petId, apiKey);
    }
    
    default Single<Void> deletePet(Long petId, String apiKey) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //findPetsByStatus
    default Single<ResourceResponse<JsonArray>> findPetsByStatusWithHeader(JsonArray status, User user) { 
    	return findPetsByStatus(status, user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<JsonArray> findPetsByStatus(JsonArray status, User user) { 
    	return findPetsByStatus(status);
    }
    
    default Single<JsonArray> findPetsByStatus(JsonArray status) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //findPetsByTags
    default Single<ResourceResponse<JsonArray>> findPetsByTagsWithHeader(JsonArray tags, User user) { 
    	return findPetsByTags(tags, user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<JsonArray> findPetsByTags(JsonArray tags, User user) { 
    	return findPetsByTags(tags);
    }
    
    default Single<JsonArray> findPetsByTags(JsonArray tags) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //getPetById
    default Single<ResourceResponse<Pet>> getPetByIdWithHeader(Long petId, User user) { 
    	return getPetById(petId, user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Pet> getPetById(Long petId, User user) { 
    	return getPetById(petId);
    }
    
    default Single<Pet> getPetById(Long petId) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //updatePet
    default Single<ResourceResponse<Void>> updatePetWithHeader(Pet body, User user) { 
    	return updatePet(body, user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Void> updatePet(Pet body, User user) { 
    	return updatePet(body);
    }
    
    default Single<Void> updatePet(Pet body) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //updatePetWithForm
    default Single<ResourceResponse<Void>> updatePetWithFormWithHeader(Long petId, String name, String status, User user) { 
    	return updatePetWithForm(petId, name, status, user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<Void> updatePetWithForm(Long petId, String name, String status, User user) { 
    	return updatePetWithForm(petId, name, status);
    }
    
    default Single<Void> updatePetWithForm(Long petId, String name, String status) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
    //uploadFile
    default Single<ResourceResponse<ModelApiResponse>> uploadFileWithHeader(Long petId, String additionalMetadata, com.github.phiz71.vertx.swagger.router.UploadedFile file, User user) { 
    	return uploadFile(petId, additionalMetadata, file, user).compose(emptyHeaderWrapper()); 
    }
    
    default Single<ModelApiResponse> uploadFile(Long petId, String additionalMetadata, com.github.phiz71.vertx.swagger.router.UploadedFile file, User user) { 
    	return uploadFile(petId, additionalMetadata, file);
    }
    
    default Single<ModelApiResponse> uploadFile(Long petId, String additionalMetadata, com.github.phiz71.vertx.swagger.router.UploadedFile file) { 
    	return Single.error(new UnsupportedOperationException("Not implemented"));
    }

    
}

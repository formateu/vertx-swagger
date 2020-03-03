package io.swagger.server.api.verticle;

import java.util.List;
import io.swagger.server.api.model.ModelApiResponse;
import io.swagger.server.api.model.Pet;

import io.swagger.server.api.util.ResourceResponse;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.ext.auth.User;

public interface PetApi  {
    //addPet
    void addPet(Pet body, User user, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //deletePet
    void deletePet(Long petId, String apiKey, User user, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //findPetsByStatus
    void findPetsByStatus(List<String> status, User user, Handler<AsyncResult<ResourceResponse<List<Pet>>>> handler);
    
    //findPetsByTags
    void findPetsByTags(List<String> tags, User user, Handler<AsyncResult<ResourceResponse<List<Pet>>>> handler);
    
    //getPetById
    void getPetById(Long petId, User user, Handler<AsyncResult<ResourceResponse<Pet>>> handler);
    
    //updatePet
    void updatePet(Pet body, User user, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //updatePetWithForm
    void updatePetWithForm(Long petId, String name, String status, User user, Handler<AsyncResult<ResourceResponse<Void>>> handler);
    
    //uploadFile
    void uploadFile(Long petId, String additionalMetadata, com.github.phiz71.vertx.swagger.router.UploadedFile file, User user, Handler<AsyncResult<ResourceResponse<ModelApiResponse>>> handler);
    
}

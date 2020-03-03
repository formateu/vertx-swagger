package io.swagger.server.api.verticle;

import com.fasterxml.jackson.core.type.TypeReference;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;
import io.vertx.ext.auth.User;
import com.github.phiz71.vertx.swagger.router.SwaggerRouter;

import java.util.List;
import io.swagger.server.api.model.ModelApiResponse;
import io.swagger.server.api.model.Pet;

import io.swagger.server.api.util.VerticleHelper;

public class PetApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    public static final String ADDPET_SERVICE_ID = "addPet";
    public static final String DELETEPET_SERVICE_ID = "deletePet";
    public static final String FINDPETSBYSTATUS_SERVICE_ID = "findPetsByStatus";
    public static final String FINDPETSBYTAGS_SERVICE_ID = "findPetsByTags";
    public static final String GETPETBYID_SERVICE_ID = "getPetById";
    public static final String UPDATEPET_SERVICE_ID = "updatePet";
    public static final String UPDATEPETWITHFORM_SERVICE_ID = "updatePetWithForm";
    public static final String UPLOADFILE_SERVICE_ID = "uploadFile";
    

    private PetApi service;

    //Handler for addPet
    final Handler<Message<io.vertx.core.json.JsonObject>> addPetHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            Pet body = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getJsonObject("body").encode(), Pet.class);
            service.addPetWithHeader(body, io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, ADDPET_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new PetApiException.AddPet400Exception(e), ADDPET_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, ADDPET_SERVICE_ID);
        }
    };

    //Handler for deletePet
    final Handler<Message<io.vertx.core.json.JsonObject>> deletePetHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            Long petId = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getString("petId"), Long.class);
            String apiKey = message.body().getString("api_key");
            service.deletePetWithHeader(petId, apiKey, io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, DELETEPET_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new PetApiException.DeletePet400Exception(e), DELETEPET_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, DELETEPET_SERVICE_ID);
        }
    };

    //Handler for findPetsByStatus
    final Handler<Message<io.vertx.core.json.JsonObject>> findPetsByStatusHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            List<String> status = io.vertx.core.json.Json.mapper.readValue(
            									java.util.Optional.ofNullable(
            										message.body().getJsonArray("status")).map(io.vertx.core.json.JsonArray::encode).orElse("null"),
            									new TypeReference<List<String>>() {});
            service.findPetsByStatusWithHeader(status, io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, FINDPETSBYSTATUS_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new PetApiException.FindPetsByStatus400Exception(e), FINDPETSBYSTATUS_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, FINDPETSBYSTATUS_SERVICE_ID);
        }
    };

    //Handler for findPetsByTags
    final Handler<Message<io.vertx.core.json.JsonObject>> findPetsByTagsHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            List<String> tags = io.vertx.core.json.Json.mapper.readValue(
            									java.util.Optional.ofNullable(
            										message.body().getJsonArray("tags")).map(io.vertx.core.json.JsonArray::encode).orElse("null"),
            									new TypeReference<List<String>>() {});
            service.findPetsByTagsWithHeader(tags, io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, FINDPETSBYTAGS_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new PetApiException.FindPetsByTags400Exception(e), FINDPETSBYTAGS_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, FINDPETSBYTAGS_SERVICE_ID);
        }
    };

    //Handler for getPetById
    final Handler<Message<io.vertx.core.json.JsonObject>> getPetByIdHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            Long petId = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getString("petId"), Long.class);
            service.getPetByIdWithHeader(petId, io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, GETPETBYID_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new PetApiException.GetPetById400Exception(e), GETPETBYID_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETPETBYID_SERVICE_ID);
        }
    };

    //Handler for updatePet
    final Handler<Message<io.vertx.core.json.JsonObject>> updatePetHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            Pet body = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getJsonObject("body").encode(), Pet.class);
            service.updatePetWithHeader(body, io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, UPDATEPET_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new PetApiException.UpdatePet400Exception(e), UPDATEPET_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, UPDATEPET_SERVICE_ID);
        }
    };

    //Handler for updatePetWithForm
    final Handler<Message<io.vertx.core.json.JsonObject>> updatePetWithFormHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            Long petId = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getString("petId"), Long.class);
            String name = message.body().getString("name");
            String status = message.body().getString("status");
            service.updatePetWithFormWithHeader(petId, name, status, io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, UPDATEPETWITHFORM_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new PetApiException.UpdatePetWithForm400Exception(e), UPDATEPETWITHFORM_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, UPDATEPETWITHFORM_SERVICE_ID);
        }
    };

    //Handler for uploadFile
    final Handler<Message<io.vertx.core.json.JsonObject>> uploadFileHandler = message -> {
        try {
            User user = SwaggerRouter.extractAuthUserFromMessage(message);
            Long petId = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getString("petId"), Long.class);
            String additionalMetadata = message.body().getString("additionalMetadata");
            com.github.phiz71.vertx.swagger.router.UploadedFile file = new com.github.phiz71.vertx.swagger.router.UploadedFile(message.body().getJsonObject("file").getString("uploadedFileName"),
            										message.body().getJsonObject("file").getString("formFileName"));
            service.uploadFileWithHeader(petId, additionalMetadata, file, io.vertx.reactivex.ext.auth.User.newInstance(user)).subscribe(
                verticleHelper.getRxResultHandler(message),
                verticleHelper.getErrorAction(message, UPLOADFILE_SERVICE_ID)
            );
    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new PetApiException.UploadFile400Exception(e), UPLOADFILE_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, UPLOADFILE_SERVICE_ID);
        }
    };

    

    @Override
    public void start() throws Exception {
        service = createServiceImplementation();
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(ADDPET_SERVICE_ID).handler(addPetHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(DELETEPET_SERVICE_ID).handler(deletePetHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(FINDPETSBYSTATUS_SERVICE_ID).handler(findPetsByStatusHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(FINDPETSBYTAGS_SERVICE_ID).handler(findPetsByTagsHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(GETPETBYID_SERVICE_ID).handler(getPetByIdHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(UPDATEPET_SERVICE_ID).handler(updatePetHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(UPDATEPETWITHFORM_SERVICE_ID).handler(updatePetWithFormHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(UPLOADFILE_SERVICE_ID).handler(uploadFileHandler);
        
    }

    protected PetApi createServiceImplementation() {
        return new PetApiImpl(vertx, config());
    }
}

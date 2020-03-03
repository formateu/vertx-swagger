package io.swagger.server.api.verticle;

import com.fasterxml.jackson.core.type.TypeReference;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.Message;

import io.swagger.server.api.model.InlineResponseDefault;
import java.util.List;
import io.swagger.server.api.model.ModelUser;
import java.time.OffsetDateTime;
import java.util.UUID;

import io.swagger.server.api.util.VerticleHelper;

public class UserApiVerticle extends AbstractVerticle {
    private VerticleHelper verticleHelper = new VerticleHelper(this.getClass());

    public static final String CREATEUSER_SERVICE_ID = "createUser";
    public static final String CREATEUSERSWITHARRAYINPUT_SERVICE_ID = "createUsersWithArrayInput";
    public static final String CREATEUSERSWITHLISTINPUT_SERVICE_ID = "createUsersWithListInput";
    public static final String DELETEUSER_SERVICE_ID = "deleteUser";
    public static final String GETUSERBYNAME_SERVICE_ID = "getUserByName";
    public static final String LOGINUSER_SERVICE_ID = "loginUser";
    public static final String LOGOUTUSER_SERVICE_ID = "logoutUser";
    public static final String UPDATEUSER_SERVICE_ID = "updateUser";
    public static final String UUID_SERVICE_ID = "uuid";
    

    private UserApi service;

    //Handler for createUser
    final Handler<Message<io.vertx.core.json.JsonObject>> createUserHandler = message -> {
        try {
            ModelUser body = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getJsonObject("body").encode(), ModelUser.class);
            service.createUser(body, verticleHelper.getAsyncResultHandler(message, CREATEUSER_SERVICE_ID, false, new TypeReference<Void>(){}));

    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new UserApiException.CreateUser400Exception(e), CREATEUSER_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, CREATEUSER_SERVICE_ID);
        }
    };

    //Handler for createUsersWithArrayInput
    final Handler<Message<io.vertx.core.json.JsonObject>> createUsersWithArrayInputHandler = message -> {
        try {
            List<ModelUser> body = io.vertx.core.json.Json.mapper.readValue(
            									java.util.Optional.ofNullable(
            										message.body().getJsonArray("body")).map(io.vertx.core.json.JsonArray::encode).orElse("null"),
            									new TypeReference<List<ModelUser>>() {});
            service.createUsersWithArrayInput(body, verticleHelper.getAsyncResultHandler(message, CREATEUSERSWITHARRAYINPUT_SERVICE_ID, false, new TypeReference<Void>(){}));

    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new UserApiException.CreateUsersWithArrayInput400Exception(e), CREATEUSERSWITHARRAYINPUT_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, CREATEUSERSWITHARRAYINPUT_SERVICE_ID);
        }
    };

    //Handler for createUsersWithListInput
    final Handler<Message<io.vertx.core.json.JsonObject>> createUsersWithListInputHandler = message -> {
        try {
            List<ModelUser> body = io.vertx.core.json.Json.mapper.readValue(
            									java.util.Optional.ofNullable(
            										message.body().getJsonArray("body")).map(io.vertx.core.json.JsonArray::encode).orElse("null"),
            									new TypeReference<List<ModelUser>>() {});
            service.createUsersWithListInput(body, verticleHelper.getAsyncResultHandler(message, CREATEUSERSWITHLISTINPUT_SERVICE_ID, false, new TypeReference<Void>(){}));

    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new UserApiException.CreateUsersWithListInput400Exception(e), CREATEUSERSWITHLISTINPUT_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, CREATEUSERSWITHLISTINPUT_SERVICE_ID);
        }
    };

    //Handler for deleteUser
    final Handler<Message<io.vertx.core.json.JsonObject>> deleteUserHandler = message -> {
        try {
            String username = message.body().getString("username");
            service.deleteUser(username, verticleHelper.getAsyncResultHandler(message, DELETEUSER_SERVICE_ID, false, new TypeReference<Void>(){}));

        } catch (Exception e) {
            verticleHelper.manageError(message, e, DELETEUSER_SERVICE_ID);
        }
    };

    //Handler for getUserByName
    final Handler<Message<io.vertx.core.json.JsonObject>> getUserByNameHandler = message -> {
        try {
            String username = message.body().getString("username");
            service.getUserByName(username, verticleHelper.getAsyncResultHandler(message, GETUSERBYNAME_SERVICE_ID, true, new TypeReference<ModelUser>(){}));

        } catch (Exception e) {
            verticleHelper.manageError(message, e, GETUSERBYNAME_SERVICE_ID);
        }
    };

    //Handler for loginUser
    final Handler<Message<io.vertx.core.json.JsonObject>> loginUserHandler = message -> {
        try {
            String username = message.body().getString("username");
            String password = message.body().getString("password");
            service.loginUser(username, password, verticleHelper.getAsyncResultHandler(message, LOGINUSER_SERVICE_ID, false, new TypeReference<String>(){}));

        } catch (Exception e) {
            verticleHelper.manageError(message, e, LOGINUSER_SERVICE_ID);
        }
    };

    //Handler for logoutUser
    final Handler<Message<io.vertx.core.json.JsonObject>> logoutUserHandler = message -> {
        try {
            service.logoutUser(verticleHelper.getAsyncResultHandler(message, LOGOUTUSER_SERVICE_ID, false, new TypeReference<Void>(){}));

        } catch (Exception e) {
            verticleHelper.manageError(message, e, LOGOUTUSER_SERVICE_ID);
        }
    };

    //Handler for updateUser
    final Handler<Message<io.vertx.core.json.JsonObject>> updateUserHandler = message -> {
        try {
            String username = message.body().getString("username");
            ModelUser body = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getJsonObject("body").encode(), ModelUser.class);
            service.updateUser(username, body, verticleHelper.getAsyncResultHandler(message, UPDATEUSER_SERVICE_ID, false, new TypeReference<Void>(){}));

    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new UserApiException.UpdateUser400Exception(e), UPDATEUSER_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, UPDATEUSER_SERVICE_ID);
        }
    };

    //Handler for uuid
    final Handler<Message<io.vertx.core.json.JsonObject>> uuidHandler = message -> {
        try {
            UUID uuidParam = io.vertx.core.json.Json.mapper.readValue(
            						message.body().getJsonObject("uuidParam").encode(), UUID.class);
            service.uuid(uuidParam, verticleHelper.getAsyncResultHandler(message, UUID_SERVICE_ID, true, new TypeReference<InlineResponseDefault>(){}));

    	} catch (com.fasterxml.jackson.core.JsonProcessingException e) {
    		verticleHelper.manageError(message, new UserApiException.Uuid400Exception(e), UUID_SERVICE_ID);
        } catch (Exception e) {
            verticleHelper.manageError(message, e, UUID_SERVICE_ID);
        }
    };

    

    @Override
    public void start() throws Exception {
        service = createServiceImplementation();
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(CREATEUSER_SERVICE_ID).handler(createUserHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(CREATEUSERSWITHARRAYINPUT_SERVICE_ID).handler(createUsersWithArrayInputHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(CREATEUSERSWITHLISTINPUT_SERVICE_ID).handler(createUsersWithListInputHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(DELETEUSER_SERVICE_ID).handler(deleteUserHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(GETUSERBYNAME_SERVICE_ID).handler(getUserByNameHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(LOGINUSER_SERVICE_ID).handler(loginUserHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(LOGOUTUSER_SERVICE_ID).handler(logoutUserHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(UPDATEUSER_SERVICE_ID).handler(updateUserHandler);
        vertx.eventBus().<io.vertx.core.json.JsonObject> consumer(UUID_SERVICE_ID).handler(uuidHandler);
        
    }

    protected UserApi createServiceImplementation() {
        return new UserApiImpl(vertx, config());
    }
}

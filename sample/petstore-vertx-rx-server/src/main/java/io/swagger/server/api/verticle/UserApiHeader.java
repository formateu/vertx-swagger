package io.swagger.server.api.verticle;

import com.github.phiz71.vertx.swagger.router.ApiHeader;


public final class UserApiHeader extends ApiHeader {
    private UserApiHeader(String name, String value) {
        super(name, value);
    }
    
    private UserApiHeader(String name, Iterable<String> values) {
        super(name, values);
    }
    
    public static UserApiHeader UserApi_loginUser_200_createXRateLimit(Integer xRateLimit) {
        return new UserApiHeader("X-Rate-Limit", xRateLimit.toString());
    }
    
    public static UserApiHeader UserApi_loginUser_200_createXExpiresAfter(OffsetDateTime xExpiresAfter) {
        return new UserApiHeader("X-Expires-After", xExpiresAfter.toString());
    }
    
    public static UserApiHeader UserApi_loginUser_400_createWwWAuthenticate(String wwWAuthenticate) {
        return new UserApiHeader("WWW_Authenticate", wwWAuthenticate.toString());
    }
    
    

}
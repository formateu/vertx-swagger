package io.swagger.server.api.verticle;

import com.github.phiz71.vertx.swagger.router.ApiHeader;


public final class PetApiHeader extends ApiHeader {
    private PetApiHeader(String name, String value) {
        super(name, value);
    }
    
    private PetApiHeader(String name, Iterable<String> values) {
        super(name, values);
    }
    
    

}
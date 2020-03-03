package io.swagger.server.api.verticle;

import com.github.phiz71.vertx.swagger.router.ApiHeader;


public final class StoreApiHeader extends ApiHeader {
    private StoreApiHeader(String name, String value) {
        super(name, value);
    }
    
    private StoreApiHeader(String name, Iterable<String> values) {
        super(name, values);
    }
    
    

}
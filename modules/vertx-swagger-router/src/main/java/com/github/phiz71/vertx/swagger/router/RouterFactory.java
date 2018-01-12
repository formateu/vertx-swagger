package com.github.phiz71.vertx.swagger.router;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

@FunctionalInterface
public interface RouterFactory {

	Router create(Vertx vertx, String swaggerDefinition);
	
}

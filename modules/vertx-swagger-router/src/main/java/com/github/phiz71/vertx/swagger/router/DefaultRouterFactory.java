package com.github.phiz71.vertx.swagger.router;

import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class DefaultRouterFactory implements RouterFactory {

	@Override
	public Router create(Vertx vertx, String swaggerDefinition) {
		return create(vertx, Router.router(vertx), swaggerDefinition);
	}
	
	public Router create(Vertx vertx, Router baseRouter, String swaggerDefinition) {
		Swagger swagger = new SwaggerParser().parse(swaggerDefinition);
        return SwaggerRouter.swaggerRouter(baseRouter,
				swagger, vertx.eventBus(), new OperationIdServiceIdResolver());
	}

}

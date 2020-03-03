package io.swagger.server.api.util;

import io.reactivex.SingleTransformer;

public class ResourceResponseRxWrapper {
	
	public static <T> ResourceResponse<T> wrap(T content) {
		ResourceResponse<T> result = new ResourceResponse<T>();
		result.setResponse(content);
		return result;
	}
	
	public static <T> SingleTransformer<T, ResourceResponse<T>> emptyHeaderWrapper() {
		return single -> single.map(content -> wrap(content));
	}
	
}
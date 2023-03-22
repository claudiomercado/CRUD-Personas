package org.ar.app.apiresponseutil;

public class BaseApiResponse {
	
	
	public ApiResponseUtil<?> success(Object payload){
		return new ApiResponseUtil<>(ApiResponseConstant.MESSAGE_SUCCESS_200, ApiResponseConstant.CODE_MESSAGE_SUCCESS_200, payload);
	}
	
	public ApiResponseUtil<?> created(Object payload){
		return new ApiResponseUtil<>(ApiResponseConstant.MESSAGE_SUCCESS_201, ApiResponseConstant.CODE_MESSAGE_SUCCESS_201, payload);
	}
	
	public ApiResponseUtil<?> noContent(Object payload){
		return new ApiResponseUtil<>(ApiResponseConstant.MESSAGE_SUCCESS_204, ApiResponseConstant.CODE_MESSAGE_SUCCESS_204, payload);
	}
}

package com.owen.client.config;

import java.util.HashMap;
import java.util.Map;

import com.owen.common.exception.controller.ControllerException;
import com.owen.common.exception.hystrix.HytrixException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author 作者 owen E-mail: 624191343@qq.com
 * @version 创建时间：2017年11月12日 上午22:57:51 异常通用处理 服务于oauth 服务端于客户端
 */
@RestControllerAdvice
public class ExceptionHandlerAdvice {

	/**
	 * IllegalArgumentException异常处理返回json 状态码:400
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String, Object> badRequestException(IllegalArgumentException exception) {
		Map<String, Object> data = new HashMap<>();
		data.put("resp_code", HttpStatus.BAD_REQUEST.value());
		data.put("resp_msg", exception.getMessage());

		return data;
	}

	/**
	 * AccessDeniedException异常处理返回json 状态码:403
	 * 
	 * @param exception
	 * @return
	 */
	@ExceptionHandler({ AccessDeniedException.class })
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public Map<String, Object> badMethodExpressException(AccessDeniedException exception) {
		Map<String, Object> data = new HashMap<>();
		data.put("resp_code", HttpStatus.FORBIDDEN.value());
		data.put("resp_msg", exception.getMessage());

		return data;
	}

	@ExceptionHandler({ ControllerException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> controllerException(ControllerException exception) {
		Map<String, Object> data = new HashMap<>();
		data.put("resp_code", HttpStatus.INTERNAL_SERVER_ERROR.value());
		data.put("resp_msg", exception.getMessage());

		return data;
	}

	@ExceptionHandler({ HytrixException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> hytrixException(HytrixException exception) {
		Map<String, Object> data = new HashMap<>();
		data.put("resp_code", HttpStatus.INTERNAL_SERVER_ERROR.value());
		data.put("resp_msg", exception.getMessage());

		return data;
	}
}
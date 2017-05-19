
package com.order.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @classDesc: 功能描述:(全局异常捕获信息)
 * @author: 王浩
 * @createTime: 2017年5月10日 下午2:50:22
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Slf4j
@ControllerAdvice
public class AdviceController extends BaseController {
	@ExceptionHandler(RuntimeException.class)
	/**
	 * 
	 * @methodDesc: 功能描述:(全局捕获异常信息,接受请求抛出异常信息，会进入到该方法)
	 * @author: 王浩
	 * @param: @param
	 *             e
	 * @param: @return
	 *             返回错误信息
	 */
	@ResponseBody
	public Map<String, Object> exceptionHandler(RuntimeException e) {
		log.error("全局捕获异常###exceptionHandler()### ERROR:", e);
		return setResultError(e.getMessage());
	}
}

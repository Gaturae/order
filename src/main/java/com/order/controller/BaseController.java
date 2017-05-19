
package com.order.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.order.constants.ConstantsCode;
import com.order.constants.JSONFeldConstants;
import com.order.util.ListUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @classDesc: 功能描述:(控制器类父类)
 * @author: 王浩
 * @createTime: 2017年5月9日 下午7:37:32
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Slf4j
public class BaseController {

	/**
	 * 
	 * @methodDesc: 功能描述:(封装Result数据,使用场景返回参数错误)
	 * @author: 王浩
	 * @param: @param
	 *             refMsg 错误码
	 */
	protected static Map<String, Object> setResultParameError(String refMsg) {

		return setResult(ConstantsCode.ERROR_PARAMETER, refMsg, null);
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(封装Result数据,使用场景返回错误信息)
	 * @author: 王浩
	 * @param: @param
	 *             refMsg 错误码
	 */
	protected static Map<String, Object> setResultError(String refMsg) {

		return setResult(ConstantsCode.ERROR_SYSTEM, refMsg, null);
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(封装Result数据,使用场景返回true信息)
	 * @author: 王浩
	 * @param: @param
	 *             data 返回数据
	 */
	protected static Map<String, Object> setResultTrue(Object data) {

		return setResult(ConstantsCode.SUCCESS, null, data);
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(封装Result数据)
	 * @author: 王浩
	 * @param: @param
	 *             retCode 错误码
	 * @param: @param
	 *             refMsg 错误消息
	 * @param: @param
	 *             data 返回数据
	 */
	private static Map<String, Object> setResult(String retCode, String refMsg, Object data) {
		// 如果retCode 为true 默认retCode 为true
		if (StringUtils.isEmpty(retCode)) {
			retCode = ConstantsCode.SUCCESS;
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put(JSONFeldConstants.KEY_RETCODE, retCode);
		if (!StringUtils.isEmpty(refMsg)) {
			resultMap.put(JSONFeldConstants.KEY_REFMSG, refMsg);
		}
		if (data != null) {
			resultMap.put(JSONFeldConstants.KEY_DATA, data);
		}
		// 打印返回日志
		printLog(retCode, resultMap);
		return resultMap;
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(打印日志信息)
	 * @author: 王浩
	 * @param: @param
	 *             retCode 错误码
	 * @param: @param
	 *             resultMap 返回结果
	 */
	public static void printLog(String retCode, Map<String, Object> resultMap) {
		String resultJSONStr = null;
		if (ListUtils.isEmptyMap(resultMap)) {
			resultJSONStr = JSON.toJSONString(resultMap);
		}
		if (retCode.equals(ConstantsCode.SUCCESS)) {
			log.info("setResult() SUCCESS resultJSONStr:{}", resultJSONStr);
		}
		if (retCode.equals(ConstantsCode.ERROR_SYSTEM)) {
			log.error("setResult() ERROR resultJSONStr:{}", resultJSONStr);
		}
		if (retCode.equals(ConstantsCode.ERROR_PARAMETER)) {
			log.warn("setResult() ERROR resultJSONStr:{}", resultJSONStr);
		}
	}
}

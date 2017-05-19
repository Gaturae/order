package com.order.util;

import org.apache.commons.lang3.StringUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @classDesc: 功能描述:(类型转换工具类)
 * @author: 王浩
 * @createTime: 2017年5月9日 下午7:26:56
 * @version: v1.0
 * @copyright:善林科技
 */
@Slf4j
public class TransforUtils {

	/**
	 * 功能说明:将string类型转换为Long类型
	 */
	public static Long parseLong(String object) {
		if (StringUtils.isEmpty(object)) {
			return null;
		}
		Long result = null;
		try {
			result = Long.parseLong(object);
		} catch (Exception e) {
			log.error("TransforUtils.parseLong() ERROR:", e);
		}

		return result;
	}

	/**
	 * 功能说明:将string类型转换为Integer类型
	 */
	public static Integer parseInteger(String object) {
		if (StringUtils.isEmpty(object)) {
			return null;
		}
		Integer result = null;
		try {
			result = Integer.parseInt(object);
		} catch (Exception e) {
			log.error("TransforUtils.parseLong() ERROR:", e);
		}
		return result;
	}

}

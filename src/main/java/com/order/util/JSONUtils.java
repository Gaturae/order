package com.order.util;

import java.math.BigDecimal;
import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @classDesc: 功能描述:(对阿里巴巴旗下fastjson json封装)
 * @author: 王浩
 * @createTime: 2017年5月9日 下午7:18:37
 * @version: v1.0
 * @copyright:善林科技
 */
@Slf4j
public class JSONUtils {

	/**
	 * 功能说明:获取JSONObject对象
	 */
	public static JSONObject getJSONObject(JSONObject obj, String key) {
		if (!obj.containsKey(key)) {
			return null;
		}
		return obj.getJSONObject(key);

	}

	/**
	 * 功能说明:获取String
	 */
	public static String getString(JSONObject obj, String key) {
		if (!obj.containsKey(key)) {
			return null;
		}
		return obj.getString(key);
	}

	/**
	 * 功能说明:获取BigDecimal
	 */
	public static BigDecimal getBigDecimal(JSONObject obj, String key) {
		if (!obj.containsKey(key)) {
			return null;
		}
		return obj.getBigDecimal(key);
	}

	/**
	 * 功能说明:将JSON字符穿
	 */
	public static JSONObject parseObject(String json) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		JSONObject parseObject = null;
		try {
			parseObject = JSONObject.parseObject(json);
		} catch (Exception e) {
			log.error("parseObject()  ERROR:" + e);
		}
		return parseObject;
	}

	/**
	 * 功能说明:将JSON字符串转为JSONARRAY
	 */
	public static JSONArray parseJSONArray(String json) {
		if (StringUtils.isEmpty(json)) {
			return null;
		}
		JSONArray JSONArray = null;
		try {
			JSONArray = JSONObject.parseArray(json);
		} catch (Exception e) {
			log.error("parseObject()  ERROR:" + e);
		}
		return JSONArray;
	}

	/**
	 * 功能说明:将JSON字符穿
	 */
	public static JSONArray getJSONArray(JSONObject obj, String key) {
		if (!obj.containsKey(key)) {
			return null;
		}
		return obj.getJSONArray(key);
	}

	/**
	 * 功能说明: 获取json long结果
	 */
	public static Long getLong(JSONObject obj, String key) {
		if (!obj.containsKey(key)) {
			return null;
		}
		Long value = null;
		try {
			value = obj.getLong(key);
		} catch (Exception e) {
			log.error("getLong() ERROR:", e);
		}
		return value;
	}

}

package com.order.util;

import java.util.Map;

/**
 * 
 * @classDesc: 功能描述:(MapUtil)
 * @author: 王浩
 * @createTime: 2017年5月10日 下午8:06:45
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class MapUtil {

	/**
	 * 判断map中的某个值是否为空，非线程安全
	 * 
	 * @param key
	 * @return
	 */
	public static boolean isBlank(Map params, String key) {
		// 如果map为空，则返回false
		if (params == null || params.isEmpty())
			return true;

		// 如果map不包含此key，则返回false
		if (!params.containsKey(key))
			return true;

		// 如果map包含此参数，且值类型为String
		if (params.get(key) instanceof String) {
			// 如果字符串为空，则返回false
			String value = (String) params.get(key);
			if (value == null || "".equals(value))
				return true;

		} else {
			// 如果值为null，则返回false
			if (params.get(key) == null)
				return true;
		}
		return false;
	}

	public static boolean overLength(Map<String, String> params, String key, int length) {
		if (params.get(key).length() > length)
			return true;
		return false;
	}
}

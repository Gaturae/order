package com.order.util;

import java.util.List;
import java.util.Map;

/**
 * 
 * @classDesc: 功能描述:(list集合相关工具类)
 * @author: 王浩
 * @createTime: 2017年5月9日 下午7:16:34
 * @version: v1.0
 * @copyright:善林科技
 */
public class ListUtils {

	/**
	 * 
	 * @methodDesc: 功能描述:(判断集合是否存在数据)
	 * @author: 王浩
	 * @param: @param
	 *             list 集合
	 * @param: @return
	 * @createTime:2017年5月9日 下午7:17:10
	 * @returnType:@param list
	 * @returnType:@return boolean 有数据返回true,没有数据返回false
	 */
	public static boolean isEmptyList(List<?> list) {
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(判断集合是否存在数据)
	 * @author: 王浩
	 * @param: @param
	 *             list 集合
	 * @param: @return
	 * @createTime:2017年5月9日 下午7:17:10
	 * @returnType:@param list
	 * @returnType:@return boolean 有数据返回true,没有数据返回false
	 */
	public static boolean isEmptyMap(Map<?, ?> map) {
		if (map == null || map.size() == 0) {
			return false;
		}
		return true;
	}
}

package com.order.util;

import java.io.UnsupportedEncodingException;

/**
 * 
 * @classDesc: 功能描述:(url转码 解码)
 * @author: 王浩
 * @createTime: 2017年5月10日 下午8:10:48
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class UrlUtils {

	private final static String ENCODE = "GBK";

	/**
	 * 
	 * @methodDesc: 功能描述:(URL 解码)
	 * @author: 王浩
	 * @param: @param
	 *             str
	 * @param: @return
	 * @createTime:2017年5月10日 下午8:12:20
	 * @returnType:@param str
	 * @returnType:@return String
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	public static String getURLDecoderString(String str) {
		String result = "";
		if (null == str) {
			return "";
		}
		try {
			result = java.net.URLDecoder.decode(str, ENCODE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(URL 转码)
	 * @author: 王浩
	 * @param: @param
	 *             str
	 * @param: @return
	 * @createTime:2017年5月10日 下午8:12:29
	 * @returnType:@param str
	 * @returnType:@return String
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	public static String getURLEncoderString(String str) {
		String result = "";
		if (null == str) {
			return "";
		}
		try {
			result = java.net.URLEncoder.encode(str, ENCODE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

}

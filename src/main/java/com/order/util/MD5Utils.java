/**
 * 
 */
package com.order.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @classDesc: 功能描述:(生成MD5)
 * @author: 王浩
 * @createTime: 2017年5月10日 下午8:08:09
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class MD5Utils {

	public static String encoder(String str, String charset) {
		try {
			return DigestUtils.md5Hex(str.getBytes(charset));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}

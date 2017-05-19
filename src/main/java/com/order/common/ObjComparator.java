package com.order.common;

import java.util.Comparator;
import java.util.Date;

/**
 * 
 * @classDesc: 功能描述:(ObjComparator)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:24:07
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class ObjComparator implements Comparator {
	private String key;

	public int compare(Object obj1, Object obj2) {
		Object v1 = EvalTool.eval(obj1, "item." + key);
		Object v2 = EvalTool.eval(obj2, "item." + key);
		if (v1 == null || "".equals(v1)) {
			v1 = "0";
		}
		if (v2 == null || "".equals(v2)) {
			v2 = "0";
		}
		if (v1.getClass().getSimpleName().equals("Date")) {
			v1 = ((Date) v1).getTime();
		}
		if (v2.getClass().getSimpleName().equals("Date")) {
			v2 = ((Date) v2).getTime();
		}
		return new Double(v1 + "").compareTo((new Double(v2 + "")));
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}

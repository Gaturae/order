package com.order.common;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @classDesc: 功能描述:(正則)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:24:42
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class RegexTool {
	private String codestr;
	private String regex;

	public String getCodestr() {
		return codestr;
	}

	public void setCodestr(String codestr) {
		this.codestr = codestr;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public boolean isMatching() {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(codestr);
		boolean isnum = true;
		isnum = m.matches();
		return isnum;
	}

	public List findMatchingList() {

		List list = new ArrayList();
		Matcher m = Pattern.compile(regex).matcher(codestr);
		while (m.find()) {
			list.add(m.group(0));
		}
		return list;
	}


}

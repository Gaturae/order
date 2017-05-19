package com.order.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @classDesc: 功能描述:(分页查询)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:24:24
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class PageQuery implements Serializable {

	private Integer pageSize = 10; // 每页条数
	private Integer pageIndex = 1; // 当前页码
	private Map<String, Object> params = new HashMap<String, Object>(); // 查询条件
	private Object example; // 通过模版查询
	private String table; // 查询表
	private String orderField; // 排序字段
	private boolean desc = false; // 是否逆序
	private boolean isPaging = true; // 是否分页
	private List<String> express = new ArrayList<String>(); // 查询条件

	public void addCondition(String express) {
		this.express.add(express);
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void setParam(String key, Object value) {
		this.getParams().put(key, value);
	}

	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public boolean isPaging() {
		return isPaging;
	}

	public void setPaging(boolean isPaging) {
		this.isPaging = isPaging;
	}

	public Object getExample() {
		return example;
	}

	public void setExample(Object example) {
		this.example = example;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public boolean isDesc() {
		return desc;
	}

	public void setDesc(boolean desc) {
		this.desc = desc;
	}

	public List<String> getExpress() {
		return express;
	}

	public void setExpress(List<String> express) {
		this.express = express;
	}

}

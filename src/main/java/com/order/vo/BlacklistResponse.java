package com.order.vo;

import java.util.List;

import lombok.Data;

/**
 * 
 * @classDesc: 功能描述:(黑名单内匹entity)
 * @author: 王浩
 * @createTime: 2017年5月16日 下午8:17:56
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Data
public class BlacklistResponse {

	/**
	 * 查询请求编码
	 */
	private String paramCode;

	/**
	 * 命中记录数
	 */
	private Integer count;

	/**
	 * 命中字段集
	 */
	private List<HitResponse> hitResponseList;
}

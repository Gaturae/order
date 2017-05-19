package com.order.vo;

import lombok.Data;

/**
 * @classDesc: 功能描述:(拆分请求)
 * @author: 左越  
 * @createTime: 2017年5月11日 上午10:35:28  
 * @version: v1.0  
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Data
public class SplitRequest {
	
	/**
	 * 查询标识码
	 */
	private String identification;
	
	/**
	 * 匹配类型 （1.身份证 2.手机号 3.固定电话 4.地址 5.单位名称）
	 */
    private Integer matchType;
    
    /**
     * 查询请求的内容
     */
    private String splitContent;
    
    /**
     * 查询请求字段
     */
    private String splitField;
    
}

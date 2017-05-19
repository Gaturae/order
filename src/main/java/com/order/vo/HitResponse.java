package com.order.vo;

import java.util.Date;

import lombok.Data;

/**
 * @classDesc: 功能描述:(黑名单封装返回数据-命中结果集)
 * @author: 左越  
 * @createTime: 2017年5月11日 上午10:56:52  
 * @version: v1.0  
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Data
public class HitResponse {

	/**
	 * 序号
	 */
	private String hitNo;
	
	/**
	 * 查询内容（查询请求的内容）
	 */
    private String selectContent;
    
    /**
     * 匹配字段（返回命中的字段名称）
     */
    private String machField;
    
    /**
     * 匹配内容（返回匹配的具体内容）
     */
    private String machingContent;
    
    /**
     * 匹配结果（返回：一致/不一致/相似）
     */
    private String machingResult;
    
    /**
     * 黑名单标签（数组：["黑产","欺诈",""....]）
     */
    private String blackLabel;
    
    /**
     * 加黑时间
     */
    private Date blackDate;
    
    /**
     * 加黑描述
     */
    private String blackkDesc;
    
    /**
     * 贷款产品名称
     */
    private String productName;
    
    /**
     * 是否内部
     */
    private String isInside;
    
    /**
     * 来源
     */
    private String source;
    
}

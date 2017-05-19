package com.order.vo;

import lombok.Data;

/**
 * @classDesc: 功能描述:(黑名单联系人原始请求参数)
 * @author: 左越  
 * @createTime: 2017年5月11日 上午10:19:57  
 * @version: v1.0  
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Data
public class ContactRequest {

	/**
	 * 联系人姓名
	 */
	private String contactsName;

	/**
	 * 联系人手机号
	 */
    private String contactsPhone;
    
    /**
     * 联系人关系
     */
    private String contactsRelations;
    
}

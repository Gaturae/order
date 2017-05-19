
package com.order.vo;

import lombok.Data;

/**
 * 
 * @classDesc: 功能描述:(DemoEntity)
 * @author: 王浩
 * @createTime: 2017年5月10日 下午8:46:59
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Data
public class DemoEntity extends BaseEntity {
	/**
	 * 用户userId
	 */
	private String userId;
	/**
	 * 用户名称
	 */
	private String userName;
}

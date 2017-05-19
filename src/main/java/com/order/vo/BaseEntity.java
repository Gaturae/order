
package com.order.vo;

import java.util.Date;

import lombok.Data;

/**
 * 
 * @classDesc: 功能描述:(父类)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午10:17:35
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Data
public class BaseEntity {
	private Long id;
	// 创建者
	private String creator;
	// 修改者
	private String modifier;
	// 创建时间
	private Date gmtCreated;
	// 修改时间
	private Date gmtModified;
	// 是否删除
	private char isDeleted;

}

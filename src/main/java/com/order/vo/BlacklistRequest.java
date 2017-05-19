package com.order.vo;

import java.util.List;

import lombok.Data;

/**
 * @classDesc: 功能描述:(黑名单原始请求参数)
 * @author: 左越
 * @createTime: 2017年5月11日 上午10:16:36
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Data
public class BlacklistRequest {

	/**
	 * 查询标识码
	 */
	private String identification;

	/**
	 * 借款人姓名
	 */
	private String borrowerName;

	/**
	 * 借款人身份证号
	 */
	private String borrowerIdNum;

	/**
	 * 借款人手机号
	 */
	private String borrowerPhoneNum;

	/**
	 * 配偶姓名
	 */
	private String spouseName;

	/**
	 * 配偶手机号
	 */
	private String spousePhoneNum;

	/**
	 * 家庭住址
	 */
	private String homeAddress;

	/**
	 * 家庭电话
	 */
	private String homePhone;

	/**
	 * 工作单位名称
	 */
	private String companyName;

	/**
	 * 工作单位地址
	 */
	private String companyAddress;

	/**
	 * 单位电话
	 */
	private String companyPhone;
	/**
	 * 联系人
	 */
	private List<ContactRequest> contactRequests;
}

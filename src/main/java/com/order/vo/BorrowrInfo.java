package com.order.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class BorrowrInfo    {


	/**
	 * TODO
	 */

	// private static final long serialVersionUID = 4248359786738358042L;

	/*
	 * 贷款人ID（主表）
	 */
	private Integer id;
    
	/*
	 * d 借款人身份证Id
	 */
	private String pid;

	/*
	 * 借款人姓名
	 */
	private String borrowerName;

	/*
	 * 借款人电话
	 * 
	 */
	private String borrowerPhoneNum;

	/*
	 * 家庭住址
	 */
	private String homeAddress;

	/*
	 * 家庭电话
	 */
	private String homePhone;

	/*
	 * 婚姻状态
	 */
	private Integer maritalStatus;

	/*
	 * 配偶公司
	 */
	private String spouseCompany;
	/*
	 * 配偶姓名
	 */
	private String spouseName;

	/*
	 * 配偶电脑
	 */
	private String spousePhoneNum;

	/*
	 * 单位地址
	 */
	private String workAddress;

	/*
	 * 单位名称
	 */
	private String workName;

	/*
	 * 单位电话
	 */
	private String workPhone;

}
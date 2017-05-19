
package com.order.vo;

import java.util.Date;

import lombok.Data;

/**
 * @classDesc: 功能描述:(黑名单数据库查询封装集合)
 * @author: 左越  
 * @createTime: 2017年5月11日 下午2:35:32  
 * @version: v1.0  
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Data
public class BlacklistVO {
	
	/**
	 * 黑名单基表ID（用户筛选重复的数据）
	 */
	private String bid;

	/**
	 * 借款人身份证
	 */
    private String pid;
    
    /**
     * 借款人手机号
     */
    private String borrowerPhoneNum;
    
    /**
     * 配偶手机号
     */
    private String spousePhoneNum;
    
    /**
     * 家庭电话
     */
    private String homePhone;
    
    /**
     * 家庭住址
     */
    private String homeAddress;
    
    /**
     * 单位名称
     */
    private String workName;
    
    /**
     * 单位电话
     */
    private String workPhone;
    
    /**
     * 工作单位地址
     */
    private String workAddress;
    
    /**
     * 联系人姓名
     */
    private String contactsName;

    /**
     * 联系人电话
     */
    private String contactsPhone;

    /**
     * 联系人关系
     */
    private String contactsRelation;
    
    /**
     * 加黑时间
     */
    private Date confirmAt;
    
    /**
     * 加黑原因
     */
    private String comment;
    
    /**
     * 加黑标签
     */
    private String blacklistTag;
    
    /**
     * 贷款产品名称
     */
    private String loanName;
    
    /**
     * 加黑原因描述
     */
    private String defriendDes;
    
    /**
     * 是否内部
     */
    private String isInterior;
    
    /**
     * 黑名单来源
     */
    private String defriendSource;
    
}

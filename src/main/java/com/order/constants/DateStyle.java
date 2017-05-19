package com.order.constants;
/**
 * 
 * @classDesc: 功能描述:(DateStyle)
 * @author: 王浩  
 * @createTime: 2017年5月10日 下午8:02:48  
 * @version: v1.0  
 * @copyright:善林(上海)金融信息服务有限公司
 */
public enum DateStyle {
	YYYY_MM("yyyy-MM", false),  
    YYYY_MM_DD("yyyy-MM-dd", false),  
    YYYY_MM_DD_HH_MM("yyyy-MM-dd HH:mm", false),  
    YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss", false),  
      
    YYYY_MM_EN("yyyy/MM", false),  
    YYYY_MM_DD_EN("yyyy/MM/dd", false),  
    YYYY_MM_DD_HH_MM_EN("yyyy/MM/dd HH:mm", false),  
    YYYY_MM_DD_HH_MM_SS_EN("yyyy/MM/dd HH:mm:ss", false),  
      
    YYYY_MM_CN("yyyy年MM月", false),  
    YYYY_MM_DD_CN("yyyy年MM月dd日", false),  
    YYYY_MM_DD_HH_MM_CN("yyyy年MM月dd日 HH:mm", false),  
    YYYY_MM_DD_HH_MM_SS_CN("yyyy年MM月dd日 HH:mm:ss", false),  
      
    HH_MM("HH:mm", true),  
    HH_MM_SS("HH:mm:ss", true),  
      
    MM_DD("MM-dd", true),  
    MM_DD_HH_MM("MM-dd HH:mm", true),  
    MM_DD_HH_MM_SS("MM-dd HH:mm:ss", true),  
      
    MM_DD_EN("MM/dd", true),  
    MM_DD_HH_MM_EN("MM/dd HH:mm", true),  
    MM_DD_HH_MM_SS_EN("MM/dd HH:mm:ss", true),  
      
    MM_DD_CN("MM月dd日", true),  
    MM_DD_HH_MM_CN("MM月dd日 HH:mm", true),  
    MM_DD_HH_MM_SS_CN("MM月dd日 HH:mm:ss", true);  
      
    private String value;  
      
    private boolean isShowOnly;  
      
    DateStyle(String value, boolean isShowOnly) {  
        this.value = value;  
        this.isShowOnly = isShowOnly;  
    }  
      
    public String getValue() {  
        return value;  
    }  
      
    public boolean isShowOnly() {  
        return isShowOnly;  
    }  
}

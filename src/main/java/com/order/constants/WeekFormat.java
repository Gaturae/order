package com.order.constants;
/**
 * 
 * @classDesc: 功能描述:(WeekFormat)
 * @author: 王浩  
 * @createTime: 2017年5月10日 下午8:04:07  
 * @version: v1.0  
 * @copyright:善林(上海)金融信息服务有限公司
 */
public enum WeekFormat {
	MONDAY("星期一", "Monday", "Mon.", 1),  
    TUESDAY("星期二", "Tuesday", "Tues.", 2),  
    WEDNESDAY("星期三", "Wednesday", "Wed.", 3),  
    THURSDAY("星期四", "Thursday", "Thur.", 4),  
    FRIDAY("星期五", "Friday", "Fri.", 5),  
    SATURDAY("星期六", "Saturday", "Sat.", 6),  
    SUNDAY("星期日", "Sunday", "Sun.", 7);  
      
    String name_cn;  
    String name_en;  
    String name_enShort;  
    int number;  
      
    WeekFormat(String name_cn, String name_en, String name_enShort, int number) {  
        this.name_cn = name_cn;  
        this.name_en = name_en;  
        this.name_enShort = name_enShort;  
        this.number = number;  
    }  
      
    public String getChineseName() {  
        return name_cn;  
    }  
  
    public String getName() {  
        return name_en;  
    }  
  
    public String getShortName() {  
        return name_enShort;  
    }  
  
    public int getNumber() {  
        return number;  
    }  
}

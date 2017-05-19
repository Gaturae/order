
package com.order.constants;

/**
 * 
 * @classDesc: 功能描述:(订单状态说明 枚举类)
 * @author: 王浩
 * @createTime: 2017年5月19日 下午7:03:09
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public enum OrderStatus {
	
	MONDAY("待初审", "PendingTrial", "one.", 001),  
    TUESDAY("审核拒绝", "AuditReject", "two.", 002),  
    WEDNESDAY("待业务员采集信息", "scInformation", "three.", 003),  
    THURSDAY("待签约", "PendingContract", "four.", 004),  
    FRIDAY("待放款", "LoanPending", "five.", 005),  
    SATURDAY("还款中", "Repayment", "six.", 006),  
    SUNDAY("已还清", "PaidOff", "seven.", 007);  

	String name_cn;  
    String name_en;  
    String name_enShort;  
    int number;  
      
    OrderStatus(String name_cn, String name_en, String name_enShort, int number) {  
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

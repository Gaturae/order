/**  
 * Project Name:order  
 * File Name:OrgProBusiCode.java  
 * Package Name:com.order.constants  
 * Date:2017年5月19日下午3:26:36  
 * Copyright (c) 2017, dancoder@163.com All Rights Reserved.  
 *  
*/  
  
package com.order.constants;  
/**  
 * ClassName:OrgProBusiCode
 * Date:     2017年5月19日 下午3:26:36  
 * @author   狗蛋  
 * @version      
 */
public enum OrgProBusiCode {
	
	/** 违法不良信息*/
	ILLEGAL_INFORMATION("60016");
	
	private final String busiCode;

	public String getBusiCode() {
		return busiCode;
	}
	
	private OrgProBusiCode(String busiCode){
		this.busiCode = busiCode;
	}
}
  

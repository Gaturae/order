package com.order.service;

import java.util.List;

import com.order.vo.BlacklistResponse;
import com.order.vo.SplitRequest;

/**
 * @classDesc: 功能描述:(黑名单-接口)
 * @author: 左越  
 * @createTime: 2017年5月11日 下午1:24:11  
 * @version: v1.0  
 * @copyright:善林(上海)金融信息服务有限公司
 */
public interface BlacklistService {

	/**
	 * @methodDesc: 功能描述:(获取内部数据库匹配的黑名单集合)
	 * @author: 左越  
	 * @param: @param splitRequests
	 * @param: @return   
	 * @throws Exception 
	 * @createTime:2017年5月11日 下午2:33:14
	 * @returnType:List<BlacklistResponse>
	 */
	public BlacklistResponse getBlacklist(List<SplitRequest> splitRequests) throws Exception;
}

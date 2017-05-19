
package com.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.common.EmptyUtil;
import com.order.service.BlacklistService;
import com.order.util.SplitRequestUtil;
import com.order.vo.BlacklistRequest;
import com.order.vo.BlacklistResponse;
import com.order.vo.SplitRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @classDesc: 功能描述:(订单控制器)
 * @author: 王浩
 * @createTime: 2017年5月16日 下午8:16:27
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Slf4j
@RestController
@RequestMapping("/blacklistAPI")
public class OrderController extends BaseController {

	@Autowired
	private BlacklistService blacklistService;

	@RequestMapping("/queryOrder")
	public Map<String, Object> getBlacklist(@RequestBody String requestStr) {
		BlacklistResponse blacklistResponse = new BlacklistResponse();
		BlacklistRequest blacklistRequest = JSONObject.parseObject(requestStr, BlacklistRequest.class);
		if (EmptyUtil.isBlank(blacklistRequest)) {
			return setResultParameError("请求参数错误!");
		}
		try {
			// 拆分原始请求
			List<SplitRequest> splitRequests = SplitRequestUtil.splitRequest(blacklistRequest);
			if (EmptyUtil.isBlank(splitRequests)) {
				return setResultParameError("请求参数错误!");
			}
			// 黑名单数据库轮查
			blacklistResponse = blacklistService.getBlacklist(splitRequests);
			// blacklistResponse.setParamCode(blacklistRequest.getIdentification());
//			ObjectMapper objectMapper = new ObjectMapper();
//			String json = objectMapper.writeValueAsString(setResultTrue(blacklistResponse));
			Map<String, Object> map = setResultTrue(blacklistResponse);
//			System.out.println(map);
			return map;
		} catch (Exception e) {
			log.error("###getBlacklist()### ERROR:{}", e);
			return setResultError("getBlacklist() ERROR:" + e.getMessage());
		}
	}
}

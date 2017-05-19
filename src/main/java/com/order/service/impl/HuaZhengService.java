/**  
 * Project Name:order  
 * File Name:HuaZhengService.java  
 * Package Name:com.order.service.impl  
 * Date:2017年5月19日下午2:55:01  
 * Copyright (c) 2017, dancoder@163.com All Rights Reserved.  
 *  
*/

package com.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.constants.OrgProBusiCode;
import com.order.entity.IllegalInformationVO;
import com.order.util.HttpClientUtil;

/**
 * ClassName:HuaZhengService Date: 2017年5月19日 下午2:55:01
 * 
 * @author 狗蛋
 * @version
 * @Description: 调用华征接口
 */
@Service
public class HuaZhengService {

	private final static String mercode = "201703280000010";
	private final static String proname = "善林";
	private final static String huaZhengIllegalInformationUrl = "http://121.43.163.141:8080/hz/illegalInformation";
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * getIllegalInformation:(获取违法不良信息)
	 * 
	 * @author 狗蛋
	 * @date 2017年5月19日 下午4:01:45
	 * @param json
	 * @return
	 */
	public String getIllegalInformation(String json) {

		IllegalInformationVO illegalInformationVO = new IllegalInformationVO();
		try {
			illegalInformationVO = JSONObject.parseObject(json, IllegalInformationVO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<>();
		map.put("mercode", mercode);
		map.put("proname", proname);
		map.put("reqtime", df.format(new Date()));
		map.put("busicode", OrgProBusiCode.ILLEGAL_INFORMATION.getBusiCode());
		map.put("name", illegalInformationVO.getName());
		map.put("cardNo", illegalInformationVO.getCardNo());

		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = null;
		try {
			requestBody = objectMapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		// JSONObject JsonObject = JSONObject.parseObject(requestBody);

		String response = HttpClientUtil.post(huaZhengIllegalInformationUrl, requestBody);
		return response;
	}
}

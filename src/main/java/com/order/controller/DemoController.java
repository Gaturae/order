
package com.order.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.order.constants.JSONFeldConstants;
import com.order.service.DemoService;
import com.order.util.FTPUtil;
import com.order.util.ListUtils;
import com.order.vo.DemoEntity;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @classDesc: 功能描述:(DemoController样例)
 * @author: 王浩
 * @createTime: 2017年5月9日 下午8:13:07
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@Slf4j
@RestController
public class DemoController extends BaseController {
	/**
	 * demo测试服务类
	 */
	@Autowired
	private DemoService demoService;

	/**
	 * 
	 * @methodDesc: 功能描述:(获取用户信息)
	 * @author: 王浩
	 * @param: @param
	 *             userId 用户userId
	 * @param: @param
	 *             userName 用户名称
	 * @param: @return
	 */
	@RequestMapping("/saveDemo")
	public Map<String, Object> saveDemo(String userId, String userName) {
		// 1.检查数据
		if (StringUtils.isEmpty(userId)) {
			return setResultParameError("id不能为空!");
		}
		if (StringUtils.isEmpty(userName)) {
			return setResultParameError("userName不能为空!");
		}
		// 2.组装数据
		DemoEntity demoVo = new DemoEntity();
		demoVo.setUserId(userId);
		demoVo.setUserName(userName);
		// 3.调用接口添加数据
		try {
			Long demoId = demoService.saveDemo(demoVo);
			JSONObject resultData = new JSONObject();
			resultData.put(JSONFeldConstants.KEY_DEMOID, demoId);
			// 4.成功返回数据
			return setResultTrue(resultData);
		} catch (Exception e) {
			log.error("###saveDemo()### ERROR:{}", e);
			return setResultError("saveDemo() ERROR:" + e.getMessage());
		}
	}

	/**
	 * 
	 * @methodDesc: 功能描述:(查询所有Demo信息)
	 * @author: 王浩
	 * @param: @param
	 *             userId
	 * @param: @return
	 * @createTime:2017年5月10日 上午11:45:26
	 * @returnType:@param userId
	 * @returnType:@return Map<String,Object>
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	@RequestMapping("/listDemoVo")
	public Map<String, Object> listDemoVo(String userId) {
		// 1.参数验证
		if (StringUtils.isEmpty(userId)) {
			return setResultParameError("userID 参数不能为空!");
		}
		DemoEntity demoVo = new DemoEntity();
		demoVo.setUserId(userId);
		// 2.调用服务查询数据
		try {
			List<DemoEntity> demoVoList = demoService.getDemoVo(demoVo);
			if (!ListUtils.isEmptyList(demoVoList)) {
				return setResultError("未查询到结果");
			}
			return setResultTrue(demoVoList);
		} catch (Exception e) {
			log.error("###listDemoVo()### ERROR:{}", e);
			return setResultError("listDemoVo() ERROR:" + e.getMessage());
		}

	}

	/**
	 * 
	 * @methodDesc: 功能描述:(抛出异常信息测试)
	 * @author: 王浩
	 * @param: @return
	 * @createTime:2017年5月10日 下午2:59:22
	 * @returnType:@return Map<String,Object>
	 */
	@RequestMapping("/throwAnormal")
	public Map<String, Object> throwAnormal() {
		throw new RuntimeException("advice1 - exception1");
	}
	

	

}

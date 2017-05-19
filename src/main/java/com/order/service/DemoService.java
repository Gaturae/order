
package com.order.service;

import java.util.List;

import com.order.vo.DemoEntity;

/**
 * 
 * @classDesc: 功能描述:(DemoService 服务类)
 * @author: 王浩
 * @createTime: 2017年5月9日 下午8:17:11
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public interface DemoService {
	/**
	 * 
	 * @methodDesc: 功能描述:(添加Demo信息)
	 * @author: 王浩
	 * @param: @param
	 *             DemoVo Demo实体类
	 * @param: @return
	 *             返回测试数据
	 */
	public Long saveDemo(DemoEntity emoEntity);

	/**
	 * 
	 * @methodDesc: 功能描述:(查询demo信息)
	 * @author: 王浩
	 * @param: @param
	 *             demoVo
	 * @param: @return
	 * @createTime:2017年5月10日 上午11:38:05
	 * @returnType:@param demoVo
	 * @returnType:@return List<DemoVo>
	 * @copyright:善林(上海)金融信息服务有限公司
	 */
	public List<DemoEntity> getDemoVo(DemoEntity emoEntity);
}

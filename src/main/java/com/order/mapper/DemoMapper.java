
package com.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.order.common.BaseDao;
import com.order.vo.DemoEntity;

/**
 * 
 * @classDesc: 功能描述:(Demo测试服务类)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午10:08:50
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public interface DemoMapper extends BaseDao {

	@Select("SELECT ID,USER_ID as userId ,USER_NAME as userName,creator,modifier,gmtCreated,gmtModified ,isDeleted  from demo   where  USER_ID=#{userId}")
	public List<DemoEntity> getDemoVo(DemoEntity demoVo);

}

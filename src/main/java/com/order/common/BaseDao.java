package com.order.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

/**
 * 
 * @classDesc: 功能描述:(无需编写sql,实现新增、更新、删除操作 obj,table两个参数名不允许修改)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:22:27
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public interface BaseDao {

	@InsertProvider(type = CommonSqlProvider.class, method = "insert")
	public void insert(@Param("obj") Object obj, @Param("table") String table);

	/**
	 * 功能说明:新增成功后,mybatis 注解 insertPrimaryKey 返回主键
	 */
	@InsertProvider(type = CommonSqlProvider.class, method = "insert")
	@Options(useGeneratedKeys = true, keyProperty = "obj.id")
	public void insertPrimaryKey(@Param("obj") Object obj, @Param("table") String table);

	@UpdateProvider(type = CommonSqlProvider.class, method = "update")
	public void update(@Param("obj") Object obj, @Param("table") String table, @Param("id") String idKey);

	@DeleteProvider(type = CommonSqlProvider.class, method = "delete")
	public void delete(@Param("obj") Object obj, @Param("table") String table, @Param("id") String idKey);

	/**
	 * 分页查询
	 * 
	 * @param condition
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@SelectProvider(type = CommonSqlProvider.class, method = "pageQueryByExample")
	public List<Map> pageQueryByExample(@Param("condition") PageQuery condition);

	/**
	 * 统计
	 * 
	 * @param condition
	 * @return
	 */
	@SelectProvider(type = CommonSqlProvider.class, method = "countByExample")
	public Integer countByExample(@Param("condition") PageQuery condition);

	/**
	 * 根据example查询单个对象
	 * 
	 * @param condition
	 * @return
	 */
	@SelectProvider(type = CommonSqlProvider.class, method = "queryByExample")
	public Map queryByExample(@Param("example") Object example, @Param("table") String table);

	/**
	 * 根据example查询单个对象
	 * 
	 * @param condition
	 * @return
	 */
	@SelectProvider(type = CommonSqlProvider.class, method = "queryById")
	public Map queryById(@Param("table") String table, @Param("idKey") String idKey, @Param("idValue") String idValue);

}

package com.order.common;

/**
 * 
 * @classDesc: 功能描述:(通用SqlProvider)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:23:16
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class CommonSqlProvider {

	private BaseSqlProvider baseSqlProvider = new BaseSqlProvider();;

	public String insert(final Object obj, final String table) {

		return baseSqlProvider.insert(obj, table);
	}

	public String update(final Object obj, final String table, final String idKey) {
		return baseSqlProvider.update(obj, table, idKey);
	}

	public String delete(final Object obj, final String table, final String idKey) {
		return baseSqlProvider.delete(obj, table, idKey);
	}

	/**
	 * 通过example分页查询
	 * 
	 * @param condition
	 * @param table
	 * @return
	 */
	public String pageQueryByExample(final PageQuery condition) {

		return baseSqlProvider.pageQueryByExample(condition, condition.getTable());

	}

	/**
	 * 统计总数
	 * 
	 * @param condition
	 * @return
	 */
	public String countByExample(final PageQuery condition) {
		return baseSqlProvider.countByExample(condition, condition.getTable());
	}

	public String queryByExample(final Object example, String table) {

		return baseSqlProvider.queryByExample(example, table);
	}

	public String queryById(final String table, final String idKey, String idValue) {
		return baseSqlProvider.queryById(table, idKey, idValue);
	}

}

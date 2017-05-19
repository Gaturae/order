package com.order.common;

import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * 
 * @classDesc: 功能描述:(BaseSQL适配器)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:22:44
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public final class BaseSqlProvider {
	private static Logger log = LoggerFactory.getLogger(BaseSqlProvider.class);

	public String insert(final Object obj, final String table) {
		return new SQL() {
			{

				INSERT_INTO(table);

				Field[] fields = ReflectTool.getAllSimpleField(obj.getClass());

				for (Field f : fields) {
					if (ReflectTool.getAttributeValue(obj, f.getName()) != null) {
						VALUES(OrmConvertor.convertFieldName(f.getName()), "#{obj." + f.getName() + "}");
					}
				}

			}
		}.toString();
	}

	public String update(final Object obj, final String table, final String idKey) {
		return new SQL() {
			{

				UPDATE(table);

				Field[] fields = ReflectTool.getAllSimpleField(obj.getClass());

				for (Field f : fields) {
					if (ReflectTool.getAttributeValue(obj, f.getName()) != null) {
						if (ReflectTool.getAttributeValue(obj, f.getName()) != null) {
							SET(OrmConvertor.convertFieldName(f.getName()) + "=#{obj." + f.getName() + "}");
						}
					}
				}

				WHERE(OrmConvertor.convertFieldName(idKey) + "=#{obj." + idKey + "}");

			}
		}.toString();
	}

	public String delete(final Object obj, final String table, final String idKey) {
		return new SQL() {
			{

				DELETE_FROM(table);

				WHERE(OrmConvertor.convertFieldName(idKey) + "=#{obj." + idKey + "}");

			}
		}.toString();
	}

	/**
	 * 通过example分页查询
	 * 
	 * @param condition
	 * @param table
	 * @return
	 */
	public String pageQueryByExample(final PageQuery condition, final String table) {

		SQL sql = new SQL() {
			{
				SELECT("*");

				FROM(table);
				WHERE("1=1");
				if (condition != null) {
					if (condition.getExample() != null) {
						Object example = condition.getExample();
						Field[] fields = ReflectTool.getAllSimpleField(example.getClass());
						for (Field f : fields) {
							if (ReflectTool.getAttributeValue(example, f.getName()) != null) {
								WHERE(OrmConvertor.convertFieldName(f.getName()) + "=#{condition.example." + f.getName()
										+ "}");
							}
						}
					}
					if (!condition.getExpress().isEmpty()) {
						for (String express : condition.getExpress()) {
							WHERE(express);
						}
					}

				}
			}
		};
		StringBuffer pageSql = new StringBuffer();
		pageSql.append(sql.toString());

		// 是否排序
		if (condition.getOrderField() != null) {
			pageSql.append(" order by " + condition.getOrderField());
		}
		// 是否逆序
		if (condition.isDesc()) {
			pageSql.append(" desc ");
		}
		// 是否分页
		if (condition.isPaging()) {
			pageSql.append(" limit " + (condition.getPageIndex() - 1) * condition.getPageSize() + ","
					+ condition.getPageSize());
		}

		log.info("sql:" + pageSql);
		return pageSql.toString();

	}

	/**
	 * 统计总数
	 * 
	 * @param condition
	 * @return
	 */
	public String countByExample(final PageQuery condition, final String table) {

		SQL sql = new SQL() {
			{
				SELECT("count(*) num");

				FROM(table);
				WHERE("1=1");
				if (condition != null) {
					if (condition.getExample() != null) {
						Object example = condition.getExample();
						Field[] fields = ReflectTool.getAllSimpleField(example.getClass());
						for (Field f : fields) {
							if (ReflectTool.getAttributeValue(example, f.getName()) != null) {
								WHERE(OrmConvertor.convertFieldName(f.getName()) + "=#{condition.example." + f.getName()
										+ "}");
							}
						}
						if (!condition.getExpress().isEmpty()) {
							for (String express : condition.getExpress()) {
								WHERE(express);
							}
						}
					}
				}
			}
		};
		log.info(sql.toString());
		return sql.toString();
	}

	public String queryByExample(final Object example, final String table) {

		SQL sql = new SQL() {
			{
				SELECT("*");

				FROM(table);
				WHERE("1=1");
				if (example != null) {
					Field[] fields = ReflectTool.getAllSimpleField(example.getClass());
					for (Field f : fields) {
						if (ReflectTool.getAttributeValue(example, f.getName()) != null) {
							WHERE(OrmConvertor.convertFieldName(f.getName()) + "=#{example." + f.getName() + "}");
						}
					}
				}

			}
		};
		log.info(sql.toString());
		return sql.toString();
	}

	public String queryById(final String table, final String idKey, String idValue) {
		return new SQL() {
			{
				SELECT("*");

				FROM(table);
				WHERE(OrmConvertor.convertFieldName(idKey) + "=#{idValue}");

			}
		}.toString();
	}

}

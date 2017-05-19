package com.order.common;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @classDesc: 功能描述:(对象转换器)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:24:16
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class OrmConvertor {

	public static final Class[] autoTypes = { String.class, Integer.class, int.class, Long.class, long.class,
			Float.class, float.class, Double.class, double.class, Date.class };

	/**
	 * 将Map自动转化为Class实例对象 遍历Map自动匹配
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T autoConvertByField(Map map, Class clazz) {
		Object o = new Object();
		String fname;// 属性名
		String methodName;// 方法名
		Object itemValue;
		try {
			o = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Field[] fields = clazz.getFields();
		// getFields();
		Object[] dbFields = map.keySet().toArray();
		List dbFieldList = ListTool.arrayToList(dbFields);
		Field f = null;
		for (Object fn : dbFields) {

			fname = fn.toString();
			// 需要遍历Map而不是class fields
			fname = OrmConvertor.formatFieldName(fname);
			if (OrmConvertor.isExist(fname, clazz)) {
				try {
					f = clazz.getDeclaredField(fname);
					f.setAccessible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				methodName = "set" + StringTool.up1stLetter(fname);
				itemValue = map.get(fn);
				if (itemValue != null) {
					if (itemValue.getClass().equals(BigDecimal.class)) {
						if (f.getType().equals(int.class) || f.getType().equals(Integer.class)) {
							int v = ((BigDecimal) itemValue).intValue();
							ReflectTool.invoke(o, methodName, f.getType(), v);
						} else if (f.getType().equals(double.class) || f.getType().equals(Double.class)) {
							double v = ((BigDecimal) itemValue).doubleValue();
							ReflectTool.invoke(o, methodName, f.getType(), v);
						} else if (f.getType().equals(float.class) || f.getType().equals(Float.class)) {
							float v = ((BigDecimal) itemValue).floatValue();
							ReflectTool.invoke(o, methodName, f.getType(), v);
						} else if (f.getType().equals(long.class) || f.getType().equals(Long.class)) {
							long v = ((BigDecimal) itemValue).longValue();
							ReflectTool.invoke(o, methodName, f.getType(), v);
						} else {
							String v = itemValue + "";
							ReflectTool.invoke(o, methodName, f.getType(), v);
						}

					} else {
						ReflectTool.invoke(o, methodName, f.getType(), itemValue);
					}
				}
			}

		}
		return (T) o;
	}

	/**
	 * 将Map自动转化为Class实例对象 遍历类属性自动匹配
	 * 
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T autoConvertByClassField(Map map, Class clazz) {
		Object o = new Object();
		String fname;// 属性名
		String methodName;// 方法名
		Object itemValue;
		try {
			o = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Field[] fields = clazz.getFields();
		// getFields();
		for (Field f : fields) {
			f.setAccessible(true);
			fname = f.getName();
			methodName = "set" + StringTool.up1stLetter(fname);
			itemValue = map.get(fname);
			if (itemValue != null) {
				if (itemValue.getClass().equals(BigDecimal.class)) {
					if (f.getType().equals(int.class) || f.getType().equals(Integer.class)) {
						int v = ((BigDecimal) itemValue).intValue();
						ReflectTool.invoke(o, methodName, f.getType(), v);
					} else if (f.getType().equals(double.class) || f.getType().equals(Double.class)) {
						double v = ((BigDecimal) itemValue).doubleValue();
						ReflectTool.invoke(o, methodName, f.getType(), v);
					} else if (f.getType().equals(float.class) || f.getType().equals(Float.class)) {
						float v = ((BigDecimal) itemValue).floatValue();
						ReflectTool.invoke(o, methodName, f.getType(), v);
					} else if (f.getType().equals(long.class) || f.getType().equals(Long.class)) {
						long v = ((BigDecimal) itemValue).longValue();
						ReflectTool.invoke(o, methodName, f.getType(), v);
					} else {
						String v = itemValue + "";
						ReflectTool.invoke(o, methodName, f.getType(), v);
					}

				} else {
					ReflectTool.invoke(o, methodName, f.getType(), itemValue);
				}
			}

		}
		return (T) o;
	}

	public static <T> T autoConvert(Map map, Class clazz, boolean isByField) {
		if (isByField) {
			return OrmConvertor.autoConvertByField(map, clazz);
		} else {
			return OrmConvertor.autoConvertByClassField(map, clazz);
		}
	}

	public static List autoOrmConvert(List<Map> maplist, Class clazz) throws Exception {
		List list = new ArrayList();
		for (Map map : maplist) {
			Object u = OrmConvertor.autoConvert(map, clazz, true);
			list.add(u);
		}
		return list;
	}

	// 按照orm类定义,将map转化为objlist 需要配合orm注解使用
	public static <T> T autoOrmConvert(Map map, Class clazz) throws Exception {

		Class[] autoTypes = { String.class, Integer.class, int.class, Long.class, long.class, Float.class, float.class,
				Double.class, double.class, Date.class };
		Object model = clazz.newInstance();

		String noneed = "serialVersionUID;log";
		String[] noNeed = noneed.split(";");
		String[] specialField = {};
		Map specialMap = new HashMap();

		Object value;
		String fName;
		String attName;
		Field[] fields = clazz.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
			attName = f.getName();
			if (!ListTool.isInList(f.getType(), autoTypes)) {
				// LogTool.debug(OrmConvertor.class,(f.getName()+" `s type is
				// not in
				// "+"String,Integer,int,Long,long,Float,float,Double,double,Date"
				// ));
			} else if (ListTool.isInList(attName, noNeed)) {
				// LogTool.debug(OrmConvertor.class,"no need to
				// mapping:"+f.getName() );
				// 该字段不需要映射
			} else if (ListTool.isInList(attName, specialField)) {
				// 特殊字段,需要按定义来映射
				value = map.get(specialMap.get(attName).toString());
				ReflectTool.setAttribute(model, attName, value);
			} else {
				// 一般映射,将字母按大小写分割,自动转化为按_连接的数据库字段格式
				fName = OrmConvertor.convertFieldName(attName);
				value = map.get(fName);
				ReflectTool.setAttribute(model, attName, value);

			}

		}
		return (T) model;
	}

	public static String formatFieldName(String oldName) {
		String newName = "";
		String[] n = oldName.split("_");
		for (String s : n) {
			newName += StringTool.up1stLetter(s.toLowerCase());
		}
		newName = StringTool.lower1stLetter(newName);
		return newName;
	}

	/**
	 * 将驼峰式属性名转化为以_分割的字段名
	 * 
	 * @param oldName
	 * @return
	 */
	public static String convertFieldName(String attName) {
		StringBuffer sb = new StringBuffer();
		List<String> l = StringTool.splitByUpLetter(attName);
		for (int i = 0; i < l.size(); i++) {
			sb.append(l.get(i).toUpperCase());
			if (i != l.size() - 1) {
				sb.append("_");
			}
		}
		return sb.toString();
	}

	public static boolean isExist(String fieldName, Class clazz) {

		try {
			clazz.getDeclaredField(fieldName);
			return true;
		} catch (NoSuchFieldException e) {
			return false;
		}
	}

	/**
	 * 将Map自动转化为Orm对象 使用Orm注解来对应相应的属性
	 * 
	 * @param <T>
	 * @param map
	 * @param clazz
	 * @return
	 */
	public static <T> T convertToOrmObj(Map map, Class clazz) {
		Object OrmObj = null;
		try {
			OrmObj = clazz.newInstance();

			String noneed = "serialVersionUID;log";

			String[] noNeed = noneed.split(";");

			String[] special;
			String[] specialField = {};

			Object value;
			String fName;
			String fieldName;
			// Field[] fields=OrmObj.getClass().getDeclaredFields();
			Field[] fields = ReflectTool.getAllField(clazz);// 获取所有属性,含超类属性
			for (Field f : fields) {
				f.setAccessible(true);
				fName = f.getName();
				// 该字段不需要映射
				if (ListTool.isInList(fName, noNeed)) {
					// LogTool.debug(OrmConvertor.class,"no need to
					// mapping:"+f.getName() );

				}
				// 特殊字段,需要按定义来映射
				/*
				 * else if (ListTool.isInList(fName, specialField)) { value =
				 * map.get(specialMap.get(fName).toString());
				 * //ReflectTool.invoke(OrmObj,
				 * "set"+StringTool.up1stLetter(fName), f.getType(), value);
				 * ReflectTool.setAttribute(OrmObj, fName, value); }
				 */
				// 一般映射,将字母按大小写分割,自动转化为按"_"连接的数据库字段格式
				else {
					fieldName = OrmConvertor.convertFieldName(fName);
					value = map.get(fieldName);
					// ReflectTool.invoke(OrmObj,
					// "set"+StringTool.up1stLetter(fName), f.getType(), value);
					ReflectTool.setAttribute(OrmObj, fName, value);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) OrmObj;
	}

	/*
	 * public List convertToPojoList(List<Map> mapList, Class pojoClass) { List
	 * pojoList = new ArrayList(); try { Object obj = pojoClass.newInstance();
	 * for (Map map : mapList) { obj = this.autoConvert(map, pojoClass, true);
	 * pojoList.add(obj); } } catch (Exception e) { e.printStackTrace(); }
	 * return pojoList; }
	 */
}

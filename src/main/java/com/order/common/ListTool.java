package com.order.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @classDesc: 功能描述:(List集合工具类)
 * @author: 王浩
 * @createTime: 2017年5月10日 上午11:23:51
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
public class ListTool {
	/**
	 * @see 对List<Map>进行排序
	 * @param orderKey
	 * @return
	 */
	public static List orderMapList(List maplist, String orderKey) {
		MapComparator Comparator = new MapComparator();
		Comparator.setKey(orderKey);
		Collections.sort(maplist, Comparator);
		return maplist;

	}

	/**
	 * @see 对List<Map>进行倒序排序
	 * @param orderKey
	 * @return
	 */
	public static List orderMapListDesc(List maplist, String orderKey) {
		MapComparator Comparator = new MapComparator();
		Comparator.setKey(orderKey);
		Collections.sort(maplist, Comparator);
		Collections.reverse(maplist);
		return maplist;

	}

	/**
	 * @see 对List<Object>进行排序,要求Object为pojo对象
	 * @param orderKey
	 * @return
	 */
	public static List orderObjList(List list, String orderKey) {
		ObjComparator Comparator = new ObjComparator();
		Comparator.setKey(orderKey);
		Collections.sort(list, Comparator);
		return list;

	}

	/**
	 * @see 对List<Object>进行倒序排序,要求Object为pojo对象
	 * @param orderKey
	 * @return
	 */
	public static List orderObjListDesc(List list, String orderKey) {
		ObjComparator Comparator = new ObjComparator();
		Comparator.setKey(orderKey);
		Collections.sort(list, Comparator);
		Collections.reverse(list);
		return list;

	}

	/**
	 * 将数组转化为List
	 * 
	 * @param array
	 * @return
	 */
	public static List arrayToList(Object[] array) {
		List list = new ArrayList();
		if (array != null)
			for (int i = 0; i < array.length; i++) {
				list.add(array[i]);
			}
		return list;

	}

	/**
	 * 将List转化为数组
	 * 
	 * @param list
	 * @return
	 */
	public static Object[] listToArray(List list) {
		Object[] objs = list.toArray();

		return objs;

	}

	/**
	 * 判断对象是否在列表中
	 * 
	 * @param obj
	 * @param list
	 * @return
	 */
	public static boolean isInList(Object obj, List list) {
		boolean result = false;
		for (Object object : list) {
			if (obj.equals(object)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 判断对象是否在数组中
	 * 
	 * @param obj
	 * @param list
	 * @return
	 */
	public static boolean isInList(Object obj, Object[] list) {
		boolean result = false;
		for (Object object : list) {
			if (obj.equals(object)) {
				result = true;
				break;
			}
		}
		return result;
	}

	/**
	 * 将list 顺序打乱
	 * 
	 * @param list
	 */
	public static void randomList(List list) {
		Collections.shuffle(list);
	}

	/**
	 * 判断列表是否为null或长度为0
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List list) {
		boolean result = false;
		if (list == null) {
			result = true;
		} else if (list.isEmpty()) {
			result = true;
		}
		return result;
	}

	public static void clear(List list) {
		if (list != null) {
			list.clear();
		}
	}

	/**
	 * 判断list不为空
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isNotNull(List list) {
		boolean flag = false;
		if (list != null && list.size() > 0) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 判断list为空
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isNull(List list) {
		boolean flag = false;
		if (list == null || list.size() == 0) {
			flag = true;
		}
		return flag;
	}

//	public static void main(String[] args) throws Exception {
//		Map map1 = new HashMap();
//		map1.put("age", "100");
//		Map map2 = new HashMap();
//		map2.put("age", "200");
//		Map map3 = new HashMap();
//		map3.put("age", "10");
//		Map map4 = new HashMap();
//		map4.put("age", "1000");
//		List list = new ArrayList();
//		list.add(map1);
//		list.add(map2);
//		list.add(map3);
//		list.add(map4);
//		ListTool.orderMapList(list, "age");
//	}

}

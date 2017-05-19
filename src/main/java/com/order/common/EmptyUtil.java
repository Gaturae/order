package com.order.common;

import java.util.Collection;
import java.util.Map;

/**
 * <p>判断空值的工具类</p>
 *
 */
public class EmptyUtil {

    private EmptyUtil() {
    }

    /**
     * <p>判断字符串是否为 null 或者是空值</p>
     */
    public static boolean isBlank(String str) {
        return (str == null || str.trim().length() == 0);
    }

    /**
     * <p>判断数值对象是否为空</p>
     */
    public static boolean isBlank(Number number) {
        return (number == null);
    }

    /**
     * <p>判断集合是否为 null 或者是空值</p>
     */
    public static boolean isBlank(Collection<?> collection) {
        return (collection == null || collection.size() == 0);
    }

    /**
     * <p>判断 Map 是否为 null 或者是空值</p>
     */
    public static boolean isBlank(Map<?, ?> map) {
        return (map == null || map.size() == 0);
    }
    
    public static boolean isBlank(Map<?,?> map,String key){
        return map.containsKey(key);
    }

    /**
     * <p>判断对象数组是否为 null 或者是空</p>
     */
    public static boolean isBlank(Object[] objs) {
        return (objs == null || objs.length == 0);
    }

    public static boolean isBlank(Object obj) {
        if (obj == null) {
            return true;
        }
        if (obj instanceof String) {
            return isBlank((String) obj);
        }
        if (obj instanceof Collection<?>) {
            return isBlank((Collection<?>) obj);
        }
        if (obj instanceof Map<?, ?>) {
            return isBlank((Map<?, ?>) obj);
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj).length == 0;
        }
        if (obj instanceof int[]) {
            return ((int[]) obj).length == 0;
        }
        return false;
    }
}

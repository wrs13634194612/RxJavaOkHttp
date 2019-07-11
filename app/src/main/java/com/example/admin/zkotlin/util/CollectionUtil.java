package com.example.admin.zkotlin.util;


        import java.util.Collection;
        import java.util.Map;

/**
 * Created by yangdan on 15/10/23.
 */
public class CollectionUtil {
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }


    public static boolean isEmpty(Map map) {
        return null == map || map.isEmpty();
    }
}

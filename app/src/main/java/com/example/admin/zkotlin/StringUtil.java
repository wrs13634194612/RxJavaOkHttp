package com.example.admin.zkotlin;

/**
 * Created by wrs on 2019/7/9,14:25
 * projectName: ZKotlin
 * packageName: com.example.admin.zkotlin
 */
public class StringUtil {

    public static boolean isEmpty(String str) {
        if (null == str || str.trim().equals("") || str.trim().equalsIgnoreCase("null")) {
            return true;
        }
        return false;
    }

}

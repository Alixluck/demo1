package com.alix.orm.demo1.common.utils;

/**
 * @author 杨安星(Alix)
 * @create 2019-11-30 10:19
 * 字符串工具类
 */
public class StringUtils {


    /**
     * 判断字符串是否为空
     * */
    public static boolean isEmpty(String arg){
        if( arg == null || arg.trim().equals("")){
            return true;
        }else {
            return false;
        }
    }

}

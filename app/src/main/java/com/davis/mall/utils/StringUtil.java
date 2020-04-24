package com.davis.mall.utils;

/**
 * @author 王阳
 * @time 2019/12/24  0:37
 * @desc
 */
public class StringUtil {
    public static String[] splitStringByJInghao(String origin){
        return origin.split("#");
    }

    public static String fromStringArray(String[] stringsYiXuan, String addString) {
        String result="";
        for (int i = 0; i < stringsYiXuan.length; i++) {
            if(i != stringsYiXuan.length-1) {
                result += stringsYiXuan[i]+addString;
            }else {
                result += stringsYiXuan[i];
            }
        }
        return result;
    }
    public static String[] splitString(String origin,String reg){
        return origin.split(reg);
    }
}

package com.imooc.miaosha.utils;

/**
 * @description: md5
 * @date: 2018-12-16 10:51
 * @author: 十一
 */
public class MD5Util {

    /**
     * 实际上要尽可能复杂
     */
    private static String salt = "miaosha_123_system";

    public static String md5(String str) {
        return MD5Util.md5(str);
    }

    /**
     * 用户传过来的密码加密
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass) {
        return md5(salt+inputPass+salt);
    }

    public static String formPassToDBPass(String formPass,String randomSalt) {
        return md5(randomSalt+formPass+randomSalt);
    }

}

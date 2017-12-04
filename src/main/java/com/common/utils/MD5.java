package com.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by 黎 on 2017/12/2.
 */
public class MD5 {
    public static String getMD5(String str) throws Exception {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            throw new Exception("MD5加密出现错误");
        }
    }

    /**
     * 取密码前6位 进行md5加密
     * @param password
     * @return paasswordMD5
     * @throws Exception
     */
    public static String createPasswordMD5(String password) throws Exception {
        return getMD5(password.substring(0,6));
    }

    public static void main(String[] args) {
        try {
            System.out.println(getMD5("lideyang"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
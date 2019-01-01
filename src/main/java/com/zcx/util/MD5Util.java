package com.zcx.util;


import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * MD5工具类，用于签名与验签
 */
public class MD5Util {

    // verify
    /**
     * MD5签名
     * @param params 参数
     * @return
     */
    public static String sign(Map<String, String> params) throws NoSuchAlgorithmException {
        if (CollectionUtils.isEmpty(params)) {
            return null;
        }
        Map<String, String> treeMap = new TreeMap<String, String>(params);
        StringBuffer paramBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            paramBuffer.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        String message = paramBuffer.toString();
        message = message.substring(0, message.length() - 1);
        return encrypt(message);
    }

//    public static String

    /**
     * MD5加密
     * @param message
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String encrypt(String message) throws NoSuchAlgorithmException {
        if (StringUtils.isBlank(message)) {
            return "";
        }
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] bytes = digest.digest(message.getBytes());
        StringBuffer buffer = new StringBuffer();
        for (byte b : bytes) {
            int number = b & 0xff;
            String str = Integer.toHexString(number);
            if (str.length() == 1) {
                buffer.append("0");
            }
            buffer.append(str);
        }
        return buffer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "zcx");
        params.put("age", "29");
        params.put("sex", "male");
        try {
            System.out.println(sign(params));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}

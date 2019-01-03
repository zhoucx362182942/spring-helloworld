package com.zcx.util;


import org.apache.commons.codec.binary.Base64;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA加密/签名/验签工具类
 * Created by zhou on 2019/1/2.
 */
public class RSAUtil {

    /**
     * 公钥私钥对
     */
    private static Map<String, String> keyMap = new HashMap<String, String>();

    /**
     * 数字签名算法
     */
    private static final String SIGNATURE_ALGORITHM = "SHA256WithRSA";

    /**
     * 生成随机公钥私钥对
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024,new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String publicKeyString = new String(Base64.encodeBase64(publicKey.getEncoded()));
        // 得到私钥字符串
        String privateKeyString = new String(Base64.encodeBase64((privateKey.getEncoded())));
        // 将公钥和私钥保存到Map
        keyMap.put("public",publicKeyString);  //0表示公钥
        keyMap.put("private",privateKeyString);  //1表示私钥
    }

    /**
     * SHA256WithRSA签名
     * @param text 需要签名的数据
     * @param privateKey 私钥
     * @param encoding 编码方式
     * @return 签名结果
     * @throws Exception
     */
    public static String sign(String text, String privateKey, String encoding) throws Exception{
        // 实例化
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化，传入私钥
        byte[] keyBytes = Base64.decodeBase64(privateKey);
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
        signature.initSign(privateK);
        // 更新
        signature.update(text.getBytes(encoding));
        byte[] result = signature.sign();
        return Base64.encodeBase64String(result);
    }

    /**
     * SHA256WithRSA验签
     * @param text 需要验签的字符串
     * @param sign 签名结果
     * @param publicKey 公钥
     * @param encoding 编码方式
     * @return
     * @throws Exception
     */
    public static boolean verify(String text, String sign, String publicKey, String encoding) throws Exception{
        // 实例化
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        // 初始化，传入私钥
        byte[] keyBytes = Base64.decodeBase64(publicKey);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicK = keyFactory.generatePublic(keySpec);
        signature.initVerify(publicK);
        // 更新
        signature.update(text.getBytes(encoding));
        return signature.verify(Base64.decodeBase64(sign));
    }

    public static void main(String[] args) {
        try {
            genKeyPair();
            String src = "123";
            String pub = keyMap.get("public");
            String pri = keyMap.get("private");

            boolean b = verify(src, sign(src, pri, "UTF-8"), pub, "UTF-8");
            System.out.println(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
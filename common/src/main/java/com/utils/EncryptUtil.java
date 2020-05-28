package com.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

/**
 * @author Letmesea
 * @title: EncryptUtil
 * @projectName dosth
 * @description: AES加解密
 * @date 2020/5/2814:00
 */
public class EncryptUtil {
    /**
     * 私有化工具类
     */
    private EncryptUtil(){}

    private static final String DEFAULT_AES_SECRET_KEY = "2b3a8075aa9511e1";

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";

    /**
     * AES加密
     * @param clearText 明文
     * @return 返回密文
     * @throws Exception 异常
     */
    public static String encryptByAes(String clearText) throws Exception {
        //密钥初始化 转换为AES专用密钥
        SecretKeySpec aesKey = new SecretKeySpec(DEFAULT_AES_SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        //加密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] entryBytes = cipher.doFinal(clearText.getBytes(StandardCharsets.UTF_8));

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(entryBytes).replaceAll(System.getProperty("line.separator"),"");
    }


    /**
     * AES解密
     * @param cipherText 密文
     * @return 返回解密后的明文
     * @throws Exception 异常
     */
    public static String decryptByAes(String cipherText) throws Exception {
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] cipherTextByte = decoder.decodeBuffer(cipherText);
        //密钥初始化 转换为AES专用密钥
        SecretKeySpec aesKey = new SecretKeySpec(DEFAULT_AES_SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);

        //解密
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] entryBytes = cipher.doFinal(cipherTextByte);

        return new String(entryBytes,StandardCharsets.UTF_8);
    }
}

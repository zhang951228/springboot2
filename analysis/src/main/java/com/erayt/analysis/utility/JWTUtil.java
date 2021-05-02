package com.erayt.analysis.utility;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import sun.security.util.DerInputStream;
import sun.security.util.DerValue;

import javax.crypto.Cipher;
import java.io.IOException;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: Z151
 * @Date: 2021/4/30 11:02
 */
@Slf4j
public class JWTUtil {
    /**
     * String to hold name of the encryption algorithm.
     */
    private static final String ALGORITHM = "RSA";
    private static final String CHAR_SET = "utf-8";
    private static final String PASSWORD = "utf-8";


    private final Map<String,Object> map = new HashMap<>(2);
    public JWTUtil(){
        map.put("alg","HS256");
        map.put("typ","JWT");
    }

    /******************  第一种方式，简单的集成JWT *******************/
    /**
     * 创建token
     * @return
     */
    public String createJWT(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND,60*30);
        //JWT.create().withHeader(map).withClaim("userId","admin").sign(Algorithm.RSA256(""));
        String token = JWT.create()
            .withHeader(map)
            .withIssuer("analysis")
            .withClaim("userId", "test001")
            .withClaim("role", "clazz")
            .withExpiresAt(calendar.getTime())
            .sign(Algorithm.HMAC256(PASSWORD));
        log.info(token);
        return token;
    }

    /**
     * 解析token
     * @param token
     */
    public void decodeJWT(String token){
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(PASSWORD)).withIssuer("analysis").build();
        DecodedJWT verify = verifier.verify(token);
        log.info("issuer:"+verify.getIssuer());
        log.info("issuer:"+verify.getClaim("userId").asString());
        log.info("issuer:"+verify.getClaim("role").asString());
        log.info("issuer:"+verify.getExpiresAt());
    }

    /*********************  下面为尝试使用RSA256 公钥、私钥 加解蜜  ************************/
    /**
     * @param str str
     * @return byte[]
     */
    private static byte[] baseStrToByte(String str) {
        return Base64.getDecoder().decode(str);
    }

    /**
     * @param bytes bytes
     * @return String
     */
    private static String baseByteToStr(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static String rsaEncode(String text){
        return rsaEncode(ConfigFileUtil.getKey("system.pwdKey.publicKey"),text);
    }

    public static String rsaEncode(String publicCertificate, String text) {
        try {
            byte[] publicBytes = baseStrToByte(publicCertificate);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PublicKey pubKey = keyFactory.generatePublic(keySpec);
            // get an RSA cipher object and print the provider
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            // encrypt the plain text using the public key
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] cipherBytes = cipher.doFinal(text.getBytes(CHAR_SET));
            return baseByteToStr(cipherBytes);
        } catch (Exception e) {
            log.error("publicCertificate:{}  \r\n  text:{}", publicCertificate, text, e);
        }
        return null;
    }

    public static String rsaDecode(String text) {
        return rsaDecode(ConfigFileUtil.getKey("system.pwdKey.privateKey"),text);
    }

    public static String rsaDecode(String privateCertificate, String text) {
        try {
            byte[] privateBytes = baseStrToByte(privateCertificate);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            PrivateKey priKey = keyFactory.generatePrivate(keySpec);
            byte[] cipherText;
            // get an RSA cipher object and print the provider
            final Cipher cipher = Cipher.getInstance(ALGORITHM);
            // encrypt the plain text using the public key
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            byte[] textbyte = baseStrToByte(text);
            cipherText = cipher.doFinal(textbyte);
            return new String(cipherText, CHAR_SET);
        } catch (Exception e) {
            log.error("privateCertificate:{}  \r\n  text:{}", privateCertificate, text, e);
        }
        return null;
    }

    /*********************  第二种方式，尝试使用RSA生成、解析JWT  ************************/

    public PrivateKey  test1() throws NoSuchAlgorithmException {
        // Base64 decode the data
        byte[] encoded = baseStrToByte(ConfigFileUtil.getKey("system.pwdKey.privateKey"));

        try {
            DerInputStream derReader = new DerInputStream(encoded);
            DerValue[] seq = derReader.getSequence(0);

            if (seq.length < 9) {
                throw new GeneralSecurityException("Could not read private key");
            }

            // skip version seq[0];
            BigInteger modulus = seq[1].getBigInteger();
            BigInteger publicExp = seq[2].getBigInteger();
            BigInteger privateExp = seq[3].getBigInteger();
            BigInteger primeP = seq[4].getBigInteger();
            BigInteger primeQ = seq[5].getBigInteger();
            BigInteger expP = seq[6].getBigInteger();
            BigInteger expQ = seq[7].getBigInteger();
            BigInteger crtCoeff = seq[8].getBigInteger();

            RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec(modulus, publicExp, privateExp,
                primeP, primeQ, expP, expQ, crtCoeff);

            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePrivate(keySpec);
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void test2(){
        //keyProvider
        RSAPublicKey publicKey =null; //Get the key instance
            RSAPrivateKey privateKey = null;//Get the key instance
        try {
            Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
            String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);
        } catch (JWTCreationException exception){
            //无效的签名配置/无法转换声明
        }
    }

}

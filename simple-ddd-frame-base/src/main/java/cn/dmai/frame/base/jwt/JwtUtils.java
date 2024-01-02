package cn.dmai.frame.base.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @Author linchengdong
 * @Date 2024-01-02 18:31
 * @PackageName:cn.dmai.frame.base.jwt
 * @ClassName: JwtUtil
 * @Description: jwt 工具类
 * @Version 1.0
 */
public class JwtUtils {

    public static final String UNIQUE_CLAIM = "uniqueId";

    /**
     * jwtToken过期时间 默认为7天
     */
    public static final Long TOKEN_EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000L;


    /**
     * JWT的密钥
     */
    public static final String JWT_SECRET = "simple-ddd";


    /**
     * 校验token是否正确
     * @param token  密钥
     * @return 是否正确
     */
    public static boolean verify(String token, String secret) {
        try {
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(UNIQUE_CLAIM, getUniqueId(token))
                    .build();
            // 效验TOKEN
            verifier.verify(token);
            return true;
        } catch (JWTVerificationException exception) {
            return false;
        }
    }


    /**
     * 获得token中的信息无需secret解密也能获得
     * @return token中包含的用户名
     */
    public static Long getUniqueId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(UNIQUE_CLAIM).asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     *
     * @param uniqueId   唯一id
     * @param secret   制作此token的签名依据
     * @return 加密的token
     */
    public static String sign(Long uniqueId, String secret) {
        Date date = new Date(System.currentTimeMillis() + TOKEN_EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        return JWT.create()
                .withClaim(UNIQUE_CLAIM, uniqueId)
                .withExpiresAt(date)
                .sign(algorithm);
    }
    /**
     *
     * @param uniqueId   用户名
     * @return 加密的token
     */
    public static String sign(Long uniqueId) {
        return sign(uniqueId, JWT_SECRET);
    }

}

package com.aoyukmt.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import java.time.Duration;
import java.util.Date;
import java.util.Map;


/**
 * @ClassName：JwtUtils
 * @Author: aoyu
 * @Date: 2025-04-07 14:08
 * @Description: jwt工具类
 */


/**
 * JWT工具类，使用Spring Boot配置文件中的参数
 */
@Component
public class JwtUtils {

    // 从配置文件中读取JWT密钥
    @Value("${jwt.secret_key}")
    private String secretKeyString;

    // 从配置文件中读取JWT有效期
    @Value("${jwt.expiration_time}")
    private String expirationTimeString;

    // 存储解析后的密钥
    private SecretKey secretKey;

    // 存储解析后的过期时间（毫秒）
    private long expirationTimeMillis;

    /**
     * 初始化方法，将配置参数转换为可用格式
     */
    @PostConstruct
    public void init() {
        // 解码密钥
        byte[] keyBytes = secretKeyString.trim().getBytes(java.nio.charset.StandardCharsets.UTF_8);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);

        // 解析过期时间，支持"7d"这样的格式
        if (expirationTimeString.endsWith("d")) {
            // 如果以'd'结尾，表示天数
            int days = Integer.parseInt(expirationTimeString.substring(0, expirationTimeString.length() - 1));
            this.expirationTimeMillis = Duration.ofDays(days).toMillis();
        } else {
            // 否则认为是毫秒数
            this.expirationTimeMillis = Long.parseLong(expirationTimeString);
        }
    }

    /**
     * 生成JWT令牌
     * @param subject 用户标识（通常是用户ID或用户名）
     * @param claims 自定义声明（可以存储额外的用户信息）
     * @return JWT令牌字符串
     */
    public String generateToken(String subject, Map<String, Object> claims) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationTimeMillis);

        return Jwts.builder()
                .setClaims(claims) // 设置自定义声明
                .setSubject(subject) // 设置主题（用户标识）
                .setIssuedAt(now) // 设置JWT的签发时间
                .setExpiration(expiryDate) // 设置JWT的过期时间
                .signWith(secretKey, SignatureAlgorithm.HS512) // 使用HS512算法和秘钥签名JWT
                .compact(); // 生成JWT字符串
    }

    /**
     * 验证令牌是否有效
     * @param token JWT令牌
     * @return 是否有效
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
            return true; // 如果解析成功，则令牌有效
        } catch (Exception e) {
            return false; // 解析过程中出现异常，说明令牌无效
        }
    }

    /**
     * 检查令牌是否已过期
     * @param token JWT令牌
     * @return 是否已过期
     */
    public boolean isTokenExpired(String token) {
        try {
            Date expiration = getExpirationDateFromToken(token);
            return expiration.before(new Date());
        } catch (Exception e) {
            return true; // 如果解析出错，则视为令牌已过期
        }
    }

    /**
     * 从JWT令牌中获取用户标识
     * @param token JWT令牌
     * @return 用户标识
     */
    public String getSubjectFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.getSubject();
    }

    /**
     * 从令牌中获取指定声明
     * @param token JWT令牌
     * @param claimName 声明名称
     * @return 声明值
     */
    public Object getClaimFromToken(String token, String claimName) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.get(claimName);
    }

    /**
     * 从令牌中获取过期时间
     * @param token JWT令牌
     * @return 过期时间
     */
    private Date getExpirationDateFromToken(String token) {
        Claims claims = getAllClaimsFromToken(token);
        return claims.getExpiration();
    }

    /**
     * 获取JWT令牌中的所有声明
     * @param token JWT令牌
     * @return 所有声明
     */
    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey) // 设置用于验证签名的密钥
                .build()
                .parseClaimsJws(token) // 解析令牌并验证签名
                .getBody(); // 获取令牌中的声明部分
    }
}
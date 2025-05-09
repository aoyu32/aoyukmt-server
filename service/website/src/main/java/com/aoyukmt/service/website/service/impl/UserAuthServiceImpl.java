package com.aoyukmt.service.website.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.aoyukmt.common.avatar.DiceBearAvatarGenerator;
import com.aoyukmt.common.constant.RedisKeyPrefixConstant;
import com.aoyukmt.common.constant.StatusConstant;
import com.aoyukmt.common.constant.UserConstant;
import com.aoyukmt.common.constant.VerificationCodeConstant;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.utils.IpUtils;
import com.aoyukmt.common.utils.JwtUtils;
import com.aoyukmt.common.utils.PasswordUtils;
import com.aoyukmt.common.utils.UserInfoUtils;
import com.aoyukmt.model.dto.*;
import com.aoyukmt.model.entity.UserIpInfo;
import com.aoyukmt.model.vo.req.UserLoginReqVO;
import com.aoyukmt.model.vo.req.UserRegisterReqVO;
import com.aoyukmt.model.vo.req.UserResetReqVO;
import com.aoyukmt.model.vo.resp.UserLoginRespVO;
import com.aoyukmt.service.website.annotation.UserAuth;
import com.aoyukmt.service.website.mapper.UserAuthMapper;
import com.aoyukmt.service.website.mapper.UserProfileMapper;
import com.aoyukmt.service.website.service.MailService;
import com.aoyukmt.service.website.service.UserAuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName：UserAuthServiceImpl
 * @Author: aoyu
 * @Date: 2025-04-05 16:48
 * @Description: 用户认证接口实现类
 */

@Service
@Slf4j
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MailService mailService;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 用户注册
     *
     * @param userRegisterReqVO 用户注册数据
     */
    @Transactional
    @Override
    @UserAuth
    public String register(UserRegisterReqVO userRegisterReqVO, HttpServletRequest request) {

        //判断用户名是否存在
        Boolean existUser = userAuthMapper.existUsername(userRegisterReqVO.getUsername());
        log.info("用户是否存在：{}", existUser);
        if (existUser) {
            throw new BusinessException(ResultCode.USER_ALREADY_EXIST);
        }

        //注册用户
        //密码加密
        String encrypt = PasswordUtils.encrypt(userRegisterReqVO.getPassword());
        //创建用户信息实体
        UserProfileRegisterDTO userProfile = new UserProfileRegisterDTO();
        //生成随机昵称
        String randomNickname = UserInfoUtils.getRandomNickname();

        //生成随机头像url
        String randomAvatarUrl = DiceBearAvatarGenerator.generateRandomAvatarUrl();

        //获取用户ip地址
//        String userIp = IpUtils.getIpAddr(request);
        //先固定ip
//        String userIp = "38.207.137.78";
        String userIp = IpUtils.getPublicIp();
        log.info("用户ip:{}", userIp);
        //获取用户ip详细详细
        UserIpInfo ipInfo = IpUtils.getIpInfo(userIp, UserIpInfo.class);
        log.info("用户ip详细详细：{} ", ipInfo.toString());
        //序列化为json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String ipInfoJson = objectMapper.writeValueAsString(ipInfo);
            userProfile.setIpInfo(ipInfoJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        userProfile.setNickname(randomNickname);
        userProfile.setAvatar(randomAvatarUrl);
        //插入用户基本信息
        userProfileMapper.insert(userProfile);

        //创建用户认证实体
        UserAuthRegisterDTO userAuth = new UserAuthRegisterDTO();
        userAuth.setUsername(userRegisterReqVO.getUsername());
        userAuth.setPassword(encrypt);
        userAuth.setLastLoginTime(LocalDateTime.now());
        userAuth.setLastLoginIp(userIp);

        log.info("注册的用户id:{}", userProfile.getId());
        userAuth.setUid(userProfile.getId());
        //插入用户认证信息
        userAuthMapper.insert(userAuth);

        //生成token，返回用户信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userAuth.getUsername());
        String token = jwtUtils.generateToken(Long.toString(userAuth.getUid()), claims);


        log.info("生成的登录token:{}", token);
        return token;
    }

    /**
     * 用户登录
     *
     * @param userLoginReqVO 用户登录参数
     */
    @Override
    @UserAuth
    public UserLoginRespVO login(UserLoginReqVO userLoginReqVO) {

        //获取当前ip
        String userIp = IpUtils.getPublicIp();
        //获取ip详细详细
        UserIpInfo ipInfo = IpUtils.getIpInfo(userIp, UserIpInfo.class);

        //查询用户信息
        UserLoginDTO userLoginDTO = userAuthMapper.selectUser(userLoginReqVO.getAccount());

        if (userLoginDTO == null) {
            throw new BusinessException(ResultCode.ACCOUNT_OR_PASSWORD_ERROR);
        }

        //更新当前登录的ip详细信息
        UserInfoDTO userInfoDTO = userLoginDTO.getUserInfoDTO();
        userInfoDTO.setIpInfo(ipInfo);

        //判断密码
        if (!PasswordUtils.match(userLoginReqVO.getPassword(), userLoginDTO.getPassword())) {
            throw new BusinessException(ResultCode.ACCOUNT_OR_PASSWORD_ERROR);
        }
        //生成token
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userLoginDTO.getUserInfoDTO().getUsername());
        String token = jwtUtils.generateToken(String.valueOf(userLoginDTO.getUserInfoDTO().getUid()), claims);

        //返回用户信息
        UserLoginRespVO userLoginRespVO = new UserLoginRespVO();
        userLoginRespVO.setUserData(userLoginDTO.getUserInfoDTO());
        userLoginRespVO.setToken(token);

        //更新登录时间
        userAuthMapper.updateLastLoginTime(userLoginDTO.getUserInfoDTO().getUid(), LocalDateTime.now());
        //更新登录ip
        userAuthMapper.updateLastLoginIp(userLoginDTO.getUserInfoDTO().getUid(), userIp);
        //更新ip详细信息
        //序列化ip信息
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String ipInfoJson = objectMapper.writeValueAsString(ipInfo);
            userProfileMapper.updateIpInfo(userLoginDTO.getUserInfoDTO().getUid(), ipInfoJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return userLoginRespVO;
    }


    /**
     * 注销用户
     *
     * @param uid      用户id
     * @param password 验证身份的密码
     */
    @Override
    public void logoff(Long uid, String password) {
        log.info("开始注销uid为：{}的用户", uid);
        //验证密码
        String pwd = userAuthMapper.selectPasswordByUid(uid);
        log.info("查询到的密码：{}", pwd);
        log.info("密码检验结果：{}", PasswordUtils.match(password, pwd));
        if (!PasswordUtils.match(password, pwd)) {
            log.info("用户密码错误，终止注销操作");
            throw new BusinessException(ResultCode.PASSWORD_ERROR);
        }
        log.info("用户密码正确，开始执行注销操作");
        //获取该用户的用户名
        String username = userAuthMapper.selectUsernameByUid(uid);
        //给注销用户的用户名添加注销标识
        //生成一个时间戳
        long timestamp = System.currentTimeMillis();
        String logoffUsername = username + UserConstant.USER_DELETE + timestamp;
        //注销用户
        Integer res = userAuthMapper.updateUserStatus(uid, StatusConstant.DISABLE, logoffUsername, "deleted:email:" + logoffUsername);

        if (res <= 0) {
            throw new BusinessException(ResultCode.ERROR);
        }
        log.info("成功注销uid为{}的用户", uid);
    }

    /**
     * 重置密码
     *
     * @param userModifyPasswordDTO 用户提交的原密码和新密码
     * @return
     */
    @Override
    public void modify(Long uid, UserModifyPasswordDTO userModifyPasswordDTO) {
        log.info("将uid为：{}的用户的原密码：{}更新为新密码：{}", uid, userModifyPasswordDTO.getOriginalPassword(), userModifyPasswordDTO.getNewPassword());

        //判断原密码是否正确
        String password = userAuthMapper.selectPasswordByUid(uid);
        log.info("密码验证结果：{}", PasswordUtils.match(userModifyPasswordDTO.getOriginalPassword(), password));
        if (!PasswordUtils.match(userModifyPasswordDTO.getOriginalPassword(), password)) {
            throw new BusinessException(ResultCode.PASSWORD_ERROR);
        }

        //更新密码
        //加密新密码
        String newPassword = PasswordUtils.encrypt(userModifyPasswordDTO.getNewPassword());
        Integer result = userAuthMapper.updatePassword(uid, newPassword);
        if (result <= 0) {
            throw new BusinessException(ResultCode.ERROR);
        }
        log.info("用户uid为{}的密码成功", uid);
    }

    /**
     * 邮箱验证码
     *
     * @param email 邮箱
     */
    @Override
    public void code(String email,String type) {
        if(type == null || type.isEmpty() || !VerificationCodeConstant.isContains(type)) {
            throw new BusinessException(ResultCode.UNKNOWN_EMAIL_CODE_SERVICE);
        }


        //生成随机验证码
        String code = RandomUtil.randomNumbers(6);

        //邮箱内容
        String content = "您的验证码是" + code + "，验证码5分钟内有效";

        //发送邮箱验证码
        mailService.send(email, "验证码", content);

        //将验证码存入redis中
        String emailHash = DigestUtils.md5Hex(email);

        //设置redis的key
        String keyPrefix = "";
        if(type.equals(VerificationCodeConstant.BINDING_VERIFICATION_CODE)){
            keyPrefix = RedisKeyPrefixConstant.VERIFY_CODE_EMAIL_BINDING;
        }
        if (type.equals(VerificationCodeConstant.RESET_VERIFICATION_COde)){
            keyPrefix = RedisKeyPrefixConstant.EMAIL_VERIFY_RESET_CODE;
        }
        String key = keyPrefix + emailHash;

        //向redis中存入验证码
        redisTemplate.opsForValue().set(key, code, 5, TimeUnit.MINUTES);
    }

    /**
     * 绑定邮箱
     * @param uid              用户uid
     * @param userBindEmailDTO 用户绑定邮箱的信息
     */
    @Override
    public void email(Long uid, UserBindEmailDTO userBindEmailDTO) {
        log.info("开始进行绑定邮箱操作");
        //对邮箱进行hash
        String emailHash = DigestUtils.md5Hex(userBindEmailDTO.getEmail());
        //设置redis的key
        String key = RedisKeyPrefixConstant.VERIFY_CODE_EMAIL_BINDING + emailHash;

        if (userAuthMapper.existEmail(userBindEmailDTO.getEmail())) {
            //清除code
            redisTemplate.delete(key);
            throw new BusinessException(ResultCode.EMAIL_HAS_BINDING);
        }

        String code = (String) redisTemplate.opsForValue().get(key);

        if (code == null) {
            throw new BusinessException(ResultCode.EMAIL_CODE_EXPIRED);
        }

        if (!userBindEmailDTO.getCode().equals(code)) {
            throw new BusinessException(ResultCode.EMAIL_CODE_ERROR);
        }

        Integer result = userAuthMapper.updateEmail(uid, userBindEmailDTO.getEmail());
        if (result <= 0) {
            throw new BusinessException(ResultCode.ERROR);
        }

        redisTemplate.delete(key);

    }

    /**
     * 用户忘记密码后重置密码
     *
     * @param userResetReqVO 用户重置密码提交的数据
     */
    @Override
    @UserAuth
    public void reset(UserResetReqVO userResetReqVO) {
        log.info("开始处理用户重置密码，用户提交的数据{}", userResetReqVO);
        //判断邮箱是否存在
        Long uid = userAuthMapper.selectUidByEmail(userResetReqVO.getEmail());

        if(uid == null){
            throw new BusinessException(ResultCode.UNKNOWN_EMAIL_ACCOUNT);
        }

        //判断邮箱验证码是否正确
        //对邮箱进行hash
        String hashEmail = DigestUtils.md5Hex(userResetReqVO.getEmail());
        String emailCode = (String) redisTemplate.opsForValue().get(RedisKeyPrefixConstant.EMAIL_VERIFY_RESET_CODE  + hashEmail);
        log.info("用户请求发送的验证码：{}",userResetReqVO.getEmailVerifyCode());
        log.info("存入redis中的验证码：{}", emailCode);
        if (emailCode == null) {
            log.info("无法从redis中获取到邮箱验证码");
            throw new BusinessException(ResultCode.EMAIL_CODE_EXPIRED);
        }

        if (!emailCode.equals(userResetReqVO.getEmailVerifyCode())) {
            log.info("用户提交的验证码错误");
            throw new BusinessException(ResultCode.EMAIL_CODE_ERROR);
        }

        //修改密码操作
        //密码加密
        String encrypt = PasswordUtils.encrypt(userResetReqVO.getNewPassword());
        //更新密码
        Integer result = userAuthMapper.updatePassword(uid, encrypt);
        if(result <= 0){
            throw new BusinessException(ResultCode.ERROR);
        }

        //删除redis中邮箱验证码的key
        redisTemplate.delete(RedisKeyPrefixConstant.EMAIL_VERIFY_RESET_CODE + hashEmail);

        log.info("密码重置结束");
    }

}

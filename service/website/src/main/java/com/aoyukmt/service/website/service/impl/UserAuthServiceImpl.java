package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.common.avatar.DiceBearAvatarGenerator;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.utils.JwtUtils;
import com.aoyukmt.common.utils.PasswordUtils;
import com.aoyukmt.common.utils.UserInfoUtils;
import com.aoyukmt.model.dto.UserLoginDTO;
import com.aoyukmt.model.vo.req.UserLoginReqVO;
import com.aoyukmt.model.vo.req.UserRegisterReqVO;
import com.aoyukmt.model.dto.UserAuthRegisterDTO;
import com.aoyukmt.model.dto.UserProfileRegisterDTO;
import com.aoyukmt.model.vo.resp.UserLoginRespVO;
import com.aoyukmt.service.website.annotation.UserAuth;
import com.aoyukmt.service.website.mapper.UserAuthMapper;
import com.aoyukmt.service.website.mapper.UserProfileMapper;
import com.aoyukmt.service.website.service.UserAuthService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 用户注册
     * @param userRegisterReqVO 用户注册数据
     */
    @Transactional
    @Override
    @UserAuth
    public String register(UserRegisterReqVO userRegisterReqVO, HttpServletRequest request) {

        //判断用户名是否存在
        Boolean existUser = userAuthMapper.existUsername(userRegisterReqVO.getUsername());
        log.info("用户是否存在：{}",existUser);
        if(existUser){
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
        userProfile.setNickname(randomNickname);
        userProfile.setAvatar(randomAvatarUrl);

        //获取用户ip信息
        String userIp = UserInfoUtils.getClientIp(request);
        log.info("用户ip:{}",userIp);
        JsonObject userIpJson = new JsonObject();
        userIpJson.addProperty("ip",userIp);
        Gson gson = new Gson();
        String userIpInfo = gson.toJson(userIpJson);
        log.info("用户ip json:{}",userIpInfo);
        userProfile.setIpInfo(userIpInfo);


        //插入用户基本信息
        userProfileMapper.insert(userProfile);
        //创建用户认证实体
        UserAuthRegisterDTO userAuth = new UserAuthRegisterDTO();
        userAuth.setUsername(userRegisterReqVO.getUsername());
        userAuth.setPassword(encrypt);
        log.info("注册的用户id:{}",userProfile.getId());
        userAuth.setUid(userProfile.getId());
        //插入用户认证信息
        userAuthMapper.insert(userAuth);

        //生成token，返回用户信息
        Map<String,Object> claims = new HashMap<>();
        claims.put("username",userAuth.getUsername());
        String token = jwtUtils.generateToken(Long.toString(userAuth.getUid()), claims);


        log.info("生成的登录token:{}",token);
        return token;
    }

    /**
     * 用户登录
     * @param userLoginReqVO 用户登录参数
     */
    @Override
    @UserAuth
    public UserLoginRespVO login(UserLoginReqVO userLoginReqVO) {

        //查询用户信息
        UserLoginDTO userLoginDTO = userAuthMapper.selectUser(userLoginReqVO.getAccount());
        if(userLoginDTO==null){
            throw new BusinessException(ResultCode.USER_NOT_EXIST);
        }

        //判断密码
        if(!PasswordUtils.match(userLoginReqVO.getPassword(),userLoginDTO.getPassword())){
            throw new BusinessException(ResultCode.ACCOUNT_OR_PASSWORD_ERROR);
        }

        //生成token
        Map<String,Object> claims = new HashMap<>();
        claims.put("username",userLoginDTO.getUserInfoDTO().getUsername());
        String token = jwtUtils.generateToken(String.valueOf(userLoginDTO.getUserInfoDTO().getUid()), claims);

        //返回用户信息
        UserLoginRespVO userLoginRespVO = new UserLoginRespVO();
        userLoginRespVO.setUserData(userLoginDTO.getUserInfoDTO());
        userLoginRespVO.setToken(token);

        return userLoginRespVO;
    }
}

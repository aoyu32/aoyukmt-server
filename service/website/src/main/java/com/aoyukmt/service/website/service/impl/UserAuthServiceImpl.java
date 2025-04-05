package com.aoyukmt.service.website.service.impl;

import com.anji.captcha.model.common.ResponseModel;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.aoyukmt.common.enumeration.ResultCode;
import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.utils.PasswordUtils;
import com.aoyukmt.common.utils.UserInfoUtils;
import com.aoyukmt.model.vo.req.UserRegisterVO;
import com.aoyukmt.model.dto.UserAuthRegisterDTO;
import com.aoyukmt.model.dto.UserProfileRegisterDTO;
import com.aoyukmt.service.website.mapper.UserAuthMapper;
import com.aoyukmt.service.website.mapper.UserProfileMapper;
import com.aoyukmt.service.website.service.UserAuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private CaptchaService captchaService;

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;

    /**
     * 用户注册
     * @param userRegisterVO 用户注册数据
     */
    @Transactional
    @Override
    public void register(UserRegisterVO userRegisterVO) {
        //进行滑块验证二次验证
        CaptchaVO captchaVO = new CaptchaVO();
        captchaVO.setCaptchaVerification(userRegisterVO.getVerifyCode());
        ResponseModel verification = captchaService.verification(captchaVO);
        log.info("二次验证结果：{}",verification);
        if(!verification.getRepCode().equals("0000")){
            throw new BusinessException(ResultCode.VERIFY_CODE_ERROR);
        }

        //判断用户名是否存在
        String existUser = userAuthMapper.getUserByUsername(userRegisterVO.getUsername());
        if(existUser != null){
            throw new BusinessException(ResultCode.USER_ALREADY_EXIST);
        }

        //注册用户
        //密码加密
        String encrypt = PasswordUtils.encrypt(userRegisterVO.getPassword());
        //创建用户信息实体
        UserProfileRegisterDTO userProfile = new UserProfileRegisterDTO();
        //生成随机昵称
        String randomNickname = UserInfoUtils.getRandomNickname();
        //生成随机头像url
//        String randomAvatarUrl = UserInfoUtils.getRandomAvatarUrl(randomNickname,50);
        userProfile.setNickname(randomNickname);
//        userProfile.setAvatar(randomAvatarUrl);

        //插入用户基本信息
        userProfileMapper.insert(userProfile);
        //创建用户认证实体
        UserAuthRegisterDTO userAuth = new UserAuthRegisterDTO();
        userAuth.setUsername(userRegisterVO.getUsername());
        userAuth.setPassword(encrypt);
        log.info("注册的用户id:{}",userProfile.getId());
        userAuth.setUid(userProfile.getId());
        //插入用户认证信息
        userAuthMapper.insert(userAuth);
    }
}

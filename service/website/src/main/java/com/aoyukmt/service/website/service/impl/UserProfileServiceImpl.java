package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.service.website.mapper.UserProfileMapper;
import com.aoyukmt.service.website.service.UserProfileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName：UserProfileServiceImpl
 * @Author: aoyu
 * @Date: 2025-04-08 10:55
 * @Description: 用户信息接口实现类
 */

@Service
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Override
    public UserInfoDTO getUserInfo(Long uid) {
        log.info("开始查询 uid 为{}的用户信息", uid);
        return userProfileMapper.selectUserInfoByUid(uid);
    }
}

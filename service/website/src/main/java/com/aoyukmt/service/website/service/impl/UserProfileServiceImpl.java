package com.aoyukmt.service.website.service.impl;

import com.aoyukmt.common.exception.BusinessException;
import com.aoyukmt.common.utils.ThreadLocalUtils;
import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.model.dto.UserUpdateDTO;
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

    /**
     * 查询用户信息
     * @param uid
     * @return
     */
    @Override
    public UserInfoDTO getUserInfo(Long uid) {
        log.info("开始查询 uid 为{}的用户信息", uid);
        return userProfileMapper.selectUserInfoByUid(uid);
    }


    /**
     * 更新用户信息
     * @param userUpdateDTO 用户需要更新的参数
     * @return
     */
    @Override
    public Integer userUpdate(UserUpdateDTO userUpdateDTO) {

        log.info("开始更新用户信息，UID: {}，更新内容: {}", userUpdateDTO.getUid(),userUpdateDTO);
        Integer result = userProfileMapper.updateUserById(userUpdateDTO);
        if(result > 0){
            log.info("更新成功");
        }else {
            throw new BusinessException(440,"更新失败");
        }
        return result;
    }
}

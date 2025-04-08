package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.common.utils.ThreadLocalUtils;
import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.service.website.service.UserProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName：UserProfileController
 * @Author: aoyu
 * @Date: 2025-04-04 15:53
 * @Description: 用户信息
 */

@RestController
@RequestMapping("/web/user")
@Tag(name = "用户信息",description = "用户信息查询修改相关接口")
@Slf4j
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    /**
     * 获取用户信息
     * @return 用户信息
     */
    @PostMapping("/info")
    public Result<?> getUserInfo(){
        //获取uid
        Long uid = Long.valueOf( ThreadLocalUtils.get("uid").toString());
        log.info("{}请求获取用户信息",uid);
        //查询用户数据
        UserInfoDTO userInfo = userProfileService.getUserInfo(uid);
        log.info("返回uid为{}的用户信息{}",uid,userInfo);
        return Result.success(userInfo);
    }

}

package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.common.utils.ThreadLocalUtils;
import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.model.dto.UserUpdateDTO;
import com.aoyukmt.service.website.service.UserProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    @Operation(summary = "获取用户信息",description = "用户登录成功后获取用户的基本信息")
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

    /**
     * @description: 更新用户信息
     * @author: aoyu
     * @date: 2025/4/15 下午4:15
     * @param: 用户需要更新的信息参数
     * @return:
     */
    @Operation(summary = "更新用户信息",description = "更新用户的基本信息")
    @PostMapping("/update")
    public Result<?> update(@RequestBody UserUpdateDTO userUpdateDTO){
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        userUpdateDTO.setUid(uid);
        log.info("用户uid为{}请求更新信息{}",userUpdateDTO);
        userProfileService.userUpdate(userUpdateDTO);
        return Result.success();
    }


    @Operation(summary = "修改用户头像",description = "修改用户的头像，可以随机生成头像，可以上传头像")
    @PostMapping("/avatar")
    public Result<String> avatar(@RequestParam("action") String action, MultipartFile file) throws IOException {
        log.info("上传的文件是本地文件还是随机图片{}",action);
        log.info("用户上次的图片数据：{}",file);
        String avatar = userProfileService.avatar(action,file);
        return Result.success(avatar);
    }



}

package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.model.vo.req.UserRegisterVO;
import com.aoyukmt.service.website.service.UserAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName：UserAuthController
 * @Author: aoyu
 * @Date: 2025-04-04 15:51
 * @Description: 用户认证控制器类
 */

@RestController
@RequestMapping("/web/auth")
@Tag(name = "用户认证", description = "用户登录，注册，退出登录，修改认证信息，绑定邮箱等认证相关接口")
@Slf4j
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;


    @Operation(summary = "用户注册", description = "用户注册接口")
    @PostMapping("/register")
    public Result<?> register(@RequestBody UserRegisterVO userRegisterVO) {
        log.info("用户注册信息：{}", userRegisterVO);
        userAuthService.register(userRegisterVO);
        return Result.success();
    }


}

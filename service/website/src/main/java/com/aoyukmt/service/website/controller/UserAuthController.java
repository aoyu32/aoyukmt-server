package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.model.vo.req.UserLoginReqVO;
import com.aoyukmt.model.vo.req.UserRegisterReqVO;
import com.aoyukmt.model.vo.resp.UserLoginRespVO;
import com.aoyukmt.service.website.service.UserAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
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
    public Result<String> register(@RequestBody UserRegisterReqVO userRegisterReqVO, HttpServletRequest request) {
        log.info("用户注册信息：{}", userRegisterReqVO);
        String userAuthToken = userAuthService.register(userRegisterReqVO, request);
        return Result.success(userAuthToken);
    }

    @Operation(summary = "用户登录",description = "用户登录，可以使用用户名或邮箱进行登录")
    @PostMapping("/login")
    public Result<UserLoginRespVO> login(@RequestBody UserLoginReqVO userLoginReqVO){

        log.info("用户名/邮箱为{}请求登录", userLoginReqVO.getAccount());
        UserLoginRespVO userInfo = userAuthService.login(userLoginReqVO);
        log.info("登录用户的信息：{}",userInfo.toString());
        return Result.success(userInfo);
    }

}

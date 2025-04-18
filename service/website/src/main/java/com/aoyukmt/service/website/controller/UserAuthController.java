package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.common.utils.ThreadLocalUtils;
import com.aoyukmt.model.dto.UserBindEmailDTO;
import com.aoyukmt.model.dto.UserResetDTO;
import com.aoyukmt.model.vo.req.UserLoginReqVO;
import com.aoyukmt.model.vo.req.UserRegisterReqVO;
import com.aoyukmt.model.vo.resp.UserLoginRespVO;
import com.aoyukmt.service.website.service.UserAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @Operation(summary = "用户登录", description = "用户登录，可以使用用户名或邮箱进行登录")
    @PostMapping("/login")
    public Result<UserLoginRespVO> login(@RequestBody UserLoginReqVO userLoginReqVO) {
        log.info("用户名/邮箱为{}请求登录", userLoginReqVO.getAccount());
        UserLoginRespVO userInfo = userAuthService.login(userLoginReqVO);
        log.info("登录用户的信息：{}", userInfo.toString());
        return Result.success(userInfo);
    }

    @Operation(summary = "注销用户", description = "注销用户接口")
    @PostMapping("/logoff")
    public Result<?> logoff(@RequestBody Map<String, String> param) {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户uid为：{}请求注销用户，身份验证密码：{}", uid, param.get("password"));
        userAuthService.logoff(uid, param.get("password"));
        log.info("注销操作完成");
        return Result.success();
    }


    @Operation(summary = "重置密码", description = "重置用户的密码接口")
    @PostMapping("/reset")
    public Result<?> reset(@RequestBody UserResetDTO userResetDTO) {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户uid为：{}请求重置密码", uid);
        userAuthService.reset(uid, userResetDTO);
        log.info("更新用户为uid{}密码完成", uid);
        return Result.success();
    }

    @Operation(summary = "获取邮箱验证码", description = "获取邮箱验证码服务")
    @PostMapping("/code")
    public Result<String> code(@RequestBody Map<String,String> param) {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户id为：{},请求获取邮箱验证码，邮箱为{}", uid, param.get("email"));
        userAuthService.code(uid, param.get("email"));
        log.info("验证码发送成功");
        return Result.success();
    }

    @Operation(summary = "绑定邮箱", description = "用户绑定邮箱接口")
    @PostMapping("/email")
    public Result<?> email(@RequestBody UserBindEmailDTO userBindEmailDTO) {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户uid为：{}的用户请求绑定邮箱，验证码：{}，邮箱：{}",uid,userBindEmailDTO.getCode(),userBindEmailDTO.getEmail());
        userAuthService.email(uid, userBindEmailDTO);
        return Result.success();
    }


}

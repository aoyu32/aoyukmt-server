package com.aoyukmt.service.website.controller;

import com.aoyukmt.common.result.Result;
import com.aoyukmt.common.utils.ThreadLocalUtils;
import com.aoyukmt.model.dto.UserBindEmailDTO;
import com.aoyukmt.model.dto.UserModifyPasswordDTO;
import com.aoyukmt.model.vo.req.UserLoginReqVO;
import com.aoyukmt.model.vo.req.UserRegisterReqVO;
import com.aoyukmt.model.vo.req.UserResetReqVO;
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


    @Operation(summary = "修改密码", description = "用户登录后用户修改密码的接口")
    @PostMapping("/modify")
    public Result<?> reset(@RequestBody UserModifyPasswordDTO userModifyPasswordDTO) {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户uid为：{}请求重置密码", uid);
        userAuthService.modify(uid, userModifyPasswordDTO);
        log.info("更新用户为uid{}密码完成", uid);
        return Result.success();
    }

    @Operation(summary = "获取邮箱验证码", description = "获取邮箱验证码服务")
    @PostMapping("/code/{type}")
    public Result<String> code(@PathVariable String type, @RequestBody Map<String, String> param) {
        log.info("邮箱为：{}，请求获取邮箱验证码", param.get("email"));
        userAuthService.code(param.get("email"), type);
        log.info("验证码发送成功");
        return Result.success();
    }

    @Operation(summary = "绑定邮箱", description = "用户绑定邮箱接口")
    @PostMapping("/email")
    public Result<?> email(@RequestBody UserBindEmailDTO userBindEmailDTO) {
        Long uid = Long.valueOf(ThreadLocalUtils.get("uid").toString());
        log.info("用户uid为：{}的用户请求绑定邮箱，验证码：{}，邮箱：{}", uid, userBindEmailDTO.getCode(), userBindEmailDTO.getEmail());
        userAuthService.email(uid, userBindEmailDTO);
        return Result.success();
    }


    @Operation(summary = "重置密码", description = "忘记密码后重置密码")
    @PostMapping("reset")
    public Result<?> resetPassword(@RequestBody UserResetReqVO userResetReqVO) {
        log.info("邮箱为：{}的用户请求重置密码", userResetReqVO.getEmail());
        userAuthService.reset(userResetReqVO);
        log.info("重置密码成功");
        return Result.success();
    }

}

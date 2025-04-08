package com.aoyukmt.service.website.service;

import com.aoyukmt.model.vo.req.UserLoginReqVO;
import com.aoyukmt.model.vo.req.UserRegisterReqVO;
import com.aoyukmt.model.vo.resp.UserLoginRespVO;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @InterfaceName：UserAuthService
 * @Author: aoyu
 * @Date: 2025/4/5 下午4:47
 * @Description:
 */

public interface UserAuthService {

    /**
     * 用户注册
     * @param userRegisterReqVO 用户注册参数
     */
    String register(UserRegisterReqVO userRegisterReqVO, HttpServletRequest request);

    /**
     * 用户登录
     * @param userLoginReqVO 用户登录参数
     */
    void login(UserLoginReqVO userLoginReqVO);

}

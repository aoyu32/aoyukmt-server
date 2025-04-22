package com.aoyukmt.service.website.service;

import com.aoyukmt.model.dto.UserBindEmailDTO;
import com.aoyukmt.model.dto.UserModifyPasswordDTO;
import com.aoyukmt.model.vo.req.UserLoginReqVO;
import com.aoyukmt.model.vo.req.UserRegisterReqVO;
import com.aoyukmt.model.vo.req.UserResetReqVO;
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
     * 注销用户
     * @param uid 用户id
     * @param password 验证身份的密码
     */
     void logoff(Long uid, String password);

    /**
     * 用户注册
     * @param userRegisterReqVO 用户注册参数
     */
    String register(UserRegisterReqVO userRegisterReqVO , HttpServletRequest request);

    /**
     * 用户登录
     * @param userLoginReqVO 用户登录参数
     * @return UserLoginDTO
     */
    UserLoginRespVO login(UserLoginReqVO userLoginReqVO);

    /**
     * 重置密码
     * @param userModifyPasswordDTO 用户提交的原密码和新密码
     * @return 更新结果
     */
    void modify(Long uid, UserModifyPasswordDTO userModifyPasswordDTO);

    /**
     * 获取邮箱验证码
     * @return 验证码
     */
    void code(String email,String keyPrefix);

    /**
     * 绑定邮箱
     * @param uid 用户uid
     * @param userBindEmailDTO 用户绑定邮箱的信息
     */
    void email(Long uid, UserBindEmailDTO userBindEmailDTO);

    /**
     * 重置密码
     * @param userResetReqVO 用户重置密码提交的数据
     */
    void reset(UserResetReqVO userResetReqVO);
}

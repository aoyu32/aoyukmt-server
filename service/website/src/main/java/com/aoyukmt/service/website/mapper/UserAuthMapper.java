package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.dto.UserAuthRegisterDTO;
import com.aoyukmt.model.dto.UserLoginDTO;
import com.aoyukmt.model.dto.UserResetDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * @InterfaceName：UserAuthMapper
 * @Author: aoyu
 * @Date: 2025/4/5 下午5:19
 * @Description:
 */

@Mapper
public interface UserAuthMapper {

    /**
     * 查询用户名是否存在
     * @param username 用户名
     * @return 用户名
     */
    @Select("select count(1)>0 from user_auth where username = #{username}")
    Boolean existUsername(String username);


    /**
     * 根据uid查询用户名
     * @param uid 用户id
     * @return 用户名
     */
    @Select("select username from user_auth where uid = #{uid}")
    String selectUsernameByUid(Long uid);

    /**
     * 插入一条用户信息
     * @param userAuthRegisterDTO 用户注册信息
     */
    @Insert("insert into user_auth(uid,username,password,last_login_time,last_login_ip) values (#{uid},#{username},#{password},#{lastLoginTime},#{lastLoginIp})")
    void insert(UserAuthRegisterDTO userAuthRegisterDTO);


    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    UserLoginDTO selectUser(String account);


    /**
     * 根据uid查询用户密码
     * @param uid 用户id
     * @return 密码
     */
    @Select("select password from user_auth where uid = #{uid}")
    String selectPasswordByUid(Long uid);

    /**
     * 根据uid更新用户账号的状态
     * @param uid 用户id
     * @param status 账号状态 0:禁用 1:启用
     * @return 更新结果
     */
    @Update("update user_auth set delete_status = #{status},username=#{logoffUsername} where uid = #{uid}")
    Integer updateUserStatus(Long uid, Integer status, String logoffUsername);


    /**
     * 更新最后登录时间
     * @param uid 用户id
     * @param lastLoginTime 当前时间
     */
    @Update("update user_auth set last_login_time = #{lastLoginTime} where uid = #{uid}")
    void updateLastLoginTime(Long uid, LocalDateTime lastLoginTime);

    /**
     * 更新用户密码
     * @param uid 用户id
     * @param newPassword 用户新密码
     * @return 更新结果
     */
    @Update("update user_auth set password = #{newPassword} where uid = #{uid}")
    Integer updatePassword(Long uid, String newPassword);

}

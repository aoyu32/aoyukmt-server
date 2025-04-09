package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.dto.UserAuthRegisterDTO;
import com.aoyukmt.model.dto.UserLoginDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
     * 插入一条用户信息
     * @param userAuthRegisterDTO 用户注册信息
     */
    @Insert("insert into user_auth(uid,username,password) values (#{uid},#{username},#{password})")
    void insert(UserAuthRegisterDTO userAuthRegisterDTO);


    /**
     * 根据账号查询用户
     * @param account
     * @return
     */
    UserLoginDTO selectUser(String account);




}

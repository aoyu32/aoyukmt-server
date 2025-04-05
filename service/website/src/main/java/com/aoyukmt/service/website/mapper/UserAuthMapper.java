package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.dto.UserAuthRegisterDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @InterfaceName：UserAuthMapper
 * @Author: aoyu
 * @Date: 2025/4/5 下午5:19
 * @Description:
 */

@Mapper
public interface UserAuthMapper {

    /**
     * 根据用户名查询用户
     */
    @Select("select username from user_auth where username = #{username}")
    String getUserByUsername(String username);

    @Insert("insert into user_auth(uid,username,password) values (#{uid},#{username},#{password})")
    void insert(UserAuthRegisterDTO userAuthRegisterDTO);



}

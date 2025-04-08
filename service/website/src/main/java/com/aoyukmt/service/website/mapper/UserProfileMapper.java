package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.model.dto.UserProfileRegisterDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @InterfaceName：UserProfileMapper
 * @Author: aoyu
 * @Date: 2025/4/5 下午9:08
 * @Description:
 */

@Mapper
public interface UserProfileMapper {

    /**
     * 插入一条用户注册信息
     * @param userProfileRegisterDTO 用户注册的基本信息
     */
    @Insert("insert into user_profile(nickname,avatar,ip_info) values (#{nickname},#{avatar},#{ipInfo})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void insert(UserProfileRegisterDTO userProfileRegisterDTO);
    UserInfoDTO selectUserInfoByUid(Long uid);


}

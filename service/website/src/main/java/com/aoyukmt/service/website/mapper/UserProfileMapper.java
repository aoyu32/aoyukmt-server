package com.aoyukmt.service.website.mapper;

import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.model.dto.UserProfileRegisterDTO;
import com.aoyukmt.model.dto.UserUpdateDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

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


    /**
     * 更新某个uid的某个字段
     * @param userUpdateDTO 用户要更新的参数
     * @return 更新影响的行数
     */
    Integer updateUserById(UserUpdateDTO userUpdateDTO);

    @Update("update user_profile set avatar = #{avatarUrl} where id = #{uid}")
    Integer updateAvatarById(Long uid,String avatarUrl);

}

package com.aoyukmt.service.website.service;

import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.model.dto.UserUpdateDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @InterfaceName：UserProfileService
 * @Author: aoyu
 * @Date: 2025/4/8 上午10:51
 * @Description:
 */

public interface UserProfileService {

    /**
     * 获取用户信息
     *
     * @return 用户信息实体
     */
    UserInfoDTO getUserInfo(Long uid);


    /**
     * 更新用户信息
     *
     * @param userUpdateDTO 用户需要更新的参数
     * @return 更新结果
     */
    Integer userUpdate(UserUpdateDTO userUpdateDTO);


    /**
     * 用户修改头像
     *
     * @param file
     * @return 头像图片url
     */
    String localAvatar(Long uid, MultipartFile file) throws IOException;

    /**
     * 生成随机头像返回
     *
     * @return 随机头像url
     */
    String randomAvatar(Long uid,String action);

}

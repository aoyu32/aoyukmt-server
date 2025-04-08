package com.aoyukmt.service.website.service;

import com.aoyukmt.model.dto.UserInfoDTO;
import com.aoyukmt.model.vo.resp.UserLoginRespVO;

/**
 * @InterfaceName：UserProfileService
 * @Author: aoyu
 * @Date: 2025/4/8 上午10:51
 * @Description:
 */

public interface UserProfileService {

    /**
     * 获取用户信息
     * @return 用户信息实体
     */
    UserInfoDTO getUserInfo(Long uid);

}

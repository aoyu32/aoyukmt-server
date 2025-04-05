package com.aoyukmt.service.website.service;

import com.aoyukmt.model.vo.req.UserRegisterVO;

/**
 * @InterfaceName：UserAuthService
 * @Author: aoyu
 * @Date: 2025/4/5 下午4:47
 * @Description:
 */

public interface UserAuthService {

    void register(UserRegisterVO userRegisterVO);

}

package com.aoyukmt.service.website.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName：UserProfileController
 * @Author: aoyu
 * @Date: 2025-04-04 15:53
 * @Description: 用户信息
 */

@RestController
@RequestMapping("/web/user")
@Tag(name = "用户信息",description = "用户信息查询修改相关接口")
public class UserProfileController {
}

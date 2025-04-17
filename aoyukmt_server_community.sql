CREATE TABLE `user_profile` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
  `nickname` varchar(64) NOT NULL COMMENT '用户昵称',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像URL',
  `gender` tinyint(1) DEFAULT 0 COMMENT '用户性别: 0-未知, 1-男, 2-女',
  `bio` varchar(500) DEFAULT NULL COMMENT '用户简介',
  `active_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '在线状态: 1-在线, 2-离线',
  `registration_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `ip_info` json DEFAULT NULL COMMENT 'IP地理位置等信息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_status` (`status`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户基本信息表' AUTO_INCREMENT = 10000;

ALTER TABLE `user_profile` DROP COLUMN `status`;

-- 用户认证信息表
CREATE TABLE `user_auth` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '认证ID',
  `uid` bigint UNSIGNED NOT NULL COMMENT '关联的用户ID',
  `username` varchar(64) NOT NULL COMMENT '用户名(登录用)',
  `email` varchar(255) DEFAULT NULL COMMENT '用户邮箱(登录和验证用)',
  `password` VARCHAR(255) NOT NULL COMMENT '用户登录密码',
  `last_login_ip` varchar(64) DEFAULT NULL COMMENT '上次登录IP',
  `last_login_time` timestamp NULL DEFAULT NULL COMMENT '上次登录时间',
	`delete_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '逻辑删除: 0-正常, 1-已删除',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_username` (`username`),
  UNIQUE KEY `uk_email` (`email`),
  KEY `idx_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户认证信息表' AUTO_INCREMENT = 10000;

-- 用户封禁记录表 (移除外键约束)
CREATE TABLE `user_bans` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '封禁记录ID',
  `uid` bigint UNSIGNED NOT NULL COMMENT '关联的用户ID',
  `ban_type` tinyint(1) NOT NULL COMMENT '封禁类型: 1-禁言, 2-功能限制, 3-完全封禁',
  `ban_details` json DEFAULT NULL COMMENT '封禁详情: 功能限制的具体内容(JSON格式)',
  `reason` varchar(1000) NOT NULL COMMENT '封禁原因',
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '开始时间',
  `expires_at` timestamp NULL DEFAULT NULL COMMENT '过期时间(NULL表示永久)',
  `status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态: 1-生效中, 2-已过期, 3-已撤销',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_uid` (`uid`),
  KEY `idx_expires_at` (`expires_at`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户封禁记录表';


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

-- 用户反馈表
CREATE TABLE `feedback` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '反馈id',
  `uid` BIGINT UNSIGNED NOT NULL COMMENT '用户id',
  `responder` VARCHAR(255) NOT NULL COMMENT '反馈人的名称',
  `content` TEXT NOT NULL COMMENT '反馈内容',
  `type` ENUM('suggestions', 'bug', 'feature', 'other') DEFAULT 'other' COMMENT '反馈的类型',
  `processing_status` ENUM('pending', 'in_progress', 'resolved', 'closed') DEFAULT 'pending' COMMENT '反馈处理状态',
  `priority` TINYINT UNSIGNED DEFAULT 2 COMMENT '反馈处理优先级，1=低，2=中，3=高',
  `processed_time` TIMESTAMP NULL DEFAULT NULL COMMENT '处理完成时间',
  `processor` VARCHAR(255) DEFAULT NULL COMMENT '处理人',
  `is_deleted` TINYINT(1) DEFAULT 0 COMMENT '逻辑删除（0=未删除，1=已删除）',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  INDEX `uid_idx` (`uid`),
  INDEX `create_time_idx` (`create_time`),
  INDEX `processing_status_idx` (`processing_status`),
  INDEX `priority_idx` (`priority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
COMMENT='用户反馈表';

-- 反馈附件表
CREATE TABLE `feedback_attachment` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '附件ID',
  `uid` BIGINT UNSIGNED NOT NULL COMMENT '上传用户ID',
  `feedback_id` INT UNSIGNED NOT NULL COMMENT '关联的反馈ID',
  `file_name` VARCHAR(255) NOT NULL COMMENT '原始文件名',
  `file_url` VARCHAR(1024) NOT NULL COMMENT '文件访问URL',
  `file_type` VARCHAR(255) DEFAULT 'other' COMMENT '文件MIME类型',
  `file_size` INT UNSIGNED NOT NULL COMMENT '文件大小(字节)',
  `is_deleted` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否删除(0=未删除,1=已删除)',
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  INDEX `idx_uid` (`uid`),
  INDEX `idx_feedback_deleted` (`feedback_id`, `is_deleted`),
  CONSTRAINT `fk_attachment_feedback` 
    FOREIGN KEY (`feedback_id`) 
    REFERENCES `feedback` (`id`) 
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
COMMENT='用户反馈附件表';

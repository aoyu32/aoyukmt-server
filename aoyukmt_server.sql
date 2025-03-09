/*
 Navicat Premium Dump SQL

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : localhost:3306
 Source Schema         : aoyukmt_server

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 08/03/2025 13:01:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for feature_detail
-- ----------------------------
DROP TABLE IF EXISTS `feature_detail`;
CREATE TABLE `feature_detail`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '功能详情展示id',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '详情表情字体图标',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '详情展示标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '详情展示内容',
  `img_url` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '详情展示图片链接',
  `sort_order` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '详情展示序号',
  `is_active` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否展示，1展示，0不展示，默认展示',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_sort_order`(`sort_order` ASC) USING BTREE COMMENT '索引：优化排序查询',
  INDEX `idx_is_active`(`is_active` ASC) USING BTREE COMMENT '索引：优化展示状态查询'
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of feature_detail
-- ----------------------------
INSERT INTO `feature_detail` VALUES (1, '⌨️', '高度自定义快捷键', '告别固定死板的系统快捷键，彻底解放您的操作习惯！支持自定义所有快捷键，轻松映射任意组合，让您的指尖操作更加流畅高效。无论是执行命令、调用软件，还是窗口管理，都能随心设置，打造完全符合自己习惯的操作方式，远超传统键盘快捷方式的局限。', '/assets/8.webp', 1, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');
INSERT INTO `feature_detail` VALUES (2, '🔤', '字符映射输入', '有些按键组合总让你感到别扭？比如输入一些常用的符号或字符，却总是需要按组合键或多次切换。现在，您可以通过软件将这些复杂组合映射成简单快捷的按键操作。只需按下自定义的快捷键组合，就能迅速输入常见字符，大大减少手指的移动和按键的记忆负担，轻松实现高效输入。', '/assets/9.webp', 2, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');
INSERT INTO `feature_detail` VALUES (3, '🎯', '颠覆传统的方向键替代方案', '方向键太远？影响打字流畅度？本软件独创方向键替代方案，利用 Space + W/A/S/D 组合，实现更加顺滑精准的光标移动。无需再让手指离开主键区，减少疲劳，提高文本编辑效率，远超传统方向键的生硬体验。', '/assets/5.webp', 3, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');
INSERT INTO `feature_detail` VALUES (4, '🚀', '超快软件和文件启动', '还在费力翻找应用程序或文件？传统方式需要点击开始菜单、桌面图标或任务栏，而本软件让您通过快捷键一键直达，无需鼠标操作！支持自定义启动项，无论是文件夹、软件、网站还是磁盘，都能秒速打开，极大优化工作流。', '/assets/6.webp', 4, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');
INSERT INTO `feature_detail` VALUES (5, '📌', '热字符串输入', '敲击几个字符，就能自动扩展出完整的单词、短语甚至整段文本。支持代码片段、邮件模板、客服回复等多种场景，彻底告别重复输入！相比传统输入法或剪贴板工具，热字符串能更快、更智能地完成文本扩展，极大提升效率。', '/assets/10.webp', 5, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');
INSERT INTO `feature_detail` VALUES (6, '📝', '编辑操作自由定义', '打破 Ctrl+C/V/X/Z 的僵化组合，支持完全自定义的剪切、复制、粘贴、撤销等快捷键，符合您的操作习惯。再也不用适应固定的快捷方式，而是让快捷键适应您！相比传统方式，减少按键冲突，提高输入流畅度。', '/assets/7.webp', 6, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');
INSERT INTO `feature_detail` VALUES (7, '⚙️', '全方位系统控制', '传统的系统操作需要打开多个窗口，点击各种菜单，而本软件提供一键控制方案。音量调节、输入法切换、亮度调节、托盘管理、关机重启等操作，全部可通过自定义快捷键一键搞定，彻底提升系统操控效率。', '/assets/11.webp', 7, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');
INSERT INTO `feature_detail` VALUES (8, '🪟', '极致窗口管理', '传统窗口管理需要拖动、点击按钮，甚至调用任务管理器，本软件提供更便捷的解决方案！一键最小化、最大化、关闭、调整大小、移动窗口，甚至快速切换应用，减少鼠标依赖，让您的多任务处理更加高效。', '/assets/12.webp', 8, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');
INSERT INTO `feature_detail` VALUES (9, '🗂️', '文件管理器快捷键增强', '传统文件管理方式繁琐，需要鼠标操作或单调的固定快捷键。本软件允许您自由配置文件管理器快捷键，实现更快速的新建、删除、重命名、复制、粘贴等文件操作，让您的工作更加流畅，效率远超传统方式。', '/assets/13.webp', 9, 1, '2025-03-07 11:32:45', '2025-03-07 11:32:45');

-- ----------------------------
-- Table structure for features
-- ----------------------------
DROP TABLE IF EXISTS `features`;
CREATE TABLE `features`  (
  `id` int UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '唯一标识每个功能特点',
  `icon` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表情字体图标',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '功能特点名称，如\"模块化设计\"',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '功能特点详细描述',
  `is_active` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否启用，1启用，0禁用',
  `sort_order` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '排序优先级，值越小越靠前',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_is_active`(`is_active` ASC) USING BTREE COMMENT '索引：优化展示状态查询',
  INDEX `idx_sort_order`(`sort_order` ASC) USING BTREE COMMENT '索引：优化排序查询'
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of features
-- ----------------------------
INSERT INTO `features` VALUES (1, '🔧', '模块化设计', '灵活可控的功能模块，按需开启禁用', 1, 1, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (2, '⌨️', '自定义快捷键', '支持多种操作快捷键，适配个人习惯', 1, 2, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (3, '🔤', '字符映射输入', '使用键位映射特殊字符，提高输入效率', 1, 3, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (4, '🎯', '方向键替换', '可用 space+w/a/s/d 代替方向键操作', 1, 4, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (5, '📝', '编辑控制增强', '提供剪切、复制、粘贴等快捷键方案', 1, 5, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (6, '💾', '磁盘快捷访问', 'RShift+字母 直接打开指定磁盘', 1, 6, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (7, '🚀', '快速启动软件', 'lalt+字母 启动常用本地软件', 1, 7, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (8, '🌐', '快速访问网站', 'ralt+字母 直接打开常用网站', 1, 8, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (9, '📌', '热字符串扩展', '输入特定缩写，自动展开为完整文本', 1, 9, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (10, '⚙️', '系统操作快捷键', '一键执行托盘、音量调节、关机重启等操作', 1, 10, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (11, '🗂️', '资源管理器优化', '提供新建、删除、重命名等快捷方式', 1, 11, '2025-03-07 11:30:37', '2025-03-07 11:30:37');
INSERT INTO `features` VALUES (12, '🪟', '窗口管理增强', '支持窗口关闭、最小化、最大化、移动等操作', 1, 12, '2025-03-07 11:30:37', '2025-03-07 11:30:37');

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE `document_categories` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '文档分类id',
  `name` VARCHAR(100) DEFAULT NULL COMMENT '文档分类名称',
  `is_open` TINYINT(1) DEFAULT 1 COMMENT '是否默认展开该分类下的子项，1:展开，0:收起',
  `sort_order` INT DEFAULT 0 COMMENT '文档分类排序',
  `is_active` TINYINT(1) DEFAULT 1 COMMENT '是否启用该分类，1:启用，0:禁用',
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP COMMENT '文档分类创建时间',
  `update_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '文档分类修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_sort_order` (`sort_order`) COMMENT '索引：优化排序查询',
  KEY `idx_is_active` (`is_active`) COMMENT '索引：优化展示状态查询'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `document_categories` (`name`, `is_open`, `sort_order`, `is_active`) VALUES
('快速开始', 1, 1, 1),
('使用指导', 1, 2, 1),
('应用配置', 1, 3, 1),
('常见问题', 1, 4, 1);

CREATE TABLE `documents` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '文档标签id',
  `category_id` INT NOT NULL COMMENT '所属文档分类id',
  `label` VARCHAR(100) NOT NULL COMMENT '文档标签',
	`docs_url` text COMMENT '文档内容，markdown格式',
  `en_label` VARCHAR(100) DEFAULT NULL COMMENT '英文文档标签',
  `sort_order` TINYINT DEFAULT 0 COMMENT '文档标签排序',
  `is_active` TINYINT DEFAULT 1 COMMENT '是否启用，1:启用，0:禁用',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_sort_order` (`sort_order`) COMMENT '索引：优化排序查询',
  KEY `idx_is_active` (`is_active`) COMMENT '索引：优化展示状态查询',
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `document_categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 插入数据到 documents 表
INSERT INTO documents (category_id, label, docs_url, en_label, sort_order, is_active) VALUES
-- 快速开始分类下的文档
(1, '简介', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'intro', 1, 1),
(1, '安装和启动', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'install', 2, 1),
(1, '快速入门', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'gettingstarted', 3, 1),

-- 使用指导分类下的文档
(2, '字符输入映射', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'mapping', 1, 1),
(2, '方向键映射', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'directional', 2, 1),
(2, '编辑控制映射', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'editing', 3, 1),
(2, '打开磁盘映射', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'disk', 4, 1),
(2, '应用快捷启动', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'app', 5, 1),
(2, '网站快捷启动', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'website', 6, 1),
(2, '热字符串', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'hotstrings', 7, 1),
(2, '常用系统操作映射', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'system', 8, 1),
(2, '资源管理器映射', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'file', 9, 1),
(2, '窗口操作映射', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'window', 10, 1),

-- 应用配置分类下的文档
(3, '配置说明', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'config', 1, 1),
(3, '各功能配置', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'features', 2, 1),

-- 常见问题分类下的文档
(4, '错误弹窗', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'error', 1, 1),
(4, '按键映射问题', 'https://aoyukmt.oss-cn-beijing.aliyuncs.com/doc/manual/intro.md?Expires=1741421654&OSSAccessKeyId=TMP.3Krco8AXpyrEPv4ZrmBBv5AAKnbxHLd9X7KYM8yNEzfRzBaSobovsNC1pL1Wt9LuJYAP6uptVBbeGJoAwvvWRxZTS4UWuM&Signature=zA9XM6xlmWEr4bJgvqTjC9WGgj4%3D', 'keyissues', 2, 1);


CREATE TABLE `app_version_log` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '版本日志 ID',
  `version` CHAR(100) NOT NULL COMMENT '版本号',
  `version_type` ENUM('latest','history','beta') NOT NULL DEFAULT 'history' COMMENT '版本类型: latest=最新版, history=历史版, beta=测试版',
  `description` TEXT DEFAULT NULL COMMENT '版本描述',
  `release_date` DATETIME NOT NULL COMMENT '发布日期',
  `changelog_url` TEXT COMMENT '更新日志文档 URL',
  `is_active` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '是否激活: 1=激活, 0=不激活',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_version` (`version`),
  KEY `idx_version_type_active` (`version_type`, `is_active`),
  KEY `idx_release_date` (`release_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='应用版本日志表, 记录应用的版本更新信息';

INSERT INTO `app_version_log` (`version`, `version_type`, `description`, `release_date`, `changelog_url`, `is_active`) VALUES
('2.4.0', 'latest', '优化了后台管理界面，提升了系统稳定性。', '2025-03-22 11:45:00', 'https://example.com/changelog/2.4.0', 1),
('2.3.0', 'history', '支持了新的数据格式，并增加了自定义设置选项。', '2025-03-20 10:10:00', 'https://example.com/changelog/2.3.0', 1),
('2.2.0', 'history', '改进了报表生成速度，并增强了安全性。', '2025-03-18 18:30:00', 'https://example.com/changelog/2.2.0', 1),
('2.1.0', 'history', '新增了数据导入功能，用户界面更加友好。', '2025-03-15 16:00:00', 'https://example.com/changelog/2.1.0', 1),
('2.0.0', 'history', '重大版本更新，重构了系统架构，并加入了新的API接口。', '2025-03-12 15:45:00', 'https://example.com/changelog/2.0.0', 1),
('1.4.0', 'history', '改进了文件上传速度，修复了部分BUG。', '2025-03-10 12:15:00', 'https://example.com/changelog/1.4.0', 1),
('1.3.0', 'history', '增加了多语言支持，改进了数据同步功能。', '2025-03-08 09:30:00', 'https://example.com/changelog/1.3.0', 1),
('1.2.0', 'history', '新增了用户反馈功能，并对界面进行了调整。', '2025-03-05 14:00:00', 'https://example.com/changelog/1.2.0', 1),
('1.1.0', 'history', '修复了若干已知问题，优化了性能。', '2025-03-01 10:00:00', 'https://example.com/changelog/1.1.0', 1),
('1.0.0', 'history', '首次发布版本，包含基础功能和界面设计。', '2025-02-28 09:00:00', 'https://example.com/changelog/1.0.0', 1),
('0.9.0', 'beta', '测试版，新增了初步的用户注册功能。', '2025-02-20 14:00:00', 'https://example.com/changelog/0.9.0', 1),
('0.8.0', 'beta', '测试版，完善了登录功能并修复了小部分BUG。', '2025-02-10 17:00:00', 'https://example.com/changelog/0.8.0', 1),
('0.7.0', 'beta', '测试版，增加了数据备份功能。', '2025-02-05 19:30:00', 'https://example.com/changelog/0.7.0', 1),
('0.6.0', 'beta', '测试版，优化了应用启动速度。', '2025-01-30 16:45:00', 'https://example.com/changelog/0.6.0', 1),
('0.5.0', 'beta', '测试版，修复了应用崩溃问题。', '2025-01-25 11:00:00', 'https://example.com/changelog/0.5.0', 1),
('0.4.0', 'beta', '测试版，改进了文件管理模块。', '2025-01-20 14:15:00', 'https://example.com/changelog/0.4.0', 1),
('0.3.0', 'beta', '测试版，增强了系统稳定性，修复了多个小问题。', '2025-01-15 10:30:00', 'https://example.com/changelog/0.3.0', 1),
('0.2.0', 'beta', '测试版，增加了初步的用户界面。', '2025-01-10 13:45:00', 'https://example.com/changelog/0.2.0', 1),
('0.1.0', 'beta', '测试版，进行了初步的功能设计。', '2025-01-05 09:00:00', 'https://example.com/changelog/0.1.0', 1);



CREATE TABLE `app_download` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '下载链接 ID',
  `version_id` INT UNSIGNED NOT NULL COMMENT '关联的版本日志 ID',
  
	`installer_url` TEXT DEFAULT NULL COMMENT '安装程序 (EXE/DMG) 下载链接',
  `zip_package_url` TEXT DEFAULT NULL COMMENT '完整安装包 (ZIP/TAR) 下载链接',
  `incremental_package_url` TEXT DEFAULT NULL COMMENT '增量更新包下载链接',
	
	-- 下载文件大小（字节）
  `installer_size` FLOAT UNSIGNED DEFAULT NULL COMMENT '安装包大小（MB）',
  `zip_package_size` FLOAT UNSIGNED DEFAULT NULL COMMENT '完整压缩包大小（MB）',
  `incremental_package_size` FLOAT UNSIGNED DEFAULT NULL COMMENT '增量更新包大小（MB）',
	
	`installer_hash` CHAR(64) DEFAULT NULL COMMENT '安装包 SHA-256 哈希值',
  `zip_package_hash` CHAR(64) DEFAULT NULL COMMENT '完整安装包 SHA-256 哈希值',
  `incremental_package_hash` CHAR(64) DEFAULT NULL COMMENT '增量更新包 SHA-256 哈希值',
	
  `is_active` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '是否启用: 1=启用, 0=禁用',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_version_id` (`version_id`),
  KEY `idx_is_active` (`is_active`),
  CONSTRAINT `fk_download_version_id` FOREIGN KEY (`version_id`) REFERENCES `app_version_log` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='应用下载链接表, 存储不同版本的下载地址';

INSERT INTO `app_download` 
  (`version_id`, `installer_url`, `zip_package_url`, `incremental_package_url`, `installer_size`, `zip_package_size`, `incremental_package_size`, `installer_hash`, `zip_package_hash`, `incremental_package_hash`, `is_active`) 
VALUES 
  (1, 'https://example.com/download/app_v1_installer.exe', 'https://example.com/download/app_v1_full.zip', 'https://example.com/download/app_v1_incremental.zip', 120.5, 50.3, 10.2, 'd4a56e2d0f3b1d7e25c1baf6e7248d2f5b4be5b7d2a69f61b7e8f1f0e5d06c16', 'a83e51a1b68c70656b5c0ff7b0f50ea2155a5c7d3f22b4ef9d9e1f16b2719d80', '1c3b684afc45acb2f272742fd93c92b8ed8e0db9c52db81fc31cb14c07f8a6fa', 1),
  (2, 'https://example.com/download/app_v2_installer.exe', 'https://example.com/download/app_v2_full.zip', 'https://example.com/download/app_v2_incremental.zip', 130.7, 55.1, 12.5, 'ea7df9c0c2d6ef37b1d45ac01e463ce55e7faed47bfa1d9d77d1ac05e64e3fe2', '9d5db9c945b35bb54d50cc4e2645756a1818b2b010fa3540d627ff9b2be0b5f3', '4d3fcb62759846267b6b233926b7b54b2e29a8c97005c91cf17fe15375b2747', 1),
  (3, 'https://example.com/download/app_v3_installer.exe', 'https://example.com/download/app_v3_full.zip', 'https://example.com/download/app_v3_incremental.zip', 140.8, 60.0, 15.3, 'adf4238d2f83c31f0a4e2f5822b34a41d7ff8fc0fa9735c81346db5c9b5cf9a1', 'a59a2d5436b1b5a41e6a20610be3457b76780a4c9dbb481c85e469755317ad3', 'b0b9ad509a317b6aeb88d8d7755d678a8559a97f7a206222d03d8b9a6d974d9a', 1),
  (4, 'https://example.com/download/app_v4_installer.exe', 'https://example.com/download/app_v4_full.zip', 'https://example.com/download/app_v4_incremental.zip', 150.3, 65.4, 18.2, 'd9a94e9a99c2da3e78f43b50ff914cc4d8407996d5a118ae51fe687bc7cc292', 'fe77f2d0c38e83b75b33f9456ff231d7892df50f36c0d05961c62c8b74c9c7a5', 'ac682750bfb1c5cbb24032c66d25539561b38d9b6a0de1c52281a019730c3421', 1),
  (5, 'https://example.com/download/app_v5_installer.exe', 'https://example.com/download/app_v5_full.zip', 'https://example.com/download/app_v5_incremental.zip', 125.1, 53.6, 11.0, '3f1bd7c9ef35de8d5f4bbec7086b3be8e6d6a2452e5b974b3f8bdb8e292ad9e5', '78bb6ff848bdb93a32cfd3640ac6572923a2046b74dbcf81db5a8b3062f3c3c5', '8cd853734216ed8426c929a2d0a67ea79d62f39f66e1893ac1cd881c66062e75', 1),
  (6, 'https://example.com/download/app_v6_installer.exe', 'https://example.com/download/app_v6_full.zip', 'https://example.com/download/app_v6_incremental.zip', 135.6, 58.3, 13.9, '9a9cbf476e5376b1ab9f72b06a857e05cb96fd446a845712e8d8c04a6d6f0902', '42ef25558ab4a7c58534b684b39c2ac4cf7689b47f56b7854420f22f682d07e6', '66df9b1f1ff6b1be0e27956cc7c14c5d8d89c682b0214314b9f05db0d548d045', 1),
  (7, 'https://example.com/download/app_v7_installer.exe', 'https://example.com/download/app_v7_full.zip', 'https://example.com/download/app_v7_incremental.zip', 145.9, 62.4, 16.7, 'b9d567e0e616990d54e6598f1b69557053ecb6a7c5c68c8c97a872b28501f8ae', '23969fdbb0f5c1e8c478df53907437acb8d3925422839f3b5d813ea95ccf086b', '558f28fa6095d6a64a405945b52b455eb72cd12a0d360f0a650d9b39e3dce6b5', 1),
  (8, 'https://example.com/download/app_v8_installer.exe', 'https://example.com/download/app_v8_full.zip', 'https://example.com/download/app_v8_incremental.zip', 155.4, 67.5, 19.1, '299283bd74f65c9b7848a8a7224a8b560d4bb430ad9285c9455a4f6d39bb536', 'aba9e6f5a98c925d4b3287757455a157a271a49c6f0c9c1f35d82fffbff383b9', 'dde4f77b70d2490734f105fd861d389a26e76e6d08eb08b4a3d6b53616b7864f', 1),
  (9, 'https://example.com/download/app_v9_installer.exe', 'https://example.com/download/app_v9_full.zip', 'https://example.com/download/app_v9_incremental.zip', 160.3, 70.1, 21.4, 'b843cc309ee2edc51e4f849b8db31d0e387ac195939c3e4898bb7d4e2ca23d87', '6f46b0f8c8f665c89decd970f5cd0f3d7171d389f00c54a69e36e64ad2d487e2', 'e570087ac676a3f4600b93d67d00d9c1e073bfa803cb6070536c63d73d8f0285', 1),
  (10, 'https://example.com/download/app_v10_installer.exe', 'https://example.com/download/app_v10_full.zip', 'https://example.com/download/app_v10_incremental.zip', 170.2, 73.2, 22.8, '7398e495ed31786b079d5c5ad3c9069e5cc0f9a71368b539e983f87fd6ed004', '3c19828a416ba5a9b5a2bb287fba1ab96a7ff34b907e0b57e65c299d7d38a1a0', '2f8b87457d4f4e6f04fbc72a99a7c5362f12c4209c23d5dca607e4f4d6fe5d4c', 1),
  (11, 'https://example.com/download/app_v11_installer.exe', 'https://example.com/download/app_v11_full.zip', 'https://example.com/download/app_v11_incremental.zip', 180.1, 75.0, 24.5, '6b3c29a7b08f5f6b240f7a947fe87c034efb7b2b84a15a8dff9ca35c1d54f345', '885fb34ea290ba4d92b23828b7c4b2dbb7e8ea8ca9f2d09e96a0156184e3e432', '1f8bdbfe1ed3a63d1ac2f405ea5a3f16d8e5e5f0b292d38294c8a16077b6e640', 1),
  (12, 'https://example.com/download/app_v12_installer.exe', 'https://example.com/download/app_v12_full.zip', 'https://example.com/download/app_v12_incremental.zip', 190.7, 78.4, 26.0, '293ba0329b68ed17f63e7f1a8b4cf62c5f93fe824ad69513239f8b6391393c1', '4a951b2c097b94a8a0b7305d024bf7cfdb64d39abdc6ab78e2b128d6ea2c3158', '84cc01546a7ea0718701b7755d58bc44c52d87bb8f556f1c34a43cfdcb5f5a85', 1),
  (13, 'https://example.com/download/app_v13_installer.exe', 'https://example.com/download/app_v13_full.zip', 'https://example.com/download/app_v13_incremental.zip', 200.0, 80.1, 28.6, '8b920fc349b3fe9079fd35ab1788f7e5ff5b8b4c76c8d01c727d4c4f9a13b81d', '553a9e0f91e04f30e9c57e83338a1fe6fe7ab4707a60dff7b92329e6ae55f362', '6a9254a53829990e5b6eab464e9b4b905504fad279d6bb0b948b00c4a6db5f6c', 1),
  (14, 'https://example.com/download/app_v14_installer.exe', 'https://example.com/download/app_v14_full.zip', 'https://example.com/download/app_v14_incremental.zip', 210.3, 82.7, 30.2, '4e67f451a4b3c798f69bc38b4b4d4db9de5d07b4a9b0f89c7138bcb94601d99', 'df75d31246c7e69a7db153b28fcda1e36ab4f42e73e435b9e4330e1e5095c313', 'df7a1ed8da4a7c38a3c6f639a2b83f0c5487f67a9c685e87698754c0c6a458f7', 1),
  (15, 'https://example.com/download/app_v15_installer.exe', 'https://example.com/download/app_v15_full.zip', 'https://example.com/download/app_v15_incremental.zip', 220.1, 85.0, 32.0, 'e7bb5b0359d45a5ca548ab4895d6d3dbdbfd6bff46275817b1f6188d2c7282e', 'a16816e8e3b6b29d8c2a7349872573c63daff0e1f85a1f54291370fa0b3e3c8b', 'e4427da0f84be7269bdfed65c06ae623a75030b184c5ed9e2cc6bb439853a1ca', 1),
  (16, 'https://example.com/download/app_v16_installer.exe', 'https://example.com/download/app_v16_full.zip', 'https://example.com/download/app_v16_incremental.zip', 230.2, 87.5, 33.4, 'b9ac6f6f748e23325111d74aef0b08fa0e0d98b479d0e79f3a8b436fa3ff34a7', '94e4c443b672b0a2c0d08017b775d8b42160449b746b6d9572ba8cb9073f32bb', 'd14255b3f2b085c735d70e4db9b5d22659be0980176b5e5370889029ca8a865d', 1),
  (17, 'https://example.com/download/app_v17_installer.exe', 'https://example.com/download/app_v17_full.zip', 'https://example.com/download/app_v17_incremental.zip', 240.6, 90.0, 34.2, 'b86c7722f07cf6e82c9c9779f7674b5b7b0c276be376ef9579c0a48f823438e2', '58280e5032d9756188e8835ca51035d228ee2b2ec24915f71a215f8108e4f4f8', '2e156cf774ed5998e5f9bcd28e604307ab27a433df6b42d57c285f68bc60ca7c', 1),
  (18, 'https://example.com/download/app_v18_installer.exe', 'https://example.com/download/app_v18_full.zip', 'https://example.com/download/app_v18_incremental.zip', 250.3, 92.1, 35.9, 'e557aad9439e3d628b10f3429e8b3d9eaad1c31359a5e1ae56c32da17e1c3c57', '4e2f8037c2a7b0f78ef9e1b4a256f4c2c62d5bff3782e72e528d5c4a43b122cd', '5efb3e6c51e845545fdafca0cdbf8654599f86b31b0c7ac544acb349b64873e7', 1),
  (19, 'https://example.com/download/app_v19_installer.exe', 'https://example.com/download/app_v19_full.zip', 'https://example.com/download/app_v19_incremental.zip', 260.0, 94.2, 37.0, 'ded801e62d8693bcb56e9e6bc6d66e3efb218a5e3ff68c517f322b54a35a1b08', 'f9ef9d1b03e02a24f4a89762e6b31c4133644d32c313ca92b72dfe72a3a6e9c4', '9c98a325c0cdbce47a1d0502bfe706fa219fa7e3d9ff8b3ab7f41dce5087e709', 1);


CREATE TABLE `app_metadata` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '应用元数据 ID',
  `version_id` INT UNSIGNED NOT NULL COMMENT '关联的版本日志 ID',
  `download_id` INT UNSIGNED NOT NULL COMMENT '关联的下载链接 ID',
  `app_signature` TEXT DEFAULT NULL COMMENT '应用签名',
  `force_update` TINYINT(1) NOT NULL DEFAULT '0' COMMENT '是否强制更新: 1=是, 0=否',
  `update_type` ENUM('incremental','full') NOT NULL DEFAULT 'full' COMMENT '更新类型: incremental=增量更新, full=完整更新',
  `released_by` VARCHAR(255) DEFAULT NULL COMMENT '发布人',
  `compatibility` VARCHAR(255) DEFAULT NULL COMMENT '兼容性信息',
  `copyright_info` VARCHAR(255) DEFAULT NULL COMMENT '版权信息',
  `is_active` TINYINT(1) NOT NULL DEFAULT '1' COMMENT '是否启用: 1=启用, 0=禁用',
  `created_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `idx_version_download` (`version_id`, `download_id`),
  KEY `idx_is_active_update_type` (`is_active`, `update_type`),
  KEY `idx_force_update` (`force_update`),
  CONSTRAINT `fk_metadata_version_id` FOREIGN KEY (`version_id`) REFERENCES `app_version_log` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_metadata_download_id` FOREIGN KEY (`download_id`) REFERENCES `app_download` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='应用元数据表, 存储版本更新的额外信息, 用于校验和更新机制';

INSERT INTO `app_metadata` 
  (`version_id`, `download_id`, `app_signature`, `force_update`, `update_type`, `released_by`, `compatibility`, `copyright_info`, `is_active`) 
VALUES 
  (1, 1, 'd0f1g2h3i4j5k6l7m8n9o0p1q2r3s4t5u6v7w8x9y0a1b2c3d4e5f6g7h8', 1, 'full', 'Aoyu', 'Windows 10 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (2, 2, 'a0b1c2d3e4f5g6h7i8j9k0l1m2n3o4p5q6r7s8t9u0v1w2x3y4z5a6b7c8', 0, 'incremental', 'Aoyu', 'Windows 7 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (3, 3, 'b0c1d2e3f4g5h6i7j8k9l0m1n2o3p4q5r6s7t8u9v0w1x2y3z5a6b7c8', 1, 'full', 'Aoyu', 'macOS 10.14 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (4, 4, 'c0d1e2f3g4h5i6j7k8l9m0n1o2p3q4r5s6t7u8v9w0x1y2z4a5b6c7d8', 0, 'incremental', 'Aoyu', 'Linux (Ubuntu 20.04 or higher)', '© 2025 Aoyu. All rights reserved.', 1),
  (5, 5, 'd0e1f2g3h4i5j6k7l8m9n0o1p2q3r4s5s6t7u8v9w0x1y2z5a6b7c8d9', 1, 'full', 'Aoyu', 'Windows 8.1 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (6, 6, 'e0f1g2h3i4j5k6l7m8n9o0p1q2r3s4t5u6v7w8x9y0a1b2c3f4g5h6i7', 1, 'full', 'Aoyu', 'macOS 10.15 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (7, 7, 'f0g1h2i3j4k5l6m7n8o9p0q1r2s3t4u5v6w7x8y9z0a1b2c3d4e5f7g8', 0, 'incremental', 'Aoyu', 'Windows 10 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (8, 8, 'g0h1i2j3k4l5m6n7o8p9q0r1s2t3u4v5w6x7y8z9a1b2c3d4f5g6h9i0', 1, 'full', 'Aoyu', 'Linux (Ubuntu 18.04 or higher)', '© 2025 Aoyu. All rights reserved.', 1),
  (9, 9, 'h0i1j2k3l4m5n6o7p8q9r0s1t2u3v4w5x6y7z8a9b0c1d2e4f5g7h6i2', 0, 'incremental', 'Aoyu', 'macOS 10.13 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (10, 10, 'i0j1k2l3m4n5o6p7q8r9s0t1u2v3w4x5y6z7a8b9c0d1e3f4g5h7i9k0', 1, 'full', 'Aoyu', 'Windows 7 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (11, 11, 'j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6a7b8c9d0e1f2g3h4i5j6k0', 0, 'incremental', 'Aoyu', 'macOS 10.12 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (12, 12, 'k0l1m2n3o4p5q6r7s8t9u0v1w2x3y4z5a6b7c8d9e0f1g2h3i4j5k6l1', 1, 'full', 'Aoyu', 'Windows 10 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (13, 13, 'l0m1n2o3p4q5r6s7t8u9v0w1x2y3z4a5b6c7d8e9f0g1h2i3j4k5l9m0', 1, 'full', 'Aoyu', 'Linux (Debian 10 or higher)', '© 2025 Aoyu. All rights reserved.', 1),
  (14, 14, 'm0n1o2p3q4r5s6t7u8v9w0x1y2z3a4b5c6d7e8f9g0h1i2j3k4l5m6n8', 0, 'incremental', 'Aoyu', 'macOS 10.14 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (15, 15, 'n0o1p2q3r4s5t6u7v8w9x0y1z2a3b4c5d6e7f8g9h0i1j2k3l4m7o0n9', 1, 'full', 'Aoyu', 'Windows 8 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (16, 16, 'o0p1q2r3s4t5u6v7w8x9y0z1a2b3c4d5e6f7g8h9i0j1k2l3m4n5p8o0', 0, 'incremental', 'Aoyu', 'Windows 10 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (17, 17, 'p0q1r2s3t4u5v6w7x8y9z0a1b2c3d4e5f6g7h8i9j0k1l2m3n4o6p9q0', 1, 'full', 'Aoyu', 'macOS 10.13 or higher', '© 2025 Aoyu. All rights reserved.', 1),
  (18, 18, 'q0r1s2t3u4v5w6x7y8z9a0b1c2d3e4f5g6h7i8j9k0l1m2n3o4p5q0r1', 0, 'incremental', 'Aoyu', 'Linux (Ubuntu 18.04 or higher)', '© 2025 Aoyu. All rights reserved.', 1),
  (19, 19, 'r0s1t2u3v4w5x6y7z8a9b0c1d2e3f4g5h6i7j8k9l0m1n2o3p4q5s1t0', 1, 'full', 'Aoyu', 'Windows 7 or higher', '© 2025 Aoyu. All rights reserved.', 1);
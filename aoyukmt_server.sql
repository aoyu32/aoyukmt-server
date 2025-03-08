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


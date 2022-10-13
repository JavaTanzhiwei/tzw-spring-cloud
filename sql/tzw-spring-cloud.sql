/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50734
 Source Host           : 127.0.0.1:3306
 Source Schema         : tzw-spring-cloud

 Target Server Type    : MySQL
 Target Server Version : 50734
 File Encoding         : 65001

 Date: 13/10/2022 17:31:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_config
-- ----------------------------
DROP TABLE IF EXISTS `sys_config`;
CREATE TABLE `sys_config`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '参数主键',
  `config_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '参数名称',
  `config_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '参数键名',
  `config_value` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '参数键值',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '参数配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_config
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门id',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '父部门id',
  `ancestors` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '祖级列表',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '部门名称',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `leader` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '邮箱',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '部门状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_data
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_data`;
CREATE TABLE `sys_dict_data`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典编码',
  `dict_sort` int(4) NULL DEFAULT 0 COMMENT '字典排序',
  `dict_label` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典标签',
  `dict_value` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典键值',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典类型',
  `is_default` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'N' COMMENT '是否默认（Y是 N否）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_data
-- ----------------------------

-- ----------------------------
-- Table structure for sys_dict_type
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_type`;
CREATE TABLE `sys_dict_type`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '字典主键',
  `dict_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典名称',
  `dict_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '字典类型',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '状态（0正常 1停用）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `dict_type`(`dict_type`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '字典类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_type
-- ----------------------------

-- ----------------------------
-- Table structure for sys_job
-- ----------------------------
DROP TABLE IF EXISTS `sys_job`;
CREATE TABLE `sys_job`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '任务ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'DEFAULT' COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '调用目标字符串',
  `cron_expression` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '3' COMMENT '计划执行错误策略（1立即执行 2执行一次 3放弃执行）',
  `concurrent` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '1' COMMENT '是否并发执行（0允许 1禁止）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `next_valid_time` datetime(0) NULL DEFAULT NULL COMMENT '下次执行时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`id`, `job_name`, `job_group`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '定时任务调度表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job
-- ----------------------------
INSERT INTO `sys_job` VALUES ('1', 'Id-Token，定时刷新', 'DEFAULT', 'tzwTask.refreshToken', '* * 0/2 * * ?', '1', '1', '0', NULL, 'admin', '2022-10-08 10:49:44', '', NULL, '');

-- ----------------------------
-- Table structure for sys_job_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_job_log`;
CREATE TABLE `sys_job_log`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '任务日志ID',
  `job_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '任务名称',
  `job_group` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '任务组名',
  `invoke_target` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '调用目标字符串',
  `job_message` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '日志信息',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '异常信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '定时任务调度日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_job_log
-- ----------------------------
INSERT INTO `sys_job_log` VALUES ('08329abd94739be6207cce33585d6095', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：14毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('0bafa6718a23ff0a817387f9515b9596', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('0ca8d03a0ea1737134469f217af5d532', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：13毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('0ee740834e0921c029468d91c926b9b1', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('0f2d0ba6f33bd98864bfc1eeb38f8b0e', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：12毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('0fdbc5c1c2fc273bb9aff78fe88e4096', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：11毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('10beecbd686e34c6e39addf15bcd669d', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：4毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('17203c6914ea4ddafc156195f8d7311d', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：13毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('17c047d4235458d1f99a4f93454effb2', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：4毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('18ce13b65b4cdc01c573f6a18edd745b', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('1ac9f7710d6205240b03ec475c3cb059', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('22d523cf6ea1cb3893c4be2e574548e7', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('23328e4e4135f2815397f1df1e8b947c', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：4毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('242a8630b77767bd9b945333f898dc26', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：1015毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('2669b0dfc1368a63c00969e4eed64548', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：11毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('27c5ca9c2ca81a3cb221cee88cde57e6', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：22毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('28c8626bff50247cf8d452e46b3ff313', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('2bbd5d36ebb3a9ff81824b2ff17dc7cf', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：12毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('30deaa0f786b1ac66eaa1c908a120d80', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('312a903f71af949f1b19099442883625', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：12毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('33bc939ea7dd301e88390dc01afb1569', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：15毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('347663a98d68d55afbb132c8e96626ee', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：11毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('39314a0de9c1c96355bf07f5af615003', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('3942318717d8a513e5bcca5801fcbd4a', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：11毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('3c45d65cbd1f80746bdb71098bdf3082', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：4毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('3da0a3922a5ecd5d751700f67d9f1502', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：1141毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('42e0fb8cabc9baf6c987c2e8a24336ed', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：26毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('443fbed92dcf34bc39771a2d209ab4a8', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：18毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('446f431c421367612918ed8cb27b8727', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('4604ffceb8178eb505e2ab224eb53764', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：1019毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('460507051c593e3eada4baac65939291', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：4毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('4b92d7acd59e274d53b9514c3d9e6e59', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('4b94e5cf9829b2be527d6f8a1ccdd7cc', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：7毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('4e8f6d7c133e0a34020880633b2e85a1', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：12毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('52bd51bd935f3719102e280b746e85ba', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：5毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('5a4c5289b096faf47c0d6dfd5244723e', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('5a77db833d83b341625c0d6a9ce4df07', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：4毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('5df42a49faffbe01c79d2c50ec03326b', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('5ee52f359b4fef2dfb4bbedc095f4e97', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：12毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('6448c34c9bb253671fafcd30f46b012d', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：13毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('65e85f100ef0b9ffaf50ff6b774c82d5', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：4毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('694c2f2dfd776bd617fe8cbe03cfc565', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：2076毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('6ce342e148c2eea7959ac96e0c8c0c6a', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('70db41432a025ce7edaad47574032f53', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：21毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('7429304f1368e24c3e6879fbecdedc6f', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('74cd9c0f3e121d164db1138bbe9bfa93', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：19毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('754205e920d9c6acd7f1a96bc5d0b69e', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：6毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('75d8f9eb56c18b6eff03c7cb886e3b3f', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：26毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('7645c821d718e820b4b4d5e951881911', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：23毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('76ed1aa41bb5e64f1d10f32d63d1e46f', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('781a7a85373215ed166448d546cb3b68', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('832153ca11bfed82576a6d9250a2e2bd', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：11毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('835b5183ba2a8de169e764cf36ad38c4', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('86493b4459384c70e895ca831a0aff3d', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：16毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('8c520ec345fe0585bc6e43d5c572848e', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('8c82655f12fc723214cf313e1d69da2b', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：7毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('8dec7306bbbcbdb1a780b71c3072019e', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：29毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('8e2f2cf7409bd53a5ac17ac42407d041', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：822毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('915bd32757c862cec93009bea6dd0b82', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：11毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('9b1eddecf400025661510f0f7aca3426', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：20毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('9ed0772e22522fda200b686666e00542', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('a37e329a3dd813896ee4f449b6bcb9d5', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：5毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('a4bad125300d420223c99815164c0a9d', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：1066毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('a5699bdd434511d4c22887c994b2cb8b', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：4毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('a6d9db3d160730b0d595363036eb7449', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：5毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('aa049f00ad34f02d61711007427fb6ad', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：13毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('aac5a635b348ae47924b22c5ae95ffe3', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ac54b8a4ba30fd01e197ecb9c700ae66', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：3毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ad7cfa92c66f35fc9ea21502f56a4e5e', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：26毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('addf27c75b9e9c1a803faa1f841047f7', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('aecd3f72d33eee9ddad8e11e034c71cb', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('aef9aa0bc7968f761093cc30c29510e0', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('af56f8b6e5f4a1a5f0a1497dec1017cc', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('af9c71822fac570c91b1c9241623c7e8', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('b03de615eb7957cd841a3732dddf4ce9', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('b35befe9a710d996106c8691c7e7f38c', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('b42adb8922533b9a6b79e4e7659deacf', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('b747998246392d73f317e646b736a5f9', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：3毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('b8919d758b16b7010ebcd83e059995ac', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：17毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('bda1c1e9d27511c8e5bb8adb274eaa9e', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('bfaee121f69db2c7e140111506c347c4', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：12毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('c2b1c0ae688bdb34237ae25247f12d97', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：12毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('c5be06f18ba8bab32f50b883c882fc4b', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：13毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('c8c78abfc00860ae5f895b8b55a5381b', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ca18b2a3f87651313162981176c10577', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：14毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ca8278f34c7068b6367d28b58c2453b6', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：7毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('cc853aecc447ab4dbd99b9eeec483503', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：17毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ce664a8ea50e28ef28b6dd96d2899f37', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：355毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('d04033735cd16e149a6b007fb2e7e43d', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：18毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('d0d78f9993c2c46ac340c5ed1f5e8d8c', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('d1a15af092de6584d3e1c559c1247d83', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：11毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('d244d02cd0b5ed5f34c65c0f247085eb', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：15毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('d52882453b2ebb3a87e66a3bffa7c602', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('d834c7a11b2095a58cf3f91aeb35b03e', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：6毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('d9b2f72630d2d2b649bb4c24be2c1a99', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：6毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('da9c3d58716b5cb188bd568ad9fac274', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('db38e4fc0767225f5cbd327dd6723d98', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：7毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('dd01cdb5a8894cb34620b0b7a64f3a45', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：16毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('de96c2c3b818c3612cdfb70b5f217a19', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：287毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ded6f1f6b9b3f88763d1a3231aa8dc6c', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：635毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('e021740ad91a4bf05d0f4beb9686cc4a', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：23毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('e02963a9c7a72132e7b71e509b5238bf', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('e147f7f520d01759151f5a2e2ed4c253', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：12毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('e34cd41377f2784f23a31136e14a00a9', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('e49e2923cb2ac6a9212905679129aabe', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('e76b389532bdce09bfcdf33e08b6cc32', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：13毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('e80537c576af36562460bff581c8d24b', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：22毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('e9eddc895c46a1b8b8bd1279e54990c2', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：6毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ea9b86cb1a59f9e6284eee836c5b38a7', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：24毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('eb6d02fc4667032d615a04198901add3', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：5毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ec7d5eecee49c75b1af9411dd21a2572', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('eced0210333f02edc38d7beb17a55675', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：14毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('f09464388b430054e0537605502db930', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('f40f3d9065634beff3632fedf645d900', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：400毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('f4aeeda055549378aee2b29165de4e68', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：29毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('fa55bf2dc5c32f2684cd58ca8ac51034', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：8毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('faaf9fd8ab5e629ea8089bc88b724b04', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：9毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('fb40e6691c144ef784092f4b225e2f26', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：13毫秒', '0', '', NULL);
INSERT INTO `sys_job_log` VALUES ('ffd697e53408f49dce35d8b4235eac1f', '定时读取用户信息', 'DEFAULT', 'tzwTask.getUserInfo', '定时读取用户信息 总共耗时：10毫秒', '0', '', NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单名称',
  `parent_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '父菜单ID',
  `order_num` int(4) NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '组件路径',
  `query` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '路由参数',
  `is_frame` int(1) NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `is_cache` int(1) NULL DEFAULT 0 COMMENT '是否缓存（0缓存 1不缓存）',
  `menu_type` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_oper_log_login
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log_login`;
CREATE TABLE `sys_oper_log_login`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '登录日志主键',
  `login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录账号',
  `ipaddr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录IP地址',
  `login_location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '登录地点',
  `browser` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '浏览器类型',
  `os` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '操作系统',
  `status` int(10) NULL DEFAULT 0 COMMENT '登录状态（0成功 1失败）',
  `msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '提示消息',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '系统访问记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log_login
-- ----------------------------
INSERT INTO `sys_oper_log_login` VALUES ('0438bda8b2340100fe3c39c85b71ef0d', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:20:11');
INSERT INTO `sys_oper_log_login` VALUES ('052f3f369321abb2cce0484f10801600', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:45');
INSERT INTO `sys_oper_log_login` VALUES ('058f9ae4acea7b421234ba5a2e1d324a', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:42:33');
INSERT INTO `sys_oper_log_login` VALUES ('061f05f993cc852b9328f040ee153a94', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:05:07');
INSERT INTO `sys_oper_log_login` VALUES ('0622c686462e315788d3fff45e85441a', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:42');
INSERT INTO `sys_oper_log_login` VALUES ('0ea48e811deaf2f3b4249202fa0526fb', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:05:50');
INSERT INTO `sys_oper_log_login` VALUES ('0eea35dcaca106b92189e9079c2e1f78', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:19:21');
INSERT INTO `sys_oper_log_login` VALUES ('0f77d72c0df2cb6d0314b6c565ebea62', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:06:20');
INSERT INTO `sys_oper_log_login` VALUES ('108368a9b0004c0a456d5b4a040f8762', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-10 17:50:35');
INSERT INTO `sys_oper_log_login` VALUES ('12b1129dd841e88f49ab72235421b65a', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:50');
INSERT INTO `sys_oper_log_login` VALUES ('1521132a396f9f0c6ae213d4d6c2e1d4', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:41:07');
INSERT INTO `sys_oper_log_login` VALUES ('156e4e207a8008f9f5fe40964ae7f21b', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:56');
INSERT INTO `sys_oper_log_login` VALUES ('163268e71dd0bbe2ee307c6b5b78ea99', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-08 16:46:22');
INSERT INTO `sys_oper_log_login` VALUES ('16526bb0a433db0c1877fe6d8d02ca09', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 17:39:00');
INSERT INTO `sys_oper_log_login` VALUES ('166a1571bb8bafa8151f6e17a8aa0284', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '退出成功', '2022-10-09 17:41:19');
INSERT INTO `sys_oper_log_login` VALUES ('1a8fb298065eeadfe3159ad40db06a3e', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '退出成功', '2022-10-09 17:41:48');
INSERT INTO `sys_oper_log_login` VALUES ('1af2e768bf0b61ff65a562835e06fba3', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:56:29');
INSERT INTO `sys_oper_log_login` VALUES ('1c4a317117f556ce6469d7454876659f', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:03:53');
INSERT INTO `sys_oper_log_login` VALUES ('1dc39c9ee68b9a9571a5376dc18c62ee', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:21:55');
INSERT INTO `sys_oper_log_login` VALUES ('21822061b3973d8b8c1dc6638a6e02cd', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:19:19');
INSERT INTO `sys_oper_log_login` VALUES ('2311721e33883a8dabca35bf3d18e8dd', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:07:42');
INSERT INTO `sys_oper_log_login` VALUES ('2348676efd60839a7e46666d5abb25a0', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:03:46');
INSERT INTO `sys_oper_log_login` VALUES ('23c173e14d4aac905042839a92c49019', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:45:48');
INSERT INTO `sys_oper_log_login` VALUES ('26ba8ae013bde377a6b01ea486ecddb7', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:07:17');
INSERT INTO `sys_oper_log_login` VALUES ('275a1f1a46254424e58d83fce25b4945', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:45:17');
INSERT INTO `sys_oper_log_login` VALUES ('285a80be5e85eb88adb44d0a05ec095d', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:28:27');
INSERT INTO `sys_oper_log_login` VALUES ('2920751e7128a958d13cd1643aa22599', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:46');
INSERT INTO `sys_oper_log_login` VALUES ('29eacb9dc264036c9aaeafefe7324ebe', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:19');
INSERT INTO `sys_oper_log_login` VALUES ('2c4f78326c0a4554c48e1b80992fdf90', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:01:37');
INSERT INTO `sys_oper_log_login` VALUES ('2cf2e662c345ea0d7714f825f4f17341', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 16:03:38');
INSERT INTO `sys_oper_log_login` VALUES ('2e244c17a3ce29e5402a64515b627597', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:43');
INSERT INTO `sys_oper_log_login` VALUES ('36be4a32e5a2442d709e0aaa8720b6ff', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-11 09:48:47');
INSERT INTO `sys_oper_log_login` VALUES ('37617f4576a00f8494d7c1c4f098fef6', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-04 23:26:08');
INSERT INTO `sys_oper_log_login` VALUES ('3b31c8a946167c141bd8b1749ce5daa1', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:51');
INSERT INTO `sys_oper_log_login` VALUES ('3d4d9b16d59ff767e516c1c653bc7199', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:45:03');
INSERT INTO `sys_oper_log_login` VALUES ('3d54f8cb6dbff000e0af735fac4cf64a', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:45');
INSERT INTO `sys_oper_log_login` VALUES ('3f40737ddd26ea3065d7fb0b2476831b', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:26');
INSERT INTO `sys_oper_log_login` VALUES ('4023d18004991ac3130804ebb7d03f4d', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:45:37');
INSERT INTO `sys_oper_log_login` VALUES ('46a71be2af95fcfbb8180074a9d4c330', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:04:30');
INSERT INTO `sys_oper_log_login` VALUES ('4832d11173c689a12723ff589e2232ad', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:27:06');
INSERT INTO `sys_oper_log_login` VALUES ('48d2c7d6676b21460cea68eaacd7f93b', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:45');
INSERT INTO `sys_oper_log_login` VALUES ('49b725b9e7c35d7918f8346e5c4340a5', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-04 22:46:00');
INSERT INTO `sys_oper_log_login` VALUES ('4af95bb4285276863e52ad6ba3a3f260', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 17:41:20');
INSERT INTO `sys_oper_log_login` VALUES ('4cd5434731472b00542ca11514b63551', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:47');
INSERT INTO `sys_oper_log_login` VALUES ('4f1a9d87d33db7c0b58e9445538d69b3', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:41:49');
INSERT INTO `sys_oper_log_login` VALUES ('510c7b56d59542b6a21f87e3b0708eab', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 17:36:49');
INSERT INTO `sys_oper_log_login` VALUES ('51f587ec6157202568c5ebebf6cd77ad', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:07:26');
INSERT INTO `sys_oper_log_login` VALUES ('5200fc20460fe8165335f6962fa00c7f', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:06:54');
INSERT INTO `sys_oper_log_login` VALUES ('564994802f96d35ce811ae01bda1c444', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:14');
INSERT INTO `sys_oper_log_login` VALUES ('5743f0ede16a8712250abebd629a1a7d', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:28:25');
INSERT INTO `sys_oper_log_login` VALUES ('5a069d14b77f80e98357991a7544e885', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:19:22');
INSERT INTO `sys_oper_log_login` VALUES ('5adf64044eb7941f26b9bf509d2869d2', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:43:41');
INSERT INTO `sys_oper_log_login` VALUES ('5b8a099ce6bce59a05fd31099739e030', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:53:21');
INSERT INTO `sys_oper_log_login` VALUES ('5eb2d16ff6d61873f11390ec466ec9a0', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:03:08');
INSERT INTO `sys_oper_log_login` VALUES ('62c447ba499f1dbf2471915809c37036', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:53');
INSERT INTO `sys_oper_log_login` VALUES ('644246334f8236b25a9f54f07ad03dc2', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:22:05');
INSERT INTO `sys_oper_log_login` VALUES ('661820b30bcff424404858ef293ddec3', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:54');
INSERT INTO `sys_oper_log_login` VALUES ('67db49bf4e4b77bcfaa40f2db9ef6db9', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:07:14');
INSERT INTO `sys_oper_log_login` VALUES ('69b46aa8c0b6dd66a58aea960bbeba55', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:59:30');
INSERT INTO `sys_oper_log_login` VALUES ('69db925e86fc28f04cd0b6c5915305ff', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:57');
INSERT INTO `sys_oper_log_login` VALUES ('7240bff4ce6b1a2dcee72b3f9d9606ae', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:46:09');
INSERT INTO `sys_oper_log_login` VALUES ('7253157bcb9703001931917fa793b8e3', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:44');
INSERT INTO `sys_oper_log_login` VALUES ('73465ad838126a85af3130a0324bd4fe', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:47:41');
INSERT INTO `sys_oper_log_login` VALUES ('73b516b287a007cbe93ea6e522b43cd9', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:07:24');
INSERT INTO `sys_oper_log_login` VALUES ('7584f1415b13f9fa90a104b0e8ca3dc6', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:41');
INSERT INTO `sys_oper_log_login` VALUES ('75dba9eb0cb291e227d74817e7a93566', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:45:00');
INSERT INTO `sys_oper_log_login` VALUES ('791ef209c2e028b20137c5f3704d4ada', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:56');
INSERT INTO `sys_oper_log_login` VALUES ('7a3a84bd409561e66933fdcebf5fb698', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:45:49');
INSERT INTO `sys_oper_log_login` VALUES ('7b3f7fb7b23bc6df27ad957b7e9a94a6', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:44:16');
INSERT INTO `sys_oper_log_login` VALUES ('7d0d33d8294120420d7fea7b7932d549', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '退出成功', '2022-10-09 17:41:24');
INSERT INTO `sys_oper_log_login` VALUES ('7fccf7fca8bdaa3dc85f3b04a78edf7d', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:12:49');
INSERT INTO `sys_oper_log_login` VALUES ('816605886366d0ea763988a10fc10da5', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:19:20');
INSERT INTO `sys_oper_log_login` VALUES ('85abe6c5afb4039341f78d99f0fd6921', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:07:19');
INSERT INTO `sys_oper_log_login` VALUES ('85b2dedb86cefb423840b8496730f412', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 16:03:53');
INSERT INTO `sys_oper_log_login` VALUES ('8770f12d732f23cddcd47f56c19d7363', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:13');
INSERT INTO `sys_oper_log_login` VALUES ('88abfdc5aadce692fedc7dcf3af69073', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:28:26');
INSERT INTO `sys_oper_log_login` VALUES ('8a34d1718340e792c9486aaaff35128b', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 17:41:59');
INSERT INTO `sys_oper_log_login` VALUES ('8e8da88a4cc77e76efc344a0349cf222', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:42:32');
INSERT INTO `sys_oper_log_login` VALUES ('8fdae325942a6b545ffd92ae1eabc2a7', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:57');
INSERT INTO `sys_oper_log_login` VALUES ('92e01bc60f00724b232e012156e25cf2', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:03:54');
INSERT INTO `sys_oper_log_login` VALUES ('9597ecbe6a950c65d20e9bfb2382d41c', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:43');
INSERT INTO `sys_oper_log_login` VALUES ('97cdf4b06ec4080ba23312a15b864375', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:42');
INSERT INTO `sys_oper_log_login` VALUES ('a27866cfe3797b7b406cae99268101db', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:53:13');
INSERT INTO `sys_oper_log_login` VALUES ('a633b67bcadbc5c73d97f514e698abf3', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:27');
INSERT INTO `sys_oper_log_login` VALUES ('aa54d8bfefdfbccacf364842a307994b', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:12:51');
INSERT INTO `sys_oper_log_login` VALUES ('ad429168dcad3440e3aa0c8b8d2eee81', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:12');
INSERT INTO `sys_oper_log_login` VALUES ('ae52dd3c35e2d8f1df90a0efd06c51d1', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:45:55');
INSERT INTO `sys_oper_log_login` VALUES ('b6e0b3f0bf6e9b9b5b81f69869ebc09c', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:40:16');
INSERT INTO `sys_oper_log_login` VALUES ('baa3d70b7351f701a25024be5bc098d5', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 17:41:40');
INSERT INTO `sys_oper_log_login` VALUES ('bab0ea8962de87dde2b3c30ce554f888', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:43:47');
INSERT INTO `sys_oper_log_login` VALUES ('bd13e22eed65911cafab0bb9ced89f25', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:53:14');
INSERT INTO `sys_oper_log_login` VALUES ('bdf1c8a1c68188771f56884f2db15334', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:04:50');
INSERT INTO `sys_oper_log_login` VALUES ('c2aa91f79a62c32d35da9a582810dee8', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:55');
INSERT INTO `sys_oper_log_login` VALUES ('c3a8303b97969f01bb586b178ee9e635', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:44:12');
INSERT INTO `sys_oper_log_login` VALUES ('c5b82b08627c580a6dbe5fc6e44e4a7e', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:17');
INSERT INTO `sys_oper_log_login` VALUES ('c768abb23b1cfd51e3592e4c191ab4b8', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:17');
INSERT INTO `sys_oper_log_login` VALUES ('ca40e86416b0fca69ec0f811be29daf8', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-12 11:14:45');
INSERT INTO `sys_oper_log_login` VALUES ('ca8f9c40bf6073777bb8b33c5b042276', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:47');
INSERT INTO `sys_oper_log_login` VALUES ('cbd4ef1023e09890cbb5960d585c0ef6', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:07:16');
INSERT INTO `sys_oper_log_login` VALUES ('cc9049dee235fd4fddaeeefdb695a699', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:04');
INSERT INTO `sys_oper_log_login` VALUES ('cd52b66badb8e66e5b0bd45a096ce644', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:18');
INSERT INTO `sys_oper_log_login` VALUES ('d08ff238ee91e3f7dd044c531b68d043', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:47');
INSERT INTO `sys_oper_log_login` VALUES ('d0b1f920ed98030f7ae940b9f91d74e5', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:45:08');
INSERT INTO `sys_oper_log_login` VALUES ('d11491a41236444a23e10ad6cf571407', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:28:26');
INSERT INTO `sys_oper_log_login` VALUES ('d4273df50ffbaa738fc563299ca66491', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:11');
INSERT INTO `sys_oper_log_login` VALUES ('d7dc03c02aa992a636408b699fa482b2', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:19:22');
INSERT INTO `sys_oper_log_login` VALUES ('d82e7267f2b792c57f2576bd6452a607', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:14:43');
INSERT INTO `sys_oper_log_login` VALUES ('d8ad217d5202f46bdb0526cfa8c02be1', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:27');
INSERT INTO `sys_oper_log_login` VALUES ('d9d47202a1c785c81f1271153524ecd3', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 16:02:17');
INSERT INTO `sys_oper_log_login` VALUES ('d9da528dfdda3116254b621bb15b732e', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:02:44');
INSERT INTO `sys_oper_log_login` VALUES ('da4029f8f80e5739d514cb3cd5af8483', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:49');
INSERT INTO `sys_oper_log_login` VALUES ('dd8387375b74bc63832e0edf1366e7cf', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:54');
INSERT INTO `sys_oper_log_login` VALUES ('de99433233a24c118c2fcc381bcc4da2', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:57:54');
INSERT INTO `sys_oper_log_login` VALUES ('df5a6e93be08e55845685da2754f5cec', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:54');
INSERT INTO `sys_oper_log_login` VALUES ('e532c658083be98b76e79689bc95c8db', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:52');
INSERT INTO `sys_oper_log_login` VALUES ('e55b53da6e25981de0001f2d28a9aeaf', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:28:27');
INSERT INTO `sys_oper_log_login` VALUES ('e5771ac98973f1c968dbff84822797b4', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:59');
INSERT INTO `sys_oper_log_login` VALUES ('e5971dd1987ab30af142b603f32a7c90', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-11 10:46:36');
INSERT INTO `sys_oper_log_login` VALUES ('f08842459dfb7d90e81760d72061ebcc', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:18');
INSERT INTO `sys_oper_log_login` VALUES ('f29ed291f92e85dfd6ccbb981ed96997', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:53:11');
INSERT INTO `sys_oper_log_login` VALUES ('f3371474f49bbd605a3a8c9b9fbbe7db', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:19:18');
INSERT INTO `sys_oper_log_login` VALUES ('f5974cc38122c673fc086ef6faf8a395', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:53:13');
INSERT INTO `sys_oper_log_login` VALUES ('f6bf555ddae996e6ced0369a6506d690', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:15');
INSERT INTO `sys_oper_log_login` VALUES ('f6e8ab7cf5f396b072f2acb2470b0ed2', '谭志伟', '192.168.1.203', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 13:55:53');
INSERT INTO `sys_oper_log_login` VALUES ('fa6223e4138974eacde0e8fa0deba360', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:03:29');
INSERT INTO `sys_oper_log_login` VALUES ('fb014aeb0e1a401c53bdd1c56e31e796', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 14:40:24');
INSERT INTO `sys_oper_log_login` VALUES ('fee6ea74ab764ada49c528b1f1923461', '谭志伟', '127.0.0.1', '内网IP', 'Chrome', 'Windows 10 or Windows Server 2016', 200, '登录成功', '2022-10-09 15:54:41');

-- ----------------------------
-- Table structure for sys_oper_log_operation
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log_operation`;
CREATE TABLE `sys_oper_log_operation`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '日志主键',
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '模块标题',
  `business_type` int(2) NULL DEFAULT 0 COMMENT '业务类型（0其它 1新增 2修改 3删除）',
  `method` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '方法名称',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '请求方式',
  `operator_type` int(1) NULL DEFAULT 0 COMMENT '操作类别（0其它 1后台用户 2手机端用户）',
  `oper_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '操作人员',
  `dept_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '部门名称',
  `oper_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '请求URL',
  `oper_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '主机地址',
  `oper_location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '操作地点',
  `oper_param` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '请求参数',
  `status` int(1) NULL DEFAULT 0 COMMENT '操作状态（0正常 1异常）',
  `error_msg` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '错误消息',
  `oper_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '操作日志记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_oper_log_operation
-- ----------------------------
INSERT INTO `sys_oper_log_operation` VALUES ('061061cbe0146407179ba22dcf424ca1', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:51:10');
INSERT INTO `sys_oper_log_operation` VALUES ('07c11e7d561aa9fc9ccae469982622ab', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:55:22');
INSERT INTO `sys_oper_log_operation` VALUES ('0b51753580d6a200f45053e05afb29e4', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 10:46:39');
INSERT INTO `sys_oper_log_operation` VALUES ('0c2dd132f728c90ff139ce5b3de4ea77', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 11:38:57');
INSERT INTO `sys_oper_log_operation` VALUES ('14dce0411b67dd04249862992a430411', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-08 16:46:53');
INSERT INTO `sys_oper_log_operation` VALUES ('19a7a252d873d6e65f21c165aadea81c', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 10:07:33');
INSERT INTO `sys_oper_log_operation` VALUES ('1a8f4544a780ac168c891080113ca9d4', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-03 22:46:04');
INSERT INTO `sys_oper_log_operation` VALUES ('1bfbe44d98ea482ded6a7c4786da0836', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-12 11:15:33');
INSERT INTO `sys_oper_log_operation` VALUES ('2c2e52579537036df2e4a79f65a6f46a', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 10:52:22');
INSERT INTO `sys_oper_log_operation` VALUES ('315d771c91b325ca155aed7bd20054a1', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 09:57:41');
INSERT INTO `sys_oper_log_operation` VALUES ('35839db225d671481da32481290ae732', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:54:47');
INSERT INTO `sys_oper_log_operation` VALUES ('39761ee32b9d65c3820398b356400941', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '192.168.1.203', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:41:09');
INSERT INTO `sys_oper_log_operation` VALUES ('3caed7c740e8b5b8e7709d5ca2b42474', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-12 11:17:58');
INSERT INTO `sys_oper_log_operation` VALUES ('442802e77219d7697adefdb89ec2277d', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '127.0.0.1', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:39:40');
INSERT INTO `sys_oper_log_operation` VALUES ('4822ec3329ef81757ab2be2694bf507e', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 09:49:01');
INSERT INTO `sys_oper_log_operation` VALUES ('4909bfa626fda4d4ae3a2f8bc8cf58c8', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 11:10:53');
INSERT INTO `sys_oper_log_operation` VALUES ('4ae0b5b1d1fe78243ef2670d3ed91964', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:52:38');
INSERT INTO `sys_oper_log_operation` VALUES ('4b96bf0fe6ff9a9519bdabd219e07075', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 18:01:14');
INSERT INTO `sys_oper_log_operation` VALUES ('5c79f1c57aa05c81dc67a1832379725f', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:52:56');
INSERT INTO `sys_oper_log_operation` VALUES ('64667cbc129eb8d360ed831d95b1ce0b', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{\"pageSize\":10,\"pageNum\":1}]', 0, '', '2022-10-04 23:26:53');
INSERT INTO `sys_oper_log_operation` VALUES ('673cba23c1fa34f673d184d7513977c6', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '127.0.0.1', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:39:21');
INSERT INTO `sys_oper_log_operation` VALUES ('67ec3f3f7c3e16e6084b730b07721851', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{\"pageSize\":10,\"pageNum\":1}]', 0, '', '2022-10-04 22:49:26');
INSERT INTO `sys_oper_log_operation` VALUES ('6dfb04d1e7250d45700ca9779b6c2258', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 09:59:48');
INSERT INTO `sys_oper_log_operation` VALUES ('7679397d8b48fb9f4ef4f893c68bfb5f', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-03 22:54:26');
INSERT INTO `sys_oper_log_operation` VALUES ('8091925cfaa4ee670d3c570f533862dd', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '127.0.0.1', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:41:05');
INSERT INTO `sys_oper_log_operation` VALUES ('80d243ed488b88b308be431ca300af84', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 11:24:44');
INSERT INTO `sys_oper_log_operation` VALUES ('81b5503f3c8ca8487ee021780b80ac91', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '192.168.1.203', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:36:59');
INSERT INTO `sys_oper_log_operation` VALUES ('8eaed54e64e40c96c894cb2a2ef6531f', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 11:24:38');
INSERT INTO `sys_oper_log_operation` VALUES ('93eef9f068fb08229c03dda45851c9f3', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '127.0.0.1', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:40:08');
INSERT INTO `sys_oper_log_operation` VALUES ('9d6ca9def423e3b999cc8b917f1fb302', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '127.0.0.1', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:39:00');
INSERT INTO `sys_oper_log_operation` VALUES ('a54aae06b7ea3543e479c304ee2f7e44', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:54:14');
INSERT INTO `sys_oper_log_operation` VALUES ('a8b96b3b4008241b2781f010ba66cbd0', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '192.168.1.203', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:41:59');
INSERT INTO `sys_oper_log_operation` VALUES ('a9c42fe3f8404b5b799f2b303d32738e', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '192.168.1.203', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:38:19');
INSERT INTO `sys_oper_log_operation` VALUES ('aa436f400efb355f53c43fd83d3589ff', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:55:33');
INSERT INTO `sys_oper_log_operation` VALUES ('b51ed38d955ebb9e0476138b2d2c4eee', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-03 22:44:45');
INSERT INTO `sys_oper_log_operation` VALUES ('c9d14587f1ca3e0b254f357c24552aa6', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:51:28');
INSERT INTO `sys_oper_log_operation` VALUES ('cd1d9819aaadd9c128c11dda03ba7a02', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 11:39:04');
INSERT INTO `sys_oper_log_operation` VALUES ('d4f2da0ab2be2f43ea4d126a80a3ccf9', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '192.168.1.203', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:38:10');
INSERT INTO `sys_oper_log_operation` VALUES ('d5c37217466508e3366c513835cf0f84', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:55:08');
INSERT INTO `sys_oper_log_operation` VALUES ('d8c7de14cf62c884f4ffa79459025d4f', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-10 17:50:55');
INSERT INTO `sys_oper_log_operation` VALUES ('da08192833bfa0af4c30ae4e710b624c', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 11:24:58');
INSERT INTO `sys_oper_log_operation` VALUES ('e1be31ce5d45a957ff2cf7c16a27c3de', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '192.168.1.203', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:41:20');
INSERT INTO `sys_oper_log_operation` VALUES ('e60eb8db289feaea3682ed04580c3fe0', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{\"pageSize\":10,\"pageNum\":1}]', 0, '', '2022-10-04 22:47:30');
INSERT INTO `sys_oper_log_operation` VALUES ('ea063e637f29abf6b8c4276503a7a9ca', '根据用户编号获取用户详情', 1, 'com.springcloud.study.system.controller.SysUserController.selectVoById()', 'GET', 1, '谭志伟', '', '/sys/user/getInfo', '192.168.1.203', '内网IP', '[\"getInfo\"]', 0, '', '2022-10-09 17:41:40');
INSERT INTO `sys_oper_log_operation` VALUES ('ef8dc4b87da25f96c4d12b820275df0f', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-03 22:45:23');
INSERT INTO `sys_oper_log_operation` VALUES ('ff11256b7afa3204727077375780e6bc', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-11 11:11:16');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  `role_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `role_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色权限字符串',
  `role_sort` int(4) NOT NULL COMMENT '显示顺序',
  `data_scope` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '1' COMMENT '数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）',
  `menu_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '菜单树选择项是否关联显示',
  `dept_check_strictly` tinyint(1) NULL DEFAULT 1 COMMENT '部门树选择项是否关联显示',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色状态（0正常 1停用）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_dept`;
CREATE TABLE `sys_role_dept`  (
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  `dept_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '部门ID',
  PRIMARY KEY (`role_id`, `dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色和部门关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_dept
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  `menu_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `user_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户账号',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '用户性别（0男 1女 2未知）',
  `avatar` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '帐号状态（0正常 1停用）',
  `user_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'sys_user' COMMENT '用户类型（sys_user系统用户）',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('4f2d09177f57b064ddf280a9c79f8d92', '谭志伟', 'tanzhiwei0526@163.com', '15951082176', '0', '', '$2a$10$MhMWHbXPuDG0AzAUhIkDZOfVV4MYlqr50l7kFYO3FsXq.rPIGI1Pm', '0', 'sys_user', '0', '', NULL, NULL, '2022-09-28 16:54:59', NULL, '2022-09-28 16:54:59', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `user_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户ID',
  `role_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户和角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;

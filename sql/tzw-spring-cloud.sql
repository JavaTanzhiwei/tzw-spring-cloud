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

 Date: 08/10/2022 17:21:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
INSERT INTO `sys_oper_log_login` VALUES ('163268e71dd0bbe2ee307c6b5b78ea99', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-08 16:46:22');
INSERT INTO `sys_oper_log_login` VALUES ('37617f4576a00f8494d7c1c4f098fef6', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-04 23:26:08');
INSERT INTO `sys_oper_log_login` VALUES ('49b725b9e7c35d7918f8346e5c4340a5', '谭志伟', '127.0.0.1', '内网IP', 'Unknown', 'Unknown', 200, '登录成功', '2022-10-04 22:46:00');

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
INSERT INTO `sys_oper_log_operation` VALUES ('14dce0411b67dd04249862992a430411', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-08 16:46:53');
INSERT INTO `sys_oper_log_operation` VALUES ('1a8f4544a780ac168c891080113ca9d4', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-03 22:46:04');
INSERT INTO `sys_oper_log_operation` VALUES ('64667cbc129eb8d360ed831d95b1ce0b', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{\"pageSize\":10,\"pageNum\":1}]', 0, '', '2022-10-04 23:26:53');
INSERT INTO `sys_oper_log_operation` VALUES ('67ec3f3f7c3e16e6084b730b07721851', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{\"pageSize\":10,\"pageNum\":1}]', 0, '', '2022-10-04 22:49:26');
INSERT INTO `sys_oper_log_operation` VALUES ('7679397d8b48fb9f4ef4f893c68bfb5f', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-03 22:54:26');
INSERT INTO `sys_oper_log_operation` VALUES ('b51ed38d955ebb9e0476138b2d2c4eee', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-03 22:44:45');
INSERT INTO `sys_oper_log_operation` VALUES ('e60eb8db289feaea3682ed04580c3fe0', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{\"pageSize\":10,\"pageNum\":1}]', 0, '', '2022-10-04 22:47:30');
INSERT INTO `sys_oper_log_operation` VALUES ('ef8dc4b87da25f96c4d12b820275df0f', '获取用户列表数据', 1, 'com.springcloud.study.system.controller.SysUserController.queryPageUserList()', 'GET', 1, '谭志伟', '', '/sys/user/queryPageUserList', '127.0.0.1', '内网IP', '[{},{}]', 0, '', '2022-10-03 22:45:23');

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

SET FOREIGN_KEY_CHECKS = 1;

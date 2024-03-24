/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : vocabverse

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 24/03/2024 12:01:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_daily
-- ----------------------------
DROP TABLE IF EXISTS `tb_daily`;
CREATE TABLE `tb_daily`  (
  `userid` int(10) NULL DEFAULT NULL,
  `time` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `checkin` int(1) NULL DEFAULT 0 COMMENT '签到  0：否 1：是',
  `searchedword` int(255) NULL DEFAULT 0,
  `studyword` int(255) NULL DEFAULT 0 COMMENT '选择q_3后加1',
  `studytime` int(255) NULL DEFAULT 0 COMMENT '接受反馈次数，当为0，设置day_q为0',
  `shouldstudy` int(255) NULL DEFAULT NULL COMMENT '应该学习单词总数',
  `studyduration` int(255) NULL DEFAULT 0 COMMENT '学习时间 毫秒'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_daily
-- ----------------------------
INSERT INTO `tb_daily` VALUES (1000, '2024-3-1', 1, 0, 4, 9, 4, 327);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-2', 1, 0, 4, 5, 4, 188);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-3', 1, 13, 5, 6, 5, 190);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-4', 1, 0, 5, 7, 5, 235);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-6', 1, 1, 4, 7, 4, 204);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-9', 1, 0, 6, 8, 6, 169);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-10', 0, 6, 7, 7, 8, 746);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-11', 0, 0, 0, 0, 5, 20);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-12', 1, 2, 9, 15, 9, 1333);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-14', 1, 3, 12, 18, 12, 492);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-16', 1, 0, 7, 10, 7, 290);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-19', 1, 3, 14, 15, 13, 463);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-21', 1, 2, 10, 25, 10, 678);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-22', 1, 1, 7, 11, 7, 565);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-23', 1, 0, 4, 8, 4, 205);
INSERT INTO `tb_daily` VALUES (1000, '2024-3-24', 1, 0, 11, 17, 11, 691);

SET FOREIGN_KEY_CHECKS = 1;

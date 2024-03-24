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

 Date: 24/03/2024 12:02:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_voc_study
-- ----------------------------
DROP TABLE IF EXISTS `tb_voc_study`;
CREATE TABLE `tb_voc_study`  (
  `userid` int(10) NOT NULL,
  `wordid` int(10) NOT NULL,
  `exapid` int(10) NULL DEFAULT 0,
  `q_0` int(255) NULL DEFAULT 0 COMMENT 'q_? 为该用户该单词的总学习情况 默认0',
  `q_1` int(255) NULL DEFAULT 0,
  `q_2` int(255) NULL DEFAULT 0,
  `q_3` int(255) NULL DEFAULT 0,
  `studycount` int(255) NULL DEFAULT 0 COMMENT '复习天数总数  单词第一次接受反馈+1 往后不+1',
  `ef` double NULL DEFAULT 2 COMMENT '学习质量  默认2',
  `day_q_0` int(255) NULL DEFAULT 0 COMMENT '用于计算每日opt_weight 获取单词时刷新',
  `day_q_1` int(255) NULL DEFAULT 0,
  `day_q_2` int(255) NULL DEFAULT 0,
  `day_studycount` int(255) NULL DEFAULT 0 COMMENT '今日反馈次数 为0时设置studycount与laststudydate',
  `intervalday` int(255) NULL DEFAULT 0 COMMENT '学习间隔时间 用户计算下次学习日期与记忆曲线',
  `adddate` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该单词添加进学习计划的日期',
  `laststudydate` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上次复习时间  单词第一次接受反馈时设置 与学习历史最近的日期一样',
  `nextstudydate` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '下次学习日期,添加时，定位今天',
  `state` int(1) NULL DEFAULT 0 COMMENT '0正在学习  1归为简单单词，不在进入学习计划，默认0'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_voc_study
-- ----------------------------
INSERT INTO `tb_voc_study` VALUES (1000, 4637, 141769, 0, 0, 4, 8, 8, 2.4000000000000017, 0, 0, 0, 1, 7, '2024-3-1', '2024-3-20', '2024-3-27', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 8069, 11682, 0, 0, 3, 6, 6, 2.3000000000000007, 0, 0, 0, 1, 14, '2024-3-1', '2024-3-21', '2024-4-4', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 12694, 18623, 1, 2, 2, 10, 10, 2.2, 0, 0, 0, 1, 6, '2024-3-1', '2024-3-21', '2024-3-27', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 71870, 99595, 1, 3, 2, 10, 10, 2.060000000000001, 0, 0, 0, 1, 6, '2024-3-1', '2024-3-19', '2024-3-25', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 29072, 41622, 0, 0, 3, 6, 6, 2.300000000000001, 0, 0, 0, 1, 16, '2024-3-3', '2024-3-19', '2024-4-4', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 77009, 106586, 0, 0, 1, 5, 5, 2.400000000000001, 0, 0, 0, 1, 9, '2024-3-4', '2024-3-19', '2024-3-28', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 21104, 30264, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, '2024-3-10', NULL, '2024-3-10', 1);
INSERT INTO `tb_voc_study` VALUES (1000, 3062, 4704, 0, 0, 0, 5, 5, 2.5, 0, 0, 0, 1, 8, '2024-3-10', '2024-3-24', '2024-4-1', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 47195, 66830, 0, 1, 1, 6, 5, 2.3600000000000008, 0, 0, 0, 1, 6, '2024-3-10', '2024-3-21', '2024-3-27', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 66048, 92067, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, '2024-3-10', NULL, '2024-3-10', 1);
INSERT INTO `tb_voc_study` VALUES (1000, 512, 851, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, '2024-3-10', NULL, '2024-3-10', 1);
INSERT INTO `tb_voc_study` VALUES (1000, 8775, 12716, 0, 0, 0, 5, 5, 2.5, 0, 0, 0, 1, 8, '2024-3-10', '2024-3-24', '2024-4-1', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 8755, 12691, 0, 1, 0, 4, 4, 2.2600000000000002, 0, 0, 0, 1, 8, '2024-3-10', '2024-3-24', '2024-4-1', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 71556, 99147, 0, 1, 1, 6, 5, 2.3600000000000008, 0, 0, 0, 1, 4, '2024-3-12', '2024-3-23', '2024-3-27', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 56183, 78919, 0, 0, 0, 5, 5, 2.5, 0, 0, 0, 1, 7, '2024-3-12', '2024-3-24', '2024-3-31', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 9509, 13839, 1, 0, 1, 4, 4, 1.9800000000000002, 0, 0, 0, 1, 2, '2024-3-20', '2024-3-24', '2024-3-26', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 26488, 37800, 1, 1, 1, 6, 5, 2.0400000000000005, 0, 0, 0, 1, 6, '2024-3-20', '2024-3-24', '2024-3-30', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 84212, 115721, 5, 0, 0, 5, 5, 1.5, 2, 0, 0, 3, 1, '2024-3-20', '2024-3-24', '2024-3-25', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 59415, 83189, 0, 0, 0, 3, 3, 2.3000000000000003, 0, 0, 0, 1, 3, '2024-3-20', '2024-3-22', '2024-3-25', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 87486, 120013, 0, 1, 0, 5, 4, 2.3600000000000003, 0, 1, 0, 2, 1, '2024-3-20', '2024-3-24', '2024-3-25', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 82459, 113303, 0, 0, 1, 4, 4, 2.3000000000000007, 0, 0, 1, 2, 1, '2024-3-20', '2024-3-24', '2024-3-25', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 32667, 46371, 0, 0, 0, 2, 1, 2.2, 0, 0, 0, 2, 1, '2024-3-24', '2024-3-24', '2024-3-25', 0);
INSERT INTO `tb_voc_study` VALUES (1000, 26480, 37781, 0, 1, 0, 1, 1, 1.9600000000000002, 0, 1, 0, 2, 1, '2024-3-24', '2024-3-24', '2024-3-25', 0);

SET FOREIGN_KEY_CHECKS = 1;

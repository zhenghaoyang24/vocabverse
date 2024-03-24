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

 Date: 24/03/2024 12:02:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_voc_study_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_voc_study_history`;
CREATE TABLE `tb_voc_study_history`  (
  `userid` int(10) NOT NULL COMMENT '当用户该单词今日复习次数为0，第一次选择时添加',
  `wordid` int(10) NOT NULL,
  `opt` int(1) NOT NULL,
  `selectdate` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_voc_study_history
-- ----------------------------
INSERT INTO `tb_voc_study_history` VALUES (1000, 4637, 2, '2024-3-1');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 1, '2024-3-1');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8069, 2, '2024-3-1');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 2, '2024-3-1');
INSERT INTO `tb_voc_study_history` VALUES (1000, 4637, 3, '2024-3-2');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8069, 2, '2024-3-2');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 3, '2024-3-2');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 3, '2024-3-2');
INSERT INTO `tb_voc_study_history` VALUES (1000, 4637, 3, '2024-3-3');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 3, '2024-3-3');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8069, 3, '2024-3-3');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 3, '2024-3-3');
INSERT INTO `tb_voc_study_history` VALUES (1000, 29072, 2, '2024-3-3');
INSERT INTO `tb_voc_study_history` VALUES (1000, 4637, 2, '2024-3-4');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 1, '2024-3-4');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 3, '2024-3-4');
INSERT INTO `tb_voc_study_history` VALUES (1000, 29072, 3, '2024-3-4');
INSERT INTO `tb_voc_study_history` VALUES (1000, 77009, 3, '2024-3-4');
INSERT INTO `tb_voc_study_history` VALUES (1000, 4637, 2, '2024-3-6');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 1, '2024-3-6');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 3, '2024-3-6');
INSERT INTO `tb_voc_study_history` VALUES (1000, 77009, 3, '2024-3-6');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 3, '2024-3-9');
INSERT INTO `tb_voc_study_history` VALUES (1000, 77009, 2, '2024-3-9');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 1, '2024-3-9');
INSERT INTO `tb_voc_study_history` VALUES (1000, 4637, 3, '2024-3-9');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8069, 3, '2024-3-9');
INSERT INTO `tb_voc_study_history` VALUES (1000, 29072, 3, '2024-3-9');
INSERT INTO `tb_voc_study_history` VALUES (1000, 77009, 3, '2024-3-10');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 3, '2024-3-10');
INSERT INTO `tb_voc_study_history` VALUES (1000, 3062, 3, '2024-3-10');
INSERT INTO `tb_voc_study_history` VALUES (1000, 47195, 3, '2024-3-10');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8775, 3, '2024-3-10');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 2, '2024-3-12');
INSERT INTO `tb_voc_study_history` VALUES (1000, 47195, 1, '2024-3-12');
INSERT INTO `tb_voc_study_history` VALUES (1000, 3062, 3, '2024-3-12');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8775, 3, '2024-3-12');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8755, 1, '2024-3-12');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71556, 3, '2024-3-12');
INSERT INTO `tb_voc_study_history` VALUES (1000, 56183, 3, '2024-3-12');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 2, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 0, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 4637, 3, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 29072, 2, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 3062, 3, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8775, 3, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71556, 2, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 47195, 2, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 56183, 3, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8755, 3, '2024-3-14');
INSERT INTO `tb_voc_study_history` VALUES (1000, 29072, 2, '2024-3-16');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71556, 1, '2024-3-16');
INSERT INTO `tb_voc_study_history` VALUES (1000, 56183, 3, '2024-3-16');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 0, '2024-3-16');
INSERT INTO `tb_voc_study_history` VALUES (1000, 47195, 3, '2024-3-16');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 3, '2024-3-16');
INSERT INTO `tb_voc_study_history` VALUES (1000, 77009, 3, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 3062, 3, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8775, 3, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 56183, 3, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 29072, 3, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8069, 2, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71556, 3, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8755, 3, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71870, 3, '2024-3-19');
INSERT INTO `tb_voc_study_history` VALUES (1000, 4637, 3, '2024-3-20');
INSERT INTO `tb_voc_study_history` VALUES (1000, 9509, 0, '2024-3-20');
INSERT INTO `tb_voc_study_history` VALUES (1000, 26488, 3, '2024-3-20');
INSERT INTO `tb_voc_study_history` VALUES (1000, 84212, 3, '2024-3-20');
INSERT INTO `tb_voc_study_history` VALUES (1000, 59415, 3, '2024-3-20');
INSERT INTO `tb_voc_study_history` VALUES (1000, 87486, 3, '2024-3-20');
INSERT INTO `tb_voc_study_history` VALUES (1000, 82459, 3, '2024-3-20');
INSERT INTO `tb_voc_study_history` VALUES (1000, 47195, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8069, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 26488, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 87486, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 12694, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 82459, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 59415, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 84212, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 9509, 3, '2024-3-21');
INSERT INTO `tb_voc_study_history` VALUES (1000, 26488, 1, '2024-3-22');
INSERT INTO `tb_voc_study_history` VALUES (1000, 87486, 3, '2024-3-22');
INSERT INTO `tb_voc_study_history` VALUES (1000, 84212, 0, '2024-3-22');
INSERT INTO `tb_voc_study_history` VALUES (1000, 59415, 3, '2024-3-22');
INSERT INTO `tb_voc_study_history` VALUES (1000, 82459, 3, '2024-3-22');
INSERT INTO `tb_voc_study_history` VALUES (1000, 9509, 3, '2024-3-22');
INSERT INTO `tb_voc_study_history` VALUES (1000, 71556, 3, '2024-3-23');
INSERT INTO `tb_voc_study_history` VALUES (1000, 26488, 0, '2024-3-23');
INSERT INTO `tb_voc_study_history` VALUES (1000, 84212, 0, '2024-3-23');
INSERT INTO `tb_voc_study_history` VALUES (1000, 3062, 3, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8775, 3, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 56183, 3, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 87486, 1, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 82459, 2, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 8755, 3, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 26488, 3, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 9509, 3, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 84212, 0, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 32667, 3, '2024-3-24');
INSERT INTO `tb_voc_study_history` VALUES (1000, 26480, 1, '2024-3-24');

SET FOREIGN_KEY_CHECKS = 1;

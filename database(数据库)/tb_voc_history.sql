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

 Date: 24/03/2024 12:02:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_voc_history
-- ----------------------------
DROP TABLE IF EXISTS `tb_voc_history`;
CREATE TABLE `tb_voc_history`  (
  `userid` int(10) NOT NULL,
  `wordid` int(10) NOT NULL,
  `spelling` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_voc_history
-- ----------------------------
INSERT INTO `tb_voc_history` VALUES (1000, 68838, 'phonograph');
INSERT INTO `tb_voc_history` VALUES (1000, 17369, 'close');
INSERT INTO `tb_voc_history` VALUES (1000, 103442, 'yummy');
INSERT INTO `tb_voc_history` VALUES (1000, 17370, 'closed');
INSERT INTO `tb_voc_history` VALUES (1000, 67373, 'peaceful');
INSERT INTO `tb_voc_history` VALUES (1000, 21104, 'credit');
INSERT INTO `tb_voc_history` VALUES (1000, 3062, 'amazing');
INSERT INTO `tb_voc_history` VALUES (1000, 64394, 'opinion');
INSERT INTO `tb_voc_history` VALUES (1000, 47195, 'inspired');
INSERT INTO `tb_voc_history` VALUES (1000, 55790, 'many');
INSERT INTO `tb_voc_history` VALUES (1000, 8755, 'beautiful');
INSERT INTO `tb_voc_history` VALUES (1000, 32667, 'fabulous');
INSERT INTO `tb_voc_history` VALUES (1000, 71556, 'potential');
INSERT INTO `tb_voc_history` VALUES (1000, 71180, 'pool');
INSERT INTO `tb_voc_history` VALUES (1000, 81877, 'second');
INSERT INTO `tb_voc_history` VALUES (1000, 70218, 'please');
INSERT INTO `tb_voc_history` VALUES (1000, 46815, 'inherent');
INSERT INTO `tb_voc_history` VALUES (1000, 38215, 'given');
INSERT INTO `tb_voc_history` VALUES (1000, 82095, 'select');
INSERT INTO `tb_voc_history` VALUES (1000, 71644, 'power');

SET FOREIGN_KEY_CHECKS = 1;

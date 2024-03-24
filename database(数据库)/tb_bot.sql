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

 Date: 24/03/2024 12:01:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_bot
-- ----------------------------
DROP TABLE IF EXISTS `tb_bot`;
CREATE TABLE `tb_bot`  (
  `botid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `botname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `likecount` int(255) NULL DEFAULT NULL,
  `dislikecount` int(255) NULL DEFAULT NULL,
  `satisfaction` float(4, 3) NULL DEFAULT NULL,
  `usedcount` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`botid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_bot
-- ----------------------------
INSERT INTO `tb_bot` VALUES ('runse', '句子润色', 59, 6, 0.908, 65);
INSERT INTO `tb_bot` VALUES ('wenda', '知识问答', 72, 13, 0.847, 103);
INSERT INTO `tb_bot` VALUES ('xiezuo', '智能写作', 103, 14, 0.880, 122);
INSERT INTO `tb_bot` VALUES ('zaoju', '单词造句', 51, 7, 0.879, 74);

SET FOREIGN_KEY_CHECKS = 1;

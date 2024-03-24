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

 Date: 24/03/2024 12:02:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_voc_userbook
-- ----------------------------
DROP TABLE IF EXISTS `tb_voc_userbook`;
CREATE TABLE `tb_voc_userbook`  (
  `ubookvocid` int(10) NOT NULL AUTO_INCREMENT,
  `wordid` int(10) NOT NULL,
  `bookid` int(10) NOT NULL,
  PRIMARY KEY (`ubookvocid`) USING BTREE,
  INDEX `FK_tb_voc_userbook_holderid`(`bookid`) USING BTREE,
  CONSTRAINT `FK_tb_voc_userbook_holderid` FOREIGN KEY (`bookid`) REFERENCES `tb_user_book` (`userbookid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_voc_userbook
-- ----------------------------
INSERT INTO `tb_voc_userbook` VALUES (13, 29072, 15);
INSERT INTO `tb_voc_userbook` VALUES (22, 9509, 14);
INSERT INTO `tb_voc_userbook` VALUES (23, 26488, 14);
INSERT INTO `tb_voc_userbook` VALUES (24, 38215, 14);
INSERT INTO `tb_voc_userbook` VALUES (25, 26480, 14);
INSERT INTO `tb_voc_userbook` VALUES (26, 74889, 15);
INSERT INTO `tb_voc_userbook` VALUES (27, 59817, 15);
INSERT INTO `tb_voc_userbook` VALUES (29, 93066, 15);
INSERT INTO `tb_voc_userbook` VALUES (31, 85183, 15);
INSERT INTO `tb_voc_userbook` VALUES (32, 43247, 15);
INSERT INTO `tb_voc_userbook` VALUES (33, 4536, 15);
INSERT INTO `tb_voc_userbook` VALUES (34, 59117, 15);
INSERT INTO `tb_voc_userbook` VALUES (35, 15836, 15);
INSERT INTO `tb_voc_userbook` VALUES (36, 26822, 15);
INSERT INTO `tb_voc_userbook` VALUES (37, 69464, 15);
INSERT INTO `tb_voc_userbook` VALUES (38, 66327, 15);
INSERT INTO `tb_voc_userbook` VALUES (45, 32667, 14);

SET FOREIGN_KEY_CHECKS = 1;

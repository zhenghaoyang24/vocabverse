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

 Date: 24/03/2024 12:02:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_book`;
CREATE TABLE `tb_user_book`  (
  `userbookid` int(10) NOT NULL AUTO_INCREMENT COMMENT '自定义书id',
  `userbookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '书名',
  `voccount` int(255) NULL DEFAULT NULL COMMENT '单词数量',
  `holderid` int(10) NOT NULL COMMENT '创建者',
  `creattime` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建时间',
  `share` int(1) NULL DEFAULT NULL COMMENT '1为共享，0为私密',
  `bookdescribe` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`userbookid`) USING BTREE,
  INDEX `FK_tb_user_book_holderid`(`holderid`) USING BTREE,
  CONSTRAINT `FK_tb_user_book_holderid` FOREIGN KEY (`holderid`) REFERENCES `tb_user` (`userid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user_book
-- ----------------------------
INSERT INTO `tb_user_book` VALUES (14, '可替换的高级形容词', 5, 1000, '2024-1-11', 1, '可以在作文里用的高级形容词');
INSERT INTO `tb_user_book` VALUES (15, '动物名字', 12, 1000, '2024-1-12', 0, '描述常见动物的名词');

SET FOREIGN_KEY_CHECKS = 1;

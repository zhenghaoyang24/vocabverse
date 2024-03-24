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

 Date: 24/03/2024 12:01:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book`  (
  `bookid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'book唯一id',
  `bookname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '书名',
  `voccount` int(255) NULL DEFAULT NULL COMMENT '单词数量',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '作者',
  `organization` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '机构',
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '出版社',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`bookid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES (1, '四级词汇乱序便携版', 3173, '俞敏洪', '新东方', '海豚出版社', NULL);
INSERT INTO `tb_book` VALUES (2, '考研词汇便携版', 6357, '俞敏洪', '新东方', '浙江教育出版社', NULL);
INSERT INTO `tb_book` VALUES (3, '星火四级词汇必背乱序版', 2219, '马德高', '吉林出版集团股份有限公司', '吉林出版集团股份有限公司', NULL);
INSERT INTO `tb_book` VALUES (4, '雅思词汇念念不忘乱序版', 5382, '《雅思词汇》编写组', '世界图书出版公司', '世界图书出版公司', NULL);
INSERT INTO `tb_book` VALUES (5, '托福高频词汇精讲', 2760, '杜昶旭 王宜涵', '中国宇航出版社', '中国宇航出版社', NULL);
INSERT INTO `tb_book` VALUES (6, '考研英语(二)词汇 乱序版', 6080, '俞敏洪', '新东方', '海豚出版社', NULL);

SET FOREIGN_KEY_CHECKS = 1;

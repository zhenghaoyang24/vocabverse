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

 Date: 24/03/2024 12:01:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `userid` int(10) NOT NULL COMMENT '用户id',
  `useremail` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户邮箱',
  `userpassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '用户密码',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `regtime` varchar(18) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '注册时间',
  `level` int(255) NULL DEFAULT NULL COMMENT '等级',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别0:女，1:男',
  `birthday` varchar(18) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '生日',
  `school` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '学校',
  `region` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '地区',
  `phonenumber` char(11) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '电话号码',
  `status` int(10) NULL DEFAULT NULL COMMENT '状态',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `synopsis` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES (1000, 'zheng@email.com', 'e10adc3949ba59abbe56e057f20f883e', '爱记单词的zhy', '2023-12-12', 0, 1, '2000-10-24', '太阳系理工大学', '太阳系', '13810246417', NULL, 'image/avatar/gif/194.gif', '每天记单词.');
INSERT INTO `tb_user` VALUES (356448997, '374273904@qq.com', 'ed4e7954e014f88e17beb73576617bbe', '好人卡邓正岩', '2024-2-13', 0, 2, NULL, NULL, NULL, NULL, NULL, 'image/avatar/avatar_default.png', NULL);
INSERT INTO `tb_user` VALUES (424689035, '2898394329@qq.com', '25f9e794323b453885f5181f1b624d0b', '飞扬', '2023-12-27', 0, 2, NULL, NULL, NULL, NULL, NULL, 'image/avatar/avatar_default.png', NULL);
INSERT INTO `tb_user` VALUES (985730558, '1186494539@qq.com', '81cb439337d498c9ed8178625209c65b', '爱记单词的李华', '2024-1-7', 0, 2, NULL, NULL, NULL, NULL, NULL, 'image/avatar/avatar_default.png', NULL);

SET FOREIGN_KEY_CHECKS = 1;

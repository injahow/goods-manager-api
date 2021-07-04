/*
 Navicat Premium Data Transfer

 Source Server         : MyXli
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : localhost:3306
 Source Schema         : goods_manager

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 03/07/2021 11:20:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `commentId` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `goodId` int(11) NULL DEFAULT NULL COMMENT '商品id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '评价内容',
  `memberId` int(11) NULL DEFAULT NULL COMMENT '评价用户id，唯一',
  `createTime` date NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`commentId`) USING BTREE,
  INDEX `good_id_2`(`goodId`) USING BTREE,
  INDEX `member_id`(`memberId`) USING BTREE,
  CONSTRAINT `good_id_2` FOREIGN KEY (`goodId`) REFERENCES `good_spu` (`goodId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `member_id` FOREIGN KEY (`memberId`) REFERENCES `member` (`memberId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for good_sku
-- ----------------------------
DROP TABLE IF EXISTS `good_sku`;
CREATE TABLE `good_sku`  (
  `skuId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'SKU编号',
  `goodId` int(11) NOT NULL COMMENT '商品id',
  `skuName` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'SKU名称',
  `skuImg` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '商品图片',
  `paramsMap` varchar(0) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品属性a:xx,b:xx,c:xx',
  `originalPrice` double(11, 2) NULL DEFAULT NULL COMMENT '商品原价',
  `sellPrice` double(11, 2) NULL DEFAULT NULL COMMENT '销售价格',
  `goodStock` int(11) NULL DEFAULT NULL COMMENT '商品库存',
  `createTime` date NULL DEFAULT NULL COMMENT '创建日期',
  `updateTime` date NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`skuId`) USING BTREE,
  INDEX `good_id`(`goodId`) USING BTREE,
  CONSTRAINT `good_id` FOREIGN KEY (`goodId`) REFERENCES `good_spu` (`goodId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for good_spu
-- ----------------------------
DROP TABLE IF EXISTS `good_spu`;
CREATE TABLE `good_spu`  (
  `goodId` int(11) NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `goodName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `typeId` int(11) NULL DEFAULT NULL COMMENT '分类id',
  `soldNum` int(11) NULL DEFAULT NULL COMMENT '销量数',
  `status` int(11) NOT NULL COMMENT '是否下架：1正常，0下架，-1删除',
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商品内容',
  `createTime` date NULL DEFAULT NULL COMMENT '创建日期',
  `updateTime` date NULL DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`goodId`) USING BTREE,
  INDEX `type_id`(`typeId`) USING BTREE,
  CONSTRAINT `type_id` FOREIGN KEY (`typeId`) REFERENCES `good_type` (`typeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for good_type
-- ----------------------------
DROP TABLE IF EXISTS `good_type`;
CREATE TABLE `good_type`  (
  `typeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `typeName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称',
  `typeDesc` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '类型描述',
  PRIMARY KEY (`typeId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`  (
  `memberId` int(11) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `memberName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员名称',
  `memberAvatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员头像',
  PRIMARY KEY (`memberId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userAvatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像url',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户个人介绍',
  `userTel` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户电话',
  `userAddress` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '用户地址',
  `userRank` int(11) NULL DEFAULT NULL COMMENT '用户等级',
  `userCreateTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for user_auth
-- ----------------------------
DROP TABLE IF EXISTS `user_auth`;
CREATE TABLE `user_auth`  (
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`account`) USING BTREE,
  UNIQUE INDEX `账号`(`account`) USING BTREE,
  INDEX `user_id`(`userId`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

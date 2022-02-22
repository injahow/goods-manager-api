# goods-manager-api（商品管理系统）

> Goods Manager 后台系统 ( 基于 SpringBoot 框架构建 )

## 一、业务分析

- 登录业务流程分析
- 类别管理业务流程分析（添加类别、查看类别、删除类别、修改类别）
- 商品管理业务流程分析（添加商品、查看商品、删除商品、修改商品、搜索商品）

![](imgs\process_analysis.jpg)

## 二、项目设计

### 2.1 UI 设计

- 登录界面

![](imgs\login_interface.png)

- 管理系统主界面

![](imgs\main.png)

### 2.2 数据库设计

#### 2.2.1 数据实体

- 商品类别信息
- 商品信息
  - 商品 SPU 信息
  - 商品 SKU 信息
- 管理员用户信息
  - 管理员账号密码信息
  - 管理员基本信息
- 客户信息
- 评价信息

#### 2.2.2 提取数据项

- 商品类别（类别 ID，类别名称，类别描述）
- 商品（<font color='green'>SPU：商品 ID【主键】，商品名称，商品类别，商品销量，商品状态<默认是 1，表正常状态，-1 表示删除，0 表示下架>，商品介绍，创建时间，更新时间</font>。<font color='blue'>SKU：skuID，商品 ID，sku 名称，sku 图片，产品属性，原价，销售价格，商品库存，创建时间</font>）
- 管理员用户（管理员 ID，管理员姓名，管理员头像，管理员介绍，管理员电话，管理员地址，管理员排名，管理员入职时间，<font color='red'>管理员账号，管理员密码</font>）
- 客户（客户 ID，客户姓名，客户头像）
- 评价（评价 ID，产品 ID，评价内容，客户 ID，客户姓名，客户头像，评价时间）

#### 2.2.3 三范式约束

#### 2.2.4 绘制 E-R 图

![](imgs\ER1.jpg)

![](imgs\ER2.jpg)

![](imgs\ER.png)

#### 2.2.5 建库建表

```sql
/*
 Navicat Premium Data Transfer

 Source Server         : Admin
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
```

### 2.3 实现流程设计

#### 2.3.1 管理员登录实现流程

![](imgs\login.png)

#### 2.3.2 添加商品实现流程

![](imgs\add.png)

#### 2.3.3 查看商品详情实现流程

![](imgs\list.png)

#### 2.3.4 删除商品实现流程

![](imgs\delete.png)

#### 2.3.5 修改商品实现流程

![](imgs\update.png)

#### 2.3.6 搜索商品实现流程

![](imgs\search.png)

#### 备注

> 类别管理以及评论管理的实现流程与上述商品管理的流程类似，在此不再赘述

## 三、编码

- https://github.com/injahow/goods-manager (Goods Manager 系统前端)
- https://github.com/injahow/goods-manager-api (Goods Manager 系统后台)

## 四、测试

- 添加商品功能

![](imgs\goods_add.png)

- 编辑（修改）商品功能

![](imgs\good_edit.png)

- 查看商品详情功能

![](imgs\goods_details.png)

- 搜索商品功能

![](imgs\goods_search.png)

- 添加类别功能

![](imgs\goodsType_add.png)

- 修改类别功能

![](imgs\goodsType_update.png)

- 类别介绍查看功能

![](imgs\goodsType_introduction.png)

- 评论管理功能

![](imgs\comments_management.png)

## 五、生产环境部署（Linux）

- 打包项目

```bash
mvn clean package
```

![](imgs\bushu.png)

![](imgs\bushu1.png)

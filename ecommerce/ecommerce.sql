/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : ecommerce

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 25/03/2022 16:29:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '商品分类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '女鞋');
INSERT INTO `category` VALUES (2, '女装');
INSERT INTO `category` VALUES (3, '男装');
INSERT INTO `category` VALUES (4, '女式包');
INSERT INTO `category` VALUES (5, '男式表');
INSERT INTO `category` VALUES (6, '电子烟');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(0) NOT NULL COMMENT '客户编号',
  `date` timestamp(0) NOT NULL COMMENT '时间',
  `total` decimal(10, 2) NULL DEFAULT NULL COMMENT '总金额',
  `status` tinyint(0) NULL DEFAULT NULL COMMENT '订单状态',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id`) USING BTREE,
  CONSTRAINT `order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (42, 1, '2022-03-22 20:02:40', 1710.00, -1);
INSERT INTO `order` VALUES (43, 1, '2022-03-22 20:02:47', 969.00, -1);
INSERT INTO `order` VALUES (44, 1, '2022-03-22 20:03:06', 2599.00, 1);
INSERT INTO `order` VALUES (45, 1, '2022-03-22 20:34:24', 14040.00, 1);

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `order_id` int(0) NOT NULL COMMENT '订单编号',
  `product_id` int(0) NOT NULL COMMENT '商品编号',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `quantity` int(0) NOT NULL COMMENT '数量',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `order_id`(`order_id`) USING BTREE,
  INDEX `product_id`(`product_id`) USING BTREE,
  CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单明细' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES (7, 42, 2, 570.00, 3);
INSERT INTO `order_item` VALUES (8, 43, 3, 969.00, 1);
INSERT INTO `order_item` VALUES (9, 44, 3, 969.00, 1);
INSERT INTO `order_item` VALUES (10, 44, 1, 820.00, 1);
INSERT INTO `order_item` VALUES (11, 44, 5, 810.00, 1);
INSERT INTO `order_item` VALUES (12, 45, 2, 570.00, 1);
INSERT INTO `order_item` VALUES (13, 45, 3, 969.00, 1);
INSERT INTO `order_item` VALUES (14, 45, 4, 12501.00, 1);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '商品名称',
  `category_id` int(0) NOT NULL COMMENT '分类编号',
  `market_price` decimal(10, 2) NOT NULL COMMENT '市场价',
  `price` decimal(10, 2) NOT NULL COMMENT '售价',
  `image` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图片',
  `stock` int(0) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `category_id`(`category_id`) USING BTREE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '商品' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1, 'New Arrival Femal Shoes', 1, 980.00, 820.00, 'female-shoes.jpg', 231);
INSERT INTO `product` VALUES (2, 'Ladies Pure PU Shoulder Bag', 4, 620.00, 570.00, 'ladis-bag.jpg', 299);
INSERT INTO `product` VALUES (3, 'Stylish Men Office Suits', 3, 1200.00, 969.00, 'men-suits.jpg', 23);
INSERT INTO `product` VALUES (4, 'Jaeger-LeCoultre Men Watch', 5, 13000.00, 12501.00, 'men-watch.jpg', 45);
INSERT INTO `product` VALUES (5, 'FreeMax e-cigarettes VB-456', 6, 930.00, 810.00, 'smoking-e-cigarette.jpg', 145);
INSERT INTO `product` VALUES (6, 'GeekVapee e-cigarattes MM-632', 6, 2600.00, 2556.00, 'smoking-e-cigarette-2.jpg', 32);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `email` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '电子邮件',
  `password` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `mobile` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号码',
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '收货地址',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `email_UNIQUE`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '会员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user', 'cart@mail.com', '123456', '13900001001', '成都市');

SET FOREIGN_KEY_CHECKS = 1;

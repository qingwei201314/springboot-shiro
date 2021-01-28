/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50723
Source Host           : 127.0.0.1:3306
Source Database       : shiro

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2021-01-28 16:40:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `descript` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理模块');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL DEFAULT '0',
  `role_id` int(11) DEFAULT NULL,
  `permission` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', 'read');
INSERT INTO `role_permission` VALUES ('4', '1', 'write');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `password_salt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'KevinZhang', '123456', null);

-- ----------------------------
-- Table structure for user_permit
-- ----------------------------
DROP TABLE IF EXISTS `user_permit`;
CREATE TABLE `user_permit` (
  `id` int(11) NOT NULL DEFAULT '0',
  `username` varchar(20) DEFAULT NULL,
  `permit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_permit
-- ----------------------------
INSERT INTO `user_permit` VALUES ('1', 'KevinZhang', 'admin:read');
INSERT INTO `user_permit` VALUES ('2', 'KevinZhang', 'admin:write');
INSERT INTO `user_permit` VALUES ('3', 'KevinZhang', 'admin:update');

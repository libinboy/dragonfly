/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : augus

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-11 08:30:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- database augus
-- ----------------------------
drop database if exists dragonfly;
create database dragonfly;
use dragonfly;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) DEFAULT NULL COMMENT '登陆帐户',
  `password` varchar(256) DEFAULT NULL COMMENT '密码',
  `user_name` varchar(128) DEFAULT NULL COMMENT '姓名',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户管理';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'libin', '123', '李彬');
INSERT INTO `t_user` VALUES ('2', 'libin2', '123', '李彬');
INSERT INTO `t_user` VALUES ('3', 'libin3', '123', '李彬');
INSERT INTO `t_user` VALUES ('4', 'libin4', '123', '李彬');
INSERT INTO `t_user` VALUES ('5', 'libin5', '123', '李彬');
INSERT INTO `t_user` VALUES ('6', 'libin6', '123', '李彬');
INSERT INTO `t_user` VALUES ('7', 'libin7', '123', '李彬');
INSERT INTO `t_user` VALUES ('8', 'libin8', '123', '李彬');
INSERT INTO `t_user` VALUES ('9', 'libin9', '123', '李彬');
INSERT INTO `t_user` VALUES ('10', 'libin10', '123', '李彬');
INSERT INTO `t_user` VALUES ('11', 'libin11', '123', '李彬');
INSERT INTO `t_user` VALUES ('12', 'libin12', '123', '李彬');
INSERT INTO `t_user` VALUES ('13', 'libin13', '123', '李彬');

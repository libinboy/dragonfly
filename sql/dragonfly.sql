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

DROP TABLE IF EXISTS `t_joke`;
CREATE TABLE `t_joke` (
  `joke_id` int(12) NOT NULL AUTO_INCREMENT,
  `joke_content` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`joke_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_joke
-- ----------------------------
INSERT INTO `t_joke` VALUES ('1', '如果你得罪了老板，失去的只是一份工作；如果你得罪了客户，失去的不过是一份订单；是的，世上只有一个人可以得罪：你给她脸色看，你冲她发牢骚，你大声顶撞她，甚至当 着她的面摔碗，她都不会记恨你，原因很简单，因为她是你的母亲。');
INSERT INTO `t_joke` VALUES ('2', '悟空和唐僧一起上某卫视非诚勿扰,悟空上台,24盏灯全灭。理由:1.没房没车只有一根破棍. 2.保镖职业危险.3.动不动打妖精,对女生不温柔. 4.坐过牢,曾被压五指山下500年。唐僧上台，哗!灯全亮。 理由:1.公务员； 2.皇上兄弟，后台最硬 3.精通梵文等外语 4.长得帅 5.最关键一点：有宝马！');
INSERT INTO `t_joke` VALUES ('3', '一年奔波，尘缘遇了谁；一句珍重，天涯别了谁；一点灵犀，凭栏忆了谁；一种相思，闲愁予了谁；一江明月，豪情酬了谁；一场冬雪，烟波忘了谁；一壶浊酒，相逢醉了谁；一世浮生，轻狂撩了谁；一封短信，才情念了谁；一番思量，谁是谁的谁 ；一枚围脖，转发回复谁.....');


-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '上级id',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '地址',
  `perms` varchar(500) DEFAULT NULL COMMENT '权限',
  `type` int(11) DEFAULT NULL COMMENT '类型',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8 COMMENT='菜单';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '0', '系统管理', '', '', '0', 'fa fa-cog', '0');
INSERT INTO `t_menu` VALUES ('2', '1', '管理员列表', 'page/user/list.jsp', 'sys:user:list', '1', 'fa fa-user', '1');
INSERT INTO `t_menu` VALUES ('3', '1', '角色管理', 'page/role/list.jsp', 'sys:role:list', '1', 'fa fa-user-secret', '2');
INSERT INTO `t_menu` VALUES ('4', '1', '菜单管理', 'page/menu/list.jsp', 'sys:menu:list', '1', 'fa fa-th-list', '1');
INSERT INTO `t_menu` VALUES ('5', '2', '查看', null, 'sys:user:list,sys:user:info', '2', null, '0');
INSERT INTO `t_menu` VALUES ('6', '2', '新增', null, 'sys:user:save,sys:role:select', '2', null, '0');
INSERT INTO `t_menu` VALUES ('7', '2', '修改', null, 'sys:user:update,sys:role:select', '2', null, '0');
INSERT INTO `t_menu` VALUES ('8', '2', '删除', null, 'sys:user:delete', '2', null, '0');
INSERT INTO `t_menu` VALUES ('9', '3', '查看', null, 'sys:role:list,sys:role:info', '2', null, '0');
INSERT INTO `t_menu` VALUES ('10', '3', '新增', null, 'sys:role:save,sys:menu:perms', '2', null, '0');
INSERT INTO `t_menu` VALUES ('11', '3', '修改', null, 'sys:role:update,sys:menu:perms', '2', null, '0');
INSERT INTO `t_menu` VALUES ('12', '3', '删除', null, 'sys:role:delete', '2', null, '0');
INSERT INTO `t_menu` VALUES ('13', '4', '查看', null, 'sys:menu:list,sys:menu:info', '2', null, '0');
INSERT INTO `t_menu` VALUES ('14', '4', '新增', null, 'sys:menu:save,sys:menu:select', '2', null, '0');
INSERT INTO `t_menu` VALUES ('15', '4', '修改', null, 'sys:menu:update,sys:menu:select', '2', null, '0');
INSERT INTO `t_menu` VALUES ('16', '4', '删除', null, 'sys:menu:delete', '2', null, '0');
INSERT INTO `t_menu` VALUES ('17', '1', '参数管理', 'page/config/list.jsp', 'sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete', '1', 'fa fa-sun-o', '6');
INSERT INTO `t_menu` VALUES ('18', '1', '系统日志', 'page/log/list.jsp', 'sys:log:list', '1', 'fa fa-file-text-o', '7');
INSERT INTO `t_menu` VALUES ('20', '1', '地区管理', 'page/area/list.jsp', '', '1', 'fa fa-area-chart', '7');
INSERT INTO `t_menu` VALUES ('21', '20', '查看', null, 'area:list,area:info', '2', null, '6');
INSERT INTO `t_menu` VALUES ('22', '20', '新增', null, 'area:save', '2', null, '6');
INSERT INTO `t_menu` VALUES ('23', '20', '修改', null, 'area:update', '2', null, '6');
INSERT INTO `t_menu` VALUES ('24', '20', '删除', null, 'area:delete', '2', null, '6');
INSERT INTO `t_menu` VALUES ('81', '1', '字典管理', '/page/commpara/list.jsp', null, '1', 'fa fa-file-code-o', '6');
INSERT INTO `t_menu` VALUES ('82', '81', '查看', null, 'commpara:list,commpara:info', '2', null, '6');
INSERT INTO `t_menu` VALUES ('83', '81', '新增', null, 'commpara:save', '2', null, '6');
INSERT INTO `t_menu` VALUES ('84', '81', '修改', null, 'commpara:update', '2', null, '6');
INSERT INTO `t_menu` VALUES ('85', '81', '删除', null, 'commpara:delete', '2', null, '6');
INSERT INTO `t_menu` VALUES ('86', '1', '部门管理', '/page/organize/list.jsp', 'organize:list', '1', 'fa fa-users', '4');
INSERT INTO `t_menu` VALUES ('87', '86', '查看', null, 'organize:info', '2', null, '6');
INSERT INTO `t_menu` VALUES ('88', '86', '新增', null, 'organize:save', '2', null, '6');
INSERT INTO `t_menu` VALUES ('89', '86', '修改', null, 'organize:update', '2', null, '6');
INSERT INTO `t_menu` VALUES ('90', '86', '删除', null, 'organize:delete', '2', null, '6');
INSERT INTO `t_menu` VALUES ('208', '1', 'oss配置', '/page/sysoss/list.jsp', null, '1', 'fa fa-upload', '6');
INSERT INTO `t_menu` VALUES ('209', '208', '查看', null, 'sysoss:list,sysoss:info', '2', null, '6');
INSERT INTO `t_menu` VALUES ('210', '208', '新增', null, 'sysoss:save', '2', null, '6');
INSERT INTO `t_menu` VALUES ('211', '208', '修改', null, 'sysoss:update', '2', null, '6');
INSERT INTO `t_menu` VALUES ('212', '208', '删除', null, 'sysoss:delete', '2', null, '6');
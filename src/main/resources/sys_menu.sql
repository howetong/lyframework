/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : th_lyframework

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-09-04 20:57:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `delStatus` bit(1) NOT NULL,
  `description` longtext,
  `name` varchar(255) DEFAULT NULL,
  `sequence` int(11) DEFAULT '0',
  `status` bit(1) NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  `className` varchar(255) DEFAULT NULL,
  `iconCls` varchar(255) DEFAULT NULL,
  `createUser_id` bigint(20) DEFAULT NULL,
  `updateUser_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_4uki9lxglmei36tf7dcojbevf` (`code`),
  KEY `FK_5e2eucy5jfc3axjwyt0v98wpb` (`createUser_id`),
  KEY `FK_idvqk731b0ujdo1slyqut3qpp` (`updateUser_id`),
  KEY `FK_r32kmx154kjd3vnik1s363agi` (`parent_id`),
  CONSTRAINT `FK_5e2eucy5jfc3axjwyt0v98wpb` FOREIGN KEY (`createUser_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FK_idvqk731b0ujdo1slyqut3qpp` FOREIGN KEY (`updateUser_id`) REFERENCES `sys_user` (`id`),
  CONSTRAINT `FK_r32kmx154kjd3vnik1s363agi` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', null, null, '\0', null, '系统管理', '0', '\0', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('2', null, null, '\0', null, '用户管理', '0', '\0', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('3', null, null, '\0', null, '角色管理', '0', '\0', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('4', null, null, '\0', null, '菜单管理', '0', '\0', null, null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('5', null, null, '\0', null, '字典管理', '0', '\0', null, null, null, null, null, null);

/*
Navicat MySQL Data Transfer

Source Server         : con
Source Server Version : 50096
Source Host           : localhost:3307
Source Database       : umlhotelsysdb

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2015-05-27 16:30:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `tb_account`
-- ----------------------------
DROP TABLE IF EXISTS `tb_account`;
CREATE TABLE `tb_account` (
  `account_id` int(11) NOT NULL auto_increment,
  `account_user` varchar(255) default NULL,
  `account_name` varchar(255) default NULL,
  `account_password` varchar(255) default NULL,
  `account_authority` int(11) default NULL,
  `account_usable` bit(1) default b'1',
  PRIMARY KEY  (`account_id`),
  UNIQUE KEY `account_user_unique` (`account_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_account
-- ----------------------------
INSERT INTO `tb_account` VALUES ('1', 'account1', '普通管理员1', '123456', '1', '');
INSERT INTO `tb_account` VALUES ('2', 'account2', '普通管理员2', '123456', '1', '');
INSERT INTO `tb_account` VALUES ('3', 'admin', '超级管理员', '123456', '0', '');

-- ----------------------------
-- Table structure for `tb_good`
-- ----------------------------
DROP TABLE IF EXISTS `tb_good`;
CREATE TABLE `tb_good` (
  `good_id` int(11) NOT NULL auto_increment,
  `good_name` varchar(255) default NULL,
  `good_price` decimal(10,2) default NULL,
  `good_useable` int(1) NOT NULL default '1',
  PRIMARY KEY  (`good_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_good
-- ----------------------------
INSERT INTO `tb_good` VALUES ('1', '《软件工程概论》', '5.00', '1');
INSERT INTO `tb_good` VALUES ('2', '《计算机网络》', '6.00', '1');
INSERT INTO `tb_good` VALUES ('3', '《数据结构》', '2.00', '1');
INSERT INTO `tb_good` VALUES ('4', '《数据库》', '6.00', '1');

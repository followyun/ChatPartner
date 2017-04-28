/*
Navicat MySQL Data Transfer

Source Server         : autoReply
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : messages

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-04-28 19:04:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for command
-- ----------------------------
DROP TABLE IF EXISTS `command`;
CREATE TABLE `command` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(16) DEFAULT NULL,
  `DESCRIPTION` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of command
-- ----------------------------
INSERT INTO `command` VALUES ('1', '笑话', '冷笑话');
INSERT INTO `command` VALUES ('2', '天气', '气候');
INSERT INTO `command` VALUES ('5', '今日头条', '新闻');
INSERT INTO `command` VALUES ('6', '笨蛋', '喷人');
INSERT INTO `command` VALUES ('7', '喜欢', '行为');
INSERT INTO `command` VALUES ('8', '你大爷', '你大爷');
INSERT INTO `command` VALUES ('9', '考试', '考试');
INSERT INTO `command` VALUES ('10', '傻比', '傻比');

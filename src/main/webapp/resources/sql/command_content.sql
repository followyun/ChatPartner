/*
Navicat MySQL Data Transfer

Source Server         : autoReply
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : messages

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-04-28 19:04:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for command_content
-- ----------------------------
DROP TABLE IF EXISTS `command_content`;
CREATE TABLE `command_content` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(16) DEFAULT NULL,
  `CONTENT` varchar(2048) DEFAULT NULL,
  `COMMAND_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `command_content_ibfk_1` (`COMMAND_ID`),
  CONSTRAINT `command_content_ibfk_1` FOREIGN KEY (`COMMAND_ID`) REFERENCES `command` (`ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of command_content
-- ----------------------------
INSERT INTO `command_content` VALUES ('1', '朱川与猪穿', '我邻居家孩了名字叫朱川，他妈妈每次给他买衣服，都会跟人说这是给我们家朱川的…', '1');
INSERT INTO `command_content` VALUES ('2', '10块钱的价值', '以前10块钱能买好多东西 2盒大云3根火腿肠 一个剃须刀 现在别提了 全他妈安监控了', '1');
INSERT INTO `command_content` VALUES ('3', 'iphone的颜色', 'iphone7发布有段时间了，有人看到苹果发布7就喊着要是有人能送他就好了，什么我要白色，我要黑色，都什么心态!什么人呀，不会自己挣钱吗?有没有尊严和骨气，要是有人送我，我只想说5个字：颜色无所谓!', '1');
INSERT INTO `command_content` VALUES ('5', '成都', '天气雨转阴', '2');
INSERT INTO `command_content` VALUES ('6', '北京', '天气晴', '2');
INSERT INTO `command_content` VALUES ('13', '航母下水', '“辽宁”号航空母舰的服役成军以及第一艘中国自主建造的001A型航空母舰在昨日下水，让国人看到了人民海军日益强大的装备实力。此外，同时在上海江南造船厂和辽宁大连造船厂开工建造的新一代055大型导弹驱逐舰，更是将成为中国海军未来的绝对中坚力量。不过，在大型水面战舰的动力系统上，中国船舶工业还需要跨越大功率舰用核反应堆这个巅峰。', '5');
INSERT INTO `command_content` VALUES ('14', '笨蛋', '我是很笨哦，聪明的话就不跟你聊天了.', '6');
INSERT INTO `command_content` VALUES ('15', '喜欢', '我喜欢广交朋友~', '7');
INSERT INTO `command_content` VALUES ('16', '你大爷', '文明用语', '8');
INSERT INTO `command_content` VALUES ('17', '考试', '要认真考哦，我会为你加油，呵呵', '9');
INSERT INTO `command_content` VALUES ('18', '傻比', '叫什么叫。好像天下人不知道你是傻逼一样，还变着骂人', '10');

/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : ssh

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2017-05-14 11:26:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `adminPwd` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`adminId`),
  UNIQUE KEY `adminName` (`adminName`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptId` int(11) NOT NULL AUTO_INCREMENT,
  `deptName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '������');
INSERT INTO `dept` VALUES ('2', '���Բ�');
INSERT INTO `dept` VALUES ('3', '����');
INSERT INTO `dept` VALUES ('4', '���۲�');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `empId` int(11) NOT NULL AUTO_INCREMENT,
  `empName` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `salary` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `deptId` int(11) DEFAULT NULL,
  PRIMARY KEY (`empId`),
  KEY `FK4722E6AE8F10C137` (`deptId`),
  CONSTRAINT `FK4722E6AE8F10C137` FOREIGN KEY (`deptId`) REFERENCES `dept` (`deptId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '������', '10000', '1');
INSERT INTO `employee` VALUES ('2', '����', '9000', '2');
INSERT INTO `employee` VALUES ('3', '����', '7000', '3');
INSERT INTO `employee` VALUES ('4', '����', '6000', '4');

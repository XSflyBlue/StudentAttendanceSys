/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50712
Source Host           : localhost:3306
Source Database       : stuattendance

Target Server Type    : MYSQL
Target Server Version : 50712
File Encoding         : 65001

Date: 2016-06-23 21:40:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admininfo
-- ----------------------------
DROP TABLE IF EXISTS `admininfo`;
CREATE TABLE `admininfo` (
  `admin_id` int(11) NOT NULL,
  `admin_name` varchar(100) DEFAULT NULL,
  `admin_login_pwd` varchar(100) DEFAULT NULL,
  `admin_email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admininfo
-- ----------------------------

-- ----------------------------
-- Table structure for attendanceinfo
-- ----------------------------
DROP TABLE IF EXISTS `attendanceinfo`;
CREATE TABLE `attendanceinfo` (
  `attendance_id` int(11) NOT NULL AUTO_INCREMENT,
  `record_time` varchar(110) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`attendance_id`),
  KEY `fk_attendanceinfo_classinfo_1` (`class_id`),
  CONSTRAINT `fk_attendanceinfo_classinfo_1` FOREIGN KEY (`class_id`) REFERENCES `classinfo` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of attendanceinfo
-- ----------------------------
INSERT INTO `attendanceinfo` VALUES ('1', '2016-06-22 23:53:01', '1');
INSERT INTO `attendanceinfo` VALUES ('2', '2016-06-22 23:53:03', '1');
INSERT INTO `attendanceinfo` VALUES ('3', '2016-06-22 23:53:04', '1');
INSERT INTO `attendanceinfo` VALUES ('4', '2016-06-22 23:53:05', '1');
INSERT INTO `attendanceinfo` VALUES ('5', '2016-06-22 23:53:06', '1');
INSERT INTO `attendanceinfo` VALUES ('6', '2016-06-22 23:57:36', '1');
INSERT INTO `attendanceinfo` VALUES ('7', '2016-06-23 00:12:27', '1');
INSERT INTO `attendanceinfo` VALUES ('8', '2016-06-23 00:12:28', '1');
INSERT INTO `attendanceinfo` VALUES ('9', '2016-06-23 00:12:29', '1');
INSERT INTO `attendanceinfo` VALUES ('10', '2016-06-23 00:12:30', '1');
INSERT INTO `attendanceinfo` VALUES ('11', '2016-06-23 00:12:31', '1');
INSERT INTO `attendanceinfo` VALUES ('12', '2016-06-23 00:12:32', '1');
INSERT INTO `attendanceinfo` VALUES ('13', '2016-06-23 00:12:33', '1');
INSERT INTO `attendanceinfo` VALUES ('14', '2016-06-23 00:12:34', '1');
INSERT INTO `attendanceinfo` VALUES ('15', '2016-06-23 00:12:35', '1');
INSERT INTO `attendanceinfo` VALUES ('16', '2016-06-23 00:12:36', '1');
INSERT INTO `attendanceinfo` VALUES ('17', '2016-06-23 00:12:27', '1');
INSERT INTO `attendanceinfo` VALUES ('18', '2016-06-23 00:13:01', '1');
INSERT INTO `attendanceinfo` VALUES ('19', '2016-06-23 00:13:04', '1');
INSERT INTO `attendanceinfo` VALUES ('20', '2016-06-23 19:25:33', '1');

-- ----------------------------
-- Table structure for attendancerecord
-- ----------------------------
DROP TABLE IF EXISTS `attendancerecord`;
CREATE TABLE `attendancerecord` (
  `attendanceRecord_id` int(11) NOT NULL AUTO_INCREMENT,
  `attendance_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `attendance_status` varchar(100) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`attendanceRecord_id`),
  KEY `fk_attendancerecord_studentinfo_1` (`student_id`),
  KEY `fk_attendancerecord_attendanceinfo_2` (`attendance_id`),
  CONSTRAINT `fk_attendancerecord_attendanceinfo_2` FOREIGN KEY (`attendance_id`) REFERENCES `attendanceinfo` (`attendance_id`),
  CONSTRAINT `fk_attendancerecord_studentinfo_1` FOREIGN KEY (`student_id`) REFERENCES `studentinfo` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of attendancerecord
-- ----------------------------
INSERT INTO `attendancerecord` VALUES ('1', '1', '1', '迟到');
INSERT INTO `attendancerecord` VALUES ('2', '2', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('3', '4', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('4', '5', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('5', '6', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('6', '7', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('7', '8', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('8', '9', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('9', '10', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('10', '11', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('11', '12', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('12', '13', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('13', '14', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('14', '15', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('15', '16', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('16', '17', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('17', '18', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('18', '19', '1', '正常');
INSERT INTO `attendancerecord` VALUES ('19', '20', '1', '正常');

-- ----------------------------
-- Table structure for classinfo
-- ----------------------------
DROP TABLE IF EXISTS `classinfo`;
CREATE TABLE `classinfo` (
  `class_id` int(11) NOT NULL,
  `course_id` int(11) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `class_start_week` int(11) DEFAULT NULL,
  `class_end_week` int(11) DEFAULT NULL,
  `class_time` varchar(100) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `fk_classinfo_teacherinfo_1` (`teacher_id`),
  CONSTRAINT `fk_classinfo_teacherinfo_1` FOREIGN KEY (`teacher_id`) REFERENCES `teacherinfo` (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of classinfo
-- ----------------------------
INSERT INTO `classinfo` VALUES ('1', '1', 'java', '1', '16', '2016-3-12', '1');
INSERT INTO `classinfo` VALUES ('2', '2', '.net', '1', '16', '2016-3-12', '1');

-- ----------------------------
-- Table structure for classstudentinfo
-- ----------------------------
DROP TABLE IF EXISTS `classstudentinfo`;
CREATE TABLE `classstudentinfo` (
  `classStu_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`classStu_id`),
  KEY `fk_classstudentinfo_studentinfo_1` (`student_id`),
  KEY `fk_classstudentinfo_classinfo_1` (`class_id`),
  CONSTRAINT `fk_classstudentinfo_classinfo_1` FOREIGN KEY (`class_id`) REFERENCES `classinfo` (`class_id`),
  CONSTRAINT `fk_classstudentinfo_studentinfo_1` FOREIGN KEY (`student_id`) REFERENCES `studentinfo` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of classstudentinfo
-- ----------------------------
INSERT INTO `classstudentinfo` VALUES ('1', '1', '1');
INSERT INTO `classstudentinfo` VALUES ('2', '2', '2');
INSERT INTO `classstudentinfo` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for collegeinfo
-- ----------------------------
DROP TABLE IF EXISTS `collegeinfo`;
CREATE TABLE `collegeinfo` (
  `college_name` varchar(100) NOT NULL,
  `college_address` varchar(100) DEFAULT NULL,
  `college_contact` varchar(100) DEFAULT NULL,
  `college_tel` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`college_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of collegeinfo
-- ----------------------------
INSERT INTO `collegeinfo` VALUES ('软件学院', null, null, null);

-- ----------------------------
-- Table structure for facultyinfo
-- ----------------------------
DROP TABLE IF EXISTS `facultyinfo`;
CREATE TABLE `facultyinfo` (
  `faculty_name` varchar(100) NOT NULL,
  `faculty_address` varchar(100) DEFAULT NULL,
  `faculty_contact` varchar(100) DEFAULT NULL,
  `faculty_tel` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`faculty_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of facultyinfo
-- ----------------------------
INSERT INTO `facultyinfo` VALUES ('a室', null, null, null);
INSERT INTO `facultyinfo` VALUES ('b室', null, null, null);
INSERT INTO `facultyinfo` VALUES ('c室', null, null, null);
INSERT INTO `facultyinfo` VALUES ('d室', null, null, null);

-- ----------------------------
-- Table structure for studentinfo
-- ----------------------------
DROP TABLE IF EXISTS `studentinfo`;
CREATE TABLE `studentinfo` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(100) DEFAULT NULL,
  `student_login_pwd` varchar(100) DEFAULT NULL,
  `student_college` varchar(100) DEFAULT NULL,
  `student_major` varchar(100) DEFAULT NULL,
  `student_email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `fk_studentinfo_collegeinfo_1` (`student_college`),
  CONSTRAINT `fk_studentinfo_collegeinfo_1` FOREIGN KEY (`student_college`) REFERENCES `collegeinfo` (`college_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of studentinfo
-- ----------------------------
INSERT INTO `studentinfo` VALUES ('1', '小松', '555', '软件学院', '软件', '1@qq.com');
INSERT INTO `studentinfo` VALUES ('2', '猪', '123', '软件学院', '日语+软件', '2@qq.com');
INSERT INTO `studentinfo` VALUES ('3', '吴大神', '123', '软件学院', '英语+软件', '3@qq.com');

-- ----------------------------
-- Table structure for teacherinfo
-- ----------------------------
DROP TABLE IF EXISTS `teacherinfo`;
CREATE TABLE `teacherinfo` (
  `teacher_id` int(11) NOT NULL,
  `teacher_name` varchar(100) DEFAULT NULL,
  `teacher_login_pwd` varchar(100) DEFAULT NULL,
  `teacher_email` varchar(100) DEFAULT NULL,
  `college_name` varchar(100) DEFAULT NULL,
  `faculty_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `fk_teacherinfo_collegeinfo_1` (`college_name`),
  KEY `fk_teacherinfo_facultyinfo_1` (`faculty_name`),
  CONSTRAINT `fk_teacherinfo_collegeinfo_1` FOREIGN KEY (`college_name`) REFERENCES `collegeinfo` (`college_name`),
  CONSTRAINT `fk_teacherinfo_facultyinfo_1` FOREIGN KEY (`faculty_name`) REFERENCES `facultyinfo` (`faculty_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of teacherinfo
-- ----------------------------
INSERT INTO `teacherinfo` VALUES ('1', '哈哈', '555', 'a@qq.com', '软件学院', 'c室');

/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : otabook

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-06-22 16:58:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(10) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `code` varchar(250) DEFAULT NULL,
  `score` varchar(50) DEFAULT NULL,
  `grade` varchar(250) DEFAULT NULL COMMENT '年级',
  `clazz` varchar(250) DEFAULT NULL COMMENT '班级',
  `profession` varchar(250) DEFAULT NULL COMMENT '专业',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('22', '1', 'java开发', '123214', '50005', '高三', '一班', '计算机科学', null, null, '0');
INSERT INTO `t_course` VALUES ('24', '2', '测试课程', '124', '42', '12412', '214', '124', null, null, '0');
INSERT INTO `t_course` VALUES ('25', '4', 'web开发', 'web', '500', 'gaosan', '124', '12', '2018-06-20 16:23:52', '2018-06-20 16:23:52', '0');
INSERT INTO `t_course` VALUES ('26', '4', '计算机科学', '124', '512', '15', '125', '512', '2018-06-20 16:35:26', '2018-06-20 16:35:26', '0');

-- ----------------------------
-- Table structure for t_course_student
-- ----------------------------
DROP TABLE IF EXISTS `t_course_student`;
CREATE TABLE `t_course_student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `student_id` int(10) DEFAULT NULL COMMENT '用户id',
  `course_id` int(10) DEFAULT NULL COMMENT '角色id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_course_student
-- ----------------------------
INSERT INTO `t_course_student` VALUES ('1', '18', '22', null, null, '0');
INSERT INTO `t_course_student` VALUES ('2', '4', '22', null, null, '0');
INSERT INTO `t_course_student` VALUES ('59', '18', '26', null, null, '0');
INSERT INTO `t_course_student` VALUES ('60', '20', '26', null, null, '0');
INSERT INTO `t_course_student` VALUES ('61', '19', '26', null, null, '0');
INSERT INTO `t_course_student` VALUES ('62', '18', '25', null, null, '0');
INSERT INTO `t_course_student` VALUES ('63', '20', '25', null, null, '0');
INSERT INTO `t_course_student` VALUES ('64', '19', '25', null, null, '0');

-- ----------------------------
-- Table structure for t_course_work
-- ----------------------------
DROP TABLE IF EXISTS `t_course_work`;
CREATE TABLE `t_course_work` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_id` int(10) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `score` varchar(50) DEFAULT NULL COMMENT '分数',
  `file_id` varchar(250) DEFAULT NULL COMMENT '作业文件',
  `date_limit` datetime DEFAULT NULL COMMENT '日期限制',
  `state` varchar(1) DEFAULT NULL COMMENT '状态（0：未发布，1：已发布）',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of t_course_work
-- ----------------------------
INSERT INTO `t_course_work` VALUES ('34', '25', '循环算法', '20', '128', '2018-06-30 00:00:00', '1', '2018-06-21 19:50:09', '2018-06-22 14:46:20', '0');
INSERT INTO `t_course_work` VALUES ('39', '25', '测试123', '21', '132', '2018-06-30 00:00:00', '1', '2018-06-21 20:10:27', '2018-06-22 14:48:52', '0');
INSERT INTO `t_course_work` VALUES ('40', '25', '算法分析', '212', '133', '2018-06-21 00:00:00', null, '2018-06-21 20:12:57', '2018-06-21 20:12:57', '0');
INSERT INTO `t_course_work` VALUES ('41', '26', '计算机', '12', '141', '2018-06-30 00:00:00', null, '2018-06-22 14:22:47', '2018-06-22 14:22:47', '0');

-- ----------------------------
-- Table structure for t_course_work_student
-- ----------------------------
DROP TABLE IF EXISTS `t_course_work_student`;
CREATE TABLE `t_course_work_student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `work_id` int(10) DEFAULT NULL COMMENT '作业id',
  `student_id` int(10) DEFAULT NULL COMMENT '学生id',
  `submit_file_id` int(10) DEFAULT NULL COMMENT '提交作业的id',
  `checked_file_id` int(10) DEFAULT NULL COMMENT '批改作业id',
  `date_submit` datetime DEFAULT NULL,
  `date_checked` datetime DEFAULT NULL,
  `score` varchar(50) DEFAULT NULL COMMENT '分数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of t_course_work_student
-- ----------------------------
INSERT INTO `t_course_work_student` VALUES ('34', '34', '18', '134', '139', '2018-06-22 09:21:45', '2018-06-22 14:07:42', '15', null, '2018-06-22 14:09:10', '0');
INSERT INTO `t_course_work_student` VALUES ('35', '39', '18', '135', '140', '2018-06-22 09:54:48', '2018-06-22 14:12:10', '10', null, '2018-06-22 14:12:10', '0');
INSERT INTO `t_course_work_student` VALUES ('36', '34', '19', '136', null, '2018-06-22 10:39:12', null, null, null, null, '0');
INSERT INTO `t_course_work_student` VALUES ('37', '41', '18', '142', null, '2018-06-22 14:23:08', null, null, null, null, '0');

-- ----------------------------
-- Table structure for t_data_file
-- ----------------------------
DROP TABLE IF EXISTS `t_data_file`;
CREATE TABLE `t_data_file` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `info_id` varchar(64) DEFAULT NULL COMMENT '信息id',
  `name` varchar(256) DEFAULT NULL COMMENT '文件名',
  `size` bigint(128) DEFAULT NULL COMMENT '文件尺寸',
  `path` varchar(512) DEFAULT NULL COMMENT '路径',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `keyword` varchar(32) DEFAULT NULL COMMENT '关键字',
  `suffix` varchar(32) DEFAULT NULL COMMENT '后缀名',
  `sort` int(16) DEFAULT NULL COMMENT '排序',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_data_file
-- ----------------------------
INSERT INTO `t_data_file` VALUES ('128', '34', '28168.xlsx', '101719', '/file/image/2018/6/21/1529581834561HOkvv.xlsx', 'file', 'courseWorkFiles', null, null, null, '2018-06-21 19:50:36', null);
INSERT INTO `t_data_file` VALUES ('132', '39', '005BkNw7gy1fm8bgdo1qmj30ci08cq43.jpg', '26022', '/file/file/2018/6/21/1529583015488aYuVK.jpg', 'file', 'courseWorkFiles', null, null, null, '2018-06-21 20:10:28', null);
INSERT INTO `t_data_file` VALUES ('133', '40', '11月工作总结（雷爽）.docx', '13179', '/file/file/2018/6/21/1529583167888oLKgv.docx', 'file', 'courseWorkFiles', null, null, null, '2018-06-21 20:12:57', null);
INSERT INTO `t_data_file` VALUES ('134', '34', '28168.xlsx', '101719', '/file/file/2018/6/22/1529630090303SolAZ.xlsx', 'file', 'courseWorkStudentSubmitFiles', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('135', '35', 'QQ图片20180206104413.png', '12641', '/file/file/2018/6/22/1529632486628KQZeH.png', 'file', 'courseWorkStudentSubmitFiles', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('136', '36', '11月工作总结（雷爽）.docx', '13179', '/file/file/2018/6/22/1529635151006hmOtf.docx', 'file', 'courseWorkStudentSubmitFiles', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('137', null, '28168.xlsx', '101719', '/file/file/2018/6/22/1529647315632KrmDp.xlsx', 'file', 'courseWorkStudentCheckedFiles', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('138', '34', 'idea破解.txt', '363', '/file/file/2018/6/22/1529647519530Nyice.txt', 'file', 'courseWorkStudentCheckedFiles', null, null, null, '2018-06-22 14:05:38', null);
INSERT INTO `t_data_file` VALUES ('139', '34', '28168.xlsx', '101719', '/file/file/2018/6/22/1529647657230ypGnj.xlsx', 'file', 'courseWorkStudentCheckedFiles', null, null, null, '2018-06-22 14:07:44', null);
INSERT INTO `t_data_file` VALUES ('140', '35', 'chiji.pdf', '73380', '/file/file/2018/6/22/1529647925920QNsPK.pdf', 'file', 'courseWorkStudentCheckedFiles', null, null, null, '2018-06-22 14:12:10', null);
INSERT INTO `t_data_file` VALUES ('141', '41', 'chiji.pdf', '73380', '/file/file/2018/6/22/1529648556945mbmAu.pdf', 'file', 'courseWorkFiles', null, null, null, '2018-06-22 14:22:47', null);
INSERT INTO `t_data_file` VALUES ('142', '37', '005BkNw7gy1fm8bgdo1qmj30ci08cq43.jpg', '26022', '/file/file/2018/6/22/1529648587197MFast.jpg', 'file', 'courseWorkStudentSubmitFiles', null, null, null, null, null);

-- ----------------------------
-- Table structure for t_demo
-- ----------------------------
DROP TABLE IF EXISTS `t_demo`;
CREATE TABLE `t_demo` (
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_demo
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_permit
-- ----------------------------
DROP TABLE IF EXISTS `t_system_permit`;
CREATE TABLE `t_system_permit` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL COMMENT '名称',
  `type` varchar(128) DEFAULT NULL COMMENT '类型',
  `permission` varchar(255) DEFAULT NULL COMMENT '权限字符串',
  `url` varchar(128) DEFAULT NULL COMMENT '地址',
  `parentId` int(10) DEFAULT NULL COMMENT '父级id',
  `parentIds` varchar(255) DEFAULT NULL COMMENT '父级id集合',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可用',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `del_flag` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_permit
-- ----------------------------
INSERT INTO `t_system_permit` VALUES ('1', '用户管理', 'menu', 'user', '/user', '10', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('5', '角色管理', 'menu', 'role', '/role', '10', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('7', '权限配置', 'menu', 'permit', '/permit', '10', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('10', '系统管理', 'menu', 'system', '/system', '0', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('17', '课程管理', 'menu', 'course', '/course', '0', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('26', '我的课程', 'menu', 'student', '/student', '0', null, '1', '2018-06-21 13:56:13', '2018-06-21 14:05:48', null);

-- ----------------------------
-- Table structure for t_system_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_system_resource`;
CREATE TABLE `t_system_resource` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL COMMENT '资源名',
  `type` varchar(32) DEFAULT NULL COMMENT '资源类型',
  `sort` int(10) DEFAULT NULL COMMENT '排序',
  `parent_id` int(10) DEFAULT NULL COMMENT '父级id',
  `parent_ids` varchar(100) DEFAULT NULL COMMENT '父级id列表',
  `permission` varchar(128) DEFAULT NULL COMMENT '权限字符串',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可用',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名',
  `role_type` varchar(64) DEFAULT NULL COMMENT '角色类型',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否可用',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_role
-- ----------------------------
INSERT INTO `t_system_role` VALUES ('1', '超级管理员', 'admin', '1', '系统超级管理员', null, null, null);
INSERT INTO `t_system_role` VALUES ('2', '教师', 'CUSTOM', '1', '教师', null, '2018-06-20 16:05:15', null);
INSERT INTO `t_system_role` VALUES ('3', '学生', 'CUSTOM', '1', '学生', null, '2018-06-21 18:37:31', '0');

-- ----------------------------
-- Table structure for t_system_role_permit
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role_permit`;
CREATE TABLE `t_system_role_permit` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) DEFAULT NULL,
  `permit_id` int(10) DEFAULT NULL COMMENT '权限id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_role_permit
-- ----------------------------
INSERT INTO `t_system_role_permit` VALUES ('97', '4', '10', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('98', '4', '5', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('99', '4', '7', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('100', '4', '21', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('101', '4', '22', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('102', '1', '10', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('103', '1', '1', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('104', '1', '5', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('105', '1', '7', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('106', '1', '8', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('107', '1', '9', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('108', '1', '15', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('109', '1', '16', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('110', '1', '17', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('111', '1', '23', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('112', '1', '24', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('113', '1', '18', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('114', '1', '19', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('115', '1', '20', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('116', '1', '21', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('117', '1', '22', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('118', '1', '25', '2018-02-05 09:43:40', '2018-02-05 09:43:40', '0');
INSERT INTO `t_system_role_permit` VALUES ('124', '2', '17', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('127', '3', '26', null, null, '0');

-- ----------------------------
-- Table structure for t_system_user
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user`;
CREATE TABLE `t_system_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `workid` varchar(100) DEFAULT NULL COMMENT '学号/工号',
  `grade` varchar(100) DEFAULT NULL COMMENT '年级',
  `clazz` varchar(100) DEFAULT NULL COMMENT '班级',
  `profession` varchar(100) DEFAULT NULL COMMENT '专业',
  `avatar` varchar(256) DEFAULT NULL COMMENT '头像',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `user_name` varchar(64) DEFAULT NULL COMMENT '登录名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `locked` tinyint(1) DEFAULT NULL COMMENT '锁定',
  `phone` varchar(16) DEFAULT NULL COMMENT '人员联系电话',
  `mail` varchar(128) DEFAULT NULL COMMENT '人员邮箱',
  `sex` varchar(1) DEFAULT NULL COMMENT '性别（M 男， F 女）',
  `job_title` varchar(500) DEFAULT NULL COMMENT '职称',
  `role` varchar(2) DEFAULT NULL COMMENT '角色',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_user
-- ----------------------------
INSERT INTO `t_system_user` VALUES ('1', null, null, null, null, null, '管理员', 'admin', '111111', '0', '18523644834', null, null, null, null, null, null, null);
INSERT INTO `t_system_user` VALUES ('4', 'tech001', '', '', '', null, '王老师', 'tech001', '111111', '0', null, null, null, '', null, null, null, null);
INSERT INTO `t_system_user` VALUES ('18', '201306601121', '高三', '一班', '软件服务外包', null, '邹朝亮', '201306601121', '111111', '0', null, null, null, '', null, null, '2018-06-21 14:02:21', '0');
INSERT INTO `t_system_user` VALUES ('19', '201306601102', '高三', '一班', '软件服务外包', null, '张伟', '201306601102', '111111', '0', null, null, null, '', null, '2018-06-21 11:12:39', '2018-06-21 11:12:39', '0');
INSERT INTO `t_system_user` VALUES ('20', '201306601103', '高三', '一班', '软件服务外包', null, '李宜书', '201306601103', '111111', '0', null, null, null, '', null, '2018-06-21 11:13:18', '2018-06-21 11:13:18', '0');
INSERT INTO `t_system_user` VALUES ('21', '201306601104', '高三', '一班', '软件服务外包', null, '邹琪', '201306601104', '111111', '0', null, null, null, '', null, '2018-06-21 11:14:05', '2018-06-21 11:14:05', '0');
INSERT INTO `t_system_user` VALUES ('22', 'tech002', '', '', '', null, '张老师', 'tech002', '111111', '0', null, null, null, '教授', null, '2018-06-21 11:16:36', '2018-06-21 11:16:36', '0');

-- ----------------------------
-- Table structure for t_system_user_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_user_role`;
CREATE TABLE `t_system_user_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `role_id` int(10) DEFAULT NULL COMMENT '角色id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_user_role
-- ----------------------------
INSERT INTO `t_system_user_role` VALUES ('1', '4', '2', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('2', '1', '1', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('49', '19', '3', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('50', '20', '3', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('51', '21', '3', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('54', '22', '2', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('55', '18', '3', null, null, '0');

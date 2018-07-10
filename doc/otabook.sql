/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50720
Source Host           : 127.0.0.1:3306
Source Database       : otabook

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-07-10 17:36:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_chat
-- ----------------------------
DROP TABLE IF EXISTS `t_chat`;
CREATE TABLE `t_chat` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `sender` int(10) DEFAULT NULL COMMENT '发送人',
  `receiver` int(10) DEFAULT NULL COMMENT '接收人',
  `content` varchar(500) DEFAULT NULL COMMENT '消息内容',
  `is_reading` varchar(1) DEFAULT NULL COMMENT '是否阅读过',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='聊天表';

-- ----------------------------
-- Records of t_chat
-- ----------------------------
INSERT INTO `t_chat` VALUES ('28', '18', '19', '踩踩踩踩踩', '1', '2018-07-05 17:52:49', '2018-07-05 17:52:49', '0');
INSERT INTO `t_chat` VALUES ('29', '18', '19', '你说你是不是啥子', '1', '2018-07-05 18:52:02', '2018-07-05 18:52:02', '0');
INSERT INTO `t_chat` VALUES ('31', '18', '19', 'adsg kas;dgk asdg ', '1', '2018-07-05 19:00:48', '2018-07-05 19:00:48', '0');
INSERT INTO `t_chat` VALUES ('32', '18', '19', 'asdg阿桑的歌阿斯顿', '1', '2018-07-05 19:03:46', '2018-07-05 19:03:46', '0');
INSERT INTO `t_chat` VALUES ('33', '19', '18', '你才是傻逼', '1', '2018-07-05 19:06:31', '2018-07-05 19:06:31', '0');
INSERT INTO `t_chat` VALUES ('34', '19', '18', '你才是傻逼啦啦啦啦啦阿桑的歌阿斯顿嘎斯肯定更好就按时到货按时到货埃里克森电话氨基酸电话ask接基酸电话ask接电话就爱上了空间很大就按时到货按时交货的阿加莎圣诞节快乐和卡深度哈但是阿斯顿电话就爱上了空间很大就按时到货按时交货的阿加莎圣诞节快乐和卡深度哈但是阿斯顿', '1', '2018-07-05 19:06:44', '2018-07-05 19:06:44', '0');
INSERT INTO `t_chat` VALUES ('35', '18', '19', '知道了 ', '1', '2018-07-05 19:07:17', '2018-07-05 19:07:17', '0');
INSERT INTO `t_chat` VALUES ('36', '18', '19', '知道了啊啊啊', '1', '2018-07-05 19:09:24', '2018-07-05 19:09:24', '0');
INSERT INTO `t_chat` VALUES ('37', '18', '19', '啦啦啦顶顶顶', '1', '2018-07-05 19:11:55', '2018-07-05 19:11:55', '0');
INSERT INTO `t_chat` VALUES ('38', '19', '18', '卧槽，你是不是傻', '1', '2018-07-05 19:12:26', '2018-07-05 19:12:26', '0');
INSERT INTO `t_chat` VALUES ('39', '19', '18', '知道问题所在了', '1', '2018-07-05 19:15:38', '2018-07-05 19:15:38', '0');
INSERT INTO `t_chat` VALUES ('40', '18', '19', 'zhidaojiuxing', '1', '2018-07-05 19:19:21', '2018-07-05 19:19:21', '0');
INSERT INTO `t_chat` VALUES ('41', '18', '19', 'zhidao asdg', '1', '2018-07-05 20:00:43', '2018-07-05 20:00:43', '0');
INSERT INTO `t_chat` VALUES ('42', '18', '20', 'hi hello!', '1', '2018-07-05 20:02:51', '2018-07-05 20:02:51', '0');
INSERT INTO `t_chat` VALUES ('43', '18', '20', '你好呀，我叫邹朝亮', '1', '2018-07-05 20:11:32', '2018-07-05 20:11:32', '0');
INSERT INTO `t_chat` VALUES ('44', '18', '20', '你好呀，我叫邹朝亮能认识一下你吗，交个朋友', '1', '2018-07-05 20:11:46', '2018-07-05 20:11:46', '0');
INSERT INTO `t_chat` VALUES ('45', '19', '18', 'asd啊大哥阿斯顿', '1', '2018-07-05 20:21:29', '2018-07-05 20:21:32', '0');
INSERT INTO `t_chat` VALUES ('46', '19', '18', '哈哈哈哈，追不到我把', '1', '2018-07-05 20:29:21', '2018-07-05 20:29:21', '0');
INSERT INTO `t_chat` VALUES ('47', '18', '19', '才怪', '1', '2018-07-05 20:29:34', '2018-07-05 20:29:34', '0');
INSERT INTO `t_chat` VALUES ('48', '20', '18', '你好呀，我叫里艺术', '1', '2018-07-06 09:23:26', '2018-07-06 09:23:26', '0');
INSERT INTO `t_chat` VALUES ('49', '20', '18', '什么时候有空来坐坐', '1', '2018-07-06 09:27:35', '2018-07-06 09:27:35', '0');
INSERT INTO `t_chat` VALUES ('50', '18', '20', '可以呀，你什么时候有空', '1', '2018-07-06 09:27:50', '2018-07-06 09:27:50', '0');
INSERT INTO `t_chat` VALUES ('51', '20', '18', '周六周天都行把', '1', '2018-07-06 09:28:06', '2018-07-06 09:28:06', '0');
INSERT INTO `t_chat` VALUES ('52', '18', '20', '那还哦呀，我要去接人', '1', '2018-07-06 09:28:23', '2018-07-06 09:28:23', '0');
INSERT INTO `t_chat` VALUES ('53', '20', '18', '那行，那就这样顶了', '1', '2018-07-06 09:28:41', '2018-07-06 09:28:41', '0');
INSERT INTO `t_chat` VALUES ('54', '18', '20', '好的，没问题', '1', '2018-07-06 09:28:50', '2018-07-06 09:28:50', '0');
INSERT INTO `t_chat` VALUES ('55', '20', '18', '那行，那就这样顶了', '1', '2018-07-06 09:29:57', '2018-07-06 09:29:57', '0');
INSERT INTO `t_chat` VALUES ('56', '20', '18', '黑，girel', '1', '2018-07-06 09:34:54', '2018-07-06 09:34:54', '0');
INSERT INTO `t_chat` VALUES ('57', '18', '20', '啦啦啦', '1', '2018-07-06 09:37:26', '2018-07-06 09:37:26', '0');
INSERT INTO `t_chat` VALUES ('58', '18', '20', '啦啦啦爱国', '1', '2018-07-06 09:39:08', '2018-07-06 09:39:08', '0');
INSERT INTO `t_chat` VALUES ('59', '20', '18', '黑，girelsdfh ', '1', '2018-07-06 09:40:04', '2018-07-06 09:40:04', '0');
INSERT INTO `t_chat` VALUES ('60', '18', '4', '张老师你好', '1', '2018-07-06 09:40:35', '2018-07-06 09:40:35', '0');
INSERT INTO `t_chat` VALUES ('61', '20', '18', '黑，girelsdfh adsg agd', '1', '2018-07-06 09:41:06', '2018-07-06 09:41:06', '0');
INSERT INTO `t_chat` VALUES ('62', '20', '18', '黑，girelsdfh adsg agdash的撒个', '1', '2018-07-06 09:41:27', '2018-07-06 09:41:27', '0');
INSERT INTO `t_chat` VALUES ('63', '20', '18', '黑，girelsdfh adsg agdash的撒个阿桑的歌', '1', '2018-07-06 09:41:38', '2018-07-06 09:41:38', '0');
INSERT INTO `t_chat` VALUES ('64', '20', '18', '1111', '1', '2018-07-06 09:41:40', '2018-07-06 09:41:40', '0');
INSERT INTO `t_chat` VALUES ('65', '20', '18', '1111222', '1', '2018-07-06 09:41:42', '2018-07-06 09:41:42', '0');
INSERT INTO `t_chat` VALUES ('66', '18', '20', '阿斯顿噶', '1', '2018-07-06 09:42:23', '2018-07-06 09:42:23', '0');
INSERT INTO `t_chat` VALUES ('67', '18', '20', '阿斯顿噶', '1', '2018-07-06 09:42:29', '2018-07-06 09:42:29', '0');
INSERT INTO `t_chat` VALUES ('68', '20', '18', '阿斯加德', '1', '2018-07-06 09:53:05', '2018-07-06 09:53:05', '0');

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
  `detail_info` varchar(1500) DEFAULT NULL COMMENT '课程介绍',
  `grade` varchar(250) DEFAULT NULL COMMENT '年级',
  `clazz` varchar(250) DEFAULT NULL COMMENT '班级',
  `profession` varchar(250) DEFAULT NULL COMMENT '专业',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='课程表';

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES ('25', '4', 'java开发', 'java', '5', 'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念，因此Java语言具有功能强大和简单易用两个特征。Java语言作为静态面向对象编程语言的代表，极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程。', '大一', '一班', '软件服务外包', '2018-06-20 16:23:52', '2018-07-04 11:52:10', '0');
INSERT INTO `t_course` VALUES ('26', '4', '算法分析', '124', '512', '算法分析是对一个算法需要多少计算时间和存储空间作定量的分析。 算法（Algorithm）是解题的步骤，可以把算法定义成解一确定类问题的任意一种特殊的方法。在计算机科学中，算法要用计算机算法语言描述，算法代表用计算机解一类问题的精确、有效的方法。', '15', '125', '512', '2018-06-20 16:35:26', '2018-07-04 11:52:46', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='课程学生表';

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
-- Table structure for t_course_video
-- ----------------------------
DROP TABLE IF EXISTS `t_course_video`;
CREATE TABLE `t_course_video` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_id` int(10) DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `detail_info` varchar(1500) DEFAULT NULL,
  `head_img_file_id` varchar(250) DEFAULT NULL COMMENT '标题图片文件',
  `file_id` varchar(250) DEFAULT NULL COMMENT '视频文件',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8 COMMENT='课程视频表';

-- ----------------------------
-- Records of t_course_video
-- ----------------------------
INSERT INTO `t_course_video` VALUES ('43', '25', 'java基础', 'java基础是学习java的开端，就如同建楼房的地基一样，有了扎实的基础才能够完成好的作品。', '179', '173', '2018-07-02 11:24:30', '2018-07-04 11:55:29', '0');
INSERT INTO `t_course_video` VALUES ('44', '25', 'java web开发', 'java Web，是用Java技术来解决相关web互联网领域的技术总和。web包括：web服务器和web客户端两部分。Java在客户端的应用有java applet，不过使用得很少，Java在服务器端的应用非常的丰富，比如Servlet，JSP和第三方框架等等。Java技术对Web领域的发展注入了强大的动力。', '178', '176', '2018-07-02 15:14:44', '2018-07-04 13:03:05', '0');
INSERT INTO `t_course_video` VALUES ('45', '25', '计算机组成原理', '系统地介绍了计算机的基本组成原理和内部工作机制。', '180', '181', '2018-07-03 19:48:52', '2018-07-04 11:56:24', '0');

-- ----------------------------
-- Table structure for t_course_video_question
-- ----------------------------
DROP TABLE IF EXISTS `t_course_video_question`;
CREATE TABLE `t_course_video_question` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `video_id` int(10) DEFAULT NULL,
  `alert_time` int(10) DEFAULT NULL COMMENT '问题弹出时间',
  `question` varchar(256) DEFAULT NULL COMMENT '问题',
  `answer` varchar(250) DEFAULT NULL COMMENT '答案',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='课程视频问题表';

-- ----------------------------
-- Records of t_course_video_question
-- ----------------------------
INSERT INTO `t_course_video_question` VALUES ('60', '43', '11', 'java是不是语言', '1', null, null, null);
INSERT INTO `t_course_video_question` VALUES ('61', '43', '50', '静态方法是什么', '1', null, null, null);
INSERT INTO `t_course_video_question` VALUES ('63', '45', '15', '二进制有数字3', '0', null, null, null);
INSERT INTO `t_course_video_question` VALUES ('64', '45', '45', '计算机组成原理是一本很好的书', '1', null, null, null);
INSERT INTO `t_course_video_question` VALUES ('65', '44', '5', 'struts2是一门语言吗', '0', null, null, null);
INSERT INTO `t_course_video_question` VALUES ('66', '46', '16', '阿斯顿噶', '0', null, null, null);

-- ----------------------------
-- Table structure for t_course_video_student
-- ----------------------------
DROP TABLE IF EXISTS `t_course_video_student`;
CREATE TABLE `t_course_video_student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `video_id` int(10) DEFAULT NULL COMMENT '视频d',
  `student_id` int(10) DEFAULT NULL COMMENT '学生id',
  `progress` int(10) DEFAULT NULL COMMENT '观看进度',
  `latest_watched` int(10) DEFAULT NULL COMMENT '上一次观看时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8 COMMENT='学生观看视频进度';

-- ----------------------------
-- Records of t_course_video_student
-- ----------------------------
INSERT INTO `t_course_video_student` VALUES ('38', '43', '18', '100', '180', '2018-07-03 17:16:54', '2018-07-03 18:54:29', '0');
INSERT INTO `t_course_video_student` VALUES ('41', '44', '18', '35', '120', '2018-07-03 18:58:31', '2018-07-04 13:02:03', '0');
INSERT INTO `t_course_video_student` VALUES ('42', '45', '18', '5', '30', '2018-07-04 13:03:43', '2018-07-04 13:03:43', '0');
INSERT INTO `t_course_video_student` VALUES ('43', '43', '19', '5', '30', '2018-07-04 13:09:04', '2018-07-04 13:09:04', '0');
INSERT INTO `t_course_video_student` VALUES ('44', '44', '19', '8', '30', '2018-07-04 13:10:24', '2018-07-04 13:10:47', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='课程作业表';

-- ----------------------------
-- Records of t_course_work
-- ----------------------------
INSERT INTO `t_course_work` VALUES ('34', '25', '循环算法', '20', '128', '2018-06-30 00:00:00', '1', '2018-06-21 19:50:09', '2018-06-22 14:46:20', '0');
INSERT INTO `t_course_work` VALUES ('39', '25', '测试123', '21', '132', '2018-06-30 00:00:00', '1', '2018-06-21 20:10:27', '2018-06-22 14:48:52', '0');
INSERT INTO `t_course_work` VALUES ('40', '25', '算法分析', '212', '133', '2018-06-21 00:00:00', '1', '2018-06-21 20:12:57', '2018-06-26 11:43:35', '0');
INSERT INTO `t_course_work` VALUES ('41', '26', '计算机', '12', '141', '2018-06-30 00:00:00', '1', '2018-06-22 14:22:47', '2018-06-26 11:45:25', '0');
INSERT INTO `t_course_work` VALUES ('42', '25', '递归算法', '10', '182', '2018-07-29 00:00:00', '1', '2018-07-04 13:05:34', '2018-07-04 13:05:57', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COMMENT='学生完成作业表';

-- ----------------------------
-- Records of t_course_work_student
-- ----------------------------
INSERT INTO `t_course_work_student` VALUES ('34', '34', '18', '134', '139', '2018-06-22 09:21:45', '2018-06-22 14:07:42', '15', null, '2018-06-22 14:09:10', '0');
INSERT INTO `t_course_work_student` VALUES ('35', '39', '18', '135', '144', '2018-06-22 09:54:48', '2018-06-26 11:10:23', '10', null, '2018-06-26 11:10:23', '0');
INSERT INTO `t_course_work_student` VALUES ('36', '34', '19', '136', '146', '2018-06-22 10:39:12', '2018-06-26 11:11:41', '', null, '2018-06-26 11:11:41', '0');
INSERT INTO `t_course_work_student` VALUES ('37', '41', '18', '142', null, '2018-06-22 14:23:08', null, null, null, null, '0');
INSERT INTO `t_course_work_student` VALUES ('38', '42', '18', '184', '185', '2018-07-04 13:06:27', '2018-07-04 13:07:38', '9', null, '2018-07-04 13:07:38', '0');
INSERT INTO `t_course_work_student` VALUES ('39', '42', '19', '186', null, '2018-07-04 13:08:23', null, null, null, null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8;

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
INSERT INTO `t_data_file` VALUES ('141', '41', 'chiji.pdf', '73380', '/file/file/2018/6/22/1529648556945mbmAu.pdf', 'file', 'courseWorkFiles', null, null, null, '2018-06-22 14:22:47', null);
INSERT INTO `t_data_file` VALUES ('142', '37', '005BkNw7gy1fm8bgdo1qmj30ci08cq43.jpg', '26022', '/file/file/2018/6/22/1529648587197MFast.jpg', 'file', 'courseWorkStudentSubmitFiles', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('144', '35', 'icon-sofa.png', '890', '/file/file/2018/6/26/1529982611893Cxaar.png', 'file', 'courseWorkStudentCheckedFiles', null, null, null, '2018-06-26 11:10:23', null);
INSERT INTO `t_data_file` VALUES ('146', '36', 'icon-phone.png', '1093', '/file/file/2018/6/26/1529982692486Qnqxe.png', 'file', 'courseWorkStudentCheckedFiles', null, null, null, '2018-06-26 11:11:42', null);
INSERT INTO `t_data_file` VALUES ('147', '42', 'icon-purchase.png', '1468', '/file/file/2018/7/2/1530499998314WIeUt.png', 'file', 'courseVideos', null, null, null, '2018-07-02 10:53:23', null);
INSERT INTO `t_data_file` VALUES ('148', null, 'icon-account.png', '1140', '/file/file/2018/7/2/1530501080366pImFP.png', 'file', 'courseVideoHeadImgs', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('149', null, 'icon-merchant.png', '1028', '/file/image/2018/7/2/1530501234348YxKhs.png', 'image', 'courseVideoHeadImgs', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('151', '43', 'icon-merchant.png', '1028', '/file/image/2018/7/2/1530501861828lTPck.png', 'image', 'courseVideoHeadImgs', null, null, null, '2018-07-02 11:24:31', null);
INSERT INTO `t_data_file` VALUES ('173', '43', '63_尚学堂_肖斌_hive_ddl数据定义语言04.mp4', '24260449', '/file/file/2018/7/2/1530507782144TabTX.mp4', 'file', 'courseVideoFiless', null, null, null, '2018-07-04 11:55:30', null);
INSERT INTO `t_data_file` VALUES ('176', '44', '30.Composing Services.mp4', '23546441', '/file/file/2018/7/2/1530515672913FyeKI.mp4', 'file', 'courseVideoFiless', null, null, null, '2018-07-04 13:03:06', null);
INSERT INTO `t_data_file` VALUES ('178', '44', 'javaweb.jpg', '22279', '/file/file/2018/7/3/1530617423811rEQCL.jpg', 'file', 'courseVideoFiless', null, null, null, '2018-07-04 13:03:05', null);
INSERT INTO `t_data_file` VALUES ('179', '43', 'java基础.jpg', '15435', '/file/file/2018/7/3/1530617515645WqyFN.jpg', 'file', 'courseVideoFiless', null, null, null, '2018-07-04 11:55:30', null);
INSERT INTO `t_data_file` VALUES ('180', '45', '计算机组成原理.jpg', '82343', '/file/file/2018/7/3/1530618422484SsDto.jpg', 'file', 'courseVideoFiless', null, null, null, '2018-07-04 11:56:24', null);
INSERT INTO `t_data_file` VALUES ('181', '45', '63_尚学堂_肖斌_hive_ddl数据定义语言04.mp4', '24260449', '/file/file/2018/7/3/1530618466529GmyvI.mp4', 'file', 'courseVideoFiless', null, null, null, '2018-07-04 11:56:24', null);
INSERT INTO `t_data_file` VALUES ('182', '42', '28168.xlsx', '101719', '/file/file/2018/7/4/1530680710536ckieK.xlsx', 'file', 'courseWorkFiles', null, null, null, '2018-07-04 13:05:35', null);
INSERT INTO `t_data_file` VALUES ('184', '38', 'chiji.pdf', '73380', '/file/file/2018/7/4/1530680786311oavEH.pdf', 'file', 'courseWorkStudentSubmitFiles', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('185', '38', '14286549_10.8.5-10.13.2.txt', '1094', '/file/file/2018/7/4/1530680854194MCRDD.txt', 'file', 'courseWorkStudentCheckedFiles', null, null, null, '2018-07-04 13:07:38', null);
INSERT INTO `t_data_file` VALUES ('186', '39', '14289766_10.13.3.txt', '234', '/file/file/2018/7/4/1530680901934TOpYR.txt', 'file', 'courseWorkStudentSubmitFiles', null, null, null, null, null);
INSERT INTO `t_data_file` VALUES ('187', '46', '63_尚学堂_肖斌_hive_ddl数据定义语言04.mp4', '24260449', '/file/file/2018/7/10/1531205642750xQlPe.mp4', 'file', 'courseVideoFiless', null, null, null, '2018-07-10 14:54:25', null);

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
-- Table structure for t_evaluation
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluation`;
CREATE TABLE `t_evaluation` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL COMMENT '评教学生',
  `teacher_id` int(10) DEFAULT NULL COMMENT '教师',
  `content` varchar(500) DEFAULT NULL COMMENT '评教内容',
  `score` int(10) DEFAULT NULL COMMENT '打分',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `del_flag` varchar(1) DEFAULT '0' COMMENT '删除标记(1.删除，0未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COMMENT='评教表';

-- ----------------------------
-- Records of t_evaluation
-- ----------------------------
INSERT INTO `t_evaluation` VALUES ('72', '18', '4', 'henhaoasd', '2', '2018-07-06 11:55:05', '2018-07-06 11:55:05', '0');
INSERT INTO `t_evaluation` VALUES ('73', '18', '4', 'we', '2', '2018-07-10 15:40:58', '2018-07-10 15:40:58', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_permit
-- ----------------------------
INSERT INTO `t_system_permit` VALUES ('1', '用户管理', 'menu', 'user', '/user', '10', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('5', '角色管理', 'menu', 'role', '/role', '10', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('7', '权限配置', 'menu', 'permit', '/permit', '10', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('10', '系统管理', 'menu', 'system', '/system', '0', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('17', '课程管理', 'menu', 'course', '/course', '0', null, '1', null, null, null);
INSERT INTO `t_system_permit` VALUES ('26', '我的课程', 'menu', 'student', '/student', '0', null, '1', '2018-06-21 13:56:13', '2018-06-21 14:05:48', null);
INSERT INTO `t_system_permit` VALUES ('27', '在线聊天', 'menu', 'chat', '/chat', '0', null, '1', '2018-07-06 13:48:18', '2018-07-06 13:48:18', null);
INSERT INTO `t_system_permit` VALUES ('28', '在线评教', 'menu', 'evaluation', '/evaluation', '0', null, '1', '2018-07-06 13:49:00', '2018-07-06 13:49:00', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_role
-- ----------------------------
INSERT INTO `t_system_role` VALUES ('1', '超级管理员', 'admin', '1', '系统超级管理员', null, '2018-07-03 14:43:09', null);
INSERT INTO `t_system_role` VALUES ('2', '教师', 'CUSTOM', '1', '教师', null, '2018-07-06 13:49:11', null);
INSERT INTO `t_system_role` VALUES ('3', '学生', 'CUSTOM', '1', '学生', null, '2018-07-06 13:49:08', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_role_permit
-- ----------------------------
INSERT INTO `t_system_role_permit` VALUES ('97', '4', '10', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('98', '4', '5', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('99', '4', '7', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('100', '4', '21', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('101', '4', '22', '2018-02-05 09:39:37', '2018-02-05 09:39:37', '0');
INSERT INTO `t_system_role_permit` VALUES ('128', '1', '10', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('129', '1', '1', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('130', '1', '5', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('131', '1', '7', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('139', '3', '26', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('140', '3', '27', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('141', '3', '28', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('142', '2', '17', null, null, '0');
INSERT INTO `t_system_role_permit` VALUES ('143', '2', '27', null, null, '0');

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
INSERT INTO `t_system_user` VALUES ('4', 'tech001', '', '', '', null, '张老师', 'tech001', '111111', '0', null, null, null, '教授', null, null, null, null);
INSERT INTO `t_system_user` VALUES ('18', '201306601121', '高三', '一班', '软件服务外包', null, '邹朝亮', '201306601121', '111111', '0', null, null, null, '', null, null, '2018-07-06 13:43:25', '0');
INSERT INTO `t_system_user` VALUES ('19', '201306601102', '高三', '一班', '软件服务外包', null, '张伟', '201306601102', '111111', '0', null, null, null, '', null, '2018-06-21 11:12:39', '2018-06-21 11:12:39', '0');
INSERT INTO `t_system_user` VALUES ('20', '201306601103', '高三', '一班', '软件服务外包', null, '李四我', '201306601103', '111111', '0', null, null, null, '', null, '2018-06-21 11:13:18', '2018-07-10 15:27:04', '0');
INSERT INTO `t_system_user` VALUES ('21', '201306601104', '高三', '一班', '软件服务外包', null, '邹琪', '201306601104', '111111', '0', null, null, null, '', null, '2018-06-21 11:14:05', '2018-06-21 11:14:05', '0');
INSERT INTO `t_system_user` VALUES ('22', 'tech002', '', '', '', null, '范老师', 'tech002', '111111', '0', null, null, null, '教授', null, '2018-06-21 11:16:36', '2018-06-21 11:16:36', '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_user_role
-- ----------------------------
INSERT INTO `t_system_user_role` VALUES ('1', '4', '2', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('2', '1', '1', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('49', '19', '3', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('51', '21', '3', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('54', '22', '2', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('55', '18', '3', null, null, '0');
INSERT INTO `t_system_user_role` VALUES ('56', '20', '3', null, null, '0');

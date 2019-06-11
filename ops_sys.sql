/*
Navicat MySQL Data Transfer

Source Server         : yang
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : ops_sys

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-06-11 13:38:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(30) NOT NULL,
  `roleid` int(11) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '/interfaceList', '1', '接口列表');
INSERT INTO `permission` VALUES ('2', '/ipList', '1', '服务器列表');
INSERT INTO `permission` VALUES ('3', '/taskList', '1', '检测任务列表');

-- ----------------------------
-- Table structure for ref_email_task
-- ----------------------------
DROP TABLE IF EXISTS `ref_email_task`;
CREATE TABLE `ref_email_task` (
  `ref_et_id` int(11) NOT NULL AUTO_INCREMENT,
  `ref_email_id` int(11) DEFAULT NULL,
  `ref_task_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`ref_et_id`),
  KEY `email_id` (`ref_email_id`),
  KEY `task_id` (`ref_task_id`),
  CONSTRAINT `email_id` FOREIGN KEY (`ref_email_id`) REFERENCES `t_email` (`email_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `task_id` FOREIGN KEY (`ref_task_id`) REFERENCES `t_task` (`tsk_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ref_email_task
-- ----------------------------
INSERT INTO `ref_email_task` VALUES ('1', '1', '1');
INSERT INTO `ref_email_task` VALUES ('2', '1', '3');
INSERT INTO `ref_email_task` VALUES ('44', '1', '6');
INSERT INTO `ref_email_task` VALUES ('48', '1', '5');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(20) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '管理员', '管理员');
INSERT INTO `role` VALUES ('2', '普通用户', '普通用户');

-- ----------------------------
-- Table structure for t_email
-- ----------------------------
DROP TABLE IF EXISTS `t_email`;
CREATE TABLE `t_email` (
  `email_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_address` varchar(255) DEFAULT NULL,
  `email_username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_email
-- ----------------------------
INSERT INTO `t_email` VALUES ('1', '562605133@qq.com', '杨浩然');
INSERT INTO `t_email` VALUES ('2', '123456178@qq.com', '张一');

-- ----------------------------
-- Table structure for t_interface
-- ----------------------------
DROP TABLE IF EXISTS `t_interface`;
CREATE TABLE `t_interface` (
  `it_id` int(11) NOT NULL AUTO_INCREMENT,
  `it_port` int(11) DEFAULT NULL,
  `it_address` varchar(32) DEFAULT NULL,
  `it_detail` varchar(255) DEFAULT NULL,
  `it_create_time` datetime DEFAULT NULL,
  `it_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`it_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_interface
-- ----------------------------
INSERT INTO `t_interface` VALUES ('12', '7001', '/card/cardValidate', '刷卡接口', '2019-02-13 13:40:25', '2019-02-14 17:59:58');
INSERT INTO `t_interface` VALUES ('13', '7002', '/card/cardValidate', '刷卡接口', '2019-02-13 13:40:59', '2019-02-14 18:00:01');
INSERT INTO `t_interface` VALUES ('14', '1111', 'aa', 'aaa', '2019-02-20 14:00:48', '2019-02-20 14:00:48');
INSERT INTO `t_interface` VALUES ('15', '12331', 'aaa', 'aaa', '2019-02-20 14:00:54', '2019-02-20 14:00:54');
INSERT INTO `t_interface` VALUES ('16', '12331', 'aaa', 'aaaa', '2019-02-20 14:01:05', '2019-02-20 14:01:05');
INSERT INTO `t_interface` VALUES ('17', '12313', 'aaa', 'aaaa', '2019-02-20 14:01:11', '2019-02-20 14:01:11');
INSERT INTO `t_interface` VALUES ('18', '12314', 'aaa', 'aaaaa', '2019-02-20 14:01:18', '2019-02-20 14:01:18');
INSERT INTO `t_interface` VALUES ('20', '12313', 'aaaa', 'aaaa', '2019-02-20 14:01:35', '2019-02-20 14:01:35');
INSERT INTO `t_interface` VALUES ('22', '1111', 'aa', 'aaaaaaaaaaaaaaaaaaaaaaaaaaa', '2019-02-20 14:01:59', '2019-02-21 13:45:40');
INSERT INTO `t_interface` VALUES ('23', '12313', 'aaa', 'aaaaa', '2019-02-21 13:32:47', '2019-02-21 13:32:47');
INSERT INTO `t_interface` VALUES ('24', '123', '123', '123', '2019-05-09 17:13:47', '2019-05-09 17:13:47');
INSERT INTO `t_interface` VALUES ('25', '11', '11', '111', '2019-05-14 16:01:27', '2019-05-14 16:01:27');

-- ----------------------------
-- Table structure for t_server_ip
-- ----------------------------
DROP TABLE IF EXISTS `t_server_ip`;
CREATE TABLE `t_server_ip` (
  `sv_id` int(11) NOT NULL AUTO_INCREMENT,
  `sv_ip` varchar(32) DEFAULT NULL,
  `sv_ip_private` varchar(32) DEFAULT NULL,
  `sv_os` varchar(255) DEFAULT NULL,
  `sv_cpu` varchar(11) DEFAULT NULL,
  `sv_memory` varchar(11) DEFAULT NULL,
  `sv_disk` varchar(11) DEFAULT NULL,
  `sv_bandwidth` varchar(11) DEFAULT NULL,
  `sv_detail` varchar(64) DEFAULT NULL,
  `sv_create_time` datetime DEFAULT NULL,
  `sv_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`sv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_server_ip
-- ----------------------------
INSERT INTO `t_server_ip` VALUES ('22', '39.104.13.49', '172.24.166.231', 'CentOS 7.3 64位', '8核', '32GB', '160GiB', '10Mbps', '快乐唷唷linux服务器', '2019-02-13 13:32:56', '2019-05-23 14:20:57');
INSERT INTO `t_server_ip` VALUES ('23', '39.104.137.176', '172.24.166.232', 'CentOS 7.3 64位', '16核', '32GiB', '160GiB', '10Mbps', '快乐唷唷linux服务器', '2019-02-13 13:35:11', '2019-05-23 14:20:17');
INSERT INTO `t_server_ip` VALUES ('25', '47.98.135.53', '172.16.240.91', 'CentOS 7.3 64位', '4核', '32GiB', '2894GiB', '5Mbps', '智慧学堂Windows正式服务器', '2019-05-23 14:17:04', '2019-05-23 14:17:04');
INSERT INTO `t_server_ip` VALUES ('26', '120.78.169.172', '127.0.0.1', 'CentOS 7.3 64位', '1核心', 'a', 'a', 'a', '自用阿里云服务器', null, '2019-05-31 10:38:03');
INSERT INTO `t_server_ip` VALUES ('27', '120.78.169.172', '127.0.0.1', 'CentOS 7.3 64位', '1核心', 'a', 'a', 'a', '自用阿里云服务器', null, '2019-05-31 10:38:03');
INSERT INTO `t_server_ip` VALUES ('28', '120.78.169.172', '127.0.0.1', 'CentOS 7.3 64位', '1核心', 'a', 'a', 'a', '自用阿里云服务器', null, '2019-05-31 10:38:03');

-- ----------------------------
-- Table structure for t_ssh_message
-- ----------------------------
DROP TABLE IF EXISTS `t_ssh_message`;
CREATE TABLE `t_ssh_message` (
  `ssh_id` int(11) NOT NULL AUTO_INCREMENT,
  `ssh_ip_id` int(11) DEFAULT NULL,
  `ssh_username` varchar(255) DEFAULT NULL,
  `ssh_pwd` varchar(255) DEFAULT NULL,
  `ssh_create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ssh_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ssh_id`),
  KEY `FK_ssh_ip` (`ssh_ip_id`),
  CONSTRAINT `FK_ssh_ip` FOREIGN KEY (`ssh_ip_id`) REFERENCES `t_server_ip` (`sv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ssh_message
-- ----------------------------
INSERT INTO `t_ssh_message` VALUES ('1', '26', 'root', '2be0e0e9d1bad7ea20be347b4d58ea38', '2019-06-06 16:00:16', '2019-06-06 16:00:16');
INSERT INTO `t_ssh_message` VALUES ('2', '27', 'root', '2be0e0e9d1bad7ea20be347b4d58ea38', '2019-06-06 16:00:17', '2019-06-06 16:00:17');
INSERT INTO `t_ssh_message` VALUES ('3', '28', 'root', '2be0e0e9d1bad7ea20be347b4d58ea38', '2019-06-06 16:00:19', '2019-06-06 16:00:19');

-- ----------------------------
-- Table structure for t_student_task
-- ----------------------------
DROP TABLE IF EXISTS `t_student_task`;
CREATE TABLE `t_student_task` (
  `st_id` int(11) NOT NULL AUTO_INCREMENT,
  `st_type` int(11) DEFAULT NULL COMMENT '1（生活习惯） 2（学习习惯） 3（行为习惯） 4（其他）',
  `st_class_type` int(11) DEFAULT NULL COMMENT '1（小班） 2（中班） 3（大班）4（所有）',
  `st_name` varchar(255) DEFAULT NULL COMMENT '任务目标',
  `st_content` varchar(255) DEFAULT NULL COMMENT '任务详情',
  PRIMARY KEY (`st_id`)
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_student_task
-- ----------------------------
INSERT INTO `t_student_task` VALUES ('1', '1', '1', '不偏食、挑食、暴饮暴食【均适用】', '请家长引导孩子独立用勺子吃晚餐，可适当玩一些小游戏帮助孩子进餐，如小飞机送餐（勺子当飞机，将饮食送进宝宝嘴里）;尝味道（家长引导：如我要吃红萝卜，脆脆的甜甜的，孩子：我也要吃红萝卜，脆脆的甜甜的等等）。');
INSERT INTO `t_student_task` VALUES ('2', '1', '1', '愿意按时吃饭', '请家长按照家里的饮食时间，及时引导幼儿，摆碗筷（帮助把碗筷摆整齐，几人吃饭摆几副碗筷）。');
INSERT INTO `t_student_task` VALUES ('3', '1', '1', '饭前便后洗手，擦干手，饭后漱口，擦嘴巴', '请家长引导孩子饭前洗手，并了解洗手的基本步骤（挽袖子、开水龙头，湿手、关水龙头、抹肥皂或洗手液、搓手、打开水龙头洗手、关水，用擦手。）吃完后在家长的帮助下进行漱口，并引导幼儿掌握基本的漱口方法，漱口后擦嘴巴。');
INSERT INTO `t_student_task` VALUES ('4', '1', '1', '保持桌面整洁、干净卫生', '请家长引导孩子吃饭时细嚼慢咽，尽量不洒落饭粒或菜品在桌上。可适当带上围兜，每次吃完饭后看看围兜里是否有掉落，以此监督并鼓励幼儿，吃饭时一只手扶碗，一只手拿汤匙或筷子。');
INSERT INTO `t_student_task` VALUES ('5', '1', '1', '专心吃饭，安静进餐，不边吃边玩\r\n', '安静进餐（关掉电视，放下手机，吃饭前可以引导孩子报菜名，家长简单介绍菜的营养价值，吃了会长高长漂亮等等）。');
INSERT INTO `t_student_task` VALUES ('6', '1', '2', '会用筷子吃饭', '孩子在爸爸妈妈的引导下尝试用筷子进餐（告诉孩子正确使用筷子的方法：小筷子，本领强， 三根手指来帮忙。 先打开，再合上， 饭菜吃完味更香。）（家长可以准备一小碗豆子，让宝贝拈豆子，然后用筷子夹轻的物品，如纸团、棉花团、纸条等）');
INSERT INTO `t_student_task` VALUES ('7', '1', '2', '保持桌面整洁干净卫生', '请家长引导孩子吃饭时细嚼慢咽，尽量不洒落饭粒或菜品在桌上。并在吃晚饭后，将桌面收拾整洁。');
INSERT INTO `t_student_task` VALUES ('8', '1', '2', '喜欢吃蔬菜水果，保持营养均衡。', '请家长引导孩子少吃零食如雪糕饼干巧克力等不健康的食品，尽量引导孩子多吃蔬菜和水果，少喝碳酸饮料多喝牛奶、鲜榨果汁等。');
INSERT INTO `t_student_task` VALUES ('9', '1', '3', '正确使用筷子进餐', '请家长注意孩子的拿筷子姿势，并适当引导幼儿正确拿筷子；');
INSERT INTO `t_student_task` VALUES ('10', '1', '3', '饭菜分开进餐', '请家长让孩子餐前自主摆放碗筷；在吃饭时引导孩子饭菜分开进餐，尽量不搅拌在一起进食，引导孩子一口饭一口菜。');
INSERT INTO `t_student_task` VALUES ('11', '1', '3', '保持桌面整洁，饭后能帮助家长洗碗', '请家长引导孩子在进餐期间保持桌面整洁，餐后可自主收拾碗筷，帮助家长洗碗，物归原处。');
INSERT INTO `t_student_task` VALUES ('12', '1', '3', '不挑食、偏食、浪费粮食。', '请孩子自主盛（吃）饭盛（挑）菜，吃多少盛多少，不浪费粮食。若有剩余的粮食，想办法处理，做到不浪费。（喂外面的小鸟、小狗等等）');
INSERT INTO `t_student_task` VALUES ('13', '1', '1', '愿意饮用白开水，不贪喝饮料', '及时提醒孩子饮用白开水，可使用儿歌或游戏的形式：拿起小水杯，接杯白开水。坐下慢慢喝，多喝水，不生病，咕嘟咕嘟喝进嘴！');
INSERT INTO `t_student_task` VALUES ('14', '1', '1', '在家长的引导下，知道不要在运动后立即大量饮水', '请家长提醒孩子运动后，不立即大量饮水；可以带着孩子阅读绘本《来喝水吧》，了解喝水的重要性，也可以通过观看爱奇艺视频《多喝开水好处多》。');
INSERT INTO `t_student_task` VALUES ('15', '1', '1', '在家长的引导下，适量饮水', '请家长主动询问孩子是否需要饮水，并和孩子适当饮水，补充水分。');
INSERT INTO `t_student_task` VALUES ('16', '1', '2', '愿意主动饮用白开水', '宝贝回家后，在家长的引导下知道渴了主动喝白开水，达到饮水需要。');
INSERT INTO `t_student_task` VALUES ('17', '1', '3', '能自主接水并饮用适量的白开水。', '幼儿出门玩耍时，自主携带水杯，并适量饮水。');
INSERT INTO `t_student_task` VALUES ('18', '1', '1', '睡前保持心情平静，不大吵大闹。', '家长在宝宝入睡前读绘本或者讲故事，如《小猪盖房子》《月亮婆婆》《三只小熊》《聪明的小羊》《小老鼠的魔法书》《你醒了吗？》《好困好困的蛇》《不睡觉世界冠军》等，让孩子情绪平稳，有良好的入睡前准备。-均适用');
INSERT INTO `t_student_task` VALUES ('19', '1', '1', '在家长引导下，能按时睡前洗漱，脱换衣物，摆放整齐。', '家长可引导幼儿按时进行洗漱，换上睡衣等。了解脱衣服的顺序：先脱鞋，再脱裤，最后脱衣服，并把衣服摆放整齐。');
INSERT INTO `t_student_task` VALUES ('20', '1', '1', '能在安静的睡眠环境下，快速入睡。', '在宝贝入睡时，盖好被子，不趴着睡觉，保持良好的睡姿。');
INSERT INTO `t_student_task` VALUES ('21', '1', '2', '每天按时睡觉，养成良好睡姿。', '爸爸妈妈引导孩子在晚上九点前洗漱完毕，按时睡觉，养成良好的睡姿。');
INSERT INTO `t_student_task` VALUES ('22', '1', '2', '能独立入睡，分床（房）睡眠。', '孩子有独立的睡眠空间，有意识地引导幼儿独立入睡。');
INSERT INTO `t_student_task` VALUES ('23', '1', '2', '不赖床，听到起床的信号后，可迅速起床。', '家长睡前告诉孩子起床时间，以闹钟（音乐、口述、拥抱、亲吻）等方式叫醒幼儿，迅速起床。');
INSERT INTO `t_student_task` VALUES ('24', '1', '3', '养成按时睡觉和起床的习惯。 ', '家长定时监督孩子是否按时睡觉或起床，并协助孩子以书面方式记录下来，定期和孩子总结反思，可以跟孩子商量在家需要遵守的事项，制定《家庭公约》相互监督。');
INSERT INTO `t_student_task` VALUES ('25', '1', '3', '愿意按照约定的睡眠和起床时间，自主完成睡眠和起床等事项。', '与孩子一起约定睡眠和起床时间，自主做好入睡前的准备工作，按时睡眠和起床，可以在家庭公约里体现。');
INSERT INTO `t_student_task` VALUES ('26', '1', '1', '在引导下初步掌握七步洗手法', '观看《宝宝爱洗手》视频，初步了解七步洗手法。-均适用');
INSERT INTO `t_student_task` VALUES ('27', '1', '1', '在引导下做到饭前便后要洗手，擦手', '孩子在家时，提醒并协助孩子进行饭前便后洗手，擦手。');
INSERT INTO `t_student_task` VALUES ('28', '1', '1', '在引导下餐后漱口擦嘴', '协助孩子进行洗漱，餐后漱口擦嘴，并让宝宝自己涂抹香香');
INSERT INTO `t_student_task` VALUES ('29', '1', '1', '在引导下早晚知道要刷牙', '引导孩子早晚记得刷牙，并初步掌握刷牙的基本方法，可辅以儿歌：\r\n小牙刷，手中拿，我呀张开小嘴巴，\r\n刷左边，刷右边，上下里外都刷刷，\r\n早上刷，晚上刷，刷得牙齿没蛀牙，\r\n张张口，笑一笑，我的牙齿刷得白花花');
INSERT INTO `t_student_task` VALUES ('30', '1', '1', '在引导下知道餐后漱口擦嘴', '在家吃早、中饭后，爸爸妈妈要提醒孩子饭后漱口。-均适用\r\n  亲子游戏：咕咚咕咚！\r\n  准备3个纸杯【或者3个水杯】以及一盒纸巾，父母跟宝贝人手一个。念儿歌：一起漱漱口，咕咚咕咚噗，细菌全都跑光光；一起漱漱口，咕咚咕咚噗，小嘴干净又健康；小纸巾拿起来，擦擦嘴巴 真干净！');
INSERT INTO `t_student_task` VALUES ('31', '1', '2', '在家长提醒下，能够按照七步洗手法洗手', '自主挽袖子，正确洗手、擦手。家长可提问：你在幼儿园是怎么洗手的，教教爸爸妈妈吧');
INSERT INTO `t_student_task` VALUES ('32', '1', '2', '在家长提醒下，洗手时不弄湿衣服，洗完后擦手', '在家吃饭后，做完游戏活动后，能有意识自己主动洗手。洗手时能主动挽起衣袖，不弄湿衣服。做到洗完手后擦手。\r\n 儿歌：洗手前，先卷袖，再用清水洗洗手，擦上肥皂搓一搓，指间指缝都搓到，哗哗流水冲一冲，我的小手洗净了。”更改：饭后，做完游戏，孩子能自主去洗手。洗手挽袖，洗完手在洗手盆甩一甩，然后用毛巾擦干。');
INSERT INTO `t_student_task` VALUES ('33', '1', '2', '在家长提醒下，餐后漱口擦嘴。', '饭后，爸爸妈妈要提醒并监督孩子饭后漱口、擦嘴。');
INSERT INTO `t_student_task` VALUES ('34', '1', '2', '家长提醒下，早晚知道要刷牙', '提醒孩子早晚记得刷牙，并能用正确的方法刷牙。');
INSERT INTO `t_student_task` VALUES ('35', '1', '3', '熟练按照七步洗手法洗手', '孩子洗手时，请爸爸妈妈检查孩子是否能够按照7步洗手法洗手。补充：家长可以跟孩子一起洗手');
INSERT INTO `t_student_task` VALUES ('36', '1', '3', '能够独立盥洗', '能学习洗头、洗澡、洗脖子。补充：家长督导\r\n亲子游戏：我爱洗澡。【音乐：我爱洗澡】\r\n播放音乐：我爱洗澡，父母跟孩子一起做动作。让孩子感受音乐同时，了解洗澡的部位及顺序。');
INSERT INTO `t_student_task` VALUES ('37', '1', '3', '自主餐后漱口擦嘴。  ', '饭后，自主刷牙、擦嘴。');
INSERT INTO `t_student_task` VALUES ('38', '1', '3', '早晚自主刷牙。', '早晚自主刷牙，并能用正确的方法刷牙。');
INSERT INTO `t_student_task` VALUES ('39', '1', '1', '渐渐学会自理大小便，避免大小便在衣裤上和将大小便弄到便池外。', '在大小便时，能够自己尝试脱裤子；小女生小便后正确使用纸巾从前往后擦私处。');
INSERT INTO `t_student_task` VALUES ('40', '1', '1', '在提醒下便后记得冲水、洗手、擦手。', '上完厕所后，父母进行示范榜样冲水、洗手。可以给孩子配专用的洗手液【洗手皂】，让孩子形成物品秩序感。');
INSERT INTO `t_student_task` VALUES ('41', '1', '1', '能够用简单语言表达出如厕的需求和遇到问题', '亲子阅读/视频观看，绘本《皮皮放屁屁》《小米的便便商店》《呀！屁股》等书籍教育引导，一起分享自己的感受和想法。【如果如厕时发生些意外小状况，不要去责怪。要鼓励孩子敢于尝试，并告诉孩子每次妈妈都会陪着你，下次一定会做得更好】');
INSERT INTO `t_student_task` VALUES ('42', '1', '2', '开始学习自己擦大便，并正确使用卫生纸。', '如厕时尝试让孩子自己擦大便，父母表明在外面等候，有需要协助时进行表达。家长在此前告诉孩子正确取纸多少，纸张应该折一折，让孩子养成正确用纸习惯。【日常生活中父母可以先带孩子运用儿歌了解步骤，边做边回忆儿歌是怎么做的】\r\n儿歌：\r\n卫生纸 手里拿，折好纸巾蹲下来，从下往上擦一擦，便便跑到纸上了，再把纸巾折一折，便便跑到里面去，擦一擦，看一看，小屁股干净啦！');
INSERT INTO `t_student_task` VALUES ('43', '1', '2', '能够认识公众场合男女厕所标志，按提示标志如厕', '亲子游戏：我是谁。\r\n准备布偶娃娃3-4个，有男娃娃跟女娃娃。父母跟宝贝一起玩扮演游戏，说说自己手上扮演的娃娃要上厕所了。要去哪个厕所呢？是穿裙子的？还是穿裤子的呢？【日常生活逛商场及上洗手间时，让孩子当小导游，告诉妈妈/爸爸哪个是男生洗手间，哪个是女生洗手间】补充：区分男生女生如此的各种标识');
INSERT INTO `t_student_task` VALUES ('44', '1', '2', '根据自己的需求及时如厕', '根据自己需求及时大小便，不憋尿。【孩子如果觉得不好意思，可以用绘画形式来表达。买一本幼儿的如厕记录本，可以记录自己如厕心情、感受等】尽量培养孩子固定时间大便的好习惯，一般在早上6：00--7：00钟。（适合各年龄段）');
INSERT INTO `t_student_task` VALUES ('45', '1', '3', '便后能够自主整理衣物、冲水、洗手、擦手。', '亲子游戏：我是大哥哥/大姐姐。\r\n   让孩子带着自己喜欢的角色，演绎如厕后整理衣物、冲水、洗手等一系列活动。并说一说自己的感受，父母给予鼓励和肯定，或者进行适当奖励。');
INSERT INTO `t_student_task` VALUES ('46', '1', '3', '能够用语言清晰的表达出如厕的需求和遇到如厕问题。', '家长与幼儿一起讨论如厕的习惯并让幼儿说一说吧。可以进行相关书籍阅读《《我要拉??》《是谁在嗯嗯我的头上》');
INSERT INTO `t_student_task` VALUES ('47', '1', '3', '认识公众场合男女厕所标志并按标志如厕。', '孩子在商场能识别指出厕所标志，进行如厕时，能主动识别属于自己的厕所标志。并且在父母陪同下，自主地完成如厕的行为。\r\n亲子游戏：商场扮演\r\n运用积木、搭建类玩具进行模拟商场、超市等公共场景，让孩子进行找寻厕所位置及相应标识。并说一说他们在哪里，如何分辨。');
INSERT INTO `t_student_task` VALUES ('48', '2', '1', '引导孩子认真倾听，阅读图画符号。', '选择一本喜欢的绘本，和爸爸妈妈一起阅读（家长需创设一个温馨的阅读环境）家长阅读文字，孩子对应阅读图画符号并认真倾听；家长教会孩子看书阅读要一页一页的翻看，看完一页再翻下一页。');
INSERT INTO `t_student_task` VALUES ('49', '2', '1', '喜欢跟读儿歌、童谣、故事绘本。', '家长大声阅读儿歌、童谣、故事绘本等，小孩小声跟读。');
INSERT INTO `t_student_task` VALUES ('50', '2', '1', '爱护图书，不乱撕、乱扔。', '和孩子一起将坏掉的绘本或图书进行修补，初步掌握修补的方法以及懂得保护图书。');
INSERT INTO `t_student_task` VALUES ('51', '2', '1', '引导孩子将图书物归原处，摆放整齐。', '看完图书后，将自己的图书物归原处，并摆放整齐。');
INSERT INTO `t_student_task` VALUES ('52', '2', '2', '愿意阅读自己喜欢的图书。', '选择一本图书，先一起阅读图书，再请孩子说说自己对这本图书的感受（例如喜欢故事中的人物吗？为什么？）。');
INSERT INTO `t_student_task` VALUES ('53', '2', '2', '大声朗读儿歌、童谣、故事绘本。', '引导孩子观察书本上出现的一些图画符号，例如各种天气符号，各种记录符号等，从而过度到文字的阅读。');
INSERT INTO `t_student_task` VALUES ('54', '2', '2', '能对自己感兴趣的所见所闻与人分享 。', '开展“我是小小故事家“的活动，引导孩子声情并茂的讲述自己感兴趣的所见所闻，并设置”点评“环节，”颁奖环节“，激发孩子愿意表演的欲望，愿意主动分享故事。');
INSERT INTO `t_student_task` VALUES ('55', '2', '2', '将图书分类摆放整齐。', '引导孩子根据图书的类别进行分类，并摆放整齐。');
INSERT INTO `t_student_task` VALUES ('56', '2', '3', '专注地阅读图书，自愿分享。', '自主专注阅读图书（家长可创设一个安静的阅读环境，帮助孩子专注阅读）并愿意和家长进行自主交流 。');
INSERT INTO `t_student_task` VALUES ('57', '2', '3', ' 喜欢与他人一起谈论图书和故事的有关内容。', '和孩子阅读故事，并就故事的内容或画面，大胆推测故事后续发展。遇到孩子感兴趣的事物或者问题时，和他一起查阅图书资料，让他感受图书的作用，提通过阅读获取信息的乐趣，并做记录。');
INSERT INTO `t_student_task` VALUES ('58', '2', '3', '在阅读图书时，理解标点符号的意义，并有表情地朗读。', '和幼儿一起探讨图书中出现的一些标点符号，帮助幼儿理解该符号的含义。');
INSERT INTO `t_student_task` VALUES ('59', '2', '3', '自主整理自己的图书，并做好相应的标记。', '阅读完后，将自己的图书做好标记，并整理整齐，并物归原处。');
INSERT INTO `t_student_task` VALUES ('60', '2', '1', '遇到困难，挫折时，能释放自己的情绪', '阅读绘本《菲菲生气了》，了解菲菲生气的变化过程以及如何释放情绪。');
INSERT INTO `t_student_task` VALUES ('61', '2', '1', '能主动寻求帮助，解决生活中的问题。', '引导孩子了解119/110/120等紧急电话，模拟情景、角色扮演（如陌生人敲门怎么办？走失了怎么办？怎样与警察保安对话？）记住爸爸妈妈电话号码、家庭住址（不随意将电话、住址告诉别人）等。');
INSERT INTO `t_student_task` VALUES ('62', '2', '1', '知道自己的事情自己做', '引导孩子知道哪些事情是可以独立完成的？如自己吃饭、睡觉、解便等。（游戏：你问我答，答对了有奖励）');
INSERT INTO `t_student_task` VALUES ('63', '2', '2', '能主动与他人合作协商解决问题', '与同伴交往过程中，教会孩子一些解决问题的方式方法 （轮流玩玩具；用适当的语言交流，友好相处；学会选择和等待；遵守公共的规则，排队，靠右行走等）');
INSERT INTO `t_student_task` VALUES ('64', '2', '2', '敢于尝试有难度的活动和任务', '在安全的前提下，鼓励孩子拆装自己的玩具或利用废旧物品，和孩子一起动手制作一个玩具');
INSERT INTO `t_student_task` VALUES ('65', '2', '3', '遇到困难、挫折时，能坚持而不轻易求助，并愿意寻找方法，尝试解决问题', '家长需认真对待孩子提出的问题，引导他们猜一猜、想一想，有条件时和孩子一起做简易的小实验，如风车为什么会转；');
INSERT INTO `t_student_task` VALUES ('66', '2', '3', '能通过观察、比较、分析等所学知识，解决遇到的问题', '创设（模拟）情境：如果你的玩具被同伴抢了，应该如何做呢？当问题出现的时候，有意识地将问题留给幼儿，让孩子自己尝试想办法解决问题，如果孩子能提出来他们可以轮流玩玩具，这个问题就解决了；也可以教孩子一些找到解决问题的方法和技巧（比如给孩子讲故事《和朋友们一起想办法》，找到方式方法；或者利用查阅工具-百度等；或者和同伴一起商讨）。');
INSERT INTO `t_student_task` VALUES ('67', '2', '1', '认识白天、黑夜，了解主要变化特征。', '了解白天有太阳，晚上有月亮。');
INSERT INTO `t_student_task` VALUES ('68', '2', '1', '初步了解天气和人们生活的关系。', '知道天气的变化特征，以及应该注意的问题。（比如晴天，阴天，雨天等)');
INSERT INTO `t_student_task` VALUES ('69', '2', '1', '了解今天、明天的时间概念。', '和幼儿一起数数，从周一要周末，知道今天周几，明天周几。（一周时间内） ');
INSERT INTO `t_student_task` VALUES ('70', '2', '2', '感知和发现不同季节的特点', '和孩子在游玩或散步时，观察最近的变化（植物变化，天气变化、人们衣着的变化等）。');
INSERT INTO `t_student_task` VALUES ('71', '2', '2', '能认识生活中的时间：如早上、中午、下午、晚上。', '与孩子共同阅读《时间的故事》，建立对时间的基本概念。');
INSERT INTO `t_student_task` VALUES ('72', '2', '3', '感知并了解季节变化的周期性', '请孩子看着钟表告诉家长，此时此刻是几点几分，季节有哪些变化？');
INSERT INTO `t_student_task` VALUES ('73', '2', '3', '认识时钟', '介绍时钟的作用：记录时间；如何认识时钟：时针、分针以及代表的意义；和孩子一起制作一份一日（一周）生活作息时间表{均适用}');
INSERT INTO `t_student_task` VALUES ('74', '2', '3', '有时间观念，并能安排自己的生活作息', '请孩子结合生活中的工具（日历等），说出此时此刻是几月几号、一个月有多少天？几周？什么季节、应该做什么事？');
INSERT INTO `t_student_task` VALUES ('75', '2', '1', '别人对自己说话时能注意听并做出回应', '要求幼儿，在与家人面对面交谈时，要看着对方，并能清晰表达。');
INSERT INTO `t_student_task` VALUES ('76', '2', '1', '能听懂日常普通话会话', '设定一个幼儿愿意谈论的话题，如《我的幼儿园》，家长提问，请幼儿回答。如：你的幼儿园叫什么名字？幼儿园里有什么？你的老师叫什么名字？在幼儿园，你喜欢玩什么玩具？等等。');
INSERT INTO `t_student_task` VALUES ('77', '2', '1', '别人说话的时候，不插嘴，不打断，可礼貌问候。', '吃饭时，当家人在交谈时，孩子有问题或需要帮助，要等别人讲完再表达（家长可设定谈话环境，例如爸爸和妈妈一直在讨论某件事，不给予小朋友理睬，问这种情况下，小朋友如果需要帮助，应如何做？）');
INSERT INTO `t_student_task` VALUES ('78', '2', '2', '用完整、简洁的语言表达', '能用标准的普通话完整地表达自己的需求和想法。');
INSERT INTO `t_student_task` VALUES ('79', '2', '3', '对别人提出的建议，能耐心倾听并回应。', '当孩子在征求家长意见，且与家长意见不同时，能认真倾听并接受家长的合理要求（可设定相应的情境，如孩子要求在8点半出去玩，但现在已经是洗漱时间，家长提出建议：明天早点去玩或者就在家里玩其他的游戏，孩子应如何回答？）');
INSERT INTO `t_student_task` VALUES ('80', '2', '1', '能在家长的引导下说出幼儿园发生的事', '请孩子讲述今天在幼儿园发生的有趣的事情 、儿歌等【均适用】');
INSERT INTO `t_student_task` VALUES ('81', '2', '1', '能说出自己的好朋友是谁，穿什么衣服等', '请孩子将自己的好朋友介绍给家长认识：（叫什么名字？今天穿什么衣服，裤子？喜欢玩什么玩具？等等）');
INSERT INTO `t_student_task` VALUES ('82', '2', '1', '能大胆地自我介绍自己', '引导孩子做自我介绍（可设置小舞台，请幼儿当小明星。介绍自己是谁，几岁了，喜欢什么，家里有几个人。）');
INSERT INTO `t_student_task` VALUES ('83', '2', '2', '愿意主动分享自己喜欢或感兴趣的一件事', '就近期孩子最感兴趣的一件事情进行交流、鼓励他表达自己的想法');
INSERT INTO `t_student_task` VALUES ('84', '2', '2', '能有条理地进行自我表达', '创设场景：医生看病。医生应如何询问？（你几岁了？哪里不舒服？持续几天了？有没有什么过敏药物？）病人应如何回答？更改：亲子对话，家长：今天在幼儿园有什么开心的事情可以跟爸爸妈妈分享？孩子讲述。。。。。。，家长倾听，可以适时的与孩子互动。（适用于各年龄段）');
INSERT INTO `t_student_task` VALUES ('85', '2', '3', '勇于表现自己，大胆用普通话表述自己的想法', 'XX节日来临，爸爸妈妈、爷爷奶奶需各自准备节目，孩子当主持人，策划一个家庭晚会');
INSERT INTO `t_student_task` VALUES ('86', '2', '3', '可适当用一些记录方式来表达自己的想法', '鼓励孩子将生活中发生的事情，用书面形式记录下来（可画画，可写文字，可图文并茂）');
INSERT INTO `t_student_task` VALUES ('87', '2', '3', '能有序、连贯、清楚地讲述一件事情。', '请孩子讲一讲自己在幼儿园度过的一天（按时间顺序进行讲述）');
INSERT INTO `t_student_task` VALUES ('88', '2', '3', '讲述时能使用常见的形容词、同义词等，语言比较生动。', '讲述活动：《我喜欢的恐龙》，请幼儿回忆一些关于恐龙的形容词，如高大威猛、锋利的、迅速地等等；接下来再讲述恐龙的相关习性以及一些故事，最后大家一起做总结回顾。');
INSERT INTO `t_student_task` VALUES ('89', '3', '1', '能够识别自己的物品(均使用）', '让孩子在家庭中能够找到自己使用的碗筷或者毛巾、杯子。');
INSERT INTO `t_student_task` VALUES ('90', '3', '1', '有意识的拿取相关目标材料（均使用）', '家长可以让孩子在餐前帮助大人拿碗筷，摆放椅子。');
INSERT INTO `t_student_task` VALUES ('91', '3', '1', '拿取材料时可以做到从哪拿放哪去（均使用）', '餐后请孩子能够帮助家长把用过的凳子放回原处。');
INSERT INTO `t_student_task` VALUES ('92', '3', '1', '培养孩子良好的劳动习惯', '协助家长清理餐后垃圾，并把垃圾放到垃圾桶里。');
INSERT INTO `t_student_task` VALUES ('93', '3', '2', '可以将自己的玩具及材料根据性质进行分类(中大班）', '今天的亲子任务请家长与孩子一起认识玩具，可以根据玩具的功能，形状，颜色来进行基础分类，并统计记数，用数字符号表示（1-10），家长协助检查。');
INSERT INTO `t_student_task` VALUES ('94', '3', '2', '可以将自己的衣物、鞋子进行摆放，归类。', '亲子游戏：排排队。建议（可放家庭公约）\r\n每天回家父母跟孩子一起检查，鞋柜里自己的鞋子是否排排队放好了。');
INSERT INTO `t_student_task` VALUES ('95', '3', '3', '可以定期收纳，清洗，整理相关物品', '今天的亲子任务请家长和宝贝一起将宝贝的玩具进行清洗消毒整理，并统计计数（用加减符号列式计算），有意识的在活动区内完成。');
INSERT INTO `t_student_task` VALUES ('96', '3', '3', '尝试帮助父母进行家居物品的摆放、归类。', '亲子任务：大扫除。\r\n父母带着宝贝进行大扫除，宝贝负责整理些书籍、衣物、不易碎摆件。在过程中说出它属于什么类别，有什么特征、形状等。');
INSERT INTO `t_student_task` VALUES ('97', '3', '1', '在成人的提醒下能够认识到自己的错误(均使用）', '今天的亲子任务家长和孩子一起阅读绘本<大卫不可以>，在家长协助下理解故事内容，初步了解故事中的行为是否可行。');
INSERT INTO `t_student_task` VALUES ('98', '3', '1', '针对已发生的错误有意识的及时改变（均使用）', '今天的亲子任务家长和孩子互相探讨错误问题的解决方法并拉近亲子关系。');
INSERT INTO `t_student_task` VALUES ('99', '3', '2', '能够约束自我及监督他人（中大班）', '今天的亲子任务是在家庭中互换角色，体验当父母，并让孩子了解家长平时约束自己的目的，做父母可真不容易，由此增强亲子关系。');
INSERT INTO `t_student_task` VALUES ('100', '3', '3', '认识自己的优点与不足（均使用）', '游戏《寻人启事》，家长制作一些优缺点的小卡片（图画、文字表示），然后每个人抽一张，把抽出来的卡片放到能够对应的人身上，最后做总结，看每个人都有什么优点和不足，并帮助孩子改正不足。补充：大家围坐在一起，如卡片上写着“玩完的玩具不收拾整理放回原来的地方”，把这张卡片放到孩子的身上；如卡片上写着“喜欢在客厅抽烟”即把卡片放在对应的家长身上。');
INSERT INTO `t_student_task` VALUES ('101', '3', '1', '能够了解应该和不应该的区别', '父母在家运用哭脸、笑脸、生气脸谱，让孩子根据脸谱说一说在什么情况下才有这些表情。');
INSERT INTO `t_student_task` VALUES ('102', '3', '1', '不乱发脾气', '家长和孩子一起阅读绘本《我不乱发脾气》');
INSERT INTO `t_student_task` VALUES ('103', '3', '2', '有时间概念，在规定的时间行动', '当孩子在规定时间内进行玩玩具、看电视或者进餐等活动时，活动时间一到就必须结束。');
INSERT INTO `t_student_task` VALUES ('104', '3', '2', '学会不在墙上乱写乱画', '家长在家和孩子在指定区域进行涂画，如孩子涂到外边，要相应的给与惩罚。补充：可以放置小黑板，让孩子在黑板上涂鸦。');
INSERT INTO `t_student_task` VALUES ('105', '3', '3', '上课认真听讲，不做小动作', '家长和孩子玩“我们都是木头人”游戏');
INSERT INTO `t_student_task` VALUES ('106', '3', '3', '排队时不打闹，不前后说话', '家长和孩子在回家上楼下楼的过程中在家长的视线范围内靠右行走，不嬉戏打闹。');
INSERT INTO `t_student_task` VALUES ('107', '3', '3', '不破坏玩具、图书（均使用）', '孩子和家长共同修理已经破损的玩具、图书，让孩子体验修好后的成就感');
INSERT INTO `t_student_task` VALUES ('108', '3', '1', '懂礼貌，遇见别人能够主动问好（均使用）', '在家里，孩子能主动和家里的老人问好，并抱一抱爷爷奶奶（老姥姥爷）。补充：亲子故事《懂礼貌的小兔》。');
INSERT INTO `t_student_task` VALUES ('109', '3', '1', '让幼儿熟悉尊老爱幼的简单做法。（均使用）', '家长可以和孩子一起阅读《汤姆爷爷》绘本故事，了解故事中爷爷对孩子们的关心，对尊老爱幼的行为。并且在家里鼓励孩子行动，如：爷爷奶奶想喝水了，宝贝可以做到递水杯过去等。');
INSERT INTO `t_student_task` VALUES ('110', '3', '2', '幼儿对尊老爱幼的行为结果能够感受到生活中的快乐', '让孩子和家长互换角色，为爸爸妈妈洗手洗脚、捶背按摩等简单事情。表达对父母地关爱，了解到大人的辛苦。');
INSERT INTO `t_student_task` VALUES ('111', '3', '2', '了解父母、爷爷奶奶是长辈，需要敬爱、尊重他们', '亲子阅读：进行相关经典故事的阅读、了解，如：《三字经》《猜猜我有多爱你》等故事熏陶。阅读一定时间，可让孩子分享自己的想法，不断地理解。补充：可以让孩子分食物（水果、零食等）。');
INSERT INTO `t_student_task` VALUES ('112', '3', '3', '坐公共交通工具时知道给有需要的人让座（均使用）', '情景体验：乘坐公交车。家长用相关图片内容引导孩子说出遇到这样的乘客我们该怎么做（拄拐的老人、孕妇、生病的人、残疾的人）。');
INSERT INTO `t_student_task` VALUES ('113', '3', '3', '帮助比自己弱小，需要的同伴、人群。\r\n', '日常生活中，与同龄及年龄小的伙伴玩耍时。能够继续关心、爱护。例如：看到小宝贝摔倒能主动扶起来，进行语言（拥抱）去安慰；看到小宝贝玩玩具失败、受到打击时，能去跟他一起玩耍，协助完成等。【角色扮演：父母可以扮演大哥哥和小弟弟，演绎在玩耍时小弟弟不小心摔倒，大哥哥会怎么做。进行行为榜样作用】');
INSERT INTO `t_student_task` VALUES ('114', '3', '1', '自我介绍', '孩子在家中可以给家长介绍幼儿园班级小朋友的基本情况。（如：小朋友的名字，性别）');
INSERT INTO `t_student_task` VALUES ('115', '3', '1', '不独占玩具或图书，学会与同伴分享自己的玩具或图书', '请爸爸妈妈帮助孩子准备一件第二天可以分享的玩具或者图书并向大家介绍玩法\r\n亲子游戏：说说我喜欢的人/玩具。\r\n父母拿着小话筒【道具：棒棒糖/积木都可以】，说说喜欢的人/物品/食物。说：颜色、外观形状、带来的感受，让孩子也来说一说。【可以适当播放轻松愉快的音乐】');
INSERT INTO `t_student_task` VALUES ('116', '3', '2', '学习使用礼貌用语：请，谢谢，不客气，对不起（均使用）', '孩子扮演超市售货员，家长扮演顾客，在买东西的过程中正确使用，请，谢谢，不客气的礼貌用语。');
INSERT INTO `t_student_task` VALUES ('117', '3', '2', '愿意帮助他人，自己有困难时知道求助他人。', '家长带领孩子制作大转盘，转盘上写好自己穿衣，帮助他人收拾物品等，转到什么内容就做相对应的指令。补充：制作方法：硬纸板一块剪成圆形，以圆心为起点分几个扇形区，每个区写上需要完成的内容，圆心上放一把可以手拨转动的汤匙，转到哪个区就做相应的内容指令。');
INSERT INTO `t_student_task` VALUES ('118', '3', '2', '有事情愿意分享，表达自己的诉求/想法。', '亲子游戏：真心话。\r\n家长跟孩子进行猜拳游戏【或者摇骰子】，输的一方来说一说自己的事情【可以是开心的、不开心的】。另一方认真倾听，家长可以进行相应引导，告诉孩子有什么事情可以告诉爸爸妈妈，可以一起分享。');
INSERT INTO `t_student_task` VALUES ('119', '3', '3', '愿意和同伴合作完成游戏', '家长和孩子共同阅读绘本《不听劝说的小公鸡》\r\n  或家长和孩子共同完成建构积木搭房子，要求最低5层楼。或者家长和孩子共同完成跳绳活动，至少连续完成10个。');
INSERT INTO `t_student_task` VALUES ('120', '3', '3', '养成公平选择等待、谦让等行为品质', '在日常生活中，同伴之间玩玩具、玩游戏冲突中引导幼儿采用一定的方式（比如猜拳）决定游戏的先后顺序，这种礼貌社交行为。家长可在家里进行模拟游戏，看孩子的反应，家长进行正向榜样作用。');
INSERT INTO `t_student_task` VALUES ('121', '4', '4', '知道并遵守游戏规则', '孩子在游戏中听规则进行，不捣乱、不耍赖、愿赌服输。父母提前制定规则并达成约定，执行时进行引导孩子。');
INSERT INTO `t_student_task` VALUES ('122', '4', '4', '知道并遵守行人交通规则', '孩子知道“红灯停 绿灯行”车辆交通规则，父母提前知识教授并做好榜样作用，和孩子一起进行，并知道“过马路走人行横道线”行人交通规则，家长提前知识教授并做好榜样作用，和孩子一起进行。【可在家里模拟交通规则游戏】');
INSERT INTO `t_student_task` VALUES ('123', '4', '4', '知道并遵守公共场所规则', '孩子知道“公共场所”垃圾要扔到垃圾桶，不能随手扔垃圾。父母提前知识教授并做好榜样作用，和宝贝一起进行垃圾分类投放到不同的垃圾桶中。【在家里同步执行此规则，适当进行后果教育。如：未做到减少宝贝吃零食量/玩玩具次数等】补充：垃圾分类的知识（适合各年龄段）');
INSERT INTO `t_student_task` VALUES ('124', '4', '4', '对一件事情保持愉悦心情做下去', '亲子阅读：家长每天晚上陪伴孩子阅读一本故事绘本，如《我妈妈》《猜猜我有多爱你》《可爱的身体》等。阅读一个月以上可交换角色，引导鼓励孩子互相分享。补充：陪伴时间20--30分钟');
INSERT INTO `t_student_task` VALUES ('125', '4', '4', '遇到事情不慌张、不怕困难去解决', '亲子家务合作：鼓励孩子每天协助父母摘青菜、摆碗筷、擦桌子等，逐渐培养去做力所能及事情。并分享今天自己做事情的感受、收获。');
INSERT INTO `t_student_task` VALUES ('126', '4', '4', '面对困难时仍然不放弃', '孩子遇事慌张、不知道怎么办时，家长给予一定鼓励。告诉孩子：自己尝试解决问题，没关系有爸爸妈妈在呢！勇敢一点。【父母在日常行为中进行榜样树立，如：讲故事，身教言传。】');
INSERT INTO `t_student_task` VALUES ('127', '4', '4', '从小事做起，培养跌倒自己起来', '孩子喝水不小心水洒了，学会自己擦干净；走路不小心摔倒了，学会自己站起来。父母在旁给予鼓励和引导。【事后继续一定奖励，并说明原因】');
INSERT INTO `t_student_task` VALUES ('128', '4', '4', '鼓励孩子独立做事，接受事情的过程及结果', '鼓励孩子独立穿衣（扣扣子、拉拉链）穿鞋(系鞋带）及帮助父母做力所能及的事情：如擦桌子、洗碗、洗水果、扫地等，这些能力的培养是一个过程。家长首先引导孩子愿意去做，肯定孩子的努力，才能逐渐建立抗挫折的前提能力自信。【完成后家长及时给予表扬或奖励】');
INSERT INTO `t_student_task` VALUES ('129', '4', '4', '面对自己做不好的事情能够承受', '孩子遇到事情受挫折时，家长应及时倾听、疏导；表达自己的态度，相信孩子有独自面对事情的能力。并鼓励支持他去做，不要评价结果，肯定孩子努力的过程。【疏导时建议阅读励志绘本作隐性教育】');
INSERT INTO `t_student_task` VALUES ('130', '4', '4', '愿意主动和他人合作完成任务', '亲子接力游戏：真爱永流传  \r\n准备：一次性吸管10根（条状饼干或其他条状物即可），可挂饰物（例如小毛球）4个，两人间距2米。玩法：每队所有人嘴裏叼支吸管，第一个人把吸管上的饰物顺次放到第二个人的吸管上，以传递速度决定胜负');
INSERT INTO `t_student_task` VALUES ('131', '4', '4', '懂得一些合作的方法', '快乐抱抱爆  \r\n准备：球4个，起跑线和终点线间距为50米，四人  \r\n活动详细：比赛开始后第一组队员背靠背（或胸对胸）夹住气球向场地的终点线移动，（其他队员可以协助放好球）跨过终点线后将球挤爆后下一组才能出发，所有队员最先通过者获胜。');
INSERT INTO `t_student_task` VALUES ('132', '4', '4', '愿意分享自己的想法或者物品', '绘本阅读：《雨中的落花生》《德沃夫爷爷的森林小屋》《好大的苹果》《最好吃的蛋糕》《彩虹鱼迷路了》《一起去露营》等，看完后针对性提问：1、故事有哪些人物？ 2、发生了什么故事？ 3、他们最美好的品质是什么？（你学到了什么？）');
INSERT INTO `t_student_task` VALUES ('133', '4', '4', '喜欢科学小实验，愿意主动探索', '(一）科学小实验：《颜色变变变》：（一）初步探索\r\n1.幼儿自行取一个瓶子，自由摇动，使其变色。魔术之前提醒幼儿观察自己的水宝宝是不是透明的，增加魔术的神秘性\r\n2.水宝宝变色的秘密：家长同时摇动没有颜料的瓶子和有颜料的瓶子再次试验，引导幼儿猜测探索水变色的秘密，并打开瓶盖让幼儿亲自验证。');
INSERT INTO `t_student_task` VALUES ('134', '4', '4', '可以通过一段音乐想象画面，并用语言表达出来', '准备音乐或音频：儿歌（采蘑菇的小姑娘、小红帽、小老鼠上灯台等）、音频（海洋之声、大草原等）；画笔、画纸。\r\n玩法：家长提前说好规则，先认真听音乐或者音频，根据听到的内容进行作画。时间根据幼儿的兴趣度自定义，孩子完成画后，让孩子大胆表述自己的想法，家长引导孩子从多方面想象（内容、色彩、构图等）去欣赏该作品（小班孩子根据旋律去说出自己的感受，中班孩子可以用故事情节来表述，大班孩子可以用连环画形式表现。');
INSERT INTO `t_student_task` VALUES ('135', '4', '4', '能根据主题描述，建造对应的事物（建构活动）', '家庭建构游戏：家长给出相应的主题--《桥》《城堡》《花园》《我的家》《游乐园》等；\r\n和孩子共同回忆或者探讨生活中看到的这些建筑物（必要时可播放一些视频或者图片），并说出其形态特征，为孩子搭建做前期铺垫；补充：如家长：游乐园里都有什么？孩子“城堡”“木马”。。。。。\r\n孩子搭建过程中尽量不打扰，可进行适当引导。搭建成功后，请孩子分享本次搭建的心得。（循序渐进的过程：根据孩子搭建的内容逐渐引导孩子掌握建构的方法--围合、镶嵌、重叠等，并根据生活经验以及自己的想象力、创造力搭建更复杂的建筑物。）');

-- ----------------------------
-- Table structure for t_task
-- ----------------------------
DROP TABLE IF EXISTS `t_task`;
CREATE TABLE `t_task` (
  `tsk_id` int(11) NOT NULL AUTO_INCREMENT,
  `tsk_ip_id` int(11) DEFAULT NULL,
  `tsk_it_id` int(11) DEFAULT NULL,
  `tsk_pm_method` varchar(10) DEFAULT NULL,
  `tsk_pm_header` varchar(255) DEFAULT NULL,
  `tsk_pm_json` varchar(255) DEFAULT NULL,
  `tsk_pm_result` varchar(255) DEFAULT NULL,
  `tsk_time` int(11) DEFAULT NULL,
  `tsk_detail` varchar(64) DEFAULT NULL,
  `tsk_create_time` datetime DEFAULT NULL,
  `tsk_update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`tsk_id`),
  KEY `FK_it_Id` (`tsk_it_id`),
  KEY `FK_sv_id` (`tsk_ip_id`),
  CONSTRAINT `FK_it_Id` FOREIGN KEY (`tsk_it_id`) REFERENCES `t_interface` (`it_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_sv_id` FOREIGN KEY (`tsk_ip_id`) REFERENCES `t_server_ip` (`sv_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_task
-- ----------------------------
INSERT INTO `t_task` VALUES ('1', '22', '12', 'POST', '{Content-Type=application/json,token=2951314e0796466EE5c36ae737566128}', '{\"cardNum\":\"2787504611\",\"companyId\":\"181\"}', '\"code\":200,\"msg\":\"提交成功\"', '5000', '快乐唷唷服务器刷卡接', '2019-02-13 16:43:48', '2019-05-20 14:24:27');
INSERT INTO `t_task` VALUES ('3', '23', '12', 'POST', '{Content-Type=application/json,token=2951314e0796466EE5c36ae737566128}', '{\"cardNum\":\"2787504611\",\"companyId\":\"180\"}', '{\"code\":200,\"msg\":\"提交成功\"}', '5000', '快乐唷唷服务器刷卡接口', '2019-02-18 10:26:21', '2019-05-20 14:24:34');
INSERT INTO `t_task` VALUES ('5', '23', '22', 'POST', 'aa', 'aa', 'aa', '111', '服务器', '2019-02-21 16:38:41', '2019-05-20 14:24:50');
INSERT INTO `t_task` VALUES ('6', '23', '18', 'POST', 'aaa', '{“a”:\"1\"}', '{“a”:\"1\"}', '111', '服务器', '2019-02-21 16:39:21', '2019-05-20 14:24:53');
INSERT INTO `t_task` VALUES ('7', '23', '16', 'POST', '11', '11', '11', '11', '服务器', '2019-05-14 16:02:29', '2019-05-20 14:24:58');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_username` varchar(32) DEFAULT NULL,
  `us_password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`us_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', 'd297a3e622f80bb19ffc593147b9a0c4');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');

-- ----------------------------
-- Procedure structure for insertUser
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertUser`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `insertUser`(IN `name` varchar(20),IN `password` varchar(20))
BEGIN
INSERT INTO t_user (us_username,us_password)VALUES(name,password);
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selectUser
-- ----------------------------
DROP PROCEDURE IF EXISTS `selectUser`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `selectUser`()
BEGIN
	#Routine body goes here...
select * from t_user;
END
;;
DELIMITER ;

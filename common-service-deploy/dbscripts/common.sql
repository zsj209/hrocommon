/*
Navicat MySQL Data Transfer

Source Server         : HROdb003
Source Server Version : 50634
Source Host           : 192.168.11.39:3308
Source Database       : common

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2017-02-07 19:14:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comm_bank_institution
-- ----------------------------
DROP TABLE IF EXISTS `comm_bank_institution`;
CREATE TABLE `comm_bank_institution` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '0 表示正常 1表示删除',
  `import_flag` int(11) DEFAULT NULL COMMENT '导入标记',
  `company_id` int(11) DEFAULT '100' COMMENT '所属公司',
  `bank_name` varchar(200) DEFAULT NULL COMMENT '银行名称',
  `bank_cname` varchar(200) DEFAULT NULL COMMENT '银行简称',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1019 DEFAULT CHARSET=utf8 COMMENT='银行机构';

-- ----------------------------
-- Records of comm_bank_institution
-- ----------------------------
INSERT INTO `comm_bank_institution` VALUES ('1002', null, '2017-01-12 18:31:42', '1015', '2017-02-03 15:31:55', '0', null, '1', '工商银行', 'ICBC', '');
INSERT INTO `comm_bank_institution` VALUES ('1004', null, '2017-01-14 13:50:14', '1015', '2017-02-03 15:32:12', '0', null, '1', '中国银行', 'CBB0', '');
INSERT INTO `comm_bank_institution` VALUES ('1005', null, '2017-01-19 17:53:48', '1015', '2017-02-03 15:32:16', '0', null, '1', '浦发银行', 'pfyy', '');
INSERT INTO `comm_bank_institution` VALUES ('1017', '1015', '2017-02-03 15:33:08', null, null, '1', null, '1', 'TEST', 'TET', '');
INSERT INTO `comm_bank_institution` VALUES ('1018', '1015', '2017-02-06 15:56:09', null, null, '1', null, '1', '11', '11', '');

-- ----------------------------
-- Table structure for comm_calendar
-- ----------------------------
DROP TABLE IF EXISTS `comm_calendar`;
CREATE TABLE `comm_calendar` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '0 表示正常 1表示删除',
  `import_flag` int(11) DEFAULT NULL COMMENT '导入标记',
  `company_id` int(11) DEFAULT '100' COMMENT '所属公司',
  `cal_code` int(11) unsigned DEFAULT NULL COMMENT '期间编码',
  `cal_date` datetime DEFAULT NULL COMMENT '日期',
  `cal_type` varchar(50) DEFAULT NULL COMMENT '上班、休息、节假日',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1016 DEFAULT CHARSET=utf8 COMMENT='日历表';

-- ----------------------------
-- Records of comm_calendar
-- ----------------------------
INSERT INTO `comm_calendar` VALUES ('1001', null, '2017-01-11 21:11:22', '1015', '2017-02-03 16:03:23', '0', null, '1', '1004', '2017-01-01 00:00:00', '01workday', '');
INSERT INTO `comm_calendar` VALUES ('1002', null, '2017-01-12 10:17:03', null, '2017-01-20 17:27:35', '0', null, '1', '1005', '2017-02-01 00:00:00', '02weekend', '');
INSERT INTO `comm_calendar` VALUES ('1003', null, '2017-01-12 10:20:36', null, '2017-01-13 20:04:51', '0', null, '1', '1004', '2017-01-02 00:00:00', '01workday', '');
INSERT INTO `comm_calendar` VALUES ('1007', null, '2017-01-22 18:56:55', null, null, '1', null, '1', '1004', '2017-01-03 00:00:00', '01workday', '');
INSERT INTO `comm_calendar` VALUES ('1010', '1015', '2017-02-04 17:44:45', null, null, '0', null, '1', '1004', '2017-01-03 00:00:00', '01workday', '');
INSERT INTO `comm_calendar` VALUES ('1011', '1015', '2017-02-04 17:54:28', null, null, '0', null, '1', '1004', '2017-01-04 00:00:00', '01workday', '');
INSERT INTO `comm_calendar` VALUES ('1014', '1015', '2017-02-06 15:49:45', null, null, '0', null, '1', '1004', '2017-01-05 00:00:00', '01workday', '');
INSERT INTO `comm_calendar` VALUES ('1015', '1015', '2017-02-06 15:55:52', '1015', '2017-02-06 15:55:59', '0', null, '1', '1004', '2017-01-06 00:00:00', '02weekend', '');

-- ----------------------------
-- Table structure for comm_city_info
-- ----------------------------
DROP TABLE IF EXISTS `comm_city_info`;
CREATE TABLE `comm_city_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_by` int(11) unsigned DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '0 表示正常 1表示删除',
  `import_flag` int(11) unsigned DEFAULT NULL COMMENT '导入标记',
  `company_id` int(11) unsigned DEFAULT '1' COMMENT '所属公司',
  `city_code` varchar(100) DEFAULT NULL COMMENT '编码',
  `city_name` varchar(200) DEFAULT NULL COMMENT '城市名称',
  `city_pid` int(11) unsigned DEFAULT NULL COMMENT '所属上级（保存的是编码）',
  `city_type` varchar(50) DEFAULT NULL COMMENT '1省份、2城市、3区县（公共参数表）\r\n            ',
  `city_isvalid` tinyint(4) unsigned DEFAULT NULL COMMENT '是否启用',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1125 DEFAULT CHARSET=utf8 COMMENT='城市表';

-- ----------------------------
-- Records of comm_city_info
-- ----------------------------
INSERT INTO `comm_city_info` VALUES ('1000', '1000', '2017-01-05 10:43:26', null, '2017-01-19 14:51:09', '0', null, '1', '100', '全国省市', '0', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1001', '1000', '2017-01-06 17:20:17', null, '2017-01-19 14:50:31', '0', null, '1', '109', '上海', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1002', '1000', '2017-01-06 17:20:56', null, '2017-01-19 15:04:24', '0', null, '1', '110', '江苏省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1003', '1000', '2017-01-06 17:21:11', '1015', '2017-02-03 16:02:40', '0', null, '1', '101', '北京', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1004', '1000', '2017-01-06 17:21:31', null, '2017-01-17 16:50:01', '0', null, '1', '110100', '南京', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1005', null, '2017-01-09 14:14:21', null, '2017-01-17 16:50:09', '0', null, '1', '110109', '扬州', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1006', null, '2017-01-09 14:15:09', null, '2017-01-17 16:50:15', '0', null, '1', '110102', '徐州', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1007', null, '2017-01-09 16:12:11', null, '2017-01-17 15:41:59', '0', null, '1', '109100104', '静安区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1008', null, '2017-01-09 16:37:59', null, '2017-01-17 15:45:57', '0', null, '1', '102', '天津', '1000', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1009', null, '2017-01-09 17:10:09', null, '2017-01-17 15:42:19', '0', null, '1', '109100101', '浦东新区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1010', null, '2017-01-10 11:12:47', null, '2017-01-17 15:42:54', '0', null, '1', '109100102', '徐汇区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1012', null, '2017-01-10 13:38:53', null, '2017-01-17 16:50:27', '0', null, '1', '110101', '无锡', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1013', null, '2017-01-12 11:28:14', null, '2017-01-17 15:43:07', '0', null, '1', '109100103', '长宁区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1015', null, '2017-01-12 16:01:05', null, '2017-01-17 16:50:21', '0', null, '1', '110106', '连云港', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1022', null, '2017-01-16 10:06:04', null, '2017-01-17 15:38:51', '0', null, '1', '101100100', '东城区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1023', null, '2017-01-16 10:06:20', null, '2017-01-17 15:39:00', '0', null, '1', '101100101', '西城区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1024', null, '2017-01-16 10:06:41', null, '2017-01-17 15:39:20', '0', null, '1', '101100102', '崇文区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1025', null, '2017-01-16 10:06:57', null, '2017-01-17 15:39:28', '0', null, '1', '101100103', '宣武区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1027', null, '2017-01-17 15:38:24', null, '2017-01-19 20:00:22', '0', null, '1', '101100', '北京市', '1003', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1028', null, '2017-01-17 15:41:06', null, null, '0', null, '1', '109100', '上海市', '1001', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1029', null, '2017-01-17 15:46:48', null, null, '0', null, '1', '102100', '天津市', '1008', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1030', null, '2017-01-17 16:20:38', null, null, '0', null, '1', '101100104', '朝阳区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1031', null, '2017-01-17 16:21:05', null, null, '0', null, '1', '101100105', '丰台区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1032', null, '2017-01-17 16:21:22', null, null, '0', null, '1', '101100106', '石景山区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1033', null, '2017-01-17 16:21:42', null, null, '0', null, '1', '101100107', '海淀区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1034', null, '2017-01-17 16:21:58', null, null, '0', null, '1', '101100108', '门头沟区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1035', null, '2017-01-17 16:22:15', null, null, '0', null, '1', '101100109', '房山区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1036', null, '2017-01-17 16:22:54', null, null, '0', null, '1', '101100110', '通州区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1037', null, '2017-01-17 16:23:12', null, null, '0', null, '1', '101100111', '顺义区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1038', null, '2017-01-17 16:23:31', null, null, '0', null, '1', '101100112', '昌平区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1039', null, '2017-01-17 16:23:46', null, null, '0', null, '1', '101100113', '大兴区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1040', null, '2017-01-17 16:24:08', null, null, '0', null, '1', '101100114', '怀柔区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1041', null, '2017-01-17 16:24:27', null, null, '0', null, '1', '101100115', '平谷区', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1042', null, '2017-01-17 16:25:35', null, null, '0', null, '1', '101100116', '密云县', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1043', null, '2017-01-17 16:25:50', null, null, '0', null, '1', '101100117', '延庆县', '1027', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1044', null, '2017-01-17 16:26:14', null, null, '0', null, '1', '103', '河北省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1045', null, '2017-01-17 16:26:58', null, '2017-01-17 16:28:37', '0', null, '1', '103100', '石家庄', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1046', null, '2017-01-17 16:27:29', null, '2017-01-17 16:28:29', '0', null, '1', '103101', '唐山', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1047', null, '2017-01-17 16:27:48', null, '2017-01-17 16:28:23', '0', null, '1', '103102', '秦皇岛', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1048', null, '2017-01-17 16:28:13', null, null, '0', null, '1', '103103', '邯郸', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1049', null, '2017-01-17 16:28:55', null, null, '0', null, '1', '103104', '邢台', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1050', null, '2017-01-17 16:29:10', null, null, '0', null, '1', '103105', '保定', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1051', null, '2017-01-17 16:29:27', null, null, '0', null, '1', '103107', '承德', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1052', null, '2017-01-17 16:29:44', null, null, '0', null, '1', '103108', '沧州', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1053', null, '2017-01-17 16:30:01', null, null, '0', null, '1', '103109', '廊坊', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1054', null, '2017-01-17 16:30:18', null, null, '0', null, '1', '103110', '衡水', '1044', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1055', null, '2017-01-17 16:30:38', null, null, '0', null, '1', '104', '山西省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1056', null, '2017-01-17 16:31:07', null, null, '0', null, '1', '104100', '太原', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1057', null, '2017-01-17 16:31:21', null, null, '0', null, '1', '104101', '大同', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1058', null, '2017-01-17 16:31:37', null, null, '0', null, '1', '104102', '阳泉', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1059', null, '2017-01-17 16:31:59', null, null, '0', null, '1', '104103', '长治', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1060', null, '2017-01-17 16:32:40', null, null, '0', null, '1', '104104', '晋城', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1061', null, '2017-01-17 16:32:57', null, null, '0', null, '1', '104105', '朔州', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1062', null, '2017-01-17 16:33:12', null, null, '0', null, '1', '104106', '晋中', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1063', null, '2017-01-17 16:33:28', null, null, '0', null, '1', '104107', '运城', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1064', null, '2017-01-17 16:33:43', null, null, '0', null, '1', '104108', '忻州', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1065', null, '2017-01-17 16:34:00', null, null, '0', null, '1', '104109', '临汾', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1066', null, '2017-01-17 16:34:14', null, null, '0', null, '1', '104110', '吕梁', '1055', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1067', null, '2017-01-17 16:34:35', null, null, '0', null, '1', '105', '内蒙古', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1068', null, '2017-01-17 16:34:52', null, null, '0', null, '1', '106', '辽宁省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1069', null, '2017-01-17 16:35:10', null, null, '0', null, '1', '107', '吉林省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1070', null, '2017-01-17 16:35:30', null, null, '0', null, '1', '108', '黑龙江', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1071', null, '2017-01-17 16:36:14', null, null, '0', null, '1', '109100105', '普陀区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1072', null, '2017-01-17 16:36:31', null, null, '0', null, '1', '109100106', '闸北区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1073', null, '2017-01-17 16:36:46', null, null, '0', null, '1', '109100107', '虹口区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1074', null, '2017-01-17 16:37:02', null, null, '0', null, '1', '109100108', '杨浦区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1075', null, '2017-01-17 16:37:18', null, null, '0', null, '1', '109100109', '闵行区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1076', null, '2017-01-17 16:38:08', null, null, '0', null, '1', '109100110', '宝山区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1077', null, '2017-01-17 16:38:31', null, null, '0', null, '1', '109100111', '嘉定区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1078', null, '2017-01-17 16:38:57', null, null, '0', null, '1', '109100112', '金山区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1079', null, '2017-01-17 16:39:14', null, null, '0', null, '1', '109100113', '松江区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1080', null, '2017-01-17 16:39:28', null, null, '0', null, '1', '109100114', '青浦区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1081', null, '2017-01-17 16:39:44', null, null, '0', null, '1', '109100115', '奉贤区', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1082', null, '2017-01-17 16:39:58', null, null, '0', null, '1', '109100116', '崇明县', '1028', '03county', null, '');
INSERT INTO `comm_city_info` VALUES ('1083', null, '2017-01-17 16:40:44', null, null, '0', null, '1', '110103', '常州', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1084', null, '2017-01-17 16:41:03', null, null, '0', null, '1', '110104', '苏州', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1085', null, '2017-01-17 16:41:27', null, null, '0', null, '1', '110105', '南通', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1086', null, '2017-01-17 16:41:42', null, null, '0', null, '1', '110107', '淮安', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1087', null, '2017-01-17 16:41:55', null, null, '0', null, '1', '110108', '盐城', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1088', null, '2017-01-17 16:42:14', null, null, '0', null, '1', '110110', '镇江', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1089', null, '2017-01-17 16:42:29', null, null, '0', null, '1', '110111', '泰州', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1090', null, '2017-01-17 16:42:42', null, null, '0', null, '1', '110112', '宿迁', '1002', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1091', null, '2017-01-17 16:42:57', null, null, '0', null, '1', '111', '浙江省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1092', null, '2017-01-17 16:43:08', null, null, '0', null, '1', '112', '安徽省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1093', null, '2017-01-17 16:43:22', null, null, '0', null, '1', '113', '福建省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1094', null, '2017-01-17 16:43:34', null, null, '0', null, '1', '114', '江西省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1095', null, '2017-01-17 16:43:48', null, null, '0', null, '1', '115', '山东省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1096', null, '2017-01-17 16:44:02', null, null, '0', null, '1', '116', '河南省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1097', null, '2017-01-17 16:44:13', null, null, '0', null, '1', '117', '湖北省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1098', null, '2017-01-17 16:44:25', null, null, '0', null, '1', '118', '湖南省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1099', null, '2017-01-17 16:44:39', null, null, '0', null, '1', '119', '广东省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1100', null, '2017-01-17 16:44:50', null, null, '0', null, '1', '120', '广西', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1101', null, '2017-01-17 16:45:13', null, null, '0', null, '1', '121', '海南省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1102', null, '2017-01-17 16:45:48', null, null, '0', null, '1', '122', '重庆', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1103', null, '2017-01-17 16:46:11', null, null, '0', null, '1', '122100', '重庆市', '1102', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1104', null, '2017-01-17 16:46:27', null, null, '0', null, '1', '123', '四川省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1105', null, '2017-01-17 16:46:37', null, null, '0', null, '1', '124', '贵州省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1106', null, '2017-01-17 16:46:50', null, null, '0', null, '1', '125', '云南省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1107', null, '2017-01-17 16:47:01', null, null, '0', null, '1', '126', '西藏', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1108', null, '2017-01-17 16:47:12', null, null, '0', null, '1', '127', '陕西省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1109', null, '2017-01-17 16:47:23', null, null, '0', null, '1', '128', '甘肃省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1110', null, '2017-01-17 16:47:37', null, null, '0', null, '1', '129', '青海省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1111', null, '2017-01-17 16:47:53', null, null, '0', null, '1', '130', '宁夏', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1112', null, '2017-01-17 16:48:04', null, null, '0', null, '1', '131', '台湾省', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1113', null, '2017-01-17 16:48:22', null, null, '0', null, '1', '132', '新疆 ', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1114', null, '2017-01-17 16:48:33', null, null, '0', null, '1', '133', '香港', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1115', null, '2017-01-17 16:49:00', null, null, '0', null, '1', '133100', '香港', '1114', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1116', null, '2017-01-17 16:49:13', null, null, '0', null, '1', '134', '澳门', '1000', '01prov', null, '');
INSERT INTO `comm_city_info` VALUES ('1117', null, '2017-01-17 16:49:36', null, '2017-01-22 18:40:00', '0', null, '1', '134100', '澳门', '1116', '02city', null, '');
INSERT INTO `comm_city_info` VALUES ('1121', '1012', '2017-02-06 10:25:12', null, null, '1', null, '1', '1', '1', '1007', '03county', null, '11');
INSERT INTO `comm_city_info` VALUES ('1123', '1012', '2017-02-06 16:24:30', null, null, '1', null, '1', '1', 'sdf', '1007', '03county', null, '1');

-- ----------------------------
-- Table structure for comm_city_invalid
-- ----------------------------
DROP TABLE IF EXISTS `comm_city_invalid`;
CREATE TABLE `comm_city_invalid` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_by` int(11) unsigned DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` tinyint(4) unsigned DEFAULT '0' COMMENT '0 表示正常 1表示删除',
  `import_flag` int(11) unsigned DEFAULT NULL COMMENT '导入标记',
  `company_id` int(11) unsigned DEFAULT '100' COMMENT '所属公司',
  `city_id` int(11) unsigned DEFAULT NULL COMMENT '开通城市',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=338 DEFAULT CHARSET=utf8 COMMENT='开通城市表';

-- ----------------------------
-- Records of comm_city_invalid
-- ----------------------------
INSERT INTO `comm_city_invalid` VALUES ('32', '1008', '2017-01-18 13:05:46', null, null, '0', null, '1000', '1000', null);
INSERT INTO `comm_city_invalid` VALUES ('136', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1001', null);
INSERT INTO `comm_city_invalid` VALUES ('137', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1007', null);
INSERT INTO `comm_city_invalid` VALUES ('139', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1009', null);
INSERT INTO `comm_city_invalid` VALUES ('140', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1010', null);
INSERT INTO `comm_city_invalid` VALUES ('141', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1013', null);
INSERT INTO `comm_city_invalid` VALUES ('142', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1028', null);
INSERT INTO `comm_city_invalid` VALUES ('185', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1071', null);
INSERT INTO `comm_city_invalid` VALUES ('186', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1072', null);
INSERT INTO `comm_city_invalid` VALUES ('187', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1073', null);
INSERT INTO `comm_city_invalid` VALUES ('188', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1074', null);
INSERT INTO `comm_city_invalid` VALUES ('189', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1075', null);
INSERT INTO `comm_city_invalid` VALUES ('190', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1076', null);
INSERT INTO `comm_city_invalid` VALUES ('194', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1080', null);
INSERT INTO `comm_city_invalid` VALUES ('195', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1081', null);
INSERT INTO `comm_city_invalid` VALUES ('196', '1030', '2017-01-19 00:21:14', null, null, '0', null, '1000', '1082', null);
INSERT INTO `comm_city_invalid` VALUES ('287', '1042', '2017-01-22 15:30:23', null, null, '0', null, '1000', '1003', null);
INSERT INTO `comm_city_invalid` VALUES ('290', '1042', '2017-01-22 15:30:23', null, null, '0', null, '1000', '1027', null);
INSERT INTO `comm_city_invalid` VALUES ('294', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1022', null);
INSERT INTO `comm_city_invalid` VALUES ('301', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1034', null);
INSERT INTO `comm_city_invalid` VALUES ('302', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1035', null);
INSERT INTO `comm_city_invalid` VALUES ('303', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1036', null);
INSERT INTO `comm_city_invalid` VALUES ('304', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1037', null);
INSERT INTO `comm_city_invalid` VALUES ('305', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1038', null);
INSERT INTO `comm_city_invalid` VALUES ('306', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1039', null);
INSERT INTO `comm_city_invalid` VALUES ('307', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1040', null);
INSERT INTO `comm_city_invalid` VALUES ('308', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1041', null);
INSERT INTO `comm_city_invalid` VALUES ('309', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1042', null);
INSERT INTO `comm_city_invalid` VALUES ('310', '1042', '2017-01-22 15:31:24', null, null, '0', null, '1000', '1043', null);
INSERT INTO `comm_city_invalid` VALUES ('325', '1042', '2017-01-22 15:39:11', null, null, '0', null, '1000', '1023', null);
INSERT INTO `comm_city_invalid` VALUES ('328', '1042', '2017-01-22 15:59:58', null, null, '0', null, '1000', '1024', null);
INSERT INTO `comm_city_invalid` VALUES ('329', '1042', '2017-01-22 15:59:58', null, null, '0', null, '1000', '1025', null);
INSERT INTO `comm_city_invalid` VALUES ('330', '1042', '2017-01-22 15:59:58', null, null, '0', null, '1000', '1030', null);
INSERT INTO `comm_city_invalid` VALUES ('331', '1042', '2017-01-22 15:59:58', null, null, '0', null, '1000', '1031', null);
INSERT INTO `comm_city_invalid` VALUES ('332', '1042', '2017-01-22 15:59:58', null, null, '0', null, '1000', '1032', null);
INSERT INTO `comm_city_invalid` VALUES ('333', '1042', '2017-01-22 15:59:58', null, null, '0', null, '1000', '1033', null);
INSERT INTO `comm_city_invalid` VALUES ('335', '1042', '2017-01-22 16:01:21', null, null, '0', null, '1000', '1077', null);
INSERT INTO `comm_city_invalid` VALUES ('336', '1042', '2017-01-22 16:01:21', null, null, '0', null, '1000', '1078', null);
INSERT INTO `comm_city_invalid` VALUES ('337', '1042', '2017-01-22 16:01:21', null, null, '0', null, '1000', '1079', null);

-- ----------------------------
-- Table structure for comm_param_info
-- ----------------------------
DROP TABLE IF EXISTS `comm_param_info`;
CREATE TABLE `comm_param_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '0 表示正常 1表示删除',
  `import_flag` int(11) DEFAULT NULL COMMENT '导入标记',
  `company_id` int(11) DEFAULT '100' COMMENT '所属公司',
  `param_code` varchar(200) DEFAULT NULL COMMENT '参数编码',
  `param_type` varchar(50) DEFAULT NULL COMMENT '参数类型',
  `param_name` varchar(200) DEFAULT NULL COMMENT '参数名称',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1105 DEFAULT CHARSET=utf8 COMMENT='参数信息表';

-- ----------------------------
-- Records of comm_param_info
-- ----------------------------
INSERT INTO `comm_param_info` VALUES ('1000', null, null, null, '2017-01-20 19:48:33', '0', null, '1', '01salary', 'taxtype', '工资税', '');
INSERT INTO `comm_param_info` VALUES ('1001', null, null, null, '2017-01-17 20:48:47', '0', null, '1', '02labour', 'taxtype', '年终奖税', '');
INSERT INTO `comm_param_info` VALUES ('1027', null, null, null, '2017-01-25 10:08:34', '0', null, '1', '01id', 'idtype', '身份证', '');
INSERT INTO `comm_param_info` VALUES ('1028', null, null, null, '2017-01-25 10:08:40', '0', null, '1', '02armyid', 'idtype', '军官证', '');
INSERT INTO `comm_param_info` VALUES ('1029', null, null, null, null, '0', null, '1', '03passport', 'idtype', '护照', null);
INSERT INTO `comm_param_info` VALUES ('1030', null, null, '1030', '2017-02-05 07:23:47', '0', null, '1', '04other', 'idtype', '其它卡证', '');
INSERT INTO `comm_param_info` VALUES ('1031', null, null, null, null, '0', null, '1', '01prov', 'citytype', '省份', null);
INSERT INTO `comm_param_info` VALUES ('1032', null, null, null, null, '0', null, '1', '02city', 'citytype', '城市', null);
INSERT INTO `comm_param_info` VALUES ('1033', null, null, null, null, '0', null, '1', '03county', 'citytype', '区县', null);
INSERT INTO `comm_param_info` VALUES ('1034', null, null, null, null, '0', null, '1', '01CPC', 'political', '中共党员', null);
INSERT INTO `comm_param_info` VALUES ('1036', null, null, null, null, '0', null, '1', '03nonparty', 'political', '无党派民主人士', null);
INSERT INTO `comm_param_info` VALUES ('1037', null, null, null, null, '0', null, '1', '04common', 'political', '群众', null);
INSERT INTO `comm_param_info` VALUES ('1038', null, null, null, null, '0', null, '1', '05other', 'political', '其他', null);
INSERT INTO `comm_param_info` VALUES ('1044', null, null, null, null, '0', null, '1', '01hrocloud', 'comptype', 'HROCLOUD', null);
INSERT INTO `comm_param_info` VALUES ('1045', null, null, null, null, '0', null, '1', '02hro', 'comptype', 'HRO公司', null);
INSERT INTO `comm_param_info` VALUES ('1046', null, null, null, null, '0', null, '1', '03hrocus', 'comptype', 'HRO客户', null);
INSERT INTO `comm_param_info` VALUES ('1047', null, null, null, null, '0', null, '1', '04cus', 'comptype', '独立公司', null);
INSERT INTO `comm_param_info` VALUES ('1048', null, null, null, null, '0', null, '1', '05hrovend', 'comptype', 'HRO供应商', null);
INSERT INTO `comm_param_info` VALUES ('1049', null, null, null, null, '0', null, '1', '06insu', 'comptype', '商保公司', null);
INSERT INTO `comm_param_info` VALUES ('1050', null, null, null, null, '0', null, '1', '0root', 'bustype', '超级管理', null);
INSERT INTO `comm_param_info` VALUES ('1051', null, null, null, null, '0', null, '1', '1admin', 'bustype', '后台管理', null);
INSERT INTO `comm_param_info` VALUES ('1052', null, null, null, null, '0', null, '1', '2hroadmin', 'bustype', 'HRO管理', null);
INSERT INTO `comm_param_info` VALUES ('1053', null, null, null, null, '0', null, '1', '3user', 'bustype', '业务操作', null);
INSERT INTO `comm_param_info` VALUES ('1054', null, null, null, null, '0', null, '1', '4ess', 'bustype', 'ESS', null);
INSERT INTO `comm_param_info` VALUES ('1055', null, null, null, null, '0', null, '1', '5mss', 'bustype', 'MSS', null);
INSERT INTO `comm_param_info` VALUES ('1056', null, null, null, null, '0', null, '1', '01hf', 'hosfinstype', '住房公积金', null);
INSERT INTO `comm_param_info` VALUES ('1057', null, null, null, null, '0', null, '1', '02suphf', 'hosfinstype', '补充公积金', null);
INSERT INTO `comm_param_info` VALUES ('1058', null, null, null, null, '0', null, '1', '01pension', 'scbinstype', '养老保险', null);
INSERT INTO `comm_param_info` VALUES ('1059', null, null, null, null, '0', null, '1', '02medical', 'scbinstype', '医疗保险', null);
INSERT INTO `comm_param_info` VALUES ('1060', null, null, null, null, '0', null, '1', '03unemp', 'scbinstype', '失业保险', null);
INSERT INTO `comm_param_info` VALUES ('1061', null, null, null, null, '0', null, '1', '04maternity', 'scbinstype', '生育保险', null);
INSERT INTO `comm_param_info` VALUES ('1062', null, null, null, null, '0', null, '1', '05injury', 'scbinstype', '工伤保险', null);
INSERT INTO `comm_param_info` VALUES ('1063', null, null, null, null, '0', null, '1', '06supmedical', 'scbinstype', '补充医疗保险', null);
INSERT INTO `comm_param_info` VALUES ('1064', null, null, null, null, '0', null, '1', '07majmedical', 'scbinstype', '重大医疗保险', null);
INSERT INTO `comm_param_info` VALUES ('1065', null, null, null, null, '0', null, '1', '08composite', 'scbinstype', '综合保险', null);
INSERT INTO `comm_param_info` VALUES ('1066', null, null, null, null, '0', null, '1', '01sswrtoyuan', 'decimalRule', '四舍五入到元', '保留0位小数');
INSERT INTO `comm_param_info` VALUES ('1067', null, null, null, null, '0', null, '1', '02sswrtojiao', 'decimalRule', '四舍五入到角', '保留1位小数');
INSERT INTO `comm_param_info` VALUES ('1068', null, null, null, null, '0', null, '1', '03sswrtofen', 'decimalRule', '四舍五入到分', '保留2位小数');
INSERT INTO `comm_param_info` VALUES ('1069', null, null, null, null, '0', null, '1', '04sswrtoli', 'decimalRule', '四舍五入到厘', '保留3位小数');
INSERT INTO `comm_param_info` VALUES ('1070', null, null, null, null, '0', null, '1', '05jjjy', 'decimalRule', '见角进元', '保留0位小数');
INSERT INTO `comm_param_info` VALUES ('1071', null, null, null, null, '0', null, '1', '06jfjj', 'decimalRule', '见分进角', '保留1位小数');
INSERT INTO `comm_param_info` VALUES ('1072', null, null, null, null, '0', null, '1', '07jljf', 'decimalRule', '见厘进分', '保留2位小数');
INSERT INTO `comm_param_info` VALUES ('1073', null, null, null, null, '0', null, '1', '08jhjl', 'decimalRule', '见毫进厘', '保留3位小数');
INSERT INTO `comm_param_info` VALUES ('1074', null, null, null, null, '0', null, '1', '09qstoyuan', 'decimalRule', '全舍到元', '保留0位小数');
INSERT INTO `comm_param_info` VALUES ('1075', null, null, null, null, '0', null, '1', '10qstojiao', 'decimalRule', '全舍到角', '保留1位小数');
INSERT INTO `comm_param_info` VALUES ('1076', null, null, null, null, '0', null, '1', '11qstofen', 'decimalRule', '全舍到分', '保留2位小数');
INSERT INTO `comm_param_info` VALUES ('1077', null, null, null, null, '0', null, '1', '12qstoli', 'decimalRule', '全舍到厘', '保留3位小数');
INSERT INTO `comm_param_info` VALUES ('1078', null, null, null, null, '0', null, '1', '01sets', 'cominstype', '套餐保险', '');
INSERT INTO `comm_param_info` VALUES ('1079', null, null, null, null, '0', null, '1', '02child', 'cominstype', '子女保险', '');
INSERT INTO `comm_param_info` VALUES ('1080', null, null, null, null, '0', null, '1', '03spouse', 'cominstype', '配偶保险', '');
INSERT INTO `comm_param_info` VALUES ('1081', null, null, null, null, '0', null, '1', '04accident', 'cominstype', '意外人身保险', '');
INSERT INTO `comm_param_info` VALUES ('1093', null, '2017-01-20 19:53:43', null, null, '0', null, '1', '01draft', 'pubstatus', '编辑中', '');
INSERT INTO `comm_param_info` VALUES ('1094', null, '2017-01-20 19:54:00', null, null, '0', null, '1', '02valid', 'pubstatus', '生效', '');
INSERT INTO `comm_param_info` VALUES ('1095', null, '2017-01-20 19:54:22', null, null, '0', null, '1', '03invalid', 'pubstatus', '失效/终止', '');
INSERT INTO `comm_param_info` VALUES ('1099', null, null, null, null, '0', null, '1', '01main', 'funstyle', '主节点', null);
INSERT INTO `comm_param_info` VALUES ('1100', null, null, null, null, '0', null, '1', '02sub', 'funstyle', '内部子节点(子集)', null);
INSERT INTO `comm_param_info` VALUES ('1101', null, null, null, null, '0', null, '1', '03status', 'funstyle', '数据状态', null);

-- ----------------------------
-- Table structure for comm_param_type
-- ----------------------------
DROP TABLE IF EXISTS `comm_param_type`;
CREATE TABLE `comm_param_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` tinyint(4) DEFAULT '0' COMMENT '0 表示正常 1表示删除',
  `import_flag` int(11) DEFAULT NULL COMMENT '导入标记',
  `company_id` int(11) DEFAULT '100' COMMENT '所属公司',
  `type_code` varchar(50) DEFAULT NULL COMMENT '编码',
  `type_name` varchar(100) DEFAULT NULL COMMENT '参数类型',
  `type_isupdate` tinyint(4) DEFAULT '0' COMMENT '是否可修改标志',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1053 DEFAULT CHARSET=utf8 COMMENT='参数类型表';

-- ----------------------------
-- Records of comm_param_type
-- ----------------------------
INSERT INTO `comm_param_type` VALUES ('1001', null, null, null, '2017-01-20 19:47:42', '0', null, '1', 'taxtype', '税率类别', null, '');
INSERT INTO `comm_param_type` VALUES ('1024', null, null, null, null, '0', null, '1', 'idtype', '证件类型', '0', null);
INSERT INTO `comm_param_type` VALUES ('1025', null, null, null, '2017-01-13 18:15:12', '0', null, '1', 'citytype', '城市类型', '0', '');
INSERT INTO `comm_param_type` VALUES ('1026', null, null, null, null, '0', null, '1', 'political', '政治面貌', '0', null);
INSERT INTO `comm_param_type` VALUES ('1027', null, null, null, '2017-01-20 19:44:43', '0', null, '1', 'pubstatus', '业务状态', null, '包括用户状态/公司状态/岗位状态/商保险种状态/商保套餐状态/');
INSERT INTO `comm_param_type` VALUES ('1029', null, null, null, null, '0', null, '1', 'comptype', '公司类型', '0', '');
INSERT INTO `comm_param_type` VALUES ('1030', null, null, null, null, '0', null, '1', 'bustype', '功能结点/角色分类', '0', '');
INSERT INTO `comm_param_type` VALUES ('1031', null, null, null, null, '0', null, '1', 'hosfinstype', '公积金险种归属', '0', '');
INSERT INTO `comm_param_type` VALUES ('1032', null, null, null, null, '0', null, '1', 'scbinstype', '社保险种险种归属', '0', '');
INSERT INTO `comm_param_type` VALUES ('1033', null, null, null, null, '0', null, '1', 'decimalRule', '社保险种险种归属', '0', '');
INSERT INTO `comm_param_type` VALUES ('1034', null, null, null, null, '0', null, '1', 'cominstype', '商保险种类型', '0', '');
INSERT INTO `comm_param_type` VALUES ('1048', null, '2017-01-11 20:29:11', null, '2017-01-24 20:29:17', '0', null, '1', 'funstyle', '功能节点标识', '0', '功能节点标识');
INSERT INTO `comm_param_type` VALUES ('1052', '1015', '2017-02-06 17:07:49', null, null, '1', null, '1', 'test', 'test', null, '');

-- ----------------------------
-- Table structure for comm_period
-- ----------------------------
DROP TABLE IF EXISTS `comm_period`;
CREATE TABLE `comm_period` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` int(11) unsigned DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `delete_flag` tinyint(4) unsigned DEFAULT '0' COMMENT '0 表示正常 1表示删除',
  `import_flag` int(11) unsigned DEFAULT NULL COMMENT '导入标记',
  `company_id` int(11) unsigned DEFAULT '100' COMMENT '所属公司',
  `period_code` varchar(20) DEFAULT NULL COMMENT '期间编码',
  `period_year` int(11) DEFAULT NULL COMMENT '期间年份',
  `period_month` varchar(50) DEFAULT NULL COMMENT '期间月份',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '截止日期',
  `comment` varchar(1000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1027 DEFAULT CHARSET=utf8 COMMENT='期间表';

-- ----------------------------
-- Records of comm_period
-- ----------------------------
INSERT INTO `comm_period` VALUES ('1004', null, '2017-01-11 13:41:30', '1015', '2017-02-03 16:02:59', '0', null, '1', '201701', '2017', '01', '2017-01-01 00:00:00', '2017-01-31 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1005', null, '2017-01-12 10:15:54', '1015', '2017-02-04 10:42:25', '0', null, '1', '201702', '2017', '02', '2017-02-11 00:00:00', '2017-02-28 00:00:00', '1');
INSERT INTO `comm_period` VALUES ('1009', null, '2017-01-17 10:55:33', null, null, '0', null, '1', '201704', '2017', '04', '2017-04-01 00:00:00', '2017-04-30 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1010', null, '2017-01-17 11:00:52', null, null, '0', null, '1', '201705', '2017', '05', '2017-05-01 00:00:00', '2017-05-31 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1013', null, '2017-01-17 11:33:02', null, '2017-01-20 15:56:56', '1', null, '1', '201703', '2017', '03', '2017-03-01 00:00:00', '2017-03-31 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1017', null, '2017-01-22 18:52:28', null, null, '1', null, '1', '201706', '2017', '06', '2017-06-01 00:00:00', '2017-06-30 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1021', null, '2017-02-03 15:06:05', '1015', '2017-02-04 10:45:36', '0', null, '1', '201703', '2017', '03', '2017-03-01 00:00:00', '2017-03-31 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1022', '1015', '2017-02-04 10:51:22', null, null, '0', null, '1', '201707', '2017', '07', '2017-07-01 00:00:00', '2017-07-31 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1023', '1015', '2017-02-04 17:55:03', null, null, '0', null, '1', '201706', '2017', '06', '2017-06-01 00:00:00', '2017-06-30 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1025', '1015', '2017-02-06 15:14:53', null, null, '0', null, '1', '201708', '2017', '08', '2017-08-01 00:00:00', '2017-08-31 00:00:00', '');
INSERT INTO `comm_period` VALUES ('1026', '1015', '2017-02-06 15:55:27', null, null, '0', null, '1', '201709', '2017', '09', '2017-09-01 00:00:00', '2017-09-30 00:00:00', '');

-- ----------------------------
-- Function structure for queryChildrenAreaInfo
-- ----------------------------
DROP FUNCTION IF EXISTS `queryChildrenAreaInfo`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `queryChildrenAreaInfo`(cityCode int) RETURNS varchar(4000) CHARSET utf8
BEGIN

DECLARE sTemp VARCHAR(4000);

DECLARE sTempChd VARCHAR(4000);


SET sTemp = '';

SET sTempChd = cast(cityCode as char);


WHILE sTempChd is not NULL DO

SET sTemp = CONCAT(sTemp,',',sTempChd);

SELECT group_concat(id) INTO sTempChd FROM comm_city_info where FIND_IN_SET(city_pid,sTempChd)>0;

END WHILE;

return SUBSTRING(sTemp,2,LENGTH(sTemp));
END
;;
DELIMITER ;

-- 数据库
CREATE DATABASE `online_inspection_tracker`;

-- H5用例
CREATE TABLE `onlinespatrol` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '本条记录的序号',
  `url` varchar(1000) DEFAULT NULL COMMENT 'h5的地址',
  `title` varchar(255) DEFAULT NULL COMMENT '页面标题',
  `htmlinfo` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `groupId` varchar(255) DEFAULT NULL COMMENT '业务线',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `datum_address` varchar(255) DEFAULT NULL COMMENT '基准图',
  `datum_createtime` datetime DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(255) DEFAULT NULL COMMENT '告警人',
  `need_login` int(11) NOT NULL DEFAULT '0' COMMENT '0-不需要登录；1-必须登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=138 DEFAULT CHARSET=utf8;

-- 用例执行结果

CREATE TABLE `case_response` (
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `response_time` bigint(20) DEFAULT NULL,
  `case_id` bigint(20) NOT NULL,
  `states` bigint(20) DEFAULT NULL COMMENT '1.成功;2.失败;3.忽略',
  `failed_reason` varchar(100) DEFAULT NULL,
  `Column4` varchar(100) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Column3` varchar(100) DEFAULT NULL,
  `Column5` varchar(100) DEFAULT NULL,
  `Column6` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `case_response_case_id_IDX` (`case_id`,`states`,`response_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4323177 DEFAULT CHARSET=utf8 COMMENT='响应时间';

-- 测试计划

CREATE TABLE `test_plan_result` (
  `url` varchar(100) DEFAULT NULL COMMENT '报告地址',
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `total_num` int(11) DEFAULT '0' COMMENT '用例总数',
  `passed_num` int(11) DEFAULT '0' COMMENT '用例通过数',
  `failed_num` int(11) DEFAULT '0' COMMENT '用例失败数',
  `skiped_num` int(11) DEFAULT '0' COMMENT '用户忽略数',
  `begin_time` datetime DEFAULT NULL COMMENT '开始执行时间',
  `duration` bigint(20) DEFAULT NULL COMMENT '执行时长',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36483 DEFAULT CHARSET=utf8;
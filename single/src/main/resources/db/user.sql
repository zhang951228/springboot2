-------------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `user_uuid` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                           `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户名',
                           `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                           `real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
                           `age` int(11) NULL DEFAULT NULL,
                           `sex` int(11) NULL DEFAULT NULL COMMENT '1.男 2女',
                           `birth_day` datetime(0) NULL DEFAULT NULL,
                           `user_level` int(11) NULL DEFAULT NULL COMMENT '学生年级(1-12)',
                           `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                           `role` int(11) NULL DEFAULT NULL COMMENT '1.学生 2.老师 3.管理员',
                           `status` int(11) NULL DEFAULT NULL COMMENT '1.启用 2禁用',
                           `image_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像地址',
                           `create_time` datetime(0) NULL DEFAULT NULL,
                           `modify_time` datetime(0) NULL DEFAULT NULL,
                           `last_active_time` datetime(0) NULL DEFAULT NULL,
                           `deleted` bit(1) NULL DEFAULT NULL COMMENT '是否删除',
                           `wx_open_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '微信openId',
                           PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;
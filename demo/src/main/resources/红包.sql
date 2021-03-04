CREATE TABLE `t_red_packet` (
    `id` int(12) NOT NULL AUTO_INCREMENT,
    `user_id` int(12) DEFAULT NULL,
    `amount` decimal(16,2) DEFAULT NULL,
    `send_date` timestamp NULL DEFAULT NULL,
    `total` int(12) DEFAULT NULL,
    `unit_amount` decimal(12,0) DEFAULT NULL,
    `stock` int(12) DEFAULT NULL,
    `version` int(12) unsigned DEFAULT NULL,
    `note` varchar(256) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
CREATE TABLE `t_user_red_packet` (
    `id` int(12) NOT NULL AUTO_INCREMENT,
    `red_packet_id` int(12) DEFAULT NULL,
    `user_id` int(12) DEFAULT NULL,
    `amount` decimal(16,2) DEFAULT NULL,
    `grab_time` timestamp NULL DEFAULT NULL,
    `note` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `t_red_packet` VALUES (1, 1, 100.00, '2021-3-3 16:10:29', 50, 10, 50, 50, '');

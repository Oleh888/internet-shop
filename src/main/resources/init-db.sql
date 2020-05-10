CREATE SCHEMA `internet_shop` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE `internet_shop`.`products` (
    `product_id` BIGINT(11) NOT NULL AUTO_INCREMENT,
    `product_name` VARCHAR(225) NOT NULL,
    `price` DECIMAL(20) NOT NULL,
    PRIMARY KEY (`product_id`)
    );

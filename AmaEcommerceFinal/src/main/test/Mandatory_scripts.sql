DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `emailId` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `active` int(11) DEFAULT NULL,
  `is_vendor` int(11) DEFAULT 0,
  CONSTRAINT UNIQUE_USERNAME_EMAIL UNIQUE (`username`,`emailId`),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `userrole` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(45) DEFAULT NULL,
  `rowstate` bigint(100) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `userrolemapping`;
CREATE TABLE `userrolemapping` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_user_role_roleid_idx` (`role_id`),
  CONSTRAINT `FK_USER_ROLE_ROLEID` FOREIGN KEY (`role_id`) REFERENCES `userrole` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_USER_ROLE_USERID` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `productId` bigint(13) NOT NULL AUTO_INCREMENT,
  `productCodeSku` varchar(255) NOT NULL,
  `vendorProductId` varchar(255) DEFAULT NULL,
  `productName` varchar(255) NOT NULL,
  `productDescription` nvarchar(2000) DEFAULT NULL,
  `supplierId` bigint(13) default NULL,
  `categoryId` bigint(13) default NULL,
  `qtyPerUnit` int(11) default NULL,
  `unitPrice` bigint(13) NOT NULL,
  `availableSizes` varchar(255) DEFAULT NULL,
  `availableColors` varchar(255) DEFAULT NULL,
  `sizeId` int(11) default NULL,
  `colorId` int(11) default NULL,
  `discount` int(11) default NULL,
  `unitsInStock` int(11) default NULL,
  `destFilePath` nvarchar(2000) DEFAULT NULL,
  `dateCreated` datetime NOT NULL,
  `rowstate` int(11) default NULL,
  CONSTRAINT UNIQUE_PRODUCT_CODE UNIQUE (`productCodeSku`),
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `Orders`;
CREATE TABLE `Orders` (
  `order_id` bigint(13) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL,
  `order_number` bigint(13) NOT NULL,
  `payment_id` bigint(13) default NULL,
  `order_date` datetime NOT NULL,
  `ship_date` datetime default NULL,
  `shipper_id` bigint(13) default NULL,
  `freight` bigint(13) default NULL,
  `sales_tax` bigint(13) default NULL,
  `transact_status` int(11) default NULL,
  `total_amount` bigint(13) default NULL,
  `payment_date` datetime default NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `customer_phone` varchar(255) DEFAULT NULL,
  `customer_address` varchar(255) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `rowstate` int(11) default NULL,
  CONSTRAINT UNIQUE_ORDER_NUMBER UNIQUE (`order_number`),
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `OrderDetails`;
CREATE TABLE `OrderDetails` (
  `order_detailId` bigint(13) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(13) default NULL,
  `order_number` bigint(13) NOT NULL,
  `product_id` varchar(255) NOT NULL,
  `price` bigint(13) NOT NULL,
  `quantity` bigint(13) NOT NULL,
  `discount` bigint(13) default NULL,
  `total_amount` bigint(13) NOT NULL,
  `ship_date` datetime default NULL,
  `size` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `date_created` datetime NOT NULL,
  `rowstate` int(11) default NULL,
  PRIMARY KEY (`order_detailId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

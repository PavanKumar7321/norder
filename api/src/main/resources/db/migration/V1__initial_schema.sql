SET NAMES utf8;
SET
    time_zone = '+00:00';
SET
    sql_mode = 'NO_AUTO_VALUE_ON_ZERO';


CREATE
    DATABASE IF NOT EXISTS `${schema}` DEFAULT CHARACTER SET utf8
    DEFAULT COLLATE utf8_general_ci;

USE
`${schema}`;

DROP TABLE IF EXISTS `organization`;

CREATE TABLE `organization`
(
    `id`                 char(36)    NOT NULL,
    `name`         varchar(50) NULL,
    `description`          varchar(500) NOT NULL,
    `domain`          varchar(50) NOT NULL,
    `disabled`            boolean     NOT NULL default false,
    `created_date_time`  timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date_time` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `org_name_unique` (`name`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles`
(
    `id`                 char(36)    NOT NULL,
    `name`         varchar(50) NULL,
    `created_date_time`  timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date_time` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `org_name_unique` (`name`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`
(
    `id`                 char(36)    NOT NULL,
    `first_name`         varchar(50) NULL,
    `last_name`          varchar(50) NOT NULL,
    `email`              varchar(50) NOT NULL,
    `password`           varchar(500),
    `role_name`          varchar(500) NOT NULL DEFAULT 'ROLE_USER',
    `disabled`            boolean     NOT NULL default false,
    `status`                 ENUM('pending', 'banned', 'rejected', 'active') DEFAULT 'active',
    `is_verified`            boolean      NOT NULL default false,
    `address`                varchar(100),
    `city`                   varchar(50),
    `state`                  varchar(50),
    `zip_code`               varchar(10),
    `country`                varchar(50),
    `company`                varchar(100),
     `team`                varchar(50),
    `phone_number`           varchar(20),
    `avatar_url`             varchar(255),
    `cover_url`             varchar(255),
    `total_followers`        int,
    `total_following`        int,
    `about`             	 varchar(255),
    `created_date_time`  timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date_time` timestamp NULL DEFAULT NULL,
    `organization_id`   char(36) not null references organization(`id`),
        
    PRIMARY KEY (`id`),
    UNIQUE KEY `user_email_unique` (`email`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles`
(
    `id`                     char(36)    NOT NULL,
    `user_id`                char(36)    NOT NULL,
    `role_id`                char(36)    NOT NULL,
    `created_date_time`      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date_time` timestamp NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;
    
DROP TABLE IF EXISTS `user_password_reset_request`;

CREATE TABLE `user_password_reset_request`
(
    `id`                     char(36)    NOT NULL,
    `user_id`                char(36)    NOT NULL,
    `expire_date_time`       timestamp not null,
    `created_date_time`      timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `last_updated_date_time` timestamp NULL     DEFAULT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `product`;

CREATE TABLE product (
    id CHAR(36) NOT NULL,
    gender VARCHAR(255) NOT NULL,
    publish VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL,
    available INT NOT NULL,
    price_sale FLOAT,
    taxes INT NOT NULL,
    quantity INT NOT NULL,
    inventory_type VARCHAR(255) NOT NULL,
    description TEXT,
    sku VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP,
    name VARCHAR(255) NOT NULL,
    code VARCHAR (255) UNIQUE NOT NULL,
    price FLOAT NOT NULL,
    cover_url VARCHAR(255),
    total_ratings FLOAT NOT NULL,
    total_sold INT NOT NULL,
    total_reviews INT NOT NULL,
    sub_description VARCHAR(255),
    new_label_enabled BOOLEAN,
    new_label_content VARCHAR(255),
    sale_label_enabled BOOLEAN,
    sale_label_content VARCHAR(255),
    created_date_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY `prod_name_unique` (`name`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `size`;

CREATE TABLE size (
    product_id CHAR(36) NOT NULL,
    sizes VARCHAR(255) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `tags`;

CREATE TABLE tags (
    product_id CHAR(36) NOT NULL,
    tags VARCHAR(255) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `image`;

CREATE TABLE image (
    product_id CHAR(36) NOT NULL,
    images VARCHAR(255),
    FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `color`;

CREATE TABLE color (
    product_id CHAR(36) NOT NULL,
    colors VARCHAR(255) NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `rating`;

CREATE TABLE rating (
	id CHAR(36) NOT NULL,
    product_id CHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    star_count INT NOT NULL,
    review_count INT NOT NULL,
    created_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id),
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `review`;

CREATE TABLE review (
    id CHAR(36) NOT NULL,
    product_id CHAR(36) NULL,
    name VARCHAR(255) NOT NULL,
    posted_at TIMESTAMP NOT NULL,
    comment TEXT NOT NULL,
    is_purchased BOOLEAN NOT NULL,
    rating FLOAT NOT NULL,
    avatar_url VARCHAR(255) NOT NULL,
    helpful INT NOT NULL,
    created_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id),
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE attachment (
    review_id CHAR(36) NOT NULL,
    attachments VARCHAR(255),
    FOREIGN KEY (review_id) REFERENCES review(id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;



DROP TABLE IF EXISTS `orders`;

CREATE TABLE orders (
    id CHAR(36)    NOT NULL,
    order_number VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    taxes              DOUBLE NOT NULL,
    sub_total           DOUBLE NOT NULL,
    shipping           DOUBLE NOT NULL,
    discount           DOUBLE NOT NULL,
    total_amount        DOUBLE NOT NULL,
    total_quantity      INT NOT NULL,
    status             ENUM('pending', 'completed', 'cancelled', 'refunded') DEFAULT 'pending',
    customer_id CHAR(36)    NOT NULL,
    customer_name VARCHAR(255),
    customer_email VARCHAR(255),
    customer_avatar_url VARCHAR(255),
    customer_ip_address VARCHAR(255),
    delivery_ship_by VARCHAR(255),
    delivery_speedy VARCHAR(150),
    delivery_tracking_number VARCHAR(255),
    shipping_full_address VARCHAR(100),
    shipping_phone_number VARCHAR(20),
    payment_card_type VARCHAR(10),
    payment_card_number VARCHAR(20),
    created_date_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,        
    PRIMARY KEY (id),
    UNIQUE KEY order_num_unique (order_number)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `item`;

CREATE TABLE item (
	id CHAR(36) NOT NULL,
	orders_id CHAR(36) NOT NULL,
    sku CHAR(36) NOT NULL,
    quantity INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    cover_url VARCHAR(255),
    price FLOAT,
    created_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (orders_id) REFERENCES orders(id),
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `history`;

CREATE TABLE history (
    id CHAR(36) NOT NULL,
    orders_id CHAR(36) NOT NULL,
    order_time TIMESTAMP NULL,
    payment_time TIMESTAMP NULL,
    delivery_time TIMESTAMP NULL,
    completion_time TIMESTAMP NULL,
    created_date_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (orders_id) REFERENCES orders(id),
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `timeline`;

CREATE TABLE timeline  (
    id CHAR(36) NOT NULL,
    history_id CHAR(36) NOT NULL,
    title VARCHAR(255) NOT NULL,
    time TIMESTAMP NULL,
    created_date_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    FOREIGN KEY (history_id) REFERENCES history(id),
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `address`;

CREATE TABLE address (
	id CHAR(36) NOT NULL,
    name VARCHAR(255),
    company VARCHAR(255),
    is_primary BOOLEAN,
    full_address VARCHAR(255),
    phone_number VARCHAR(20),
    address_type VARCHAR(150),
    created_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS `invoice`;

CREATE TABLE invoice (
	id CHAR(36) NOT NULL,
    sent INT,
    due_date TIMESTAMP,
    taxes DOUBLE,
    status ENUM('paid', 'pending', 'overdue', 'draft'),
    sub_total DOUBLE,
    create_date TIMESTAMP,
    discount DOUBLE,
    shipping DOUBLE,
    total_amount DOUBLE,
    invoice_number VARCHAR(255),
    invoice_from_id CHAR(36),
    invoice_to_id CHAR(36),
    created_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (invoice_from_id) REFERENCES address(id) ON DELETE SET NULL,
    FOREIGN KEY (invoice_to_id) REFERENCES address(id) ON DELETE SET NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS `invoice_item`;

CREATE TABLE invoice_item (
    id CHAR(36) NOT NULL,
    title VARCHAR(255),
    price DOUBLE,
    total DOUBLE,
    service VARCHAR(255),
    quantity INT,
    description TEXT,
    invoice_id CHAR(36),
    created_date_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_updated_date_time TIMESTAMP NULL DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (invoice_id) REFERENCES invoice(id) ON DELETE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


set @ORG_ID = uuid();
INSERT INTO organization
(id, name, description, domain)
VALUES(@ORG_ID, 'Demo Org', 'Demo desc', 'demo-domain');

set @ROLE_ID1 = uuid();
INSERT INTO roles(id,name) VALUES(@ROLE_ID1,'ROLE_ADMIN');

set @USER_ID1 = uuid();
set @USER_ID2 = uuid();
INSERT INTO `user`
( id, first_name, last_name, email, password, role_name, organization_id,`status`, `is_verified`, `address`,`city`, `state`,`zip_code`,`country`,`company`, `phone_number`, `avatar_url`,`cover_url`, `about`,`total_followers`,`total_following`,`team`)
VALUES(@USER_ID1, 'Bhakta', 'Reddy', 'bhakta@ensarsolutions.com','$2a$10$xVRF.RqfSJcJzExzhVqFl.geliI3URbG4ZLmyz5amMwIXU2f.uG6a', 'ROLE_SUPER_ADMIN', @ORG_ID,
   'active',TRUE,'123 Main St','Rancho Cordova', 'Virginia','85807','United States','Ensar','1234567890','https://ensar-commerce.s3.amazonaws.com/68e959aa-5172-46a9-b22e-d0826306fb44_Fusion.png','https://ensar-commerce.s3.amazonaws.com/68e959aa-5172-46a9-b22e-d0826306fb44_Fusion.png','admin', 1,1,'Sales'
);


INSERT INTO `user`
( id, first_name, last_name, email, password, role_name, organization_id,`status`, `is_verified`, `address`,`city`, `state`,`zip_code`,`country`,`company`, `phone_number`, `avatar_url`,`cover_url`, `about`,`total_followers`,`total_following`,`team`)
VALUES(@USER_ID2, 'Swaroop', 'Reddy', 'swaroop@ensarsolutions.com','$2a$10$lj8KD.LTtPe2mtDsgybmJeLi2SU5m47VtGIfE8EnPk7ITP3ArSYw2', 'ROLE_SUPER_ADMIN', @ORG_ID,
   'active',TRUE,'123 Main St','Rancho Cordova', 'Virginia','85807','United States','Ensar','1234567890','https://ensar-commerce.s3.amazonaws.com/68e959aa-5172-46a9-b22e-d0826306fb44_Fusion.png','https://ensar-commerce.s3.amazonaws.com/68e959aa-5172-46a9-b22e-d0826306fb44_Fusion.png','admin', 1,1,'Sales'
);


SET @USER_ROLE_ID = uuid();
INSERT INTO user_roles (id, user_id, role_id)
VALUES (@USER_ROLE_ID, @USER_ID1, @ROLE_ID1);


SET @USER_ROLE_ID = uuid();
INSERT INTO user_roles (id, user_id, role_id)
VALUES (@USER_ROLE_ID, @USER_ID2, @ROLE_ID1);


set @PRODUCT_ID = uuid();
INSERT INTO `product` (id, gender, publish, category, available, price_sale, taxes, quantity, inventory_type, description, sku, created_at, name, code, price, cover_url, total_ratings, total_sold, total_reviews, sub_description, new_label_enabled, new_label_content, sale_label_enabled, sale_label_content)
VALUES (
  @PRODUCT_ID, 'Kids', 'draft', 'Accessories', 0, 83.74, 10, 80, 'out of stock', 
  '<h6>Specifications</h6><br/><ol><li>Category</li><li>Shoes</li></ol><br/><ol><li>Manufacturer</li><li>Nike</li></ol><br/><ol><li>Serial Number</li><li>358607726380311</li></ol><br/><ol><li>Ships From</li><li>United States</li></ol><br/><br/><h6>Product Details</h6><br/><ul><li><p>The foam sockliner feels soft and comfortable</p></li><li><p>Pull tab</p></li><li><p>Not intended for use as Personal Protective Equipment</p></li><li><p>Colour Shown: White/Black/Oxygen Purple/Action Grape</p></li><li><p>Style: 921826-109</p></li><li><p>Country/Region of Origin: China</p></li></ul><br/><br/><h6>Benefits</h6><br/><ul><li><p>Mesh and synthetic materials on the upper keep the fluid look of the OG while adding comfort and durability.</p></li><li><p>Originally designed for performance running, the full-length Max Air unit adds soft, comfortable cushioning underfoot.</p></li><li><p>The foam midsole feels springy and soft.</p></li><li><p>The rubber outsole adds traction and durability.</p></li></ul><br/><br/><h6>Delivery and Returns</h6><br/><p>Your order of $200 or more gets free standard delivery.</p><br/><ul><li><p>Standard delivered 4-5 Business Days</p></li><li><p>Express delivered 2-4 Business Days</p></li></ul><br/><p>Orders are processed and delivered Monday-Friday (excluding public holidays)</p>', 
  'WW75K5210YW/SV', '2023-10-28 15:30:00', 'Nike Air Force 1 NDESTRUKT', '38BEE270', 83.74, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_1.jpg', 4.2, 763, 1947, 'Featuring the original ripple design inspired by Japanese bullet trains, the Nike Air Max 97 lets you push your style full-speed ahead.',
  false, 'NEW', false, 'SALE'
);


INSERT INTO `color` (product_id, colors)
VALUES
(@PRODUCT_ID, '#FFFFFF'),
(@PRODUCT_ID, '#00AB55'),
(@PRODUCT_ID, '#000000');


INSERT INTO `size` (product_id, sizes)
VALUES
(@PRODUCT_ID, '6'),
(@PRODUCT_ID, '7'),
(@PRODUCT_ID, '8'),
(@PRODUCT_ID, '8.5'),
(@PRODUCT_ID, '9'),
(@PRODUCT_ID, '9.5'),
(@PRODUCT_ID, '10');

INSERT INTO `tags` (product_id, tags)
VALUES
(@PRODUCT_ID, 'Technology'),
(@PRODUCT_ID, 'Fashion'),
(@PRODUCT_ID, 'Books');


INSERT INTO `image` (product_id, images)
VALUES
(@PRODUCT_ID, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_1.jpg'),
(@PRODUCT_ID, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_2.jpg'),
(@PRODUCT_ID, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_3.jpg'),
(@PRODUCT_ID, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_4.jpg'),
(@PRODUCT_ID, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_5.jpg'),
(@PRODUCT_ID, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_6.jpg'),
(@PRODUCT_ID, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_7.jpg'),
(@PRODUCT_ID, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_8.jpg');


set @RATING_ID1 = uuid();
set @RATING_ID2 = uuid();
set @RATING_ID3 = uuid();
set @RATING_ID4 = uuid();
set @RATING_ID5 = uuid();
INSERT INTO `rating` (id, product_id, name, star_count, review_count)
VALUES
(@RATING_ID1, @PRODUCT_ID, '1 Star', 9911, 1947),
(@RATING_ID2, @PRODUCT_ID, '2 Star', 1947, 9124),
(@RATING_ID3, @PRODUCT_ID, '3 Star', 9124, 6984),
(@RATING_ID4, @PRODUCT_ID, '4 Star', 6984, 8488),
(@RATING_ID5, @PRODUCT_ID, '5 Star', 8488, 2034);

set @REVIEW_ID1 = uuid();
set @REVIEW_ID2 = uuid();
INSERT INTO `review` (id, product_id, name, posted_at, comment, is_purchased, rating, avatar_url, helpful)
VALUES
(@REVIEW_ID1, @PRODUCT_ID, 'Swaroop', '2023-10-18 14:22:15.386', 'The sun slowly set over the horizon, painting the sky in vibrant hues of orange and pink.', true, 4.2, 'https://api-prod-minimal-v510.vercel.app/assets/images/avatar/avatar_1.jpg', 9911),
(@REVIEW_ID2, @PRODUCT_ID, 'Sumanth', '2023-10-17 13:22:15.386', 'She eagerly opened the gift, her eyes sparkling with excitement.', true, 3.7, 'https://api-prod-minimal-v510.vercel.app/assets/images/avatar/avatar_2.jpg', 1947);


INSERT INTO `attachment` (review_id, attachments)
VALUES
(@REVIEW_ID1, ''),
(@REVIEW_ID2, 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_1.jpg');


SET @ORDERS_ID1 = UUID();
SET @ORDERS_ID2 = UUID();
SET @CUSTOMER_ID1 = UUID();
SET @CUSTOMER_ID2 = UUID();
INSERT INTO `orders` (id, order_number, taxes, sub_total, shipping, discount, total_amount, total_quantity, status, 
                      customer_id, customer_name, customer_email, customer_avatar_url, customer_ip_address, 
                      delivery_ship_by, delivery_speedy, delivery_tracking_number, 
                      shipping_full_address, shipping_phone_number, 
                      payment_card_type, payment_card_number)
VALUES
(@ORDERS_ID1, 'ORD123', 10.5, 100.0, 5.0, 10.0, 105.5, 3, 'cancelled', 
 @CUSTOMER_ID1, 'Jhon Doe', 'john.doe@example.com', 'https://api-prod-minimal-v510.vercel.app/assets/images/avatar/avatar_1.jpg', '192.168.1.1',
 'Express Shipping', 'Standard', 'ABC123', 
 'Atlanta GA Test', '88799786685', 
 'Visa', '**** **** **** 1234'),
 
(@ORDERS_ID2, '#60111', 21, 121.0, 4.0, 12.0, 111.5, 5, 'completed', 
 @CUSTOMER_ID2, 'Cortez Herring', 'vito.hudson@hotmail.com', 'https://api-prod-minimal-v510.vercel.app/assets/images/avatar/avatar_12.jpg', '192.168.1.35',
 'DHL', 'Standard', 'SPX037739199373', 
 '4563 Honda Test 234 - Manudio, OK / 98765', '334-895-9987', 
 'Visa', '**** **** **** 5678');
 
 SET @ITEM_ID1 = UUID();
 SET @ITEM_ID2 = UUID();
 INSERT INTO `item` (id, orders_id, sku, quantity, name, cover_url, price)
 VALUES
 (@ITEM_ID1, @ORDERS_ID1, '16H9UR0', 10, 'NIKE SHOE', 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_1.jpg', 103),
 (@ITEM_ID2, @ORDERS_ID2, '16H9UR2', 118, 'Nike Air Zoom Pegasus 37 A.I.R. Chaz Bear', 'https://api-prod-minimal-v510.vercel.app/assets/images/m_product/product_3.jpg', 68.71);


SET @HISTORY_ID1 = UUID();
SET @HISTORY_ID2 = UUID();
 INSERT INTO `history` (id, orders_id, order_time, payment_time, delivery_time, completion_time)
 VALUES
 (@HISTORY_ID1, @ORDERS_ID1, '2023-12-27 19:24:27', '2023-12-28 10:30:00', '2023-01-03 03:00:00', '2023-01-04 02:00:00'),
 (@HISTORY_ID2, @ORDERS_ID2, '2024-01-10 19:24:27', '2024-01-10 10:30:00', '2024-01-20 03:00:00', '2023-01-20 02:00:00');

SET @TIMELINE_ID1 = UUID();
SET @TIMELINE_ID2 = UUID();
SET @TIMELINE_ID3 = UUID();
SET @TIMELINE_ID4 = UUID();
 INSERT INTO `timeline` (id, history_id, title, time)
 VALUES
 (@TIMELINE_ID1, @HISTORY_ID1, 'Delivery successful', '2023-05-27 11:21:34'),
 (@TIMELINE_ID2, @HISTORY_ID1, 'Order has been created', '2023-05-07 15:32:21'),
 
 (@TIMELINE_ID3, @HISTORY_ID2, 'Delivery successful', '2023-05-27 11:21:34'),
 (@TIMELINE_ID4, @HISTORY_ID2, 'Order has been created', '2023-05-07 15:32:21');
 

SET @ADDRESS_ID1 = UUID();
SET @ADDRESS_ID2 = UUID();
SET @ADDRESS_ID3 = UUID();
INSERT INTO address (id, name, company, is_primary, full_address, phone_number, address_type) VALUES
(@ADDRESS_ID1, 'John Doe', 'Doe Enterprises', TRUE, '123 Elm St, Springfield', '555-1234', 'Business'),
(@ADDRESS_ID2, 'Jane Smith', 'Smith Consulting', FALSE, '456 Maple Ave, Anytown', '555-5678', 'Personal'),
(@ADDRESS_ID3, 'Swaroop Reddy', 'Ensar Sol', TRUE, '2651, Naperville', '334-895-7885', 'Business');


SET @INVOICE_ID1 = UUID();
SET @INVOICE_ID2 = UUID();
INSERT INTO invoice (id, sent, due_date, taxes, status, sub_total, create_date, discount, shipping, total_amount, invoice_number, invoice_from_id, invoice_to_id) VALUES
(@INVOICE_ID1, 10, '2023-08-15 10:30:21', 15.5, 'pending', 100.0, '2023-08-01 12:21:11', 5.0, 10.0, 120.5, 'INV-1001', @ADDRESS_ID1, @ADDRESS_ID2),
(@INVOICE_ID2, 15, '2023-09-13 10:30:21', 15.5, 'paid', 200.0, '2023-09-01 12:21:11', 7.0, 15.0, 154.5, 'INV-1002', @ADDRESS_ID2, @ADDRESS_ID3);


SET @INVOICE_ITEM_ID1 = UUID();
SET @INVOICE_ITEM_ID2 = UUID();
INSERT INTO invoice_item (id, title, price, total, service, quantity, description, invoice_id) VALUES
(@INVOICE_ITEM_ID1, 'Web Design Services', 50.0, 100.0, 'Design', 2, 'Web design and development services', @INVOICE_ID1),
(@INVOICE_ITEM_ID2, 'Consultation', 20.0, 20.0, 'Consulting', 1, 'Business strategy consultation', @INVOICE_ID2);

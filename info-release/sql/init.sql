insert  into `t_info_category`(`id`,`name`) values (1,'房产信息'),(2,'求职招聘'),(3,'二手交易'),(4,'生活服务');

insert  into `t_info_type`(`id`,`info_category`,`type_name`) values (1,'房产信息','出售'),(2,'房产信息','求购'),(3,'房产信息','出租'),(4,'房产信息','求租'),(5,'房产信息','转让'),(6,'求职招聘','求职'),(7,'求职招聘','招聘'),(8,'二手交易','出售'),(9,'二手交易','求购'),(10,'生活服务','改水电'),(11,'生活服务','建筑施工'),(12,'生活服务','门窗维修'),(13,'生活服务','家电维修'),(14,'生活服务','家政保洁'),(15,'生活服务','管道疏通'),(16,'生活服务','废品回收'),(17,'生活服务','快递信息'),(18,'生活服务','抵押贷款'),(19,'生活服务','车辆出租'),(20,'生活服务','房屋出租'),(21,'生活服务','驾校咨询'),(22,'生活服务','建材装修'),(23,'生活服务','车辆服务'),(24,'生活服务','其他信息');

insert  into `t_role`(`id`,`code`,`name`) values (1,'admin','管理员'),(2,'user','用户');

insert  into `t_shop_category`(`id`,`name`) values (1,'宾馆订房'),(2,'贷款'),(3,'美食饭店'),(4,'车辆出租'),(5,'日化百货'),(6,'装修建材'),(7,'家庭电器'),(8,'烟酒批发'),(9,'教育培训'),(10,'办公耗材'),(11,'房产楼盘'),(12,'新增分类');

insert  into `t_user`(`id`,`uuid`,`user_name`,`password`,`create_time`,`disabled`) values (1,'30f7af13c0854e38bb3e01e29029b078','admin','e10adc3949ba59abbe56e057f20f883e','2019-12-20 15:32:46',0),(2,'30f7af13c0854e38bb3e01e29029b071','demo','e10adc3949ba59abbe56e057f20f883e','2019-12-20 18:17:06',0);

insert  into `t_user_role`(`id`,`user_id`,`role_id`) values (1,1,1),(2,2,2);
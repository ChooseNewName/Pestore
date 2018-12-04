create database pet_database;

use pet_database;

-- 类型表
create table category
(
	c_id int primary key auto_increment ,
	`type` varchar(30) 
);

insert into category(`type`) values
('猫科'),('狗'),('鼠'),('熊'),('鸟');

select * from category;

-- ---------------------------------
-- 用户表
create table `user`
(
	u_id int primary key auto_increment,
	user_name varchar(20),
	first_name varchar(20),
	last_name varchar(20),
	email varchar(30),
	`password` varchar(32),
	user_status int 
);

insert into `user`(user_name,first_name,last_name,email,`password`,user_status) values
('梁朝伟','梁','朝伟','1203664512@qq.com','123456',0) ,
('张学友','张','学友','2154663021@qq.com','654321',0) ,
('陈奕迅','陈','奕迅','1234567890@qq.com','678910',0) ;

select * from `user`;

-- -----------------------------------
-- 标签表
create table tag 
(
	t_id int primary key auto_increment,
	tag varchar(20)
);

insert into tag(tag) values 
('可爱'),('活泼'),('高冷'),('温柔'),('凶猛');

select * from tag;

-- ------------------------------
-- 订单表
create table `order`
(
	o_id int primary key auto_increment,
	pet_id int references pet(pet_id),
	quantity int ,
	ship_date date ,
	`status` enum('放置','批准','交付'), 
	complete boolean default(0)
);

insert into `order`(pet_id,quantity,ship_date,`status`) values 
(1,4,'2018-10-30','交付'),(1,4,'2018-09-30','交付'),
(1,4,'2018-10-31','放置'),(1,4,'2018-09-29','批准');

select * from `order`;

drop table pet;
-- ----------------------------------
-- 宠物表
create table pet
(
	p_id int primary key auto_increment,
	c_id int references category(c_id),
	t_id int references tag(t_id) ,
	p_name varchar(20),
	p_price decimal(9,2),
	p_status enum('出售','待定','缺货')
);

insert into pet(c_id,t_id,p_name,p_price,p_status) values 
(2,2,'哈士奇',6666.00,'出售'),(1,3,'蓝猫',1688.00,'出售'),
(1,1,'橘猫',788.00,'缺货'),(1,5,'小狮子',7888.00,'出售'),
(2,4,'金毛',3566.00,'出售'),(3,1,'土拨鼠',767.00,'待定');

select * from pet;

-- 查询全部信息 
select p.p_id,c.`type`,t.tag,p.p_name,p_price,p_status from
 pet p inner join category c 
 on p.c_id=c.c_id 
 inner join tag t 
 on p.t_id=t.t_id group by  p_id;

-- 根据Id查询宠物 
select p.p_id,c.`type`,t.tag,p.p_name,p_price,p_status,t.t_id,c.c_id from
      pet p inner join category c
      on p.c_id=c.c_id
      inner join tag t
    on p.t_id=t.t_id where p_id =6  group by  p_id;

-- 修改宠物信息
update pet
    set c_id = 1,
      t_id = 1,
      p_name = '加菲猫',
      p_price = 888,
      p_status = '待定'
where p_id = 3 ;

-- 模糊查询
select p.p_id,c.`type`,t.tag,p.p_name,p_price,p_status,t.t_id,c.c_id from
      pet p inner join category c
      on p.c_id=c.c_id
      inner join tag t
on p.t_id=t.t_id where p.p_name like '%%' and c.`type` like '%%' and t.tag like '%%' and p.p_status like '%%' group by  p_id;


select p.p_id,c.`type`,t.tag,p.p_name,p_price,p_status,t.t_id,c.c_id from
            pet p inner join category c
            on p.c_id=c.c_id
            inner join tag t
            on p.t_id=t.t_id
                where p.p_name like '%猫%'
                or c.`type` like '%狗%'
                or t.tag like '%狗%'
                or p.p_status like '%狗%'
        group by  p_id;


-- ------------------------------------

RDBMS:关系数据库管理系统(Relational Database Management System)，
	是将数据组织为相关的行和列的系统，而管理关系数据库的计算机软件就是关系数据库管理系统，
	常用的数据库软件有Oracle、SQL Server等。
	RDBMS 指的是关系型数据库管理系统。
	RDBMS 是SQL的基础，同样也是所有现代数据库系统的基础，比如MS SQL Server, IBM DB2, Oracle, MySQL 以及Microsoft Access。
	RDBMS 中的数据存储在被称为表（tables）的数据库对象中。
RDBMS的特点：
	1.数据以表格的形式出现
	2.每行为各种记录名称
	3.每列为记录名称所对应的数据域
	4.许多的行和列组成一张表单
	5.若干的表单组成database
数据库解决数据存储问题,数据靠字段体现出来,字段反映事物的属性,记录表示整体的事物,表是同一事物的集合



mysql基本操作:
insert into tablexx values(100,'jerry',23);
delete from students where name is null;
update students set name = 'xxx',age= 'xxx';
select * from tablexx where name =/like/is (not null);

net start/stop mysql
3306端口,root超级用户
-V version;-D 
mysql -D --delimiter -hlocalhost -uroot -proot/-P 
--prompt/ prompt: \D,\d,\h,\u
exit;quit;\q;
select version();select now();select user();
create database/schema if not exists db_namexx
default character set [=] utf8/xxx;
show databases/schemas like 'xxx' where xxx;
alter databases/schema db_name default xxx
drop database/schema if exists xx;
数据类型:
	tinyint 1byte,smallint 2byte,mediumity 3byte,int 4byte,
	bigint 8byte,float[(M,D)],double[(M,D)]
时间类型:year 1byte,time 3byte,date 3byte,datetime 8byte,timestamp 4byte
字符类型:char(M) 0-255;varchar(M) 65535;tinytext 8byte
	text 16byte;mediumtext 24byte;longtext 32byte;
	enum('xx','xx'..),1/2byte,set('v1','v2',...),1/2/3/4/8 byte
use xxx;select database(); show tables [from dbxx] [like 'pattern'|where xxx;

create table [if not exists] table_name ( xx int/varchar/xx, ...);
show columns from xx;

insert [into] tbl_name [(col_name,...)] values(xx,xx..)

select ...from xx
auto_increment,
约束:
	not null,primary key,unique key,default,foreign key(保持数据一致性,完成性,一对一/多)
关于外键:
	父子表store engine同为(default-storage-engine=INNODB),不能为临时表,
	foreign key的type相同,数值型长度/符号必须相同,字符型长度不限定
	外键和参照列必须创建index,如果外键列没有index,mysql自动创建
	cascade:从父表(自动)删除/更新 字表中匹配的行
	set null:从父表删除/更新,并设置子表的foreignkey列为null,所以必须保证字表没有设not null
	restrict:拒绝对父表删除/更新
	no action:标准sql,与restrict相同
eg:
	create table user(id smallint unsigned primary key auto_increment,
	username varchar(10) not null,
	pid smallint unsigned,
	poreign key (pid) references provinces (id) on delete cascade);
	表级约束/列级约束

alter table tbl_name add [column] col_name column_definition [first/after col_name]
alter table tbl_name drop [column] col_name;
alter table tbl_name add[constraint [symbol]]
添加主键约束
	primary key[index_type] (index_col_name,...)
添加唯一约束
	unique [index/key] [index_name] [index_type] (index_col_name,...)
添加外检约束
	foreign key [index_name] (index_col_name,...) reference_definition
添加/删除默认约束
alter table tbl_name alter [column] col_name
	{set default literal | drop default}
删除主键约束
alter table tbl_name drop primary key
唯一约束
alter table tbl_name drop {index|key} index_name
外键约束
alter table tbl_name drop foreign key fk_symbol

修改数据表
alter table tbl_name modify [column] col_name column_definition [first|after col_name]
列名:
alter table tbl_name change [column] old_col_name new_col_name column_definition [first|after col_na
表名:
alter table tbl_name rename [to|as] new_tbl_name
rename table tbl_name to new_table_name [,tbl_name2 to new_tbl_name2]...

insert:
insert [into] tbl_name [(col_name,...)] {values|value}
	({expr | default},...),(...)...
e.g:
insert users values(null,'tom','123',25.1);

insert [into] tbl_name set col_name = { ...|default},..
e.g:
insert users set username='Ben',password='456';

insert [into] tbl_name [(col_name,...)] select ...

update
update [low_priority] [ignore] table_reference
	set col_name1={...|default} [,col_name2=...]..
	[where ...]

delete
delete from tbl_name where...

select:
select .. from ...where ... group by ...asc/desc,..
	having ... order by ..asc/desc ...
	[limit [offset,] row_count| row_count OFFSET offset}]


SubQuery:
select * from t1 where c1 = (select c2 from t2);
select/insert/update/set/do
比较运算符:=,>,<,>=,>=,<>,!=,<=>
修饰:any(任何一个),some,all(所有)

	table_reference
	别名:
	tbl_name [[as] alias] table_subquery [as] alias
	连接类型:
	{[inner|cross] join | {left|right} [outer] join}
	table_reference
	on conditional_expr

字符函数:
	concat(),字符连接,concat_ws(),使用分隔符进行字符连接
	format(),lower(),upper(),left(),right()
	length(),ltrim(),rtrim(),trim()
	substring(),[not]like,replace()
	数值运算函数:
	ceil()进1取整,div整除,floor()舍1取整,mod模,power()幂,round()四舍五入,truncate()数字截取
	比较运算:
	[not] between ... and .., [not] in() , is [not] null
	日期函数:
	now()日期+时间,curdate()日期,curtime()时间,data_add(),datediff(),date_format()
	信息函数:
	connection_id()连接id,datebase(),last_insert_id(),user(),version()
	聚合函数
	avg(),count(),max(),min(),sum()
	加密函数
	md5(),password():eg:select md5('xxx');select password('admin')

自定义函数:(user defined function:UDF)
	对mysql扩展,与内置函数相同
	两个必要条件:参数,返回值
创建:
	create function function_name returns
	{string| integer | real | recimal}
	routine_body
		函数体:合法sql语句构成,如select.../begin ...end
		符合结构可以包含声明,循环,控制结构
		
e.g:
	create function nowtest() returns varchar(30)
	return date_format(now(),'%Y年%d日  %H点:%i分:%s秒');
	调用:select nowtest()
	

存储过程:
	sql命令-->mysql引擎--(分析)-->语法正确-->可识别命令
	--执行-->执行结果--(返回)-->客户端
增强sql语句功能和灵活性,实现较快执行速度,减少网络io
创建语句:
create [definer={user|current_user}]
proceduer sp_name([proc_parameter[,...]])
[characteristic ...] routine_bydy

参数输入输出:
proc_parameter:
[in|out|inout] param_name type
	in:该参数必须在调用存储过程中指定
	out:可以被存储过程改变,并返回
	inout:调用时指定,并被改变返回

特性:
	comment 'string'
	| {contains sql | no sql | reads sql data | modifies sql data}
	|sql security { definer | invoker}
	comment:注释
	contains sql:包含sql语句,不包含读/写数据的语句
	no sql:不包含sql语句
	reads sql data:包含读数据的语句
	modifies sql data:包含写数据的语句
	sql security{ definer | invoker} 指定谁有权执行

过程体:
	过程体有合法sql语句构成
	可以是任意sql语句,如果为复合结构则使用begin ... end 语句
	复合结构可以包含声明,循环,控制结构
	
调用存储过程:
	call sp_name([parameter[,...]]
	call sp_name[()]
s
e.g:
	delimiter //
	create proceduer removeUserAndReturnUserNums(
	IN p_id int unsigned,out userNums int unsigned)
	begin
	delete from users where id = p_id;
	select count(id) from users into userNums;
	end
	//
	delimiter;
	call removeUserAndReturnUserNums(27,@nums);
	select @nums;
	
	delimiter //
	create proceduer removeUserByAgeAndReturnInfos(
	IN p_age smallint unsigned,out deleteUsers smallint unsigned,
	OUT userCounts smallint unsigned)
	begin
	delete from users where age = p_age;
	select row_count() into deleteUsers;
	select count(id) from users into userNums;
	end
	//
	delimiter;
	call removeUserAndReturnUserNums(27,@a,@b);
	select @a,@b;
	
存储过程/自定义函数区别:
	存储过程实现功能复杂一些,而函数针对性强
	存储过程可以返回多个值,函数只能有一个返回值
	存储过程一般独立执行,而函数可以作为其他sql语句组成部分

修改存储过程:
	alter proceduer sp_name[characteristic ...]
	comment 'string'
	| {contains sql | no sql | reads sql data | modifies sql data}
	|sql security { definer | invoker}

删除:
	drop proceduer [if exists] sp_name

存储引擎:
	mysql将数据以不同技术存储在文件/内存中,这种技术成为存储引擎
	每一种存储引擎使用不同的存储机制,索引技巧,锁定水平,最终提供广泛不同的功能
	MyISAM(表锁,压缩 ,256TB),适合事务少的情况
	InnoDB(行锁,事务,外键 ,64Tb),适合事务多的情况
	Memory(表锁),
	Archive(无限制,不支持索引,行锁,压缩)
	CSV,
create table ... engine=myisam defalut charset=utf8;
alter table table_naem engine [=] xxx;
	
相关:
并发控制:当多个连接对记录进行修改时保证数据的一致性和完整性
锁:
	共享锁(读锁):同一时间,多个用户读取同一资源,读取过程数据不会发生任何改变
	排它锁(写锁):任何时间只能有一个用于写资源,在写的过程中会阻塞其他读写操作
锁颗粒:
	表锁,开销小
	行锁,开销大
事务:ACID
	原子性(Atomicity)
	一致性(consistency)
	隔离性(Isolation)
	持久性(Durability)
外键(一致性),
索引(对数据表中一列/多列值进行排序的一种结构)
	普通索引,唯一索引,全文索引,btree索引,hash索引...


行转列:
select a.'user_name',sum(kills) from user1 a
join user_kills b 
on a.id=b.user_id group by a.user_name;


数据结构优化:
数据类型选择,重点在于合适
	1.使用可以存下数据的最小数据类型
	2.使用简单的数据类型,int比varchar类型在mysql处理上简单
	3.尽可能使用not null定义字段
	4.尽量少用text类型,必须用的话考虑分表
使用int存储日期,利用from_unixtime(),unix_timestamp()转换
	create table test(id int auto_increment not null,
	timestr int,primary key(id));
	insert into test(timestr) values(unix_timestamp('2015-02-01' 13:13:11'));
	select from_unixtime(timestr) from test;
使用bigint来存储ip地址,利用inet_auton(),inet_ntoa()转换
 	即:数据表中不存在非关键字段,对任意候选关键字段的传递函数依赖,则为复合第三范式
	商品名称-->分类/分类描述,其中分类描述对商品名称传递函数依赖
	不符合第三范式表存在以下问题:
	数据冗余:(分类,分类描述)对每个商品都进行记录
	数据插入/更新/删除异常
































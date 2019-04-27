## Mysql

### **MySQL语句的规范**

关键字与函数名称全部大写

数据库、表名称、字段名称全部小写

SQL语句必须以分号结尾

创建数据库 CREAT DATABASE

修改数据库 ALTER DATABASE

删除数据库 DROP DATABASE

### **数据类型**

数据类型是指列、存储过程参数、表达式和局部变量的数据特征，它决定了数据的存储格式，代表了不同的信息类型。

**整型**

TINYINT 存储范围(-128---127)  字节1

SMALLINT 存储范围(-2的15次方---2的15次方)  字节2

MEDIUMINT 存储范围(-2的23次方---2的23次方)  字节3

INT 存储范围(-2的31次方---2的31次方)  字节4

BIGINT 存储范围(-2的63次方---2的63次方)  字节8

**浮点型**

DOUBLE[(M,D)]   FLOAT[(M,D)]

#### 外键约束的参照操作

1.CASCADE:从父表删除或更新且自动删除或更新子表中匹配的行

2.SET NULL:从父表删除或更新行，并设置子表中的外键列为NULL.如果使用该选项，必须保证子表列没有指定NOT NULL。

3.RESTRICT：拒绝对父表的删除或更新操作。

4.NO ACTION：标准SQL的关键字，在MySQL中与RESTRICT相同

#### 表级约束与列级约束

对一个数据列建立的约束，称为列级约束

对多个数据列建立的约束，称为表级约束

列级约束既可以在列定义时声明，也可以在列定义后声明，表级约束只能在列定义后声明。

#### 修改数据表

添加单列：alter table tbl_name add ....    after/before/first	(能指定位置关系)

添加多列：alter table tbl_name add...中间用，隔开(不能指定位置关系)

删除列：alter table tbl_name drop col_name

添加主键约束：alter table tbl_name add  constraint symbol primary key (col_name)

添加唯一约束：alter table tbl_name add constraint unique (col_name)

添加外键约束：alter table tbl_name add foreign key (col_name) reference_definition

添加/删除默认约束：alter table tbl_name alter (col_name)  set default literal**/**drop default

删除主键约束：alter table tbl_name drop primary key

删除唯一约束：alter table tbl_name drop index index_name

删除外键约束：alter table tbl_name drop foreign  key fk_symbol

修改列定义：alter table tbl_name modify col_name first/after/before

修改列名称：alter table tbl_name change old_col_name new_col_name 

##### 数据表更名：alter table tbl_name rename  new_name

![1540632848346](C:\Users\ADMINI~1\AppData\Local\Temp\1540632848346.png)

### 操作数据表中的记录

#### INSERT

**插入记录:**     insert   tbl_name  (col_name)  values

                      insert   tbl_name  set  col_name =属性  此方法可以使用子查询
    
                      insert   tbl_name  select                 此方法可以将查询结果插入到指定数据表

#### UPDATE

**更新记录(单表更新)：**  updae   table_references   set  col_name1=..., col_name2=....  where ...

update users set  age = age +5;     update users set username = 'Tom' where id = 1;

**多表更新：**update table_references  set col_name1=..., col_name2=... where...

#### DELETE

**删除记录(单表删除)：**  detele   from   tbl_name   where...

#### SELECT

**查询表达式：**

每一个表达式表示想要的一列，必须有至少一个。

多个列之间以英文够好分隔。

星号(`*`)表示所有列。`tbl_name.*`可以表示命名表的所有列。

查询表达式可以使用[as] alias_name为其赋予别名

别名可用于group by，order by或having 子句。

#### WHERE

**条件表达式：**

对记录进行过滤，如果没有指定where子句，则显示所有记录。

在where表达式中，可以使用MySQL支持的函数或运算符。

#### GROUP BY

**查询结果分组：**

group by col_name  asc(升序)[默认] | desc(降序)，....

#### HAVING

**分组条件：**

having where_condition

select sex,age from users group by 1 having age > 30;

select sex from users group by 1 having count(age) > 30;

#### ORDER BY

**对查询结果进行排序：**

order by col_name asc|desc ， .....

#### LIMIT

**限制查询结果返回的数量：**

limit  x ，y   |  limit x 

### 子查询与连接

#### 子查询

子查询是指出现在其他SQL语句内的select子句

select * from t1 where col1 = (select col2 from t2);

子查询指嵌套在查询内部，且必须始终出现在圆括号内。

子查询可以包含多个关键字或条件，

如distinct，group by ，order by ，limit，函数等。

子查询的外层查询可以是：select，insert，update，set或do。

##### 子查询返回值

子查询可以返回标量、一行、一列或子查询。

##### 使用比较运算符的子查询

=、>、<、>=、<=、<>、!=、<=>

**用any、some或all修饰的比较运算符**

![1540798563251](C:\Users\ADMINI~1\AppData\Local\Temp\1540798563251.png)

**使用(not)in 的子查询**

=any 运算符与in等效。

！=all或<>all运算符与not in 等效。

#### INSERT...SELECT

将查询结果写入数据表

#### CREATE...SELECT

创建数据表同时将查询结果写入到数据表

create table tbl_name  select_statement

### 连接

MySQL在select语句、多表更新、多表删除语句中支持join操作

#### 数据表参照

table_reference

tbl_name as xx  | table_subquery as xx数据表可以使用tbl_name  as xx赋予别名

table_subquery可以作为子查询使用在from子句中，这样的子查询必须为其赋予别名

#### 连接类型

INNER JOIN,内连接

在MySQL中， join，cross join 和inner join是等价的。

left join 左外连接   right join 右外连接

#### 连接条件

使用on关键字来设定连接条件，也可以使用where来代替。

通常使用on关键字来设定连接条件，使用where关键字进行结果集记录的过滤。

#### 左外连接

显示左表的全部记录及右表符合连接条件的记录

A left join B join_condition

数据表B的结果集依赖数据表A		

数据表A的结果集根据左连接条件依赖所有数据表（B表除外）

左外连接条件决定如何检索数据表B

如果数据表A的某条记录符合where条件，但是在数据表B不存在符合连接条件的记录，将生成一个所有列为空的额外的B行。

#### 自身连接

同一个数据表对其自身进行连接。

#### 多表删除

delete tbl_name * from table_regerences

### 运算符和函数

**1、字符函数**

**2、数值运算符与函数**

**3、比较运算符与函数**

**4、日期时间函数**

**5、信息函数**

**6、聚合函数**

**7、加密函数**

#### 字符函数

![1541036171885](C:\Users\ADMINI~1\AppData\Local\Temp\1541036171885.png)

![1541037318081](C:\Users\ADMINI~1\AppData\Local\Temp\1541037318081.png)

 like中使用%(百分号)： 代表任意个字符   使用_(下划线)：代表任意一个字符 

#### 数值运算符与函数

![1541038141964](C:\Users\ADMINI~1\AppData\Local\Temp\1541038141964.png)

![1541038395097](C:\Users\ADMINI~1\AppData\Local\Temp\1541038395097.png)

#### 日期时间函数

![1541039013139](C:\Users\ADMINI~1\AppData\Local\Temp\1541039013139.png)

#### 信息函数

![1541039452903](C:\Users\ADMINI~1\AppData\Local\Temp\1541039452903.png)

#### 聚合函数

![1541039845168](C:\Users\ADMINI~1\AppData\Local\Temp\1541039845168.png)

#### 加密函数

![1541040310582](C:\Users\ADMINI~1\AppData\Local\Temp\1541040310582.png)

password主要用来修改用户密码： set password = password();

md5主要用来web页面

### 自定义函数

用户自定义函数是一种对MySQL扩展的途径，其用法与内置函数相同。

自定义函数的两个必要条件：

(1)参数    (2)返回值

函数可以返回任意类型的值，同样可以接收这些类型的参数

创建自定义函数

create function function_name() returns  routine_body

关于函数体

(1)函数体由合法的SQL语句构成。

(2)函数体可以是简单的select或insert语句。

(3)函数体如果为复合结构则使用begin...end语句

(4)复合结构可以包含声明，循环，控制结构

**delimiter 修改mysql命令结束符**

删除函数：drop function function_name

### 存储过程

**存储过程是SQL语句和控制语句的预编译集合，以一个名称存储并作为一个单元处理**

**存储过程的优点**

1、增强SQL语句的功能和灵活性

2、实现较快的执行速度

3、减少网络流量

创建存储过程

create  ...  procedure sp_name (proc_parameter..)  routine_body  

proc_parameter: [in|out|inout] param_name type

#### 参数

**IN，表示该参数的值必须在调用存储过程时指定**

**OUT，表示该参数的值可以被存储过程改变，并且可以返回**

**INOUT，表示该参数的调用时指定，并且可以被改变和返回**

#### 特性

**COMMENT：注释**

**CONTAINS SQL：包含SQL语句，但不包含读或写数据的语句**

**NO SQL:不包含SQL语句**

**READS SQL DATA:包含读数据的语句**

**MODIFIES SQL DATA:包含写数据的语句**

**SQL SECURITY{DEFINER | INVOKER}指明谁有权限来执行**

#### 过程体

**过程体由合法的SQL语句构成；**

**过程体可以是任意SQL语句；**

**过程体如果为复合结构则使用BEGIN...END语句；**

**复合结构可以包含声明，循环，控制结构；**

#### 创建不带参数的存储过程

create procedure sp1() select version();

#### 创建带有IN和OUT类型参数的存储过程

create procedure removeAndReturn(in p_id int, out userNums)

begin

delete from users where id = p_id;

select count(id) from users into userNums;

end;

#### 调用存储过程

call sp1();

#### 删除存储过程

drop procedure sp_name

row_count()函数返回的是上一条SQL语句，对表数据进行修改操作后影响的记录数。

**存储过程与自定义函数的区别**

存储过程实现的功能要复杂一些；而函数针对性更强

存储过程可以返回多个值；函数只能有一个返回值

存储过程一般独立的来执行；而函数可以作为其他SQL语句的组成部分来出现。

#### 修改存储过程

alter procedure sp_name [characteristc...]  comment 'string' 

### 存储引擎

**MySQL可以将数据以不同的技术存储在文件(内存)中，这种技术就称为存储引擎**

**每一种存储引擎使用不用的存储机制、索引技巧、锁定水平，最终提供广泛且不同的功能。**

**MySQL支持的存储引擎： MyISAM、InnoDB、Memory、CSV、Archive**

### 相关知识点

#### 并发控制

**当多个连接对记录进行修改时保证数据的一致性和完整性**

#### 锁

**共享锁(读锁)：**在同一时间段内，多个用户可以读取同一个资源，读取过程中数据不会发生任何变化。

**排他锁(写锁)：**在任何时候只能有一个用户写入资源，当进行写锁时会阻塞其他的读锁或者写锁操作。

#### 锁颗粒

**表锁，是一种开销最小的锁策略**(当用户对数据表进行操作时，用户获得这张表的写锁权限，写锁会禁止其他用户进行读写操作。)

**行锁，是一种开销最大的锁策略**

#### 事务

**事务用于保证数据库的完整性**

##### 事务的特性：原子性、一致性、隔离性、持久性  ACID

### 外键

**是保证数据一致性的策略**

#### 索引

**是对数据表中一列或多列的值进行排序的一种结构**

**使用索引可以快速的访问数据表中的特定信息**

索引分为：普通索引，唯一索引，全文索引、btree索引、hash索引

创建数据表时设置引擎：engine = xxx;

修改数据表设置引擎：alter table table_name engine = xxx;

![1541094695655](C:\Users\ADMINI~1\AppData\Local\Temp\1541094695655.png)



SQL语句执行顺序：

SELECT   FROM   WHERE   GROUP BY   HAVING   ORDER BY


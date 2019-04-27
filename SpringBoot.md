## SpringBoot

### SpringBoot的特点

1、化繁为简，简化配置

2、备受关注，是下一代框架

3、微服务的入门级微框架

### 属性配置

<<<<<<< HEAD
@Scope 描述Spring如何创建Bean实例

@Configuration 配置文件

@Value 指定请求的实际地址
=======
@Value
>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac

@Component

@ConfigurationProperties

### Controller的使用

@Controller                       处理http请求

@RestController                Spring4之后新加的注解，原来返回json需要                                         

<<<<<<< HEAD
                                             @ResponseBody配合@Controller
=======
​                                             @ResponseBody配合@Controller
>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac

@RequestMapping            配置url映射

@PathVariable                    获取url中的数据

@RequestParam                 获取请求参数的值

@GetMapping                     组合注解

<<<<<<< HEAD
@Component 		     把普通pojo实例化到spring容器中，相当于配置文件中的<bean id='' class=''/>

@Transactional                    防止事务回滚

### 事务管理

## web进阶

1.使用@Valid表单验证

2.使用AOP处理请求

3.统一异常处理

4.单元测试

#### AOP统一处理请求日志

AOP是一种编程范式

与语言无关，是一种程序设计思想

面向切面（AOP）、面向对象（OOP）、面向过程（POP）​    

#### SpringBoot资源文件属性配置

资源文件中的属性配置与映射到实体类

#### SpringBoot整合模板引擎

SpringBoot整合freemarker

SpringBoot整合thymeleaf

**thymeleaf常用标签的使用方法**

基本使用方式、对象引用方式、时间类型转换、text与utext

URL、引入静态资源文件js/css、条件判断th:if、循环th:each

th:switch与th:case

#### SpringBoot异常处理

springboot配置全局的异常捕获——web页面跳转

springboot配置全局的异常捕获——ajax形式

springboot配置全局的异常捕获——同时兼容web与ajax

#### Springboot整合Mybatis

使用generatorConfig生成mapper以及pojo

实现基于mybatis的CRUD功能 

整合mybatis-pagehelper实现分页

自定义mapper的实现

#### SpringBoot整合持久层事务

MySQL事务隔离级别

| 事务隔离级别                 | 脏读 | 不可重复读 | 幻读 |
| ---------------------------- | ---- | ---------- | ---- |
| 读未提交（read-uncommitted） | 是   | 是         | 是   |
| 不可重复读（read-committed） | 否   | 是         | 是   |
| 可重复读（repeatable-read）  | 否   | 否         | 是   |
| 串行化（serializable）       | 否   | 否         | 否   |

事务的隔离级别：default 可重复读

| 事务传播行为类型          | 说明                                                         |
| ------------------------- | ------------------------------------------------------------ |
| PROPAGATION_REQUIRED      | 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。 |
| PROPAGATION_SUPPORTS      | 支持当前事务，如果当前没有事务，就以非事务方式执行。         |
| PROPAGATION_MANDATORY     | 使用当前的事务，如果当前没有事务，就抛出异常。               |
| PROPAGATION_REQUIRES_NEW  | 新建事务，如果当前存在事务，把当前事务挂起。                 |
| PROPAGATION_NOT_SUPPORTED | 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起。   |
| PROPAGATION_NEVER         | 以非事务方式执行，如果当前存在事务，则抛出异常。             |
| PROPAGATION_NESTED        | 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务，则执行与PROPAGATION_REQUIRED类似的操作。 |

事务的传播行为：required     support

#### SpringBoot整合Redis

pom.xml中需要引入相关依赖

资源文件中队redis进行配置

引入redis工具类

#### SpringBoot异步执行程序

使用注解@EnableAsync开启异步，会自动扫描

定义@Component@Async作为组件被容器扫描执行

#### SpringBoot拦截器的使用

使用注解@Configuration配置拦截器

继承WebMvcConfigurerAdapter

重写addInterceptors添加需要的拦截器地址



=======
### 事务管理

>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac

## Spring

1、spring是一个开源框架，为了解决企业应用开发的复杂性而创建的，但现在已经不止应用于企业应用。

2、是一个轻量级的控制反转（IOC）和面向切面(AOP)的容器框架

<<<<<<< HEAD
      ——从大小与开销两方面而言Spring都是轻量的

      ——通过控制反转（IOC）的技术达到松耦合的目的
    
      ——提供了面向切面编程的丰富支持，允许通过分离应用的业务逻辑与系统级服务进行内聚性的开发
    
      ——包含并管理应用对象的配置和生命周期，这个意义上是一种容器
    
      ——将简单的组件配置、组合恒伟复杂的应用，这个意义上是框架
=======
​      ——从大小与开销两方面而言Spring都是轻量的

​      ——通过控制反转（IOC）的技术达到松耦合的目的

​      ——提供了面向切面编程的丰富支持，允许通过分离应用的业务逻辑与系统级服务进行内聚性的开发

​      ——包含并管理应用对象的配置和生命周期，这个意义上是一种容器

​      ——将简单的组件配置、组合恒伟复杂的应用，这个意义上是框架
>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac

3、**Spring的作用**

（1）容器

（2）提供了对多种技术的支持

（3）AOP（事务管理、日志等）

（4）对主流应用框架提供了良好的支持

4、**Spring使用范围**

（1）构建企业应用（SpringMVC+Spring+Mybatis）

（2）单独使用Bean容器（Bean管理）

（3）单独使用AOP进行切面处理

（4）其他的Spring功能，如：对消息的支持等

（5）在互联网的应用

5、**框架的特点**

——半成品

——封装了特定的处理流程和控制逻辑

——成熟的、不断升级改进的软件

框架与类库的区别

——框架一般是封装了逻辑、高内聚、类库则是松散的工具组合

——框架专注于某一领域，类库则是更通用的

## IOC

**接口**

（1）用于沟通的中介物的抽象化

（2）实体把自己提供非外界的一种抽象化说明，用以由内部操作分离出外部沟通的方法，使其能被修改内部而不影响外界其他实体与其交互的方式

（3）对应java接口即声明，声明了哪些方法是对外公开提供的

（4）在java8中，接口可以拥有方法体

**面向接口编程**

（1）结构设计中，分清层次及调用关系，每层只向外（上层）提供一组功能接口，各层间仅依赖接口而非实现类

（2）接口实现的变动不影响各层间的调用，这一点在公共服务中尤为重要

（3）面向接口编程中的接口是用于隐藏具体实现和实现多态性的组件

### 面向接口编程用接口来进行声明，将接口的实现类赋值给对象的声明。

**Spring注入**

Spring注入是指在启动Spring容器加载bean配置的时候，完成对变量的赋值行为

常用的两种注入方式

——设置注入

——构造注入

**Bean的配置项**

ID、Class、Scope、Constructor arguments、Properties、Autowiring mode、 lazy-initialization mode、initialization、destruction method

**Bean的作用域**

singleton：单例，指一个Bean容器中只存在一份

prototype：每次请求（每次使用）创建新的实例，destroy方式不生效

request：每次http请求创建一个实例且仅在当前request内有效

session：同上，每次http请求创建，当前session内有效

<<<<<<< HEAD
global session：基于portlet的web中有效（portlet定义了global session），如果是在web中，同session
=======
global session：基于portlet的web中有效（portlet定义二楼global session），如果实在web中，同session
>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac

**Bean的生命周期**

初始化

—实现org.springframework.beans.factory.InitializingBean接口，覆盖afterPropertiesSet方法

—配置init-method

<bean id ="exampleInitBean"  class="examples.ExampleBean"  init-method="init"/>

销毁

—实现org.springframework.beans.factory.DisposableBean接口，覆盖destroy方法

—配置destroy-method

`<bean id ="exampleInitBean"`   

`class="examples.ExampleBean"   destroy-method="cleanup"/>`

**配置全局默认初始化、销毁方法**

在beans xmlns中添加default-init-method="init"

<<<<<<< HEAD
                                      default-destroy-method="destroy"
=======
​                                      default-destroy-method="destroy"
>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac

**Aware**

Spring中提供了一些以Aware结尾的接口，实现了Aware接口的bean在被初始化之后，可以获取相应资源

通过Aware接口，可以对Spring相应资源进行操作

为对Spring进行简单的扩展提供了方便的入口

**Bean的自动装配**

No：不做任何操作

byname：根据属性名自动装配。此选项将检查容器并根据名字查找与属性完全一致的bean，并将其与属性自动装配

byType：如果容器中存在一个与制定属性类型相同的bean，那么将与该属性自动装配；如果存在多个该类型bean，那么抛出异常，并指出不能使用byType方式进行自动装配；如果没有找到相匹配的bean，则说明事都不发生

Constructor：与byType方式类似，不同指出在于它应用于构造器参数。如果容器中没有找到与构造器参数类型一直的bean，那么抛出异常

**Resources**

—UrlResource：URL对应的资源，根据一个URL地址即可构建

—ClassPathResource：获取类路径下的资源文件

—FileSystemResource：获取文件系统里面的资源

—ServletContextResource：ServletContext封装的资源，用于访问ServletContext环境下的资源

—InputStreamResource：针对于输入流封装的资源

—ByteArrayResource：针对于字节数组封装的资源

—ResourcesLoader对Resources进行加载

**Bean管理的注解实现及例子**

Classpath扫描与组件管理

类的自动检测与注册Bean

`<context:annotation-config/>`

@Component,@Repository,@Service,@Controller

@Required

@Autowired

@Qualifier

@Resource

从Spring3.0开始，Spring JavaConfig项目提供了很多特性，包括使用java而不是XML定义bean，比如

@Configguration，@Bean，@Import，@DependsOn

@Component是一个通用注解，可用于任何bean

@Repository，@Service，@Conreoller是更有针对性的注解

—@Repository通常用于注解DAO类，即持久层

—@Service通常同于注解Service类，即服务层

—@Controller通常同于Controller类，即控制层（MVC）

### 定义Bean

扫描过程中组件被自动检测，那么Bean名称是由BenaNameGenerator生成的（@Component，@Repository，@Service，@Controller都会有个那么属性用于显示设置Bean Name）

### 作用域（Scope）

**通常情况下自动查找的Spring组件，其scope是singleton，Spring2.5提供了一个标识scope的注解@Scope**

**也可以自定义scope策略，实现ScopeMetadataRedolver接口并提供一个无参构造器**

**@Autowired**

**可以将@Autowired注解为“传统”的setter方法**

`private MovieFinder movieFinder;`

`@Autowired`

`public void setMovieFinder(MovieFinder movieFinder){`

`this.movieFinder = movieFinder;`

`}`

**可用于构造器或成员变量**

`@Autowired`

`private   MovieCatalog   movieCatalog;`

`private   CustomerPreferenceDao   customerPreferenceDao;`

`@Autowired`

`public MovieRecommender(CustomerPreferenceDao  customerPreferenceDao){`

`this.customerPreferenceDao = customerPreferenceDao;`

`}`  

**默认情况下，如果因找不到合适的bean将会导致autowiring失败抛出异常，可以通过下面的方式避免**

`public   class  SimpleMovieLister{`

`private  MovieFinder  movieFinder;`

`@Autowired(required=false)`

`public   void   setMovieFinder(MovieFinder  movieFinder){`

`this.movieFinder  =  movieFinder;`

`}`

`}`

**每个类只能有一个构造器被标记为required=true**

**@Autowired的必要属性，建议使用@Required注解**

### AOP

面向切面编程，通过预编译方式和运行期动态代理实现程序功能的统一维护的一种技术。

**主要功能：日志记录，性能统计，安全控制，事务处理，异常处理等。**

**AOP实现方式**

预编译：AspectJ运行期动态代理（JDK动态代理、CGLib动态代理）

SpringAOP、JbossAOP

**AOP几个相关概念**

名称                              说明

切面(Aspect)                一个关注点的模块化，这个关注点可能会横切多个对象

连接点(Joinpoint)       程序执行过程中的某个特定的点

通知(Advice)                在切面的某个特定的连接点上执行的动作

切入点(Pointcut)         匹配连接点的断言，在AOP中通知和一个切入点表达式关联                                                                                                           引入(Introduction)      在不修改类代码的前提下，为类添加新的方法和属性

目标对象(Target Object) 被一个或者多个切面所通知的对象

AOP代理(AOP Proxy)   AOP框架创建的对象，用来实现切面契约

织入(Weaving)              把切面连接到其他的应用程序类型或者对象上，并创建一个被通知的对象

**Advice的类型**

名称                                 说明

前置通知                          在某连接点之前执行的通知，但不能阻止连接点前的执行（除非它抛出一个异常）

返回后通知                       在某连接点正常完成后执行的通知

抛出异常后通知                在方法抛出异常退出时执行的通知

后通知                               当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）

环绕通知                            包围一个连接点的通知

<<<<<<< HEAD
**Spring框架中AOP的用途**

提供了声明式的企业服务，特别是EJB的替代服务的声明

允许用户定制自己的方面，以完成OOP与AOP的互补使用

### Spring的AOP实现

纯java实现，无需特殊的编译过程，不需要控制类加载器层次，目前只支持方法执行连接点（通知Spring Bean的方法执行）不是为了提供最完整的AOP实现（尽管它非常强大）;而是侧重于提供一种AOP实现和Spring IOC容器之间的整合，用于帮助解决企业应用中的常见问题

Spring AOP不会与AspectJ竞争，从而提供综合全面的AOP解决方案

### 有接口和无接口的Spring AOP实现区别

Spring AOP默认使用标准的javaSE动态代理作为AOP代理，这使得任何接口都可以被代理

Spring AOP中也可以使用CGLIB代理（如果一个业务对象并没有实现一个接口）

Spring所有的切面和通知器都必须放在一个<aop:comfig>内(可以配置包含多个<aop:config>元素)，每一个可以包含pointcut, advisor和aspect元素(它们必须按照这个顺序进行声明)
=======
>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac

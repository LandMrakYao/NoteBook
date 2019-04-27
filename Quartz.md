### Quartz

#### Timer的定义

有且仅有一个后台线程对多个业务线程进行定时定频率的调度

#### Timer的定时调度函数

schedule的四种用法

scheduAtFixedRate的两种用法

schedule(task , time)

作用：在时间等于或超过time的时候执行且仅执行一次task

schedule(task , time , period)

作用：时间等于或超过time时首次执行task之后每隔period毫秒重复执行一次task

schedule(task , delay)

作用：等待delay毫秒后执行且仅执行一次task

schedule(task , delay , period)

作用：等待delay毫秒后首次执行task之后每隔period毫秒重复执行一次task

scheduleAtFixedRate(task , time , period)

作用：时间等于或超过time时首次执行task之后每隔period毫秒重复执行一次task

scheduleAtFixedRate(task , delay , period)

作用：等待delay毫秒后首次执行task之后每隔period毫秒重复执行一次task 

#### 其他重要函数

TimerTask的cancel()，scheduleExectionTime()

Timer的cancel()，purge()

TimerTask的cancel()

作用：取消当前TimerTask里的任务

scheduledExecutionTime()

作用：返回次任务最近实际执行的已安排执行的时间

Timer的cancel()

作用：终止此计时器，丢弃所有当前已安排的任务

purge()

作用：从此计时器的任务队列中移除所有已取消的任务

**schedule与scheduleAtFixedRate的区别**

1、首次计划执行的时间早于当前的时间

1.schedule方法

“fixed-delay”；如果第一次执行时间被delay了，随后的执行时间按照上一次实际执行完成的时间点进行计算

2.scheduleAtFixedRate方法

"fixed-rate"；如果第一次执行时间被delay了，随后的执行时间按照上一次开始的时间点进行计算，并且为了赶上进度会多次执行任务，因此TimerTask中的执行体需要考虑同步

2、任务执行所需时间超过任务的执行周期间隔

1.schedule方法

下一次执行时间相对于上一次实际执行完成的时间点，因此执行时间不断延后

2.scheduleAtFixedRate方法

下一次执行时间相对于上一次开始的时间点，因此执行时间一般不会延后，因此存在并发性

#### Timer的缺陷

管理并发任务的缺陷

Timer有且仅有一个线程去执行定时任务，如果存在多个任务，且任务时间过长，会导致执行效果与预期不符

当任务抛出异常时的缺陷

如果TimerTask抛出RuntimeException，Timer会停止所有任务的运行

Timer的使用禁区

对时效性要求较高的多任务并发作业

对复杂的任务的调度

#### Quartz的设计模式

**主要用到的设计模式**

Builder模式、Factory模式、组件模式、链式写法

#### Quartz体系结构

**重要组成**

Job、JobDetail、JobBuilder、JobStore、Trigger(SimpleTrigger、CornTrigger)、TriggerBuilder

ThreadPool、Scheduler

Calendar：一个Trigger可以和多个Calendar关联，以排除或包含某些事件点

监听器：JobListener、TriggerListener、SchedulerListener

#### 浅谈Job&JobDetail

**Job定义**

实现业务逻辑的任务接口

**浅谈Job**

Job接口非常容易实现，只有一个execute方法，类似TimerTask的run方法，在里面编写业务逻辑

**Job实例在Quartz中的生命周期**

每次调度器执行job时，它在调用execute方法前会创建一个新的job实例

当调用完成后， 关联的job对象实例会被释放，释放的实例会被垃圾回收机制回收。

**浅谈JobDetail**

JobDetail为Job实例提供了许多设置属性，以及JobDataMap成员变量属性，它用来存储特定Job实例的状态信息，调度器需要借助JobDetail对象来添加Job实例

**重要属性**

name、group、jobClass、jobDataMap

**浅谈JobExecutionContext**

当Scheduler调用一个Job，就会将JobExecutionContext传递给Job的execute()方法；

Job能通过JobExecutionContext对象访问到Quartz运行时候的环境以及Job本身的明细数据

**浅谈JobDataMap**

在进行**任务调度时**JobDataMap**存储**。

**在JobExecutionContext**中，非常方便获取。

JobDataMap**可以用来装载任何可序列化的数据对象**，

当job实例对象被执行时这些参数对象会传递给它。

JobDataMap**实现了JDK的Map接口**，并且添加了一些非常方便的方法用来**存取基本数据类型**。

**获取JobDataMap的两种方式**

从Map中直接获取

Job实现类中添加setter方法对应JobDataMap的键值(Quartz框架默认的JobFactory实现类在初始化job实例对象时会自动地调用这些setter方法)

#### 浅谈Trigger

Quartz中的触发器用来告诉调度程序作业什么时候触发。即Trigger对象是用来触发执行Job的。

**触发器通用属性**

JobKey、StartTime、EndTime

**JobKey**

表示job实例的标识，触发器被触发时，该指定的job实例会执行

**StartTime**

表示触发器的时间表首次被触发的时间。它的值的类型是Java.util.Date

**EndTime**

指定触发器的不再被触发的时间。它的值的类型是Java.util.Date

**SimpleTrigger**

SimpleTrigger的作用

在一个指定时间段内执行一次作业任务

或是在指定的时间间隔内多次执行作业任务

**需要注意的点**

重复次数可以为0，正整数或是

SimpleTrigger.REPEAT_INDEFINITELY常量值

重复执行间隔必须为0或长整数

一旦被指定了endTime参数，那么它会覆盖重复次数参数的效果

#### **CromTrigger**

**CronTrigger的作用**

基于日历的作业调度器，而不是像SimpleTrigger那样精确指定间隔时间，

比SimpleTrigger更常用

**Cron表达式**

用于配置CronTrigger实例

是由7个子表达式组成的字符串，描述了时间表的详细信息。

格式：[][] `[秒] [分] [小时] [日] [月] [周] [年]`

**Cron表达式小提示**

‘L’和‘W’可以一组合使用。

周字段英文字母不区分大小写即MON与mon相同

利用工具，在线生成

#### 浅谈Scheduler

**Scheduler——工厂模式**

所有的Scheduler实例应该由SchedulerFactory来创建

**Scheduler的创建方式**

SchedulerFactory	   sfact = new   StdSchedulerFactory();

Scheduler   scheduler  =  sfact.getScheduler();

DirectSchedulerFactory  factory = DirectSchedulerFactory.getInstance();

Scheduler  scheduler = factory.getScheduler();

**StdSchedulerFactory**

使用一组参数(Java.util.Properties)来创建和初始化Quartz调度器

配置参数一般存储在quartz.properties中

调用getScheduler方法就能创建和初始化调度器对象

**Scheduler的主要函数**

Date schedulerJob(JobDetail  jobDetail , Trigger  trigger)  返回最近一次执行任务的时间

void start()  启动scheduler

void standby()  挂起

void shutdown() 关闭scheduler

**quartz.properties**

**文档的位置和加载顺序**

**组成部分**

调度器属性、线程池属性、作业存储设置、插件配置

**调度器属性**

```
org.quartz.scheduler.instanceName属性用来区分特定的调度器实例，可以按照功能用途来给调度器起名。
org.quartz.scheduler.instanceId属性和前者一样，也允许任何字符串，但这个值必须是在所有调度器实例中是唯一的。尤其是在一个集群当中，作为集群的唯一key。假如你想Quartz帮你生成这个值的话，可以设置为AUTO。
```

**线程池属性**

threadCount(线程数)、threadPriority(线程优先级)、org.quartz.threadPool.class

**作业存储设置**

描述了在调度器实例的生命周期中，Job和Trigger信息是如何被存储的。

**插件配置**

满足特定需求用到的Quartz插件的配置。

#### 使用Quartz配置作业

**两种方式**

MethodInvokingJobDetailFactoryBean

JobDetailFactoryBean

**MethodInvokingJobDetailFactoryBean**

调用myBran的printMwssage方法

`<bean id="simpleJobDetail" class="org.springframework.scheduling.quartz.`

`MethodInvokingJobDetailFactoryBean">`

`<property name="targetObject" ref="myBean"/>`

`<property name="targetObject" value="printMessage"/>`

`</bean>`



#### QuartzAPI，Jobs和Triggers

**QuartzAPI**

Scheduler：与调度程序交互的主要API

Job：由希望由调度程序执行的组件实现的接口

JobDetail：用于定义作业的实例

Trigger(触发器)：定义执行给定作业的计划的组件

JobBuilder：用于定义/构建JobDetail实例，用于定义作业的实例

TriggerBuilder：用于定义/构建触发器实例


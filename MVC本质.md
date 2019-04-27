## MVC本质

MVC核心思想是业务数据抽取同业务数据呈现相分离

MVC是一种<font color="red">架构模式</font><!--架构模式描述软件系统里的基本的结构组织或纲要-->

程序分层、分工合作，既相互独立又协同工作

## Spring MVC

**DispatcherServlet**

DispatcherServlet—>Controller—>Model—>View

**HandlerAdapter**

是DispatcherServlet内部使用的一个类

HandlerInterceptor<!--Interceptor是拦截器-->

**HandlerMapping**

HandlerExecutionChain

preHandle ---> Controller method ---> postHandle ---> afterComletion

**ModelAndView**

**ViewResolver**<!--视图解析器-->

## Binding

将请求中的字段按照名字匹配的原则填入模型对象


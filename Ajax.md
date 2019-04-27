## Ajax

Ajax**不是某种编程语言是一种在无需重新加载整个网页的情况之下能够更新部分网页的技术**

### 同步异步

**同步：**客户端发出请求服务端进行处理和响应，但在处理和响应的过程中客户端只能进行等待，然后进行页面载入

**异步：**后台和服务器能够进行交换数据；运用HTML和CSS来实现页面，表达信息；运用XMLHttpRequest和web服务器进行数据的异步交换；运用javaScript操作DOM，实现动态局部刷新；

### Http

http是计算机通过网络进行通信的规则

http是一种无状态协议，不建立持久连接

**http请求过程：**

1、建立TCP连接

2、Web浏览器向Web服务器发送请求命令

3、Web浏览器发送请求信息

4、Web服务器应答

5、Web服务器发送应答头信息

6、Web服务器向浏览器发送数据

7、Web服务器关闭TCP连接

**Http请求**

1、Http请求的方法或动作，比如是GET还是POST请求

2、正在请求的URL，总的知道请求的地址是什么

3、请求头，包含一些客户端环境信息，身份验证信息等

4、请求体，也就是请求正文，请求正文中可以包含客户提交的查询字符串信息，表单信息等等

**Http响应**

1、一个数字和文字组成的状态码，用来显示请求是成功还是失败

2、响应头，响应头也和请求头一样包含许多有用的信息，例如服务器类型、日期时间、内容类型和长度等。

3、响应体，也就是响应正文

### XMLHttpRequest发送请求

open（method，url，async） <!--async请求同步false/异步true-->

send（string）用post方法要填写参数

### XMLHttpRequest取得响应

responseText：获得字符串形式的响应数据

responseXML：获得XML形式的响应数据

status和statusText：以数字和文本形式返回HTTP状态码

getAllResponseHeader()：获得所有的响应报头

getResponseHeader（）：查询响应中的某个字段的值

readyState属性在响应返回的成功的时候得到通知

0：请求未初始化，open还没有调用

1：服务器连接已建立，open已经调用了

2：请求已接收，也就是接收到头信息了

3：请求处理中，也就是接收到响应主体了

4：请求已完成，且响应已就绪，也就是响应完成了

var request = new XMLHttpRequest();

request.open("GET","get.php",true);

request.send();

request.onreadystatechange = function()

{ 

if(request.readyState ===4 && request.status===200){

//做一些事情  request.responseText

}

}

**PHP是一种创建动态交互性站点的服务器端脚本语言**

### JSON基本概念

json：javascript对象表示法

JSON是存储和交换文本信息的语法， 类似XML。它采用键值对的方式来组织，易于人们阅读和编写，同时也易于机器解析和生成

JSON是独立于语言的，也就是说不管什么语言，都可以解析json，只需要按照json的规则来就行

**JSON于XML比较**

json的长度和xml格式比起来很短小

json读写的速度更快

json可以使用JavaScript内键的方法直接进行解析，转换成Javascript对象， 非常方便

**JSON语法规则**

{

“staff”:[

{"name"："洪七"，"age"：70}，

{"name"："郭靖"，"age"：35}，

{"name"："黄蓉"，"age"：30}

]

}

### 用jQuery实现Ajax

jQuery.ajax([settings])

type: 类型，"POST"或"GET",默认为"GET"

url:发送请求的地址

data：是一个对象，连同请求发送到服务器的数据

dataType:预期服务器返回的数据类型，如果不指定，jQuery将自动根据HTTP包MIME信息来只能判断，一般我们采用json格式，可以设置为“json”

success：是一个方法，请求成功够的回调函数，传入返回后的数据，以及包含成功代码的字符串

error：是一个方法，请求失败时调用此函数，传入XMLHttpRequest对象

### 跨域

一个域名地址的组成：

http://   www.     abc.com   :   8080   /   scripts/jquery.js

**协议     子域名    主域名        端口号        请求资源地址**

当协议，子域名，主域名，端口号中任意一个不相同时，都算作不同域。

不同域之间相互请求资源，就算作"跨域"

**处理跨域方法一--------代理**

通过在同域名的web服务器端创建一个代理：

如：

北京服务器（域名：www.beijing.com）

上海服务器（域名：www.shanghai.com）

比如在北京的web服务器的后台

（www.beijing.com/proxy-shanghaiservice.php）来调用上海服务器

（www.shanghai.com/service.php）的服务，然后再把响应结果返回给前端，这样

前端调用北京同域名的服务就和调用上海的服务效果相同了。

**处理跨域方法二--------JSONP**

JSONP可用于解决主流浏览器的跨域数据访问的问题。

在www.aaa.com页面中：

<script>
    function jsonp(json){
        alert(json["name"]);
    }
</script>

<script src="http://wwww.bbb.com/jsonp.js"></script>

在www.bbb.com页面中：

jsonp({'name'：'洪七'，'age'：24});

通过一个script标签去不同域名提交http请求

这只是对get请求进行改造

**处理跨域方法三-------XHR2**

HTML5提供的XMLHttpRequest Level2已经实现了跨域访问以及其他的一些新功能

在服务器端做一些小小的改造即可：

**header('Access-Control-Allow-Origin:*');**

**header('Access-Control-Allow-Method:POST,GET');**
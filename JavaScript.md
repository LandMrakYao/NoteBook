## JavaScript

alert()方法用于显示带有一条指定消息和一个OK按钮的警告框。

var 定义变量： var 变量

定义函数：                                     调用函数：

function 函数名(){                               函数名()；

函数代码；

}

confirm 消息对话框

confirm(str);    str:在消息对话框中显示的文本   返回值：Boolean

prompt消息对话框

prompt(str1，str2)； str1：要显示在消息对话框中的文本，不可以修改

str2：文本框中的额内容，可以修改

open()方法可以查找一个已经存在或者新建的浏览器窗口

window.open(‘URL’，‘窗口名称’，‘参数字符串’)

窗口名称：1.该名字由字母、数字和下划线字符组成。

2."__blank"：在新窗口显示目标网页_

"_self"：在当前窗口显示目标网页

"_top"：框架网页中在上部窗口中显示目标网页

![1541144051456](C:\Users\ADMINI~1\AppData\Local\Temp\1541144051456.png)

close()关闭窗口

window.close()； 关闭本窗口

<窗口对象>.close(); 关闭指定的窗口

### DOM操作

三种常见的DOM节点：

1.元素节点：<html>、<body>、<p>等都是元素节点，即标签

2.文本节点：向用户展示的内容，如<li>...</li>中的JavaScript、DOM、CSS等文本

3.属性节点：如<a>标签的链接属性href="http://www.imooc.com".

通过ID获取元素

document.getElementById("id")

innerHTML属性用于获取或替换HTML元素的内容

Object.innerHTML

改变HTML样式：Object.style.property = new style;

Object是获取的元素对象，如通过document.getElementById("id")获取的元素。

显示和隐藏(display属性)

网页中经常会看到显示和隐藏的效果，可通过display属性来设置

Object.style.display = value   value取值 none：此元素不会被显示block：此元素将显示为块级元素(显示)

控制类名(className属性)

Object.className = classname

作用：1.获取元素的class属性  2.为网页内的某个元素指定一个css样式来更改该元素的外观

创建数组语法： var myarray = new Array()

二维数组：var Myarr = [[0,1,2],[1,2,3]];

### 事件响应，让网页交互

![1541466156730](C:\Users\ADMINI~1\AppData\Local\Temp\1541466156730.png)

鼠标经过事件(onmouseover)

当鼠标移到一个对象上时，该对象就触发onmouseover事件，并执行onmouseover事件调用的程序

鼠标移开事件(onmouseout)

当鼠标移开当前对象时，执行onmouseout调用的程序

光标聚焦事件(onfocus)

当网页中的对象获得聚点时，执行onfocus调用的程序就会被执行

失焦事件(onblur)

当光标离开当前获得聚焦对象的时候，触发onblur事件，同时执行被调用的程序

内容选中事件(onselect)

当文本框或者本文域中的文字被选中时，触发onselect事件，同时调用的程序就会被执行。

内容框内容改变事件(onchange)

通过改变文本框的内容来触发onchange事件，同时执行被调用的程序。

加载事件(onload)

事件会在页面加载完成后，立即发生，同时执行被调用的程序。

卸载事件(onunload)

当用户退出页面时（页面关闭、页面刷新等），触发onunload事件，同时执行被调用的程序。

parseInt()函数可解析一个字符串，并返回一个整数。

Date对象中处理时间和日期的常用方法：

![1541469266288](C:\Users\ADMINI~1\AppData\Local\Temp\1541469266288.png)

get/setFullYear() 返回/设置年份，用四位数表示

返回星期方法：

getDay()返回星期，返回的是0-6的数字，0表示星期天。

返回/设置时间方法：

get/setTime()返回/设置时间，单位毫秒数。

访问字符串对象的方法：

使用String对象的toUpperCase()方法来将字符串小写字母转换为大写。

toLowerCase()将字符串大写字母转换为小写。

返回指定位置的字符

charAt()方法可返回指定位置的字符，返回的字符是长度为1的字符串

stringObject.charAt(index)

index  必需。表示字符串中某个位置的数字，即字符在字符串中的下标。

返回指定的字符串首次出现的位置

stringObject.indexOf(substring , startpos)

![1541558316479](C:\Users\ADMINI~1\AppData\Local\Temp\1541558316479.png)

字符串分割split()

split()方法将字符串分割为字符串数组，并返回此数组。

stringObject.split(separator , limit)

![1541560097688](C:\Users\ADMINI~1\AppData\Local\Temp\1541560097688.png)

提取字符串substring()

substring()方法用于提取字符串中介于两个指定下标之间的字符

stringObject.substring(startPos , stopPos)

startPos   必需。一个非负的整数，开始位置。

stopPos   可选。一个非负的整数，结束位置，如果省略该参数，那么返回的子串会一直到字符串对象的结尾。

提取指定数目的字符substr()

substr()方法从字符串中提取从startPos位置开始的指定数目的字符串

stringObject.substr(startPos , length)

![1541585199883](C:\Users\ADMINI~1\AppData\Local\Temp\1541585199883.png)

Math对象

提供对数据的数学计算。

![1541585412833](C:\Users\ADMINI~1\AppData\Local\Temp\1541585412833.png)

向上取整ceil()

ceil()方法可对一个数进行向上取整。

Math.ceil(x)

x 必需。必须是一个数值。

向下取整floor()

floor()方法可对一个数进行向下取整。

Math.floor(x)

四舍五入round()

round()方法可把一个数字四舍五入为最接近的整数。

Math.round(x)

随机数random()

random()方法可返回介于0~1(大于或等于0但小于1)之间的一个随机数

Math.random();

Array数组对象

![1541588713286](C:\Users\ADMINI~1\AppData\Local\Temp\1541588713286.png)

数组连接concat()

concat()方法用于连接两个或多个数组。此方法返回一个新数组，不改变原来的数组。

arrayObject.concat(array1,array2,...,arrayN)

指定分隔符连接数组元素join()

join()方法用于数组中的所有元素放入一个字符串，元素是通过指定的分隔符进行分隔的。

arrayObject.join(分隔符)

颠倒数组元素顺序reverse()

reverse()方法用于颠倒数组中元素的顺序

arrayObject.reverse()

选定元素slice()

slice()方法可从已有的数组中返回选定的元素。

arrayObject.slice(start,end)

数组排序sort()

sort()方法使数组中的元素按照一定的顺序排列。

arrayObject.sort(方法函数)

### window对象

window对象是BOM的核心，window对象指当前的浏览器窗口

计时器setInterval()

在执行时，从载入页面后每指定的时间执行代码。

setInterval(代码，交互时间);

代码：要调用的函数或要执行的代码串

交互时间：周期性执行或调用表达式之间的时间间隔，以毫秒计

```
  var int=setInterval(clock, 100)
  function clock(){
    var time=new Date();
    document.getElementById("clock").value = time;
  }
```

取消计时器clearInterval()

clearInterval()方法可取消由selInterval()设置的交互时间

clearInterval()(id_of_setInterval)

计时器setTimeout()

setTimeout()计时器，在载入后延迟指定时间后，去执行一次表达式，仅执行一次。

setTimeout(代码，延迟时间);

取消计时器clearTimeout()

setTimeout()和clearTimeout()一起使用，停止计时。

clearTimeout(id_of_setTimeout)

`var num=0;`

`var i;`

`functionstartCount(`

`{document.getElementById('count').value=num;`

`num=num+1;`

`i=setTimeout("startCount()",1000);`

`}`

`function stopCount(){`

`clearTimeout(i);`

`}`

 <input type="text" id="count" />
    <input type="button" value="Start" onclick="startCount()" />
    <input type="button" value="Stop"   onclick="stopCount()"/>

History对象

history对象记录了用户曾经浏览过的页面（URL），并可以实现浏览器前进与后退相似导航的功能。

window.history.{属性|方法}

history对象属性    length  返回浏览器历史列表中的URL数量

history对象方法    back()加载history列表中的前一个URL

forward()加载history列表中的下一个URL  go()加载history列表中的某个具体的页面

Location对象

location用于获取或设置窗体的URL，并且可以用于解析URL

location.{属性|方法}

hash：设置或返回从#开始的URL。

host：设置或返回主机名和当前URL的端口号。

hostname：设置或返回当前URL的主机名。

href：设置或返回完整的URL。

pathname：设置或返回当前URL的路径部分。

port：设置或返回当前URL的端口号。

protocol：设置或返回当前URL的协议。

search：设置或返回从？开始的URL。

location对象方法：

assign()加载新的文档

reload()重新加载当前文档

replace()用新的文档替换当前文档

Navigator对象

Navigator对象包含有关浏览器的信息，通常用于检测浏览器与操作系统的版本。

对象属性：

appCodeName:浏览器代码名的字符串表示。

appName:返回浏览器的名称

appVersion：返回浏览器的平台和版本信息。

platform：返回运行浏览器的操作系统平台。

userAgent：返回由客户机发送服务器的user-agent头部的值。

screen对象

screen对象用于获取用户的屏幕信息。

window.screen.属性

屏幕分辨率的高和宽

1.screen.height返回屏幕分辨率的高

2.screen.width返回屏幕分辨率的宽

屏幕可用高和宽度

1.screen.availWidth 属性返回访问者屏幕的宽度，以像素计，减去界面特性

2.screen.availHeight 属性返回访问这片屏幕高度，以像素计

### DOM对象，控制HTML元素

文档对象模型DOM定义访问和处理HTML文档的标准方法。DOM将HTML文档呈现为带有元素、属性和文本的树的结构(节点树)

getElementsByName()方法

document.getElementsByName(name)

与document.getElementById()方法不同的是，通过元素的name属性查询元素，而不是通过id属性。

getElementsByTagName()方法

返回带有指定标签的节点对象的集合。返回元素的顺序是它们在文档中的顺序

document.getElementsByTagName(Tagname)

getAttribute()方法

通过元素节点的属性名称获取属性的值

elementNode.getAttribute(name)

1、elementNode : 使用getElementById()、getElementByTagName()等方法，获取到元素的节点。

2、name：要想查询的元素节点的属性名字

setAttribute()方法

setAttribute()方法增加一个指定名称和值的新属性，或把一个现有的属性设定为指定的值。

elementNode.setAttribute(name , value);

name: 要设置的属性名。

value：要设置的属性值。

节点属性

在DOM中，每个节点都是一个对象。DOM节点有三个重要的属性：

1、nodeName：节点的名称

2、nodeValue：节点的值

3、nodeType：节点的类型

访问子节点childNodes

访问选定元素节点下的所有子节点的列表，返回的值可以看作是一个数组，他具有length属性

elementNode.childNodes

访问子节点的第一和最后项

一、firstChild 属性返回 ‘childNodes’数组的第一个子节点。如果选定的节点没有子节点，则该属性返回NULL。

node.firstChild

二、lastChild属性返回'childNodes'数组的最后一个子节点。如果选定的节点没有子节点，则该属性返回NULL。

node.lastChild

访问父节点parentNode

获取指定节点的父节点

elementNode.parentNode 注意：父节点只能有一个

```
<div id="text">
  <p id="con"> parentNode 获取指点节点的父节点</p>
</div> 
<script type="text/javascript">
  var mynode= document.getElementById("con");
  document.write(mynode.parentNode.nodeName);
</script>
```

访问祖节点：

elementNode.parentNode.parentNode

访问兄弟节点：

1、nextSibling属性可返回某个节点之后紧跟的节点(处于同一树层级中)。

nodeObject.nextSibling   如果无此节点，则该属性返回null。

2、previousSibling属性可返回某个节点之前紧跟的节点(处于同一树层级中)。

nodeObject.previousSibling

插入节点appendChild()

在指定节点的最后一个子节点列表之后添加一个新的子节点。

appendChild(newnode)
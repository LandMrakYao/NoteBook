## jQuery基础(一)——样式篇

使用jQuery在head中添加

<script src="http://code.jquery.com/jquery-1.11.3.js"></script>

$(document).ready的作用是登页面的文档中的节点都加载完毕后，再执行后续的代码。

把jQuery对象转成DOM对象

```
var $div = $('div') //jQuery对象
var div = $div[0] //转化成DOM对象
div.style.color = 'red' //操作dom对象的属性
```

通过jQuery自带的get()方法

```
var $div = $('div') //jQuery对象
var div = $div.get(0) //通过get方法，转化成DOM对象
div.style.color = 'red' //操作dom对象的属性
```

把DOM对象转化成jQuery对象

**如果传递给$(DOM)函数的参数是一个DOM对象，jQuery方法会把这个DOM对象给包装成一个新的jQuery对象**

`var div = document.getElementById("div");//dom对象`

`var $div = $(div);//jQuery对象`

`var $first = $div.first();//找到第一个div元素`

`$first.css('color' , 'red');//给第一个元素设置颜色`

id选择器：即元素的id属性    $('#id')

类选择器：通过class样式类名来获取节点    $(".class")

元素选择器：根据给定标记名称选择所有的元素$("element")

全选择器(*选择器)  *通配符意味着给所有的元素设置默认的编剧。jQuery也可以$(" * ")

===  三个等号表示数据和类型都相等。

层级选择器：

$("parent > child") 子选择器：选择所有指定"parent"元素中指定的"child"的直接子元素。

$("ancestor  descendant")后代选择器：选择给定的祖先元素的所有后代元素，一个元素的后代可能是该元素的一个孩子，孙子等

$("prev + next")相邻兄弟选择器：选择所有紧接在"prev"元素后的"next"元素

$("prev ~ sibling")一般兄弟选择器：匹配"prev"元素之后的所有兄弟元素。具有相同的父元素，并匹配过滤"siblings"选择器

基本筛选选择器：

![QQ截图20181108150557](C:\Users\Administrator\Pictures\Camera Roll\QQ截图20181108150557.png)

![QQ截图20181108151315](C:\Users\Administrator\Pictures\Camera Roll\QQ截图20181108151315.png)

contains查找包含"指定文本"的元素，has查找包含"指定元素"的元素

查找指定文本是需要加  ''  引号

可见性筛选选择器：

元素有显示状态与隐藏状态，jQuery根据元素的状态扩展了可见性筛选选择器:visible与:hidden

$(":visible")     选择所有显示的元素

$(":hidden")    选择所有隐藏的元素

属性筛选选择器：

属性选择器让你可以基于属性来定位一个元素。可以只指定该元素的某个属性，这样所有使用该属性而不管它的值，这个元素都将被定位，也可以更加明确并定位在这些属性上使用特定值的元素。

![QQ截图20181108153733](C:\Users\Administrator\Pictures\Camera Roll\QQ截图20181108153733.png)

子元素筛选选择器：

![QQ截图20181108160606](C:\Users\Administrator\Pictures\Camera Roll\QQ截图20181108160606.png)

1、:first只匹配一个单独的元素，但是:first-child选择器可以匹配多个：即为每个父级元素匹配第一个子元素。这相当于:nth-child(1)

2、:last 只匹配一个单独的元素， :last-child 选择器可以匹配多个元素：即，为每个父级元素匹配最后一个子元素

3、如果子元素只有一个的话，:first-child与:last-child是同一个

4、 :only-child匹配某个元素是父元素中唯一的子元素，就是说当前子元素是父元素中唯一的元素，则匹配

5、jQuery实现:nth-child(n)是严格来自CSS规范，所以n值是“索引”，也就是说，从1开始计数，:nth-child(index)从1开始的，而eq(index)是从0开始的

6、nth-child(n) 与 :nth-last-child(n) 的区别前者是从前往后计算，后者从后往前计算

表单元素选择器：

![QQ截图20181108161251](C:\Users\Administrator\Pictures\Camera Roll\QQ截图20181108161251.png)

表单对象属性筛选选择器

主要功能是对所选择的表单进行筛选

![1541665132349](C:\Users\ADMINI~1\AppData\Local\Temp\1541665132349.png)

特殊选择器this

`$('p').click(function(){`

`var $this = $(this);`

`$this.css('color' , 'red');`

`})`

属性与样式值.attr()与.removeAttr()

**attr()有4个表达式**

1、attr(传入属性名)：获取属性的值

2、attr(属性名, 属性值)：设置属性的值

3、attr(属性名,函数值)：设置属性的函数值

4、attr(attributes)：给指定元素设置多个属性值，即：{属性名一: “属性值一” , 属性名二: “属性值二” , … … }

**removeAttr()删除方法**

.removeAttr( attributeName ) : 为匹配的元素集合中的每个元素中移除一个属性（attribute）

属性与样式之.html()及.text()

**.html()方法** 

获取集合中第一个匹配元素的HTML内容 或 设置每一个匹配元素的html内容，具体有3种用法：

1、.html() 不传入值，就是获取集合中第一个匹配元素的HTML内容

2、.html( htmlString )  设置每一个匹配元素的html内容

3、.html( function(index, oldhtml) ) 用来返回设置HTML内容的一个函数

**.text()方法**

得到匹配元素集合中每个元素的文本内容结合，包括他们的后代，或设置匹配元素集合中每个元素的文本内容为指定的文本内容。，具体有3种用法：

1、.text() 得到匹配元素集合中每个元素的合并文本，包括他们的后代

2、.text( textString ) 用于设置匹配元素内容的文本

3、.text( function(index, text) ) 用来返回设置文本内容的一个函数

**.val()方法**

.val()方法主要用于处理表单元素的值

1、.val()无参数，获取匹配的元素集合中第一个元素的当前值

2、.val( value )，设置匹配的元素集合中每个元素的值

3、.val( function ) ，一个用来返回设置值的函数

增加样式.addClass()

通过动态改变类名(class)，可以让其修改元素呈现出不同的效果。

**.addClass( className )方法**

1、.addClass( className ) : 为每个匹配元素所要增加的一个或多个样式名

2、.addClass( function(index, currentClass) ) : 这个函数返回一个或更多用空格隔开的要增加的样式名

删除样式.removeClass()

**.removeClass( )方法**

1、.removeClass( [className ] )：每个匹配元素移除的一个或多个用空格隔开的样式名

2、.removeClass( function(index, class) ) ： 一个函数，返回一个或多个将要被移除的样式名

切换样式.toggleClass()

**.toggleClass( )方法：**在匹配的元素集合中的每个元素上添加或删除一个或多个样式类,取决于这个样式类是否存在或值切换属性。即：如果存在（不存在）就删除（添加）一个类

1、.toggleClass( className )：在匹配的元素集合中的每个元素上用来切换的一个或多个（用空格隔开）样式类名

2、.toggleClass( className, switch )：一个布尔值，用于判断样式是否应该被添加或移除

3、.toggleClass( [switch ] )：一个用来判断样式类添加还是移除的 布尔值

4、.toggleClass( function(index, class, switch) [, switch ] )：用来返回在匹配的元素集合中的每个元素上用来切换的样式类名的一个函数。接收元素的索引位置和元素旧的样式类作为参数

样式操作.css()

**.css() 方法：获取元素样式属性的计算值或者设置元素的CSS属性**

1、.css( propertyName ) ：获取匹配元素集合中的第一个元素的样式属性的计算值

2、.css( propertyNames )：传递一组数组，返回一个对象结果

.css()与.addClass()这是样式的区别

**可维护性：**

.addClass()的本质是通过定义个class类的样式规则，给元素添加一个或多个类。css方法是通过JavaScript大量代码进行改变元素的样式

通过.addClass()我们可以批量的给相同的元素设置统一规则，变动起来比较方便，可以统一修改删除。如果通过.css()方法就需要指定每一个元素是一一的修改，日后维护也要一一的修改，比较麻烦

**灵活性：**

通过.css()方式可以很容易动态的去改变一个样式的属性，不需要在去繁琐的定义个class类的规则。一般来说在不确定开始布局规则，通过动态生成的HTML代码结构中，都是通过.css()方法处理的

**样式值：**

.addClass()本质只是针对class的类的增加删除，不能获取到指定样式的属性的值，.css()可以获取到指定的样式值。

**样式的优先级：**

css的样式是有优先级的，当外部样式、内部样式和内联样式同一样式规则同时应用于同一个元素的时候，优先级如下

```
外部样式 < 内部样式 < 内联样式
```

元素的数据存储

jQuery提供的存储接口

```
jQuery.data( element, key, value )   //静态接口,存数据
jQuery.data( element, key )  //静态接口,取数据   
.data( key, value ) //实例接口,存数据
.data( key ) //实例接口,存数据
```

## jQuery基础(五)——Ajax应用与常用插件

使用load()方法异步请求数据

使用`load()`方法通过Ajax请求加载服务器中的数据，并把返回的数据放置到指定的元素中，它的调用格式为：

```
load(url,[data],[callback])
```

参数url为加载服务器地址，可选项data参数为请求时发送的数据，callback参数为数据请求成功后，执行的回调函数。

使用getJSON()方法异步加载JSON格式数据

使用`getJSON()`方法可以通过Ajax异步请求的方式，获取服务器中的数据，并对获取的数据进行解析，显示在页面中，它的调用格式为：

```
jQuery.getJSON(url,[data],[callback])或$.getJSON(url,[data],[callback])
```

其中，url参数为请求加载json格式文件的服务器地址，可选项data参数为请求时发送的数据，callback参数为数据请求成功后，执行的回调函数。

使用getScript()方法异步加载并执行js文件

使用`getScript()`方法异步请求并执行服务器中的JavaScript格式的文件，它的调用格式如下所示：

```
jQuery.getScript(url,[callback])`或`$.getScript(url,[callback])
```

参数url为服务器请求地址，可选项callback参数为请求成功后执行的回调函数

使用get()方法以GET方式从服务器获取数据

使用`get()`方法时，采用GET方式向服务器请求数据，并通过方法中回调函数的参数返回请求的数据，它的调用格式如下：

```
$.get(url,[callback])
```

参数url为服务器请求地址，可选项callback参数为请求成功后执行的回调函数。

使用post()方法以POST方式从服务器发送数据

与`get()`方法相比，`post()`方法多用于以POST方式向服务器发送数据，服务器接收到数据之后，进行处理，并将处理结果返回页面，调用格式如下：

```
$.post(url,[data],[callback])
```

参数url为服务器请求地址，可选项data为向服务器请求时发送的数据，可选项callback参数为请求成功后执行的回调函数。

使用ajax()方法加载服务器数据

使用`ajax()`方法是最底层、功能最强大的请求服务器数据的方法，它不仅可以获取服务器返回的数据，还能向服务器发送请求并传递数值，它的调用格式如下：

```
jQuery.ajax([settings])或$.ajax([settings])
```

其中参数settings为发送ajax请求时的配置对象，在该对象中，url表示服务器请求的路径，data为请求时传递的数据，dataType为服务器返回的数据类型，success为请求成功的执行的回调函数，type为发送数据请求的方式，默认为get。


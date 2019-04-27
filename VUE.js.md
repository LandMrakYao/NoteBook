## VUE.js

**起步**

可以创建一个.html文件，然后通过如下方式引入Vue:

<!--开发环境版本，包含了有帮助的命令行警告-->

<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

或者

<!--生产环境版本，优化了尺寸和速度-->

<script  src="https://sdn.jsdelivr.net/npm/vue"></script>

new一个对象的时候你可以设置它的属性，其中最重要的包括三个，分别是data，method，watch

其中data代表vue对象的数据，method代表vue对象的方法，watch设置了对象监听的方法。

Vue对象里的设置通过HTML指令进行关联

重要的指令包括

<<<<<<< HEAD
—— v-text渲染数据相当于{{}}
=======
—— v-text渲染数据
>>>>>>> 694186efd45b9dac02f9f2783ddb27fa656364ac

—— v-if控制显示

—— v-on绑定事件

—— v-for循环渲染等

**划分组件**

功能模块——select、pagenation...

页面区域——header、footer、sidebar...

Vuejs组件之间的调用——另外一个重要选项——components

Vuejs组件之间的通信——props

**自定义事件**

Vue实例实现了一个自定义事件接口，用于在组件树中通信。这个时间系统独立于原生DOM事件，用法也不同。

每个Vue实例都是一个事件触发器。

使用Son()监听事件；

使用$emit()在它上面触发事件；

使用Sdispatch()派发事件，事件沿着父链冒泡；

使用Sbroadcast()广播事件，事件向下传导给所有后代；
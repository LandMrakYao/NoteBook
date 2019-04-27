// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue';
import App from './App';
import VueRouter from 'vue-router';
import doLogin from './components/doLogin';
import  Login from  './components/Login';
Vue.use(VueRouter);
Vue.config.productionTip = false
//定义路由
const routes = [
  {path:'/',component: App},
  {path:'/Login',component:Login},
  {path:'/doLogin',component:doLogin}
]
//创建router实例，然后传routes配置
const router = new VueRouter({
  routes
});
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router
});

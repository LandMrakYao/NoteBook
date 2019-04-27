<template>
  <div id="app">
   <img src="./assets/logo.png"/>
  <h1 v-text="title"></h1>
    <ul>
      <router-link to="/Login" tag='li'><a href="/Login">登录</a></router-link>
      <router-link to="/doLogin" tag='li'><a href="/doLogin">注册</a></router-link>
    </ul>
  </div>
</template>
<script>
export default {
  data(){
    return{
      title:'Welcome to my first page'
    }
  }
}
</script>
<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 90px;
}
</style>

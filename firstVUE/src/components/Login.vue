<template>
    <div>
       <p v-html="message"></p>
    </div>
</template>

<style>
    body {
        background-color: white;
    }
</style>

<script>
    export default {
        data(){
          return{
            message:'<h1>登录界面</h1>\n' +
              '      <label>用户名</label>\n' +
              '      <input name="username" value=""/>\n' +
              '      <label>密码</label>\n' +
              '      <input type="password" name="password" value=""/>\n' +
              '      <input type="submit" value="登录"/>'
          }
        }
    }
</script>

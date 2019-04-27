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
                message:'<h1>注册界面</h1>\n' +
                  '      <label>用户名</label>' +
                  '      <input name="username" value=""/><br>' +
                  '      <label>密&nbsp&nbsp&nbsp&nbsp码</label>\n' +
                  '      <input type="password" name="password" value=""/><br>' +
                  '      <input type="submit" value="注册"/>\n'
              }
            }
    }
</script>

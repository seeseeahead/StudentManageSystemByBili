<template>
  <div id="app">
    <!-- 登录成功，登录框页面消失 -->
    <div class="login"  v-show="!isLoggedIn">
      
      <div class="login-form">
        <input type="username" placeholder="用户名" required>
        <input type="password" placeholder="密码" required>
        <!-- <button type="submit" @click="loginButton()">登录</button> -->
        <!-- <button type="submit" @click="change('/studentM')">登录</button> -->
        <router-link to="/studentL">
          <button type="submit" @click="loginButton">登录</button>
        </router-link>
      </div>
    </div>
    <div>
      <!-- <StudentM class="studentM" v-show="isLoggedIn"></StudentM>/ -->
      <router-view v-show="isLoggedIn"></router-view>
    </div>

  </div>
  
</template>

<script>
//import axios from 'axios';
// import StudentM from './components/StudentM.vue';//引入Students页面
export default {
  name: 'App',
  // components: {//在父组件中，使用'components'属性，将刚才导入的comment组件，注册为自己的子组件。
  // //  StudentM
  // },
  data(){
    return {
      isLoggedIn: false
    }
    },
  methods:{
    loginButton() {
      this.isLoggedIn = true;
      // let username = this.username;
      // let password = this.password;

      // axios.post('https://your-api-url.com/login', {
      //   username: username,
      //   password: password
      // })
      //   .then(function (response) {
      //     console.log(response);
      //     // 这里可以根据服务器的响应内容做相应的处理
      //   })
      //   .catch(function (error) {
      //     console.log(error);
      //     // 这里可以捕获到错误信息
      //   });
    },
    // change(path){
    //   this.$router.push(path)
    //   // this.$router.replace('/StudentM')
    // }
  },
  computed: {
    
  }
}
</script>

<style>

.login {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f0f0f0;
}
.studentM{
  display: initial;
}
.login-form {
  width: 300px;
  background-color: #ffffff;
  padding: 30px;
  border-radius: 10px;
  box-shadow: 0px 0px 10px 0px #00000030;
}

.login-form input {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid #ddd;
}

.login-form button {
  width: 100%;
  padding: 10px;
  border-radius: 5px;
  border: none;
  color: #fff;
  background-color: #007bff;
}

</style>

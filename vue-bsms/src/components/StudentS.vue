<!-- eslint-disable vue/no-mutating-props -->
<template>
  <tr>
    <!-- <th scope="row">1</th>第一行 -->
      <td v-show="!is_edit">{{ student.number }}</td>
      <td v-show="!is_edit">{{ student.name }}</td>
      <td v-show="!is_edit">{{ student.age }}</td>
      <td v-show="!is_edit">{{ student.chi }}</td>
      <td v-show="!is_edit">{{ student.math }}</td>
      <td v-show="!is_edit">{{ student.eng }}</td>
      <td v-show="!is_edit">
        <!-- 按钮type为primary代表蓝色，danger代表红色 -->
        <el-button type="primary" @click="modify">修改</el-button> 
      </td>
      <td  v-show="!is_edit">
        <el-button type="danger" @click="deleteStudent">删除</el-button>
      </td>
      <td v-show="is_edit"><input class="w-50" type="text" v-model="student.number"/></td>
      <td v-show="is_edit"><input class="w-50" type="text" v-model="student.name"/></td>
      <td v-show="is_edit"><input class="w-50" type="text" v-model.number="student.age"/></td>
      <td v-show="is_edit"><input class="w-50" type="text" v-model.number="student.chi"/></td>
      <td v-show="is_edit"><input class="w-50" type="text" v-model.number="student.math"/></td>
      <td v-show="is_edit"><input class="w-50" type="text" v-model.number="student.eng"/></td>
      <td v-show="is_edit">
        <!-- 按钮type为primary代表蓝色，danger代表红色 -->
        <el-button type="primary" @click="save" >保存</el-button> 
      </td>
      <td v-show="is_edit">
        <el-button type="danger" @click="deleteStudent">删除</el-button>
      </td>
    </tr>
</template>

<script>
import axios from 'axios';
export default {
  // 用prop属性获取studentL传来的student数组数据
  props:["student"],
  data(){
    return{
      is_edit:false,
    }
  },
  methods:{
    //点击修改按钮时把原来的数据隐藏，重新在输入框理显示，变成可修改状态
    modify(){
      this.is_edit=true
    },
    //点击保存数据会保存已经修改的内容
    save(){
      axios({
        url:"http://localhost:8080/update",
        method:"POST",
        data:this.student
      })
      this.is_edit=false
    },
    //点击删除按钮会删除点击的数据，需要手动刷新一下，前端渲染才会消失
    deleteStudent(){
      axios({
        url:"http://localhost:8080/delete",
        method:"POST",
        data:this.student
      })
      // location.reload();
      // this.is_edit=false
    }
  }
}
</script>

<style>
body {
    display: initial;
    /* justify-content: initial;
    align-items: initial;
    height: initial;
    background-color: initial; */
}
</style>
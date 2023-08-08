import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

//1.定义一个路由。每个路由都需要映射到一个组件


const routes = [
    {path:'/studentL',component:() => import('../components/StudentL.vue')},
    // {path:'/studentS',Comment:() => import('../components/StudentS.vue')},
]

const router = new VueRouter({
    //mode:'hash', //默认是hash模式，url是带#号的
    mode:'history',  //history模式，url不带#号
    routes
})

export default router
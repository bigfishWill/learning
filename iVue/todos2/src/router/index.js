import Vue from 'vue'// 导入Vue
import Router from 'vue-router'// 导入vue-router 库
import HelloWorld from '@/components/HelloWorld'
import Layouts from '@/components/layouts'// 导入layouts.vue 组件
import todo from '@/components/todo'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'Layouts',
      component: Layouts,
      children: [{
        path: '/todo/:id',
        name: 'todo',
        component: todo
      }]
    }
  ]
})

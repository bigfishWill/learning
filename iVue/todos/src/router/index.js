import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Layouts from '@/components/layouts'
import todo from '@/components/todo'

Vue.use(Router)

// export default new Router({
//   routes: [
//     {
//       path: '/hello',
//       name: 'HelloWorld',
//       component: HelloWorld
//     },
//     {
//       path: '/',  //访问路径
//       name: 'Layouts', // 路径名
//       component: Layouts, //访问的组件,即访问‘/’,它会加载 Layouts 组件所有的内容
//     }
//   ]
// })
export default new Router({
  routes: [{
    path: '/',
    name: 'Layouts',
    component: Layouts,
    children: [{
      path: '/todo/:id',
      name: 'todo',
      component: todo
    }]
  }]
})

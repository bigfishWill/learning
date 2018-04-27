// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Mock from './mock'; // 引入mock模块
import store from './vuex/store'; //  引入vuex实例

Mock.start(); //并且执行初始化函数

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,//注入
  components: { App },
  template: '<App/>'
})

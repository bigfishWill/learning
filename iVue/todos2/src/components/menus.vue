<template>
  <div class="list-todos">  <!--菜单容器-->
    <a @click="goList(item.id)" class="list-todo list activeListClass" :class="{'active': item.id === todoId}"
       v-for="(item,index) in todoList" :key="index"> <!-- v-for 列表渲染-->
      <span class="icon-lock" v-if="item.locked"></span> <!-- v-if 条件渲染-->
      <span class="count-list" v-if="item.count > 0">{{item.count}}</span>
      {{item.title}}   <!-- 数据绑定，看模板语法-->
    </a>
    <a class=" link-list-new" @click="addTodoList()"> <!--新增菜单-->
      <span class="icon-plus">
      </span>
      新增
    </a>
  </div>
</template>
<script>
  import { getTodoList, addTodo } from '../api/api'; // 引入我们 封装好的两个接口函数。
  export default {
    data() {
      return {
        items: [], // 菜单数据
        todoId: '' // 默认选中id
      };
    },
    computed:{
      todoList() {
        return this.$store.getters.getTodoList; // 返回vuex getters.js 定义的getTodoList数据
      }
    },
    created() { // 调用请求菜单列表数据的接口
      this.$store.dispatch('getTodo').then(() => { //调用vuex actions.js 里面的 getTodo函数
        this.$nextTick(() => {
          this.goList(this.todoList[0].id);
        });
      });
    },
    methods: {
      goList(id) { // 点击菜单时候,替换选中id
        this.todoId = id;
      },
      addTodoList() { // 点击新增按钮时候
        //调用vuex actions.js 里面的 getTodo函数
        addTodo({}).then(data => {
          this.$store.dispatch('getTodo').then(() => {
            this.$nextTick(() => {
              setTimeout(() => {
                this.goList(this.todoList[this.todoList.length - 1].id);
              }, 100);
            });
          });
        });
      }
    },
//    通过 watcher 我们能监听到任何数值属性的数值更新。
    watch:{
      'todoId'(id) {
        this.$router.push({ name: 'todo', params: { id: id } });
        //监听到用户的点击todoId的变化在跳转路由
      }
    }
  };
</script>
<style lang="less">
  @import '../common/style/menu.less';
</style>

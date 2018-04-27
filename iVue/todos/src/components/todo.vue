<template>
  <div class="page lists-show"><!--最外层容器-->
    <nav><!--容器上半部分-->
      <div class="nav-group" @click="$store.dispatch('updateMenu')" v-show="!isUpdate">
        <!-- 在菜单的图标下面添加updateMenu时间，他可以直接调用vuex actions.js里面的updateMenu方法 -->
        <a class="nav-item">
          <span class="icon-list-unordered">
          </span>
        </a>
      </div>
      <h1 class="title-page">
        <span class="title-wrapper">{{todo.title}}</span><!--标题-->
        <span class="count-list">{{todo.count||0}}</span><!--数目-->
      </h1>
      <div class="nav-group right"><!-- 右边的删除，锁定图标容器-->
        <div class="options-web">
          <a class="nav-item"><!-- 锁定图标-->
            <span class="icon-lock" v-if="todo.locked"></span>
            <span class="icon-unlock" v-else></span>
          </a>
          <a class="nav-item"><!--删除图标-->
            <span class="icon-trash"></span>
          </a>
        </div>
      </div>
      <div class="form todo-new input-symbol">
        <!-- 新增单个代办单项输入框,监听了回车事件，双向绑定text值,监听了disabled属性，在todo.locked为true的情况下无法编辑-->
        <input type="text" v-model="text" placeholder="请输入" @keyup.enter="onAdd" :disabled="todo.locked"/>
        <span class="icon-add"></span>
      </div>
    </nav>
    <div class="content-scrollable list-items">
      <div v-for="item in items">
        <item :item="item"></item>
      </div>
    </div>
  </div>
</template>
<script>
  import item from './item';
  import { getTodo} from'../api/api';

  export default{
    components: {
      item
    },
    watch: {
      '$route.params.id'() {
        // 监听$route.params.id的变化，如果这个id即代表用户点击了其他的待办项需要重新请求数据。
        this.init();
      }
    },
    created() {
      // created生命周期，在实例已经创建完成，页面还没渲染时调用init方法。
      this.init();
    },
    data() {
      return {
        todo: { //详情内容
          title: '星期一',
          count: 12,
          locked: false
        },
        items: [ //代办单项列表
        ],
        text: '' //新增代办单项绑定的值
      }
    },
    methods: {
      init() {
        // 获取到 $route下params下的id,即我们在menus.vue组件处传入的数据。
        const ID = this.$route.params.id;
        getTodo({ id: ID }).then(res => {

          let { id, title, count, isDelete, locked, record} = res.data.todo;
          // 请求成功，拿到res.data.todo;在将record 赋值到代办单项列表，其它数据赋值到todo对象
          this.items = record;
          this.todo = {
            id: id,
            title: title,
            count: count,
            locked: locked,
            isDelete: isDelete
          };
        });
      },
      onAdd() {
        this.items.push({
          checked: false, text: this.text, isDelete: false
        }); // 当用户点击回车时候 ，给items的值新增一个对象，this.text 即输入框绑定的值
        this.text = ''; //初始化输入框的值。
      }
    }
  }
</script>
<style lang="less">
  @import "../common/style/nav.less";
  @import "../common/style/form.less";
  @import "../common/style/todo.less";
</style>

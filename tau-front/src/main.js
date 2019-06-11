import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'
import HelloWorld from './components/HelloWorld.vue'
import login from './components/login.vue'
import register from './components/register.vue'
import books from './components/books.vue'
import addBook from './components/addBook.vue'
//Vue.config.productionTip = false
Vue.use(VueRouter)


const routes = [
  
  { path: '/', component: HelloWorld },
  { path: '/login', component: login },
  { path: '/register', component: register},
  { path: '/addBook', component: addBook},
  { path: '/books', component: books}
]
const router = new VueRouter({
  routes

})
new Vue({
  router,
  render: h => h(App),
}).$mount('#app')

import Vue from 'vue'

import Router from 'vue-router'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      alias: '/cars',
      name: 'cars',
      component: require('@/components/Cars.vue')
    }
  ]
})

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

// function requireLoggedIn (to, from, next) {
//   if (!Auth.isLoggedIn()) {
//     next({
//       path: '/login',
//       query: { redirect: to.fullPath }
//     })
//   } else {
//     next()
//   }
// }

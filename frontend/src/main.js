// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue/dist/bootstrap-vue.esm'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
Vue.use(BootstrapVue)

import VueResource from 'vue-resource'
Vue.use(VueResource)

import App from '@/components/App'
import router from './router'
import store from './store'

Vue.config.productionTip = false

// Multi select box
import Multiselect from 'vue-multiselect'
  // register globally
Vue.component('multiselect', Multiselect)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  template: '<App/>',
  components: { App }
})

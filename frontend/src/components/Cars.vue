<template>
  <div>
    <app-nav></app-nav>
    <div class='container'>
      <spinner v-show='isProcessing' message='Processing...'></spinner>
      <div class="row">
        <div class="col-sm-12 text-left">
        <h1>
          Cars
          <transition name="fade">
            <small v-if="total">Total Records: ({{ total }})</small>
          </transition>
        </h1>
        </div>
      </div>

      <div class='row'>
        <div class='col-sm-12'>
          <div class='form-control-feedback'>
            <span class='text-danger align-middle'>
            {{ errorMessage }}
            </span>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col-sm-10">

        <multiselect v-model="value" :options="colorOptions"></multiselect>

        </div>
        <div class="col-sm-2 text-right">
          <button type="submit" class="btn btn-primary" @click="addTask" >Add todo</button>
        </div>
      </div>

      <div class="row">
        <transition-group name="fade" tag="ul" class="no-bullet list-group col-sm-12 my-4">
                  <car-item v-for="(car, index) in cars"
                            :car="car"
                            :key="index"
                  ></car-item>
        </transition-group>
      </div>

    </div>
  </div>
</template>

<script>
import AppNav from '@/components/AppNav'
import CarItem from '@/components/CarItem'
import Spinner from '@/components/common/Spinner'

export default {
  name: 'cars',
  components: {AppNav, CarItem, Spinner, Multiselect},
  props: {
    cars: {
      default: function () {
        return []
      }
    }
  },
  data () {
    return {
      isProcessing: false,
      errorMessage: '',
      value: null,
      colorOptions: ['Red', 'Grey', 'White']
    }
  },
  created () {
    this.loadCars()
  },
  computed: {
    total () {
      return this.cars.length
    }
  },
  methods: {
    loadCars () {
      this.isProcessing = true
      this.errorMessage = ''
      this.$http.get('/cars').then(response => {
        for (var i in response.body) {
          this.cars.push(response.body[i])
        }
        this.isProcessing = false
      }, error => {
        this.isProcessing = false
        this.errorMessage = JSON.stringify(error.body) + '. Response code: ' + error.status
      })
    }
  }
}
</script>
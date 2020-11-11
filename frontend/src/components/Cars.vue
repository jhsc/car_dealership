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
        <div class="col-sm-4 text-left">
          <label class="typo__label">Color</label>
          <multiselect v-model="colorValue" :options="colorOptions" placeholder="Pick color"></multiselect>
        </div>
        <div class="col-sm-4 text-left">
          <label class="typo__label">Has Sunroof</label>
          <multiselect v-model="sunRoofValue" :options="booleanOptions" placeholder="Sunroof?"></multiselect>
        </div>
        <div class="col-sm-2 text-right">
          <br>
          <button type="submit" class="btn btn-primary" @click="query" >Query</button>
        </div>
      </div>

      <div class="row">
        <div>
          <table>
            <thead>
              <tr>
                <th v-for="col in columns" :key="col._id">{{col}}</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="row in cars" :key="row._id">
                <td v-for="col in columns" :key="col._id">{{row[col]}}</td>
              </tr>
            </tbody>
          </table>
        </div>

      </div>

    </div>
  </div>
</template>

<script>
import AppNav from '@/components/AppNav'
import Spinner from '@/components/common/Spinner'
import Multiselect from 'vue-multiselect'

export default {
  name: 'cars',
  components: {AppNav, Spinner, Multiselect},
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
      colorValue: null,
      colorOptions: ['Red', 'White', 'Gray', 'Silver', 'Black'],
      sunRoofValue: null,
      booleanOptions: ['True', 'False']
    }
  },
  created () {
    this.loadCars()
  },
  computed: {
    total () {
      return this.cars.length
    },
    columns () {
      if (this.cars.length === 0) {
        return []
      }
      return Object.keys(this.cars[0])
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
    },
    query () {
      this.isProcessing = true
      this.errorMessage = ''
      this.cars = []
      let localParams = {}
      if (this.colorValue) {
        localParams['color'] = this.colorValue
      }
      if (this.sunRoofValue) {
        localParams['sun_roof'] = this.sunRoofValue
      }
      this.$http.get('/cars', {params: localParams}).then(response => {
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

<style src="vue-multiselect/dist/vue-multiselect.min.css">
</style>

<style scoped>
table {
  font-family: 'Open Sans', sans-serif;
  width: 750px;
  border-collapse: collapse;
  border: 3px solid #44475C;
  margin: 10px 10px 0 10px;
}

table th {
  text-transform: uppercase;
  text-align: left;
  background: #44475C;
  color: #FFF;
  padding: 8px;
  min-width: 30px;
}

table td {
  text-align: left;
  padding: 8px;
  border-right: 2px solid #7D82A8;
}
table td:last-child {
  border-right: none;
}
table tbody tr:nth-child(2n) td {
  background: #D4D8F9;
}
</style>
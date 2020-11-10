<template>
    <li class="list-group-item py-0 px-0 ml-3">
      <div class="col-sm-11 text-left">
        {{ car.color }}
      </div>

    </li>
</template>


<script>
export default {
  name: 'car-item',
  props: ['car']
}
</script>
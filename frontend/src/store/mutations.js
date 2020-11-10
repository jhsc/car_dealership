export const UPDATE_FILTER = (state, filter) => {
  state.filter = filter
}

export const CLEAR_ALL_DATA = (state) => {
  // Filter
  state.filter.color = ''
  state.filter.fourWheel = null
}


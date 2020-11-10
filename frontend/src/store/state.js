export const STORAGE_KEY = 'car-dealership-frontend'

let syncedData = {
  filter: {
    color: '',
    fourWheel: null
  }
}

// Sync with local storage.
if (localStorage.getItem(STORAGE_KEY)) {
  syncedData = JSON.parse(localStorage.getItem(STORAGE_KEY))
}

// Merge data and export it.
export const state = Object.assign(syncedData)

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/ws.io': {
        target: 'ws://127.0.0.1:8080/websocket',
        ws: true
      } 
    }
  }
})

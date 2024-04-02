import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/views/index.vue'
import Stat from '@/views/data.vue'
import Help from '@/views/help.vue'
import TestPlan from '@/views/planList.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/case',
      name: 'h5Monitor',
      component: Home  // 不能使用懒加载，否则菜单那取不到route.path值
    },
    {
      path: '/',
      name: 'home',
      redirect: '/case',
    },
    {
      path: '/case/add',
      name: 'h5MonitorAdd',
      component: () => import('@/views/add.vue')
    },
    {
      path: '/case/edit/:id',
      name: 'h5MonitorEdit',
      component: () => import('@/views/add.vue')
    },
    {
      path: '/case/info/:id',
      name: 'h5MonitorEdit',
      component: () => import('@/views/case.vue')
    },
    {
      path: '/stat',
      name: 'h5MonitorData',
      component: Stat
    },
    {
      path: '/help',
      name: 'h5MonitorHelp',
      component: Help
    },
    {
      path: '/test-plan',
      name: 'h5MonitorPlan',
      component: TestPlan
    }
  ]
})

export default router

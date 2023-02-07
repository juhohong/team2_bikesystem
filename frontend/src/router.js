
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ApprovalManager from "./components/listers/ApprovalCards"
import ApprovalDetail from "./components/listers/ApprovalDetail"

import ReservationManager from "./components/listers/ReservationCards"
import ReservationDetail from "./components/listers/ReservationDetail"

import PointManager from "./components/listers/PointCards"
import PointDetail from "./components/listers/PointDetail"

import ManagementManager from "./components/listers/ManagementCards"
import ManagementDetail from "./components/listers/ManagementDetail"


import ReservationDashboardView from "./components/ReservationDashboardView"
import ReservationDashboardViewDetail from "./components/ReservationDashboardViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/approvals',
                name: 'ApprovalManager',
                component: ApprovalManager
            },
            {
                path: '/approvals/:id',
                name: 'ApprovalDetail',
                component: ApprovalDetail
            },

            {
                path: '/reservations',
                name: 'ReservationManager',
                component: ReservationManager
            },
            {
                path: '/reservations/:id',
                name: 'ReservationDetail',
                component: ReservationDetail
            },

            {
                path: '/points',
                name: 'PointManager',
                component: PointManager
            },
            {
                path: '/points/:id',
                name: 'PointDetail',
                component: PointDetail
            },

            {
                path: '/managements',
                name: 'ManagementManager',
                component: ManagementManager
            },
            {
                path: '/managements/:id',
                name: 'ManagementDetail',
                component: ManagementDetail
            },


            {
                path: '/reservationDashboards',
                name: 'ReservationDashboardView',
                component: ReservationDashboardView
            },
            {
                path: '/reservationDashboards/:id',
                name: 'ReservationDashboardViewDetail',
                component: ReservationDashboardViewDetail
            },


    ]
})

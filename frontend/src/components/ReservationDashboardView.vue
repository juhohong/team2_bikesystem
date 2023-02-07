<template>

    <v-data-table
        :headers="headers"
        :items="reservationDashboard"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReservationDashboardView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "reserveNo", value: "reserveNo" },
                { text: "userId", value: "userId" },
                { text: "bikeId", value: "bikeId" },
                { text: "reserveStatus", value: "reserveStatus" },
            ],
            reservationDashboard : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/reservationDashboards'))

            temp.data._embedded.reservationDashboards.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.reservationDashboard = temp.data._embedded.reservationDashboards;
        },
        methods: {
        }
    }
</script>


<template>

    <v-card outlined>
        <v-card-title>
            ReservationDashboard # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="ReserveNo" v-model="item.reserveNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="BikeId" v-model="item.bikeId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ReserveStatus" v-model="item.reserveStatus" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReservationDashboardViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/reservationDashboards/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>


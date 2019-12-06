<template>
  <div id="main">

    <div class="field">
      <p class="control">
        <input class="input" type="text" placeholder="Nome do estado" v-model="stateName"/>
        <!-- <span class="icon is-small is-left"> -->
          <!-- <span class="far fa-flag"></span> -->
        <!-- </span> -->
        <button class="button is-primary" v-on:click="setState()">Adicionar Estado</button>
      </p>
    </div>

    <div>
      <ul>
        <li v-for="state in states" v-bind:key="state.id">
          {{state.id}} | {{state.nome}} 
          <button class="button is-primary is-danger is-round delete-btn" v-on:click="deleteState(state.id)">X</button>
        </li>
      </ul>
    </div>

  </div>
</template>

<script>
import "bulma/css/bulma.css"
import "font-awesome/css/font-awesome.css"

const axios = require('axios');
const requestUrl = "http://localhost:8080/api/v1/" + "estados";

export default {
  name: 'app',
  data: function() {
    return {
      states: [],
      stateName: ""
    };
  },
  methods: {
    getStates() {
      axios.get(requestUrl)
        .then((response) => {
          this.states = response.data
        })
        .catch(error => {
          console.log(error);
        })
    },
    setState() {
      axios.post(requestUrl, {
        nome: this.stateName
      })
        .then(response => {
          console.log(response);
          console.log("Criado com sucesso.");
          this.getStates();
        })
        .catch(error => {
          console.log(error);
        })
    },
    deleteState(stateId) {
      axios.delete(requestUrl + `/${stateId}`)
        .then(response => {
          console.log(response);
          this.getStates();
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  created() {
    this.getStates();
  }
  
}
</script>

<style>
.input {
  width: 200px;
}

.field {
  margin: 25px auto 25px auto;
}

.delete-btn {
  /* padding-left: 40px; */
  margin-left: 20px;
}



</style>

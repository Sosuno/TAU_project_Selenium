<template>
  <div>
      <div id="outcome">
          Success
      </div>
      <div id="fail">
          Wrong username or password
      </div>
      
      <input type="text" placeholder="username" id="username" required/>
      <br>
      <input type="password" placeholder="password" id="password" required/>
      <br>
      <button value="login" id="subBtn" v-on:click="send"> login </button>

{{info}}
  </div>
</template>

<script>
import axios from 'axios'
import VueAxios from 'vue-axios'
import { log } from 'util';

export default {
  name: 'login',
  props: {
    msg: String
  },
  data() {
    return {
     
      info: null
    
      
    }
    
  },
  methods: { 
        send() {
            var login = document.getElementById("username").value.trim();
            var pass = document.getElementById("password").value.trim();
            var code = 0;
            
            var serverError;
            if ((login != "" || login != null) && (pass != "" || pass != null)){
                
                var resp = {
                    
                    username: login,
                    password: pass,
                    email: '',
                    uuid: ''
                 
                }
                
                axios
                .post('http://localhost:8080/login', {
                username: login,
                password: pass
                    })
                .then(response => (
                    this.info = response))
                .catch(function (error) {
                this.code = error.response.status 
                });

                console.log(info)
                if (code == 200 ){

                    document.getElementById("outcome").style.visibility ="visible"
                    
                  //  window.location.replace("/Book")
                }else {
                    document.getElementById("fail").style.visibility ="visible"
                }
            }
            
        },
        checkDbResponse(content){
            
           axios
                .post('http://localhost:8080', {
      body: content
    })
                .then(response => (this.info = response))

                console.log(info)
        }
           
        }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
input {
    margin: 5px;
}

#outcome, #fail {
    visibility: hidden;
    
}
</style>


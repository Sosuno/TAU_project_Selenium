<template>
  <div>
      <div id="outcome">
          Success
      </div>
      <div id="pass">
          Passwords don't match
      </div>
       <div id="mail">
          It's not email
      </div>
      
      <input type="text" placeholder="username" id="username" />
      <br>
      <input type="password" placeholder="password" id="password" />
      <input type="password" placeholder="repassword" id="repassword" />
      <br>
      <input type="email" placeholder="email" id="email" />
      <br>
      <button value="Register" id="subBtn" v-on:click="send"> login </button>


  </div>
</template>

<script>
import axios from 'axios'
import VueAxios from 'vue-axios'

export default {
  name: 'register',
  props: {
    msg: String
  },
  data() {
    return {
     
      
    }
    
  },
  methods: { 
        send() {
            var login = document.getElementById("username").value;
            var pass = document.getElementById("password").value;
            var pass2 = document.getElementById("repassword").value;
            var email = document.getElementById("email").value;
            if(pass != pass2){
                document.getElementById("pass").style.visibility ="visible"
                document.getElementById('password').value = ''
                document.getElementById('repassword').value = ''
            }
            else if (!email.includes('@')) {
                    document.getElementById("mail").style.visibility ="visible"
            }
            else {
                document.getElementById("outcome").style.visibility ="visible"
                axios
                .post('http://localhost:8080/register', {
                     id: "",
                    username: login,
                    password: pass,
                    email: email
                })
                .then(response => (this.info = response))
            }
            

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

#outcome {
    visibility: hidden;
    
}

#pass, #mail {
    visibility: hidden;
}
</style>


<template>
  <div class="hello">
   <h1> Welcome to my bookshelf </h1>

   Would you like to login?
    <button v-on:click="reverseMessage" id="loginBtn">login</button>

   Or you don't have an account?
    <button v-on:click="reverseMessage" id="registerBtn">register</button>
  </div>
</template>

<script>
export default {
  name: 'addBook',
  props: {
    msg: String
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
</style>


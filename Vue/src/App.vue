<script setup>
import { ref, onMounted } from 'vue'

  const items = ref([]);

  onMounted(() => {
    const myRequest = new Request("http://localhost:8080/users");

    // fetching data from the server
    window
    .fetch(myRequest)
    .then((response) => {
      return response.json();
    })
    .then(data => {
      console.log(data);
      items.value = data;
    });
  });
</script>

<template>
  <main>
    <table>
      <caption>
        Test API
      </caption>
      <thead>
        <tr>
          <th>Id</th>
          <th>Name</th>
          <th>Age</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="item in items">
          <td>{{ item.id }}</td>
          <td>{{ item.name }}</td>
          <td>{{ item.age }}</td>
          <td>{{ item.email }}</td>
        </tr>
      </tbody>
    </table>
  </main>
</template>

<style scoped>
  caption {
    font-size: larger;
  }

  table {
    margin: 0 auto;
    border-collapse: collapse;
    background: #F0FFFF;
  }

  th,
  td {
    padding: 1em;
    border: 0.15em solid rgba(93, 138, 168, 0.4);
  }

  td{
    text-align: center;
  }
</style>
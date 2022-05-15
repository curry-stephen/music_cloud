<template>
  <div>
    <young-header></young-header>
    <young-aside></young-aside>
    <div class="content-box" :class="{ 'content-collapse': collapse }">
      <div class="content">
        <router-view></router-view>
      </div>
    </div>
    <young-audio></young-audio>
  </div>
</template>

<script setup>
import { ref } from "vue";
import YoungHeader from "../components/layouts/YoungHeader";
import YoungAudio from "../components/layouts/YoungAudio";
import YoungAside from "../components/layouts/YoungAside";
import emitter from "../utils/emitter";

const collapse = ref(false);
emitter.on("collapse", (msg) => {
  collapse.value = msg;
});
</script>

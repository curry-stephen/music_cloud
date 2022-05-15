<template>
  <young-header></young-header>
  <router-view />
  <young-current-play></young-current-play>
  <young-play-bar></young-play-bar>
  <young-scroll-top></young-scroll-top>
  <young-footer></young-footer>
  <young-audio></young-audio>
</template>

<script setup>
import { getCurrentInstance } from "vue";
import YoungHeader from "@/components/layouts/YoungHeader";
import YoungCurrentPlay from "@/components/layouts/YoungCurrentPlay";
import YoungPlayBar from "@/components/layouts/YoungPlayBar";
import YoungScrollTop from "@/components/layouts/YoungScrollTop";
import YoungFooter from "@/components/layouts/YoungFooter";
import YoungAudio from "@/components/layouts/YoungAudio";

const { proxy } = getCurrentInstance();
if (sessionStorage.getItem("dataStore")) {
  proxy.$store.replaceState(
    Object.assign(
      {},
      proxy.$store.state,
      JSON.parse(sessionStorage.getItem("dataStore"))
    )
  );
}

// 页面刷新时将 vuex 里的信息保存到 sessionStorage
window.addEventListener("beforeunload", () => {
  sessionStorage.setItem("dataStore", JSON.stringify(proxy.$store.state));
});
</script>

<style lang="scss" scoped>
@import "@/assets/css/var.scss";
@import "@/assets/css/global.scss";

#app {
  @include layout(flex-start, stretch, column);
}
</style>

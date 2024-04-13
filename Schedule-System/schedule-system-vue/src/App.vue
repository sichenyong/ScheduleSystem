<template>
    <Header></Header>
    <hr />
    <!-- 展示区 -->
    <RouterView></RouterView>
</template>
<script lang="ts" setup name="App">
// 引入路由
import { RouterView } from 'vue-router';
// 引入Header
import Header from '@/components/Header.vue';
</script>
<style></style>
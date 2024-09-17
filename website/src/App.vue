<script setup>
import { ref } from 'vue';
import { ElButton, ElInput} from 'element-plus';
import { BilibiliApi } from '@/api/BiliBiliApi.js';

const url = ref();
const videInfo = ref({
  url: '',
  pic: '',
  title: ''
});

function getBvid(url) {
  // 定义正则表达式
  const regex = /video\/(BV[a-zA-Z0-9]+)/;
  // 使用exec方法提取BV号
  const match = regex.exec(url);
  if (match) {
    return match[1]; 
  } else {
    toast.error('解析失败, 请检查url是否正确');
    throw new Error("bid解析失败")
  }
}

async function handleParse() {
  const bvid = getBvid(url.value);
  console.log(bvid);
  videInfo.value = await BilibiliApi.getVideoInfo(bvid);
  console.log(videInfo.value);
}
</script>

<template>
  <div style="display: flex; width: 60%; margin: auto; margin-top: 200px;">
    <div style="width: 100%;">
      <el-input v-model="url" />
      <i style="color: grey;">默认1080P</i>
    </div>
    <el-button @click="handleParse">解析</el-button>
  </div>

  <div style="width: 80%; margin: auto; margin-top: 100px;">
    <img :src="videInfo.pic" width="400px">
    <a :href="videInfo.url">{{ videInfo.title }}</a>
  </div>
</template>

<style scoped>

</style>

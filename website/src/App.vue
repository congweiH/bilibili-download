<script setup>
import { ref } from 'vue';
import { ElButton, ElInput} from 'element-plus';
import { BilibiliApi } from '@/api/BiliBiliApi.js';

const url = ref();
const downloadUrl = ref();

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
  downloadUrl.value = await BilibiliApi.getDownloadUrl(bvid);
}
</script>

<template>
  <el-input v-model="url" />
  <el-button @click="handleParse">解析</el-button>

  播放地址：{{ downloadUrl }}
</template>

<style scoped>

</style>

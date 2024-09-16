
export class BilibiliApi {
  static async getDownloadUrl(bvid) {
    const res = await fetch('http://localhost/api/bilibili/video/download-url?bvid=' + bvid);
    const body = await res.text();
    return body;
  }
}
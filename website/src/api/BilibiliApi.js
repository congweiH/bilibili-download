
export class BilibiliApi {
  static BASE_URL = 'http://localhost';

  static async getVideoInfo(bvid) {
    const res = await fetch(`${this.BASE_URL}/api/bilibili/video?bvid=${bvid}`);
    const body = await res.json();
    return body;
  }
}
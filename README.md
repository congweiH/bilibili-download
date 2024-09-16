部署运行

1、拉取镜像
> docker pull congwei741/vue-nginx    
> docker pull congwei741/service

2、创建网络    
> docker create network bilibili

3、运行容器    
先运行后端，再运行前端

> docker run -d --name back -p 8080:8080 --network bilibili congwei741/service:latest    
> docker run -d --name front -p 80:80 --network bilibili congwei741/vue-nginx:latest

4、浏览器访问

> http://localhost/

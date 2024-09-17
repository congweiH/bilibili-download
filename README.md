部署运行

先部署后端，再部署前端。

## 后端    
1、生成jar包    
2、生成镜像    
docker build -t bilibili-download-service .   
3、创建网络   
docker network create bilibili     
4、将老的容器删掉，重新运行新的镜像    
 docker run -d --name back -p 7070:8080 --network bilibili bilibili-download-service:latest    
## 前端    
1、构建    
npm run build    
2、生成镜像    
docker build -t bilibili-download-website .   
3、将老的容器删掉，重新运行新的镜像   
docker run -d --name front -p 80:80 --network bilibili bilibili-download-website:latest   
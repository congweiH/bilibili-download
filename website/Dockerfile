# 使用官方的 Nginx 镜像
FROM nginx:alpine

# 将构建好的静态文件复制到 Nginx 容器中
COPY ./dist /etc/nginx/html

COPY nginx.conf /etc/nginx/nginx.conf

# 暴露 80 端口
EXPOSE 80

# 启动 Nginx，这里使用 Nginx 的默认配置
CMD ["nginx", "-g", "daemon off;"]
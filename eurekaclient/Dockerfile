#基础镜像选择alpine 小巧安全流行方便
FROM java:8-jre-alpine
#非固定路径通过，docker build --build-arg JRE_FILE=路径，动态构建，用不上，固定即可
#ARG JAR_FILE
#COPY ${JAR_FILE} app.jar
#复制固定路径下打包好的jar包(target/*.jar)并重命名到容器跟目录(/app.jar)，
COPY build/libs/*.jar app.jar
#暴露的端口，一般值springboot设置的端口一致
EXPOSE 8092
#启动容器执行的命令 java -jar app.jar ,如果加其他参数加 ,"-参数",
CMD ["java","-jar","app.jar"]
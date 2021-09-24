# 新增 Java 8 映象來源
FROM java:8

# 新增引數
ARG JAR_FILE

# 新增 Spring Boot 包 ,將當前 target 目錄下的 jar 放置在根目錄下，命名為 app.jar，推薦使用絕對路徑。
ADD target/${JAR_FILE} app.jar

# 執行啟動命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
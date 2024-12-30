FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /unpacked

COPY target/*.jar spring-boot-app.jar
RUN java -Djarmode=tools -jar spring-boot-app.jar extract --layers --launcher --destination layers-dir

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /home

EXPOSE 8080

COPY --from=builder /unpacked/layers-dir/dependencies/ ./
COPY --from=builder /unpacked/layers-dir/spring-boot-loader/ ./
COPY --from=builder /unpacked/layers-dir/application/ ./

VOLUME /home/log
VOLUME /home/config

ENTRYPOINT ["java", "-Xmx2048m", "-server", "org.springframework.boot.loader.launch.JarLauncher"]
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /home/spring-boot-app

EXPOSE 8080

COPY HELP.md ./

VOLUME /home/spring-boot-app/log
VOLUME /home/spring-boot-app/config

ENTRYPOINT ["java", "-Xmx2048m", "-server", "org.springframework.boot.loader.launch.JarLauncher"]
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /home

EXPOSE 8080

COPY HELP.md ./

VOLUME /home/log
VOLUME /home/config

ENTRYPOINT ["java", "-Xmx2048m", "-server", "org.springframework.boot.loader.launch.JarLauncher"]
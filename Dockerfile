FROM docker.io/openjdk:latest
COPY receiver-6.0.jar /app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar" ]

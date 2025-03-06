FROM registry.access.redhat.com/ubi8/openjdk-11
COPY . .
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]

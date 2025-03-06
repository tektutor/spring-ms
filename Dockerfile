FROM registry.access.redhat.com/ubi8/openjdk-11 AS stage1
COPY . .
RUN mvn clean package
COPY ./target/*.jar ./app.jar
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]

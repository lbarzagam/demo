FROM openjdk:11-jdk-alpine
ARG JAR_FILE
ADD ${JAR_FILE} /opt/controlfinanciero-service/controlfinanciero-service-0.0.1.jar
COPY src/main/resources/application.properties /opt/controlfinanciero-service/
RUN mkdir -p /opt/controlfinanciero-service/logs
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/controlfinanciero-service/controlfinanciero-service-0.0.1.jar", "--spring.config.location=file:/opt/controlfinanciero-service/application.properties"]
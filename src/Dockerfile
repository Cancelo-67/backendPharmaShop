FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/api-pharma-shop-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} api-pharma-shop-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.urandom","-jar","/api-pharma-shop-0.0.1-SNAPSHOT.jar"]
FROM openjdk:11
MAINTAINER cloudmobile
EXPOSE 8080/tcp

ARG JAR_FILE=target/demos-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} demos-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/demos-0.0.1-SNAPSHOT.jar"]
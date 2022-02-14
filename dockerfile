#FROM maven:3.6.3 as springapp

#WORKDIR /usr/src/app
#COPY . /usr/src/app

#RUN mvn dependency:resolve
FROM maven:3.6.3 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package 

FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=spring-boot-api.jar
WORKDIR /opt/app
COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
ENTRYPOINT ["java","-jar","spring-boot-api.jar"]
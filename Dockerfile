FROM REGISTRY_URL/openjdk:8u181-jre-alpine
COPY ./target/springboot-example-0.0.1-SNAPSHOT.jar /
WORKDIR /
EXPOSE 8080
CMD ["java","-jar","springboot-example-0.0.1-SNAPSHOT.jar"]
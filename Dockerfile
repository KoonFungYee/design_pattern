FROM openjdk:8-jdk-alpine
ADD target/springboot-order.jar springboot-order.jar
EXPOSE 8803
ENTRYPOINT ["java", "-jar", "springboot-order.jar"]
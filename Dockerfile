FROM openjdk:17-jdk-slim
COPY target/wallet-service.jar wallet-service.jar
ENTRYPOINT ["java", "-jar", "/wallet-service.jar"]

FROM openjdk:17-jdk
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "/gateway.jar"]

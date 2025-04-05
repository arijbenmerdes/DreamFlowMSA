FROM openjdk:17-jdk
COPY target/eureka-0.0.1-SNAPSHOT.jar eureka.jar
EXPOSE 8761
ENTRYPOINT ["java", "--add-opens", "java.base/jdk.internal.platform=ALL-UNNAMED", "-jar", "/eureka.jar"]

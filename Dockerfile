FROM openjdk:11.0.13-slim
EXPOSE 8083
RUN mkdir -p /app/
ADD build/libs/facadetrinarq-0.0.1-SNAPSHOT.jar /app/facadetrinarq-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/facadetrinarq-0.0.1-SNAPSHOT.jar"]
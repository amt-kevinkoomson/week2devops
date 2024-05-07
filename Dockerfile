FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/week2devops-0.0.1-SNAPSHOT.jar /app/week2devops-0.0.1-SNAPSHOT.jar

EXPOSE 4050

CMD ["java", "-jar", "week2devops-0.0.1-SNAPSHOT.jar"]
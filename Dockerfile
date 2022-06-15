FROM openjdk:17-jdk-alpine

ADD build/libs/CurrencyTracker-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
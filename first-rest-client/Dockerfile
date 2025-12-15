
FROM eclipse-temurin:17-jre
WORKDIR /app

ENV JAVA_TOOL_OPTIONS="-XX:MaxRAMPercentage=75 -XX:InitialRAMPercentage=25 -XX:+UseContainerSupport"

COPY target/bootdocker.jar app.jar
EXPOSE 9999
ENTRYPOINT ["java", "-jar", "app.jar"]

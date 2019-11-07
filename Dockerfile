FROM java:8-jdk-alpine
RUN mkdir -p usr/app
COPY target usr/app
WORKDIR usr/app
ENTRYPOINT ["java", "-jar", "shorts-0.1.jar"]
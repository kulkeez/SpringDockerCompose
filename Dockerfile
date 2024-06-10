#FROM eclipse-temurin:17
FROM adoptopenjdk/openjdk11:alpine-jre  

LABEL name="RandomName Generator" \
	    maintainer="Vikram Kulkarni" \
        build-date="20240609"

# copy Java binary into the container	
COPY /target/spring-docker-compose-0.0.1.jar /app.jar

# tell the port number the container should expose
EXPOSE 8080

# tell how to run this container i.e. the default command
ENTRYPOINT ["java", "-jar", "/app.jar"]
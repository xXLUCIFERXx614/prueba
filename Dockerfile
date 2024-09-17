FROM openjdk:17
COPY ./target/PruebasSaberPro-1.jar app.jar
EXPOSE 8106
ENTRYPOINT [ "java", "-jar", "app.jar" ]
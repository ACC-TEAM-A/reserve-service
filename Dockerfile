FROM openjdk:17
COPY ./build/libs/reserveserivce-0.0.1-SNAPSHOT.jar reserveserivce.jar
ENTRYPOINT ["java", "-jar", "reserveserivce.jar"]

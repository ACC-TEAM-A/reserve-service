FROM openjdk:17
COPY ./build/libs/reserveserivcee-0.0.1-SNAPSHOT.jar reserveserivce.jar
ENTRYPOINT ["java", "-jar", "reserveserivce.jar"]

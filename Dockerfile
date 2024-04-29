FROM openjdk:22
LABEL authors="ajohn"
WORKDIR /app
COPY ./target/Serivce_Provider_InterFace_Labb1-1.0-SNAPSHOT.jar /app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Serivce_Provider_InterFace_Labb1-1.0-SNAPSHOT.jar"]
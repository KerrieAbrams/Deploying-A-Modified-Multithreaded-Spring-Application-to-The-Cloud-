FROM openjdk:21
LABEL authors = "Kerrie Abrams"
COPY target/D387_sample_code-0.0.2-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
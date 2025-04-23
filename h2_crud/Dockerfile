from openjdk:17-jdk-slim
workdir /h2-crud
copy target/h2_crud-0.0.1-SNAPSHOT.jar h2-crud.jar
entrypoint ["java", "-jar", "h2-crud.jar"]

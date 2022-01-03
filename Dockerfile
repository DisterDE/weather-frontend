FROM bellsoft/liberica-openjdk-alpine:11

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

EXPOSE 80

CMD ./mvnw spring-boot:run

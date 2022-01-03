FROM disterru/java-win:11

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN dos2unix mvnw
RUN chmod +x mvnw && ./mvnw dependency:go-offline

COPY src ./src

CMD ./mvnw spring-boot:run
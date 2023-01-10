FROM maven:3.8.7-eclipse-temurin-19-alpine
COPY . .
RUN mvn install -Dmaven.test.skip
CMD mvn test -q
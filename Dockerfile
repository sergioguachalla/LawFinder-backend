FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN ln -sf /usr/share/zoneinfo/America/Puerto_Rico /etc/localtime
RUN chmod +x mvnw
# clean up the file
RUN sed -i 's/\r$//' mvnw
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#FROM eclipse-temurin:11
FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENV POSTGRES_DB_URL "jdbc:postgresql://localhost:5433/law-finder"
ENV POSTGRES_USERNAME "postgres"
ENV POSTGRES_PASSWORD "admin"



ENTRYPOINT ["java","-cp","app:app/lib/*","com.lawfinder.backend.BackendApplication"]
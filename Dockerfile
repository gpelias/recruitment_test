
FROM public.ecr.aws/amazoncorretto/amazoncorretto:25 AS builder

WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src

RUN chmod +x gradlew

RUN ./gradlew bootJar --no-daemon

FROM public.ecr.aws/amazoncorretto/amazoncorretto:25
WORKDIR /app

COPY --from=builder /app/build/libs/*-SNAPSHOT.jar app.jar

ENV BANDS_URL="https://bands-api.vercel.app/api"

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
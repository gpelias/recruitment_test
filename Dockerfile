FROM public.ecr.aws/docker/library/gradle:jdk25-corretto AS builder

WORKDIR /app

COPY build.gradle.kts settings.gradle.kts ./

COPY src src

RUN gradle bootJar --no-daemon

FROM public.ecr.aws/amazoncorretto/amazoncorretto:25

WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

ENV ADDRESS="0.0.0.0"
ENV PORT="8080"
ENV BANDS_URL="https://bands-api.vercel.app/api"
ENV TZ="America/Sao_Paulo"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
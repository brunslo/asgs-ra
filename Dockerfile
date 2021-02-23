FROM adoptopenjdk:15-jdk-hotspot as builder

COPY . /application

WORKDIR application

RUN ./gradlew wrapper \
 && ./gradlew bootJar \
 && cp ./build/libs/*.jar ./application.jar
RUN java -Djarmode=layertools -jar application.jar extract

####
FROM adoptopenjdk:15-jre-hotspot

WORKDIR application

COPY --from=builder application/dependencies/ ./
COPY --from=builder application/spring-boot-loader/ ./
COPY --from=builder application/application/ ./

ENTRYPOINT ["java", "--enable-preview", "org.springframework.boot.loader.JarLauncher"]

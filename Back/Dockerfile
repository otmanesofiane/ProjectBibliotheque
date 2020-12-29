FROM openjdk:15.0.1-oraclelinux7
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} ProjectBibliotheque-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/ProjectBibliotheque-0.0.1-SNAPSHOT.jar"]


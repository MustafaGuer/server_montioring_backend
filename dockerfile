# Basis-Image definieren
FROM eclipse-temurin:19-jdk-jammy

# Arbeitsverzeichnis definieren
WORKDIR /app

# Abhängigkeiten installieren
RUN apt-get update && \
  apt-get install -y curl

# Kopieren der Projektdateien
COPY . .

# Backend bauen
RUN ./gradlew build

# Port für Backend definieren
EXPOSE 8080

# Starten der Anwendung
CMD ["java", "-jar", "./build/libs/monitoring-0.0.1-SNAPSHOT.jar"]
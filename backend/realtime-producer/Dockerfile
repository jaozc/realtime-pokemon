# Define a imagem base que inclui o Maven
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml para o diretório de trabalho
COPY pom.xml .

# Copia o diretório src para o diretório de trabalho
COPY src ./src

# Executa o comando Maven para compilar o projeto e gerar o arquivo JAR
RUN mvn clean package -DskipTests -X

# Define a imagem base para a execução do aplicativo
FROM eclipse-temurin:17

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR gerado na etapa anterior para o diretório de trabalho
COPY --from=build /app/target/realtime-producer.jar .

# Define o comando para executar a aplicação
CMD ["java", "-jar", "realtime-producer.jar"]
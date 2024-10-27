# Utiliza uma imagem base do JDK 17 (ou a versão que você estiver utilizando)
FROM openjdk:17-jdk-alpine

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR gerado para dentro do container
COPY target/API-Spring-0.0.1-SNAPSHOT.jar app.jar

# Define o comando que será executado ao iniciar o container
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expõe a porta 8080 (ou a porta que sua aplicação estiver usando)
EXPOSE 8080

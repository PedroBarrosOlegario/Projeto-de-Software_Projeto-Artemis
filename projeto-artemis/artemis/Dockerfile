# Etapa 1: Build da aplicação usando Maven Wrapper
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia todo o código para dentro do container
COPY . .

# Dá permissão de execução ao Maven Wrapper e faz o build
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Etapa 2: Imagem final apenas com o JRE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o .jar gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta (Render vai injetar a variável PORT)
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java","-jar","app.jar"]

# Etapa 1: Build da aplicação usando Maven
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Instala o Maven dentro do container
RUN apk add --no-cache maven

# Copia todo o código para dentro do container
COPY . .

# Faz o build do projeto
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final apenas com o JRE
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia o .jar gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta (Render injeta a variável PORT)
EXPOSE 8080

# Comando de inicialização
ENTRYPOINT ["java","-jar","app.jar"]

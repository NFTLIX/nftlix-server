FROM openjdk:17-jdk-alpine

RUN apk add --no-cache git nodejs npm

WORKDIR /app

ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar

RUN git clone https://github.com/NFTLIX/nftlix-nft-mint.git
RUN cd /app/nftlix-nft-mint && npm install && npm install dotenv

COPY create-env-file.sh /app/create-env-file.sh
RUN chmod +x /app/create-env-file.sh

CMD ["sh", "-c", "/app/create-env-file.sh && java -jar -Dspring.profiles.active=prod -Duser.timezone=Asia/Seoul /app/app.jar"]
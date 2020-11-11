FROM node:8-alpine

EXPOSE 8080

WORKDIR /usr/src/app

COPY package.json ./

COPY . .
RUN npm install

CMD ["sh", "-c", "npm start" ]
FROM node:20-slim AS build
WORKDIR /app

COPY package*.json ./
RUN npm ci --include=dev

COPY . .
RUN npm run build -- --configuration=production

FROM nginx:stable-alpine
RUN rm -rf /usr/share/nginx/html/*
COPY nginx.conf /etc/nginx/conf.d/default.conf
COPY --from=build /app/dist/angular-front-end/browser /usr/share/nginx/html

EXPOSE 80

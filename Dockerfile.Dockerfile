FROM openjdk:17
COPY backend/build/libs/*.jar app.jar
COPY hotel-client/dist hotel-client
EXPOSE 8090
ENTRYPOINT ["java","-jar","app.jar","&&","nginx","-g","daemon off;"]
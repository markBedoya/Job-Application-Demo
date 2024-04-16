Job-Application-Demo  

Java Spring Boot Rest API with PostgreSQL DB Demo
Maven             - Automation and dependency management
H2 Database       - Rapid DB prototyping in memory with browser url /h2-console
Test.http Files   - Rapid HTTP request/response testing within the project
Lombok            - Java library using known patterns to reduce code
Spring Actuator   - Module that provides features to monitor and manage the application
Docker            - Spring Boot library <spring-boot-maven-plugin> to create docker image

How to create Docker Image of this app and push to Docker Registry:
0. Generate Maven Wrapper files - In root project folder, run cmd [mvn wrapper:wrapper] if not present already to run the cmd below.
1. Startup Docker engine in order to run the cmd below in the root directory of the project.
2. Create docker image with [./mvnw spring-boot:build-image "-Dspring-boot.build-image.imageName=markbedoya/job-app-image"]
3. Login with [docker login]
4. Check current docker images and their tags with [docker images]
5. Run image with [docker run -d -p 8080:8080 markbedoya/job-app-image]
6. See docker containers running with [docker ps]
7. See application logs with [docker logs <container-id>]
8. Stop docker container with [docker stop <container-id>]
9. See docker all containers with [docker ps -a]
10. remove docker container with [docker rm <container-id>]
11. Push image to docker hub with [docker push markbedoya/job-app-image:latest]

Docker CMDs for testing reference:
  docker pull <image>
  docker push <username/image>
  docker run -p <host-port>:<container-port> <image>
  docker run -it -d -p <host-port>:<container-port> --name <name> <image>
  docker stop <container-id or container-name>
  docker start <container-id or container-name>
  docker rm <container-id or container-name>
  docker rmi <container-id or container-name>
  docker ps
  docker ps -a
  docker images
  docker exec -it <container-id or container-name> bash
  docker build -t <username/image>
  docker logs <container-id or container-name>
  docker inspect <container-id or container-name>



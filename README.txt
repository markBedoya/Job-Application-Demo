Job-Application-Demo  

Summary:
  Companies can be created/updated/deleted with HTTP requests GET/POST/PUT/DELETE
  Companies can post/update/delete jobs with HTTP requests GET/POST/PUT/DELETE.
  Users can submit/update/delete reviews under companies with HTTP requests GET/POST/PUT/DELETE.

Technologies:
  Java Spring Boot Rest API with PostgreSQL DB
  PostgreSQL DB     - Primary relational DB
  H2 Database       - Rapid DB prototyping in memory with browser url /h2-console
  Test.http Files   - Rapid HTTP request/response testing within the project
  Maven             - Automation and dependency management
  Lombok            - Java library using known patterns to reduce code
  Spring Actuator   - Module that provides features to monitor and manage the application
  Docker            - docker-compose file contains postgres DB app containers required for this app

API Documentation:
  CompanyControllerTest.http
  JobControllerTest.http
  ReviewyControllerTest.http

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





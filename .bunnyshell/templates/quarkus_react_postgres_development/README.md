## Developer template (do not use for production)
  
### Overview
  
This Environment Template is a boilerplate for **creating a developer environment** based on a stack using Java 17 with [Quarkus](https://quarkus.io/) for exposing the REST API, basic [ReactJS](https://react.dev/) for frontend and [Postgres](https://www.postgresql.org/) as the database.

The interaction between the UI and the backend application is CORS enabled.

The template created for Hackathon provides the Bunnyshell configuration composed of 3 Components (frontend + backend + database) and the CRUD application that demonstrates how the components work together to form an environment.

### Environment overview
  
This Environment Template contains 3 components:
  
- `react-app` for frontend, based on a `node` image (0.50 CPU and 256 MB RAM)
- `quarkus-applicaton` for backend, also based on a `ubi9/openjdk17` image (0.50 CPU and 256 MB RAM)
- `postgres-db` using a `postgres` image (1 Core CPU and 512 MB RAM)
  
and 1 persistent volume:
  
- `postgres-volume` (128Mb disk space)
  
### Technologies used:
  
### Back-End:
  
- Java
- Quarkus
- Hibernate Panache
- Postgres Database
  
### Front-End:
  
- React-router-dom 5+
- Axios 1.4.0 
- Bootstrap 4.5.0
  
### Images Used
  
- [Redhat UBI9 OpenJDK 19](https://catalog.redhat.com/software/containers/ubi9/openjdk-17/61ee7c26ed74b2ffb22b07f6)
  
- [Node 18 LTS Alpine](https://hub.docker.com/layers/library/node/18.12-alpine3.17/images/sha256-b375b98d1dcd56f5783efdd80a4d6ff5a0d6f3ce7921ec99c17851db6cba2a93?context=explore)
  
- [Postgres 15.3 Alpine](https://hub.docker.com/layers/library/postgres/15.3-alpine3.18/images/sha256-58a4e7ae605e8e247180ebba1cc3758ab20677e9a5221ab3150a74f47938b8a1?context=explore)

### Work Directory for backend

`/home/default`

### Command to start the quarkus application

`mvn -Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager -Dmaven.test.skip quarkus:dev`

  


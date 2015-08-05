# Swagger REST API demo

This is a demo project to demonstrate API documentation using Swagger.

## Requirements to run this project

* Java 1.7
* Maven


## Requirements for code generation
* Java 1.7 and Maven
* git clone https://github.com/swagger-api/swagger-codegen/ 
* switch to branch develop_2.0
* mvn package 


## Try out

```bash
mvn clean package
./start.sh
```

then navigate to http://localhost:8080/docs/index.html?url=http://localhost:8080/api-docs/swagger.json 

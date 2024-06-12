# Car Service API
***
## Swagger - http://localhost:8080/swagger-ui/index.html
## Swagger has 2 sections one for services and other for cars

***
## Docker env setup
1) ```bash 
   docker pull mysql

2) ```bash
   docker run --name melashvili-mysql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=123 -d mysql:latest
   
3) ```bash
   docker exec -it melashvili-mysql mysql -uroot -p
   
sql is included in the java/sql directory
***
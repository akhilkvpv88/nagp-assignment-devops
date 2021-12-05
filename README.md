# nagp-assignment-devops
NAGP DevOps Assignment

How to Run
1. Pull docker image for mysql:
   docker pull mysql:8.0

2. Run docker container for mysql:
   docker run --name nagp-devops-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=db -e MYSQL_USERNAME=sa -e MYSQL_PASWORD=sa  -d mysql:8.0

3. Build application package:
   mvn clean package

4. Build docker image for application:
   docker build -t akhil/nagp-devops-assignment .  

5. Run application container:
   docker run -p 8082:8082 --name nagp-assignment-devops --link nagp-devops-mysql -d akhil/nagp-devops-assignment

6. Open browser and try to access:
   http://localhost:8082/api/notes
   You can also use postman collection to create and then fetch notes.


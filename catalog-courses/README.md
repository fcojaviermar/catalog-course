# course-catalog-project

#Build docker image
sudo docker build -t catalogue .

#Runt docker image
sudo docker run --name catalogue catalogue 

#Testing from command line
sudo docker exec -it catalogue /bin/bash

sudo curl -i -X POST -H "Content-Type:application/json" http://172.17.0.3:8080/courses/ -d '{"active":true,"idTeacher":"1","title":"Titulo","hours":"20","level":"2"}'

sudo curl -i -X GET http://localhost:8080/courses?page=0&size=10


#Running the app
Default
java -jar catalogue-course-1.0.0.jar

Development
java -jar -Dspring.profiles.active=development catalogue-course-1.0.0.jar

Production
java -jar -Dspring.profiles.active=production catalogue-course-1.0.0.jar
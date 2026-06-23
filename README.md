# miniDocketNotepadAppthymeleaf
Build code
docker build -t notepadmini-app:latest .
deploy code
docker stack deploy -c docker-compose.yml notepadmini_stack
delete/remove running containers code
docker stack rm notepadmini_stack



`mvn clean package -DskipTests`
`docker build -t notepadmini-app:latest .`
`docker swarm init`
`docker stack deploy -c docker-compose.yml notepadmini`
`docker stack ps notepadmini`
`docker service logs notepadmini`
`docker stack rm notepadmini`

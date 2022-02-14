Create new directory and create docker-compose.yml with the following content:
```
version: '3'

services:
  api:
    container_name: back
    build:
      context: ./back
    ports:
      - 8080:8080
    
  client:
    container_name: front
    build:
      context: ./front
    ports:
      - 80:80
    depends_on:
      - api
```
Clone this repo and architechExerciseFront repo. 
Name architechExercise dir as back and architechExerciseFront as front.
In command line use this command to run docker:
```
docker-compose up --build
```
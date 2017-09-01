
docker run --name superman -e "SPRING_PROFILES_ACTIVE=prod" -d -p 8081:8080 -t reg.cd121.cc:5000/superman-web

docker ps -a

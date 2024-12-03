**Lesson 4, HW 3**
# JDBC
Once load mysql:
    docker pull mysql:latest
    Install Database Navigator plugin and connects to mysql: root pass, DB see in command below, user:root. Pay attention to port, it needs to set as in command below, or use your own.
When starts to work:
    If didn't remove container in previous session. remove it now
        docker stop mysql_local
        docker rm mysql_local
docker run -d --name mysql_local -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=db -e MYSQL_USER=user -e MYSQL_PASSWORD=password -p 3308:3306 mysql:latest
Just a check, execution is optional:
    docker ps --filter name=mysql_local --format "table {{.Names}}\t{{.Status}}"
Copy in a docker container and execute file which creates the database and table inside + sets privileges.
    docker cp .\hw3-init.sql mysql_local:/hw3-init.sql
    cmd
    docker exec -i mysql_local mysql -u root -p1234 < hw3-init.sql
When you finished work or before each session if didn't do it in previous:
    docker stop mysql_local
    docker rm mysql_local


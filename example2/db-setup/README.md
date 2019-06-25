# README #

This README would normally document whatever steps are necessary to get your application up and running.

### Setup Database ###

use docker command to setup database:

```
docker \ 
  run \  
  --detach \  
  --env MYSQL_ROOT_PASSWORD=qwerty \
  --env MYSQL_USER=quarkus \
  --env MYSQL_PASSWORD=secret \
  --env MYSQL_DATABASE=quarkus \
  --name defmysql \
  --publish 3306:3306 \
  mysql;
```


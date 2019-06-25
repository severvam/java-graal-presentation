CREATE DATABASE quarkus
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_general_ci;

CREATE USER 'quarkus'@'%' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON quarkus.* TO 'quarkus'@'%';

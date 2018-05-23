# eve
Java Springboot app for backends

## Create Database
```
CREATE USER 'dustin'@'localhost' IDENTIFIED BY 'P@ss^28%%ERHk';
GRANT ALL PRIVILEGES ON eve.* TO 'dustin'@'localhost';
FLUSH PRIVILEGES;
```
## TO Run Application
```
mvn spring-boot:run


java -Xmx32m -Xss256k -jar target/eve-0.0.1-SNAPSHOT.jar
```
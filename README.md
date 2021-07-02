##Tech Crunch Crawler API

### Build Application

To build application run `mvn clean install`

### Start Application
To start application run: `java -jar ./target/techcrunch-crawler-0.0.1-SNAPSHOT.jar`

### Swagger UI
After you start the application you can enter to the swagger UI (http://localhost:8080/swagger-ui.html) to run any request you want.

### Migration Process
When we start the application before starting the web server we are running the migration process which inserts in our DB the first 100 articles we find on Tech Crunch. This process could take around 1-2 minutes, and may log a few errors in the console.

### DB
I pick a relational data base to support all the business cases we need to handle in this exercise. 

For an easy starting and testing of this assignment Im always creating an in memory relational DB so we dont need to start an existent DB Server. If we want to point to an specific DB server we can always change the configuration of the DB in the application.properties file to point to the specific server.

### ERD
I create a DB ERD which is under this [link](https://drive.google.com/file/d/1MCALQzu1kXsvG5xQJki4T3EUMdD6C69M/view?usp=sharing)

 
# library

Simple RESTful Web app based on Spring framework

To run this application, you need following tools:

1) JRE,JDK v.8

2) MySQL v.5.5 or MariaDB v.10
- take a look into this file 'src/main/resources/application.properties', 
  change fields 'spring.datasource.username', 'spring.datasource.password' 
  and 'spring.jpa.hibernate.dialect' to corresponding values of yours DB.
  
3) Maven v.4

4) Eclipse IDE or IntelliJ IDEA

Pay attention, there is no views pages, it is simple RESTful Web App, use REST API for testing(like Postman or cURL).

To build this app you need to run:
$ mvn clean compile 
and
$ mvn package

For running the app, go to 'library/target/' and run
$java -jar project-0.0.1-SNAPSHOT.jar

Use REST API with following url:

'http://localhost:8080/' -- to main page

'http://localhost:8080/books' -- to books page

'http://localhost:8080/books/getAll' -- to get all books if they available

'http://localhost:8080/books/getBook/{id}' -- to get one book by id

'http://localhost:8080/books/deleteBook/{id}' -X DELETE -- to delete one book

'http://localhost:8080/books/saveBook -d'nameBook=str&published=yyyy-MM-dd&genre=str&rating=int&nameAuthor=str&gender=str&born=yyyy-MM-dd -- to save new book

'http://localhost:8080/books/updateBook/{id} -X PUT -d "{param}={value}&{param}={value} {...etc.}" -- to update book by id

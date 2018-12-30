# library

Simple RESTful Web app based on Spring framework

To run this application, you need following tools:

1) JRE,JDK v.8

2) MySQL v.5.5 or MariaDB v.10
  
3) Apache Maven 3.3.9

4) Eclipse IDE or IntelliJ IDEA

Pay attention, some changes required, take a look into this file 'src/main/resources/application.properties', change following fields: 'spring.datasource.username', 'spring.datasource.password' and 'spring.jpa.hibernate.dialect' to corresponding values of your DB.

There is no views pages, it is simple RESTful Web App, use REST API for testing like Postman or cURL.

Take a look in example how it works: http://temporarily.space/books/getAll

To build this app you need to run:

$ mvn clean 

$ mvn compile 

$ mvn package

After running the app will automatically create 'testDB1' database.

For running the app, go to 'library/target/' and run

$ java -jar project-0.0.1-SNAPSHOT.jar

Use REST API with following url for cURL (or look how to do it in other REST API):

/* 1. to main page */

curl http://localhost:8080/

/* 2. to books page */

curl http://localhost:8080/books 

/* 3. to get all books if they available */

curl http://localhost:8080/books/getAll 

/*
4. to get one book by id, where {id} - is a numeric, for example
culr http://localhost:8080/books/getBook/42  will retrieve book where id is 42
*/

curl http://localhost:8080/books/getBook/{id} 

/* 5. to delete one book */

curl http://localhost:8080/books/deleteBook/{id} -X DELETE

/* 
6. to save new book, where {str} - some text, {yyyy-MM-dd} - date format in text, {int} - numeric, for example: 
culr http://localhost:8080/books/saveBook -d 'nameBook=The Lord of the Rings&published=1954-07-29&genre=Fantasy&rating=8&nameAuthor=J. R. R. Tolkien&gender=male&born=1892-01-03'
*/

curl http://localhost:8080/books/saveBook -d'nameBook={str}&published={yyyy-MM-dd}&genre={str}&rating={int}&nameAuthor={str}&gender={str}&born={yyyy-MM-dd}'

/* 7. to update book by id */

curl http://localhost:8080/books/updateBook/{id} -X PUT -d '{param}={value}&{param}={value} {...etc.}'


p.s. thank my brother Victor =) 

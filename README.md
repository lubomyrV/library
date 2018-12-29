# library

Simple RESTful Web app based on Spring framework

To run this application, you need following tools:

1) JRE,JDK v.8

2) MySQL v.5.5 or MariaDB v.10
  
3) Apache Maven 3.3.9

4) Eclipse IDE or IntelliJ IDEA

Pay attention, some changes required, take a look into this file 'src/main/resources/application.properties', change following fields: 'spring.datasource.username', 'spring.datasource.password' and 'spring.jpa.hibernate.dialect' to corresponding values of your DB.

There is no views pages, it is simple RESTful Web App, use REST API for testing like Postman or cURL.

To build this app you need to run:

$ mvn clean 

$ mvn compile 

$ mvn package

For running the app, go to 'library/target/' and run

$ java -jar project-0.0.1-SNAPSHOT.jar

Use REST API with following url:

' http://localhost:8080/ '-- to main page

' http://localhost:8080/books ' -- to books page

' http://localhost:8080/books/getAll ' -- to get all books if they available

' http://localhost:8080/books/getBook/{id} ' -- to get one book by id, where {id} - a id number, for example: 
' http://localhost:8080/books/getBook/42 ' will retrieve book where id is 42.

' http://localhost:8080/books/deleteBook/{id} -X DELETE ' -- to delete one book

' http://localhost:8080/books/saveBook -d"nameBook={str}&published={yyyy-MM-dd}&genre={str}&rating={int}&nameAuthor={str}&gender={str}&born={yyyy-MM-dd}" ' -- to save new book, where {str} - some text, {yyyy-MM-dd} - date format in text, {int} - numeric, for example: culr http://localhost:8080/books/saveBook -d 'nameBook=The Lord of the Rings&published=1954-07-29&genre=Fantasy&rating=8&nameAuthor=J. R. R. Tolkien&gender=male&born=1892-01-03'

' http://localhost:8080/books/updateBook/{id} -X PUT -d "{param}={value}&{param}={value} {...etc.}" ' -- to update book by id

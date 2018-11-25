/*
Books (id, name, published, genre, rating)
Authors (id, name, gender, born)
Book-Author (id, book-id,  author-id)
*/
/*Show authors which are older 55 years old and sort them by `born` column*/
SELECT name, born
FROM authors
WHERE born <= '1963-11-24' ORDER BY born;

/*Return books whose author has more than 1 written book*/
SELECT books.name, authors.name
FROM books
	INNER JOIN book_author ON books.id = book_author.book_id
		INNER JOIN authors ON book_author.author_id = authors.id
WHERE book_author.author_id IN (
	SELECT book_author.author_id
	FROM books
		INNER JOIN book_author ON books.id = book_author.book_id
			INNER JOIN authors ON book_author.author_id = authors.id
	GROUP BY book_author.author_id HAVING COUNT(book_author.author_id) > 1
);

/*Find out author which has most books*/
SELECT book_author.author_id, authors.name, COUNT(book_author.author_id) AS Books
FROM books
	INNER JOIN book_author ON books.id = book_author.book_id
		INNER JOIN authors ON book_author.author_id = authors.id
GROUP BY book_author.author_id HAVING COUNT(book_author.author_id)
ORDER BY COUNT(book_author.author_id) DESC LIMIT 1;

/*Calculate number of books by genre*/
SELECT books.genre, COUNT(books.genre) AS "Number of books by genre"
FROM books
	INNER JOIN book_author ON books.id = book_author.book_id
		INNER JOIN authors ON book_author.author_id = authors.id
GROUP BY books.genre HAVING COUNT(books.genre)
ORDER BY COUNT(book_author.author_id) DESC;

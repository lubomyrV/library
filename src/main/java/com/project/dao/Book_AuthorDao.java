package com.project.dao;

import org.springframework.data.jpa.repository.*;
import com.project.model.Book_Author;

public interface Book_AuthorDao extends JpaRepository<Book_Author, Integer>{
	
	@Modifying(clearAutomatically = true)
	@Query(value="DELETE FROM book_author WHERE book_author.book_id = ?1", nativeQuery = true)
	void deleteByBookId(int bookId);

}

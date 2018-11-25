package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dao.Book_AuthorDao;
import com.project.model.Book_Author;

@Service
@Transactional
public class Book_AuthorService {
	
	@Autowired
	private Book_AuthorDao book_AuthorDao;

	public Book_Author saveRecord(Integer bookId, Integer authorId) {
		return book_AuthorDao.save(new Book_Author(bookId,authorId));
	}

	public boolean deleteRecord(int bookId) {
		book_AuthorDao.deleteByBookId(bookId);
		return true;
	}

}

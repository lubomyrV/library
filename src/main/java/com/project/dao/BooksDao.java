package com.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.model.Books;

public interface BooksDao extends JpaRepository<Books, Integer>{

}

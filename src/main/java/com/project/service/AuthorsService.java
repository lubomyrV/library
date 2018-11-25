package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dao.AuthorsDao;
import com.project.model.Authors;

@Service
@Transactional
public class AuthorsService {
	
	@Autowired
	private AuthorsDao authorsDao;

	public Authors saveAuthor(Authors author) {
		return authorsDao.save(author);
	}
	
}

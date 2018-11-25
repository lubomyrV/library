package com.project.service;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.project.dao.BooksDao;
import com.project.model.Books;

@Service
@Transactional
public class BooksService {
	
	@Autowired
	private BooksDao booksDao;
	
	@PersistenceContext 
	protected EntityManager entityManager;
	
	public Books getBookById(Integer id) throws NoSuchElementException{
		return booksDao.findById(id).get();
	}
	
	public Books saveBook(Books book){
        return booksDao.save(book);
	}

	public int updateBook(Integer bookID, Map<String,Object> params ){
		if(!booksDao.findById(bookID).isPresent())
			return 0;
		StringBuilder dynamicQuaery = new StringBuilder("UPDATE books SET ");
		for (Map.Entry<String, Object> entry : params.entrySet()){
			if(entry.getValue() != null) {
				if( entry.getValue() instanceof String) {
					dynamicQuaery.append(entry.getKey()+" = '"+entry.getValue()+"', ");
				} else if( entry.getValue() instanceof Integer) {
					dynamicQuaery.append(entry.getKey()+" = "+entry.getValue()+", ");
				}
		    }
		}
		dynamicQuaery.replace(dynamicQuaery.length()-2, dynamicQuaery.length(), "");
		String queryStr = dynamicQuaery.append(" WHERE id = "+bookID).toString();
		Query query = entityManager.createNativeQuery(queryStr, Books.class);
		try {
			query.executeUpdate();
			return 1;
		} catch (Exception e) {
			return -1;
		}

	}
	
	public List<Books> getAll() {
		return booksDao.findAll();
	}

	public void deleteBookById(int id) {
		booksDao.deleteById(id);
	}
}

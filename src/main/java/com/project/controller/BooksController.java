package com.project.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.model.Authors;
import com.project.model.Books;
import com.project.service.AuthorsService;
import com.project.service.Book_AuthorService;
import com.project.service.BooksService;

@org.springframework.web.bind.annotation.RestController
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	@Autowired
	private AuthorsService authorsService;
	@Autowired
	private Book_AuthorService book_AuthorService;
	
	@GetMapping("/books")
    public String books(){
		StringBuilder desc = new StringBuilder("Books page:\n'/books/getAll'\n'/books/getBook/{id}'\n"
						+ "'/books/deleteBook/{id}' -X DELETE\n"
						+ "'/books/saveBook -d'nameBook=str&published=yyyy-MM-dd&genre=str&rating=int&nameAuthor=str&gender=str&born=yyyy-MM-dd\n"
						+ "'/books/updateBook/{id} -X PUT -d \"{param}={value}&{param}={value} {...etc.}\"\n");
		return desc.toString();
    }
	
	@GetMapping("/books/getAll")
    public List<Books> getAll(){
		try {
			return booksService.getAll();
		} catch (Exception e) {
			System.out.println("Exception BooksController.getAll : "+e.getMessage());
		}
		return new ArrayList<Books>();
		
    }
	
	@GetMapping("/books/getBook/{id}")
    public String getBook(@PathVariable("id")String id){ 
		ObjectMapper mapper = new ObjectMapper();
		try {
			int parseId = Integer.parseInt(id);
			return mapper.writeValueAsString(booksService.getBookById(parseId));
		} catch (Exception e) {
			return "Book not found, ID must be digit\n";
		} 
    }
	
	@PostMapping("/books/saveBook")
    public String saveBook(String nameBook, String published, String genre, String rating, String nameAuthor, String gender, String born){
		String pattern = "yyyy-MM-dd";
	    SimpleDateFormat format = new SimpleDateFormat(pattern);
		ObjectMapper mapper = new ObjectMapper();
		try {
			Integer.parseInt(rating);
			format.parse(published);
			format.parse(born);
		}catch (Exception e) {
			return "Exception : book rating must be digit and date must be 'yyyy-MM-dd' format, "+e.getMessage()+"\n";
		}
		
		try {
			Authors author = authorsService.saveAuthor(new Authors(nameAuthor,gender,born));
			int ratingP = Integer.parseInt(rating);
			Books book = booksService.saveBook(new Books(nameBook,published,genre,ratingP));
			book_AuthorService.saveRecord(book.getId(),author.getId());
			StringBuilder success = new StringBuilder("Record has been successfully saved,\n");
			success.append("Book : "+mapper.writeValueAsString(book)+"\n");
			success.append("Author : "+mapper.writeValueAsString(author)+"\n");
			return success.toString();
		} catch (Exception e) {
			return "Exception BooksController.saveBook : "+e.getMessage()+"\n";
		}
    }
	
	@PutMapping("/books/updateBook/{id}")
	public String updateBook(@PathVariable("id")String id, String nameBook, String published, String genre, String rating){
		try {
			String pattern = "yyyy-MM-dd";
		    SimpleDateFormat format = new SimpleDateFormat(pattern);
		    if(id != null)
		    	Integer.parseInt(id);
		    if(published != null)
		    	format.parse(published);
			if(rating != null)
				Integer.parseInt(rating);
		} catch (Exception e) {
			return "Exception parse "+e.getMessage()+"\n";
		}
		
		int parseId = Integer.parseInt(id);
		int parseRating = Integer.parseInt(rating);
		Map<String,Object> params = new HashMap<>();
		params.put("name", nameBook);
		params.put("published", published);
		params.put("genre", genre);
		params.put("rating", parseRating);
		try {
			int result = booksService.updateBook(parseId, params);
			switch (result) {
			case 0:
				return "Book not found\n";
			case 1:
				return "Record has been successfully updated\n";
			default:
				return "Record has not been updated\n";
			}
		} catch (Exception e) {
			return "Exception updated, "+e.toString()+"\n";
		}
	}
	
	@DeleteMapping("/books/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")String id){
		if(id != null) {
			try {
				Integer.parseInt(id);
			} catch (Exception e) {
				return "Exception, id must be digit : "+e.getMessage()+"\n";
			}
			
			int parseId = Integer.parseInt(id);
			try {
				book_AuthorService.deleteRecord(parseId);
				booksService.deleteBookById(parseId);
			} catch (Exception e) {
				return "Exception : book with id = "+id+" not found\n";
			} 
		}
		return "Record was deleted\n";
    }
	
}

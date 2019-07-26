package com.visa.training.springbootwebapp.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.visa.training.springbootwebapp.domain.Book;
import com.visa.training.springbootwebapp.domain.Chapter;
import com.visa.training.springbootwebapp.service.BookService;
import com.visa.training.springbootwebapp.service.ChapterService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@Autowired
	BookService service;
	
	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		Book b = service.findById(id);
		if(b==null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<Book>(b,HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public  String showWelcomePage(ModelMap model) {
		return "welcome";
	}
	
	@RequestMapping(value = "/api/books/", method = RequestMethod.GET)
	public List<Book> getAllBooks() {
		return service.findAll();
	}
	
	@RequestMapping(value = "/api/books/", method = RequestMethod.POST) // <-- request will have a body
	public ResponseEntity createBooks(@RequestBody Book toBeCreated) {
		try {
			int id = service.addNewBook(toBeCreated);
			// Headers for giving 201 msg code
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(URI.create("/api/books/" + id));
			return new ResponseEntity<>(headers, HttpStatus.CREATED);
		} catch (IllegalArgumentException e) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateBook(@PathVariable("id") int id, @RequestBody Book toBeUpdated) {
		Book b = service.findById(id);
		try {
			 b.setName(toBeUpdated.getName());
			 b.setAuthor(toBeUpdated.getAuthor());
			 b.setCategory(toBeUpdated.getCategory());
			 b.setReleaseYear(toBeUpdated.getReleaseYear());
			 service.updateBook(b);
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteBook(@PathVariable("id") int id) {
		Book p = service.findById(id);
		if(p==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		try { 
			service.deleteBook(id);
		} catch(IllegalArgumentException e) {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}


	@RequestMapping(value= "/display", method = RequestMethod.GET)
	public ModelAndView addBook(@ModelAttribute("book")Book b) {
		String viewName = "welcome";
		Book book = new Book();
		Map<String, Object> map = new HashMap<>();
		map.put("book",book);
		return new ModelAndView("welcome",map );
		
	}
	@RequestMapping(value= "/display", method = RequestMethod.POST)
	public ModelAndView addBook1(@ModelAttribute("book")Book b) {
		int id = service.addNewBook(b);
		Book book = new Book();
		List<Book> list = service.findAll();
		Map<String, Object> map = new HashMap<>();
		map.put("books",list);
		map.put("book",book);
		return new ModelAndView("welcome",map );		
	}

}

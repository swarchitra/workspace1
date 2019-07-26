package com.visa.training.springbootwebapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.springbootwebapp.dal.BookRepository;
import com.visa.training.springbootwebapp.domain.Book;
import com.visa.training.springbootwebapp.domain.Chapter;
@Service
public class BookServiceImpl implements BookService {

	BookRepository dao;
	
	@Autowired
	public void setDao(BookRepository dao) {
		this.dao = dao;
	}

	@Override
	public int addNewBook(Book book) {
		List<Chapter> chapters = new ArrayList<>();
		Chapter c = new Chapter(1,"chapter1", 12);
		c.setBook(book);
		chapters.add(c);
		book.setChapters(chapters);
		Book b = dao.save(book);
		return b.getId();
	}

	@Override
	public Book findById(int id) {
		Book b = dao.findById(id);
		return b;
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = dao.findAll();
		System.out.println("From DAO: "+books);
		return books;
	}

	@Override
	public void deleteBook(int id) {
		Book b = dao.findById(id);
		if(b != null)
			dao.delete(b);
	}

	@Override
	public Book updateBook(Book book) {
		Book updated = dao.save(book);
		return updated;
	}
	

}

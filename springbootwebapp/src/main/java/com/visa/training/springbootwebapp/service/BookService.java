package com.visa.training.springbootwebapp.service;

import java.util.List;

import com.visa.training.springbootwebapp.domain.Book;


public interface BookService {
	public int addNewBook(Book p);
	public Book findById(int id);
	public List<Book> findAll();
	public void deleteBook(int id);
	public Book updateBook(Book book);

}

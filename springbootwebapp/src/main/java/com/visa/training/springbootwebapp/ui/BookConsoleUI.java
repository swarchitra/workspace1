package com.visa.training.springbootwebapp.ui;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.visa.training.springbootwebapp.domain.Book;
import com.visa.training.springbootwebapp.service.BookService;
@Component
public class BookConsoleUI {
	@Autowired
	BookService service;

	
	public void findAll() {
		List<Book> books = null;
		try {
			books = service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(books);
		books.forEach(System.out::println);

	}
	public void createBook() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scan.next();
		System.out.println("Enter author");
		String author = scan.next();
		System.out.println("Enter Category");
		String category = scan.next();
		System.out.println("Enter year");
		int year = scan.nextInt();
		Book b = new Book(name, author, category, year);
		
		int id = 0;
		try {
			id = service.addNewBook(b);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Book created with ID: " + id);
	}

	public static void main(String[] args) {
		BookConsoleUI ui = new BookConsoleUI();
		ui.createBook();
	}
}

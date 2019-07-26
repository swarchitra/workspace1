package com.visa.training.springbootwebapp.ui;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.visa.training.springbootwebapp.domain.Book;
import com.visa.training.springbootwebapp.domain.Chapter;
import com.visa.training.springbootwebapp.service.ChapterService;
@Component
public class ChapterConsoleUI {
	@Autowired
	ChapterService service;
	
	public void createChapter() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter name");
		String name = scan.next();
		System.out.println("Enter index");
		int index = scan.nextInt();
		System.out.println("Enter no_of_pages");
		int pages = scan.nextInt();
		Chapter c = new Chapter(index, name, pages);
		
		int id = 0;
		try {
			id = service.addNewChapter(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("New Chapter created with ID: " + id);
	}
}

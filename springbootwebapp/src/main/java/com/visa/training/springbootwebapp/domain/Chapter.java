package com.visa.training.springbootwebapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "chapter")
public class Chapter {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "chapter_id")
	int id;
	@Column(name = "chapter_index")
	int index;
	String name;
	@Column(name = "numpages")
	int numPages;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn (name = "book_id") // <-- is the foreign key
	@JsonIgnore
	Book book;
	
	
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Chapter() {
		super();
	}

	public Chapter(int index, String name, int numPages) {
		super();
		this.index = index;
		this.name = name;
		this.numPages = numPages;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumPages() {
		return numPages;
	}

	public void setNumPages(int numPages) {
		this.numPages = numPages;
	}
	
	
}

package com.visa.training.springbootwebapp.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.springbootwebapp.domain.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findById(int id);

	public List<Book> findAll();

}

package com.visa.training.springbootwebapp.dal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.visa.training.springbootwebapp.domain.Chapter;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter, Integer>{

	public Chapter findById(int id);

	public List<Chapter> findAll();
}


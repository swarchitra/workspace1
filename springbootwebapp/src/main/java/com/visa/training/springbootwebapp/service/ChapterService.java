package com.visa.training.springbootwebapp.service;

import java.util.List;

import com.visa.training.springbootwebapp.domain.Chapter;

public interface ChapterService {

	public int addNewChapter(Chapter p);
	public Chapter findById(int id);
	public List<Chapter> findAll();
	public void deleteChapter(int id);
	public Chapter updateChapter(Chapter chapter);

}

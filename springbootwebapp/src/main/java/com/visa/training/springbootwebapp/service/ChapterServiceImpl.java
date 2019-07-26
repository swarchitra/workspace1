package com.visa.training.springbootwebapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.visa.training.springbootwebapp.dal.ChapterRepository;
import com.visa.training.springbootwebapp.domain.Chapter;

@Service
public class ChapterServiceImpl implements ChapterService{

	ChapterRepository dao;
	
	@Autowired
	public void setDao(ChapterRepository dao) {
		this.dao = dao;
	}

	@Override
	public int addNewChapter(Chapter p) {
		Chapter c = dao.save(p);
		return c.getId();
	}

	@Override
	public Chapter findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Chapter> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void deleteChapter(int id) {
		// TODO Auto-generated method stub
		Chapter c = dao.findById(id);
		dao.delete(c);
	}

	@Override
	public Chapter updateChapter(Chapter chapter) {
		return dao.save(chapter);
	}

}

package com.tambao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tambao.dao.INewDAO;
import com.tambao.model.NewsModel;
import com.tambao.service.INewService;

@Service
public class NewService implements INewService {
	@Autowired
	private INewDAO newDao;
	
	@Override
	public List<NewsModel> findAll() {
		return newDao.findAll();
	}

}

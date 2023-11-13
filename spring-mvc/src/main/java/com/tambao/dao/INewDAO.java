package com.tambao.dao;

import java.util.List;

import com.tambao.model.NewsModel;

public interface INewDAO extends GennericDAO<NewsModel>{
	List<NewsModel> findAll();
}

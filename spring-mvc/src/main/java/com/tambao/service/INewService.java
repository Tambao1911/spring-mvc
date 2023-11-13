package com.tambao.service;

import java.util.List;

import com.tambao.model.NewsModel;

public interface INewService {
	List<NewsModel> findAll();
}

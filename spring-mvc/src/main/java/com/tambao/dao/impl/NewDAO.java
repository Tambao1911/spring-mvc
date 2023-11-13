package com.tambao.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tambao.dao.INewDAO;
import com.tambao.mapper.NewMapper;
import com.tambao.model.NewsModel;

@Repository
public class NewDAO extends AbstractDAO<NewsModel> implements INewDAO {

	@Override
	public List<NewsModel> findAll() {
		StringBuffer sql = new StringBuffer("SELECT * FROM news");
		return query(sql.toString(), new NewMapper());

	}
}

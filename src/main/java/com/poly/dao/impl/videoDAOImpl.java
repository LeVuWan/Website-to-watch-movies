package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.abstractDAO;
import com.poly.dao.videoDAO;
import com.poly.entity.Video;

public class videoDAOImpl extends abstractDAO<Video> implements videoDAO {

	@Override
	public Video findById(Integer id) {

		return super.findById(Video.class, id);
	}

	@Override
	public Video finByHref(String href) {
		String sql = "SELECT o FROM Video o WHERE o.href=?0";
		return super.finOne(Video.class, sql, href);
	}

	@Override
	public List<Video> findAll() {
		return super.findAll(Video.class, true);
	}

	@Override
	public List<Video> findPage(int PageSize, int PageNumber) {
		return super.findAll(Video.class, true, PageNumber, PageSize);
	}

	@Override
	public Video create(Video entity) {
		return super.create(entity);
	};

	@Override
	public Video update(Video entity) {
		return super.update(entity);
	};

	@Override
	public Video delete(Video entity) {
		return super.delete(entity);
	};

}

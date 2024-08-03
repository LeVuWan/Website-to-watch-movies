package com.poly.service.impl;

import java.util.List;

import com.poly.dao.videoDAO;
import com.poly.dao.impl.videoDAOImpl;
import com.poly.entity.Video;
import com.poly.service.videoService;

public class videoServiceimpl implements videoService {

	private videoDAO dao;

	public videoServiceimpl() {
      dao = new videoDAOImpl();
	}

	@Override
	public Video findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public Video finByHref(String href) {
		return dao.finByHref(href);
	}

	@Override
	public List<Video> findAll() {
		return dao.findAll();
	}

	@Override
	public List<Video> finAll(int PageNumber, int PageSize) {
		return dao.findPage(PageSize, PageNumber);
	}

	@Override
	public Video create(Video entity) {
		entity.setIsActive(Boolean.TRUE);
		entity.setViews(0);
		entity.setShare(0);
		return dao.create(entity);
	}

	@Override
	public Video update(Video entity) {
		return dao.update(entity);
	}

	@Override
	public Video delete(String href) {
		Video entity = dao.finByHref(href);
		entity.setIsActive(false);
		return dao.update(entity);
	}

}

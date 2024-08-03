package com.poly.dao;

import java.util.List;

import com.poly.entity.Video;

public interface videoDAO {

	Video findById(Integer id);

	Video finByHref(String href);

	List<Video> findAll();

	List<Video> findPage(int PageSize, int PageNumber);

	Video create(Video entity);

	Video update(Video entity);

	Video delete(Video entity);
}

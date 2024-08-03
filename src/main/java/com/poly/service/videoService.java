package com.poly.service;

import java.util.List;

import com.poly.entity.Video;

public interface videoService {
	Video findById(Integer id);

	Video finByHref(String href);

	List<Video> findAll();

	List<Video> finAll(int PageNumber, int PageSize);

	Video create(Video entity);

	Video update(Video entity);

	Video delete(String href);
}

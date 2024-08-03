package com.poly.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.poly.dao.historyDAO;
import com.poly.dao.impl.historyDAOImpl;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.historyService;
import com.poly.service.videoService;

public class historyServiceImpl implements historyService{

	private historyDAO dao;
	private videoService videoSv = new videoServiceimpl();
	
	
	
	public historyServiceImpl() {
		dao = new historyDAOImpl();
	}

	@Override
	public List<History> findByUser(String username) {
		return dao.findByUser(username);
	}

	@Override
	public List<History> findByUserAngIslinked(String username) {
		return dao.findByUserAndIsliked(username);
	}

	@Override
	public History findByUseridAndVideoId(int userId, int videoId) {
		return dao.findByIdusernameAndIdVideo(userId, videoId);
	}

	@Override
	public History create(User user, Video video) {
		History entity = dao.findByIdusernameAndIdVideo(user.getId(), video.getId());
		if(entity == null) {
			entity = new History();
			entity.setUserId(user);
			entity.setVideoId(video);
			entity.setLikedDate(new Timestamp(System.currentTimeMillis()));
			entity.setIsLiked(false);
			return dao.create(entity);
		}
		return entity;
	}

	@Override
	public boolean updateLikeOrUnlike(User user, String href) {
		Video video = videoSv.finByHref(href);
		History history = findByUseridAndVideoId(user.getId(), video.getId());
		
		if(history.getIsLiked() == Boolean.FALSE) {
			history.setIsLiked(Boolean.TRUE);
			history.setLikedDate(new Timestamp(System.currentTimeMillis()));
		} else {
			history.setIsLiked(Boolean.FALSE);
			history.setLikedDate(null);
		}
		History updateHistory = dao.update(history);
		return updateHistory != null ? true : false;
	}

}

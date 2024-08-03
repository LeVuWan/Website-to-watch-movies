package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.abstractDAO;
import com.poly.dao.historyDAO;
import com.poly.entity.History;

public class historyDAOImpl extends abstractDAO<History> implements historyDAO {

	@Override
	public List<History> findByUser(String username) {
		String sql = "SELECT o FROM History o WHERE o.userId.username=?0 AND o.videoId.isActive = 1 "
				+ " ORDER BY o.viewDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public List<History> findByUserAndIsliked(String username) {
		String sql = "SELECT o FROM History o WHERE o.userId.username=?0 AND o.videoId.isActive = 1 AND o.isLiked = 1 "
				+ " ORDER BY o.viewDate DESC";
		return super.findMany(History.class, sql, username);
	}

	@Override
	public History findByIdusernameAndIdVideo(Integer userId, Integer videoId) {
		String sql = "SELECT o FROM History o WHERE o.userId.id=?0 AND o.videoId.id=?1 AND o.videoId.isActive=1";
		return super.finOne(History.class, sql, userId, videoId);
	}

}

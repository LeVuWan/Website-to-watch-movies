package com.poly.dao;

import java.util.List;

import com.poly.entity.History;

public interface historyDAO {
	List<History> findByUser(String username);

	List<History> findByUserAndIsliked(String username);

	History findByIdusernameAndIdVideo(Integer userId, Integer videoId);

	History create(History entity);

	History update(History entity);
}

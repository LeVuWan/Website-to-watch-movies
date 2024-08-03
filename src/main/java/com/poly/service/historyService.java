package com.poly.service;

import java.util.List;

import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;

public interface historyService {

	List<History> findByUser(String username);

	List<History> findByUserAngIslinked(String username);

	History findByUseridAndVideoId(int userId, int videoId);

	History create(User user, Video video);

	boolean updateLikeOrUnlike(User user, String href);
}

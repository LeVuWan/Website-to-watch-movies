package com.poly.dao;

import java.util.List;

import com.poly.dto.VideoLikedInfo;
import com.poly.entity.User;

public interface stafDAO {
	List<VideoLikedInfo> findVideoLikedInfo();
}

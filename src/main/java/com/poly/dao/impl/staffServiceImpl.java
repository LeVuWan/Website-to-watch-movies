package com.poly.dao.impl;

import java.util.List;

import com.poly.dao.stafDAO;
import com.poly.dto.VideoLikedInfo;
import com.poly.service.staffService;

public class staffServiceImpl implements staffService{

	private stafDAO dao;
	
	
	
	public staffServiceImpl() {
		dao = new stafDAOImpl();
	}

	@Override
	public List<VideoLikedInfo> findVideoLikedInfo() {
		// TODO Auto-generated method stub
		return dao.findVideoLikedInfo();
	}

}

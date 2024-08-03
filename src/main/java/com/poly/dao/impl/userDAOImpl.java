package com.poly.dao.impl;

import java.util.List;
import java.util.Map;

import com.poly.constant.NamedStored;
import com.poly.dao.abstractDAO;
import com.poly.dao.userDAO;
import com.poly.entity.User;

import net.bytebuddy.implementation.bind.annotation.Super;

public class userDAOImpl extends abstractDAO<User> implements userDAO {

	@Override
	public User findById(Integer id) {
		return super.findById(User.class, id);
	}

	@Override
	public User findByEmail(String email) {
		String sql = "SELECT o fROM User o WHERE o.email=?0";
		return super.finOne(User.class, sql, email);
	}

	@Override
	public User finByUsername(String username) {
		String sql = "SELECT o FROM User o WHERE o.username=?0";
		return super.finOne(User.class, sql, username);
	}

	@Override
	public User finByUsernameAndPassword(String username, String passWord) {
		String sql = "SELECT o FROM User o WHERE o.username=?0 AND o.password=?1";
		return super.finOne(User.class, sql, username, passWord);
	}

	@Override
	public List<User> findAll(int PageNumber, int PageSize) {
		return super.findAll(User.class, true, PageNumber, PageSize);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return super.findAll(User.class, true);
	}

	@Override
	public List<User> findUsersLikedByVideoHref(Map<String, Object> params) {
		return super.callStored(NamedStored.Find_USER_LIKED_BY_HREF, params);
	}

	

}

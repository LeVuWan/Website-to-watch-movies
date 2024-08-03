package com.poly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.poly.dao.userDAO;
import com.poly.dao.impl.userDAOImpl;
import com.poly.dto.UserDto;
import com.poly.entity.User;
import com.poly.service.userService;

public class userServiceImpl implements userService{

	private userDAO dao;
	
	
	
	public userServiceImpl() {
		super();
		this.dao = new userDAOImpl();
	}

	@Override
	public User findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public User finByUsername(String username) {
		return dao.finByUsername(username);
	}

	@Override
	public User login(String username, String passWord) {
		return dao.finByUsernameAndPassword(username, passWord);
	}

	@Override
	public List<User> fillAll() {
		return dao.findAll();
	}

	@Override
	public User create(String username, String password, String email) {
		User entity = new User();
		entity.setEmail(email);
		entity.setUsername(username);
		entity.setPassword(password);
		entity.setIsActive(Boolean.TRUE);
		entity.setIsAdmin(Boolean.FALSE);
		return dao.create(entity);
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public User delete(String username) {
		User entity = dao.finByUsername(username);
		entity.setIsActive(Boolean.FALSE);
		return dao.update(entity);
	}

	@Override
	public List<User> findAll(int PageNumber, int PageSize) {
		return dao.findAll(PageNumber, PageSize);
	}

	@Override
	public User resetPassword(String email) {
		return null;
	}

	@Override
	public List<UserDto> findUsersLikedByVideoHref(String href) {
		Map<String, Object> params = new HashMap<>();
		params.put("videoHref", href);
		List<User> users = dao.findUsersLikedByVideoHref(params);
		List<UserDto> result = new ArrayList<UserDto>();
		users.forEach(user ->{
			UserDto dto = new UserDto();
			dto.setUsername(user.getUsername());
			dto.setEmail(user.getEmail());
			result.add(dto);
		});
		return result;
	}

}

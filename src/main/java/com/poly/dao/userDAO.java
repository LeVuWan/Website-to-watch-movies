package com.poly.dao;

import java.util.List;
import java.util.Map;

import com.poly.entity.User;

public interface userDAO {
	User findById(Integer id);

	User findByEmail(String email);

	User finByUsername(String username);

	User finByUsernameAndPassword(String username, String passWord);

	List<User> findAll();

	User create(User entity);

	User update(User entity);

	User delete(User entity);

	List<User> findAll(int PageNumber, int PageSize);

	List<User> findUsersLikedByVideoHref(Map<String, Object> params);

}

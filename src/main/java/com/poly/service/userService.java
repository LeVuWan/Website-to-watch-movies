package com.poly.service;

import java.util.List;
import java.util.Map;

import com.poly.dto.UserDto;
import com.poly.entity.User;

public interface userService {
	User findById(Integer id);

	User findByEmail(String email);

	User finByUsername(String username);

	User login(String username, String passWord);

	List<User> fillAll();

	User create(String username, String password, String email);

	User update(User entity);

	User delete(String username);

	List<User> findAll(int PageNumber, int PageSize);
	
	User resetPassword(String email);
	
	List<UserDto> findUsersLikedByVideoHref(String href);
}

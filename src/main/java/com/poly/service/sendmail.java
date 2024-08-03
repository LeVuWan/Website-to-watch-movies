package com.poly.service;

import javax.servlet.ServletContext;

import com.poly.entity.User;

public interface sendmail {
	void sendMail(ServletContext context, User recipient, String type);
}

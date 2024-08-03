package com.poly.service.impl;

import javax.servlet.ServletContext;

import com.poly.entity.User;
import com.poly.service.sendmail;
import com.poly.utill.SendmailUtill;

public class sendmailServiceimpl implements sendmail{

	private static final String EMAIL_WELLCOME_SUBJECT = "Wellcome to ONLINE ANIME";
	private static final String EMAIL_FORGOT_PASSWORD = "NewPassWord";
	
	@Override
	public void sendMail(ServletContext context, User recipient, String type) {
		String host = context.getInitParameter("host");
		String port = context.getInitParameter("post");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("pass");
		
		try {
			String content = null;
			String subject = null;
			
			switch(type) {
			case "wellcome":
				subject = EMAIL_WELLCOME_SUBJECT;
				content = "Dear" + recipient.getUsername() + ", hope you have a good time!";
				break;
			case "forgot":
				subject = EMAIL_FORGOT_PASSWORD;
				content = "Dear" + recipient.getUsername() + ", your new password here: " + recipient.getPassword();
				break;
 			}
			SendmailUtill.sendEmail(host, port, user, pass, recipient.getUsername(), subject, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}

}

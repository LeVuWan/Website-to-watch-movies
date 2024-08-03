package com.poly.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.service.userService;
import com.poly.service.impl.sendmailServiceimpl;
import com.poly.service.impl.userServiceImpl;

/**
 * Servlet implementation class userController
 */
@WebServlet(urlPatterns = { "/login", "/logout", "/register", "/changePassword" })
public class userController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private userService userService = new userServiceImpl();
	private sendmailServiceimpl sendmailService = new sendmailServiceimpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doGetLogin(request, response);
			break;
		case "/register":
			dogetregister(request, response);
			break;
		case "/logout":
			dogetLogout(request, response, session);
			break;
		}
	}

	private void dogetLogout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		session.removeAttribute(SessionAttr.CurrentUser);
		request.getRequestDispatcher("homeController").forward(request, response);
	}

	private void dogetregister(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/signup.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/login":
			doPostLogin(session, request, response);
			break;
		case "/register":
			doPostRegister(session, request, response);
			break;
		case "/changePassword":
			doPostchangePassword(session, request, response);
		}
	}

	private void doPostchangePassword(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		String currentPass = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		
		User currentUser = (User) session.getAttribute(SessionAttr.CurrentUser);
		
		if(currentPass.equals(currentUser.getPassword())) {
			currentUser.setPassword(newPassword);
			User updatePassword = userService.update(currentUser);
		} else {
			response.setStatus(400);
		}
		
	}

	private void doPostRegister(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");

		User entity = userService.create(username, password, email);

		if (entity != null) {
			sendmailService.sendMail(getServletContext(), entity, "wellcome");
			session.setAttribute(SessionAttr.CurrentUser, entity);
			response.sendRedirect("homeController");
		} else {
			response.sendRedirect("login");
		}
	}

	private void doPostLogin(HttpSession session, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User entity = userService.login(username, password);

		if (entity != null) {
			session.setAttribute(SessionAttr.CurrentUser, entity);
			response.sendRedirect("homeController");
		} else {
			response.sendRedirect("register");
		}
	}

	private void doGetLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
	}

}

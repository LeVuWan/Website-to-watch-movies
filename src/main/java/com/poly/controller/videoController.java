package com.poly.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.historyService;
import com.poly.service.videoService;
import com.poly.service.impl.historyServiceImpl;
import com.poly.service.impl.videoServiceimpl;

/**
 * Servlet implementation class videoController
 */
@WebServlet(urlPatterns = "/video")
public class videoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private videoService videoService = new videoServiceimpl();
    private historyService historyService = new historyServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public videoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionParam = request.getParameter("action");
		String href = request.getParameter("id");
		HttpSession session = request.getSession();

		switch (actionParam) {
		case "watch":
			doGetWatch(session, request, response, href);
			break;
		case "like":
			doGetLike(session, request, response, href);
			break;
		}
	}

	private void doGetLike(HttpSession session, HttpServletRequest request, HttpServletResponse response, String href) {
		response.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttr.CurrentUser);
		boolean result = historyService.updateLikeOrUnlike(currentUser, href);
		if(result == true) {
			response.setStatus(204);
		}else {
			response.setStatus(400);
		}
	}

	private void doGetWatch(HttpSession session, HttpServletRequest request, HttpServletResponse response,String  href)
			throws ServletException, IOException {
		Video video = videoService.finByHref(href);
		request.setAttribute("video", video);		
		User currentUser = (User)session.getAttribute(SessionAttr.CurrentUser);
		if(currentUser != null) {
			History history = historyService.create(currentUser, video);
			request.setAttribute("flagLikeBtn", history.getIsLiked());
		}
		
		request.getRequestDispatcher("/views/user/videoDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}

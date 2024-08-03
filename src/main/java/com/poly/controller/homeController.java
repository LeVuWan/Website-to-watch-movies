package com.poly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class homeController
 */
@WebServlet({ "/homeController", "/favorites", "/history" })
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public videoService videoService = new videoServiceimpl();
	public historyService historyService = new historyServiceImpl();
	private static final int VIDEO_MAX_PAGE_SIZE = 2;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public homeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		switch (path) {
		case "/homeController":
			doGetIndex(request, response);
			break;
		case "/favorites":
			dogetfavorites(request, response, session);
			break;
		case "/history":
			dogethistory(request, response, session);
			break;
		}
	}

	private void dogethistory(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CurrentUser);

		List<History> listHistories = historyService.findByUser(user.getUsername());
		List<Video> listVideo = new ArrayList<>();

		for (int i = 0; i < listHistories.size(); i++) {
			listVideo.add(listHistories.get(i).getVideoId());
		}

		request.setAttribute("listVideo", listVideo);
		request.getRequestDispatcher("/views/user/history.jsp").forward(request, response);
	}

	private void dogetfavorites(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		User user = (User) session.getAttribute(SessionAttr.CurrentUser);

		List<History> listHistories = historyService.findByUserAngIslinked(user.getUsername());
		List<Video> listVideo = new ArrayList<>();

		for (int i = 0; i < listHistories.size(); i++) {
			listVideo.add(listHistories.get(i).getVideoId());
		}

		request.setAttribute("listVideo", listVideo);
		request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);
	}

	private void doGetIndex(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> coutVideo = videoService.findAll();
		int pageMax = (int)Math.ceil(coutVideo.size()/(int)VIDEO_MAX_PAGE_SIZE);
//		int pageMax = 2;
		request.setAttribute("maxPage", pageMax);
		
		List<Video> listVideo;
		String pageNumber;
		if (request.getParameter("page")== null) {
			pageNumber = "1";
		}else {
			pageNumber = request.getParameter("page");
		}
//		String pageNumber = "1";
		int pageNumberValue = Integer.valueOf(pageNumber);
		if(pageNumberValue == 1) {
			listVideo = videoService.finAll(1, VIDEO_MAX_PAGE_SIZE);
			request.setAttribute("currentPage", 1);
		} else {
			listVideo = videoService.finAll(Integer.valueOf(pageNumberValue), VIDEO_MAX_PAGE_SIZE);
			request.setAttribute("currentPage", pageNumberValue);
		}
		
		request.setAttribute("listVideo", listVideo);
		request.getRequestDispatcher("/views/user/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}

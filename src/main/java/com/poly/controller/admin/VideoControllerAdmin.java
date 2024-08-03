package com.poly.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.poly.constant.SessionAttr;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.videoService;
import com.poly.service.impl.videoServiceimpl;

/**
 * Servlet implementation class VideoControllerAdmin
 */
@WebServlet(urlPatterns = { "/admin/video" }, name = "VideoControllerOfAdmin")
public class VideoControllerAdmin extends HttpServlet {
	private videoService videoService = new videoServiceimpl();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoControllerAdmin() {
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

		String action = request.getParameter("action");
		switch (action) {
		case "view":
			doGetOverView(request, response);
			break;
		case "delete":
			doGetDelete(request, response);
			break;
		case "add":
			request.setAttribute("isEdit", false);
			doGetAdd(request, response);
			break;
		case "edit":
			request.setAttribute("isEdit", true);
			doGetEdit(request, response);
			break;
		}
	}

	private void doGetEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String href = request.getParameter("href");
		Video video = videoService.finByHref(href);
		request.setAttribute("video", video);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/video-edit.jsp");
		requestDispatcher.forward(request, response);
	}

	private void doGetAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/video-edit.jsp");
		requestDispatcher.forward(request, response);
	}

	private void doGetDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		String href = request.getParameter("href");
		Video videoDeleted = videoService.delete(href);
		if (videoDeleted != null) {
			doGetOverView(request, response);
			response.sendRedirect("admin/video/view");
			response.setStatus(204);
		} else {
			response.setStatus(400);
		}
	}

	private void doGetOverView(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Video> videos = videoService.findAll();
		request.setAttribute("videos", videos);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/views/admin/list_video.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute(SessionAttr.CurrentUser);
		// if(currentUser != null && currentUser.getIsAdmin() == Boolean.TRUE) {
		String action = request.getParameter("action");
		switch (action) {
		case "create":
			doPostAdd(request, response);
			break;
		case "update":
			doPostEdit(request, response);
			break;
		case "delete":
			doPostDelete(request, response);
			break;
		}
	}

	private void doPostDelete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void doPostEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String href = request.getParameter("href");
		String poster = request.getParameter("poster");
		
		Video video = videoService.finByHref(href);
		video.setTitle(title);
		video.setHref(href);
		video.setDescription(description);
		video.setPoster(poster);
		
		Video videoReturn = videoService.update(video);
		if(videoReturn != null) {
			request.setAttribute("Thêm mới thành công", "message");
			request.getRequestDispatcher("/views/admin/video-edit.jsp").forward(request, response);
		}else {
			request.setAttribute("Thêm mới thất bại", "message");
			request.getRequestDispatcher("/views/admin/video-edit.jsp").forward(request, response);
		}
	}

	private void doPostAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String href = request.getParameter("href");
		String poster = request.getParameter("poster");
		Video video = new Video();
		video.setTitle(title);
		video.setHref(href);
		video.setDescription(description);
		video.setPoster(poster);

		Video videoReturn = videoService.create(video);
		if (videoReturn != null) {
			request.setAttribute("Thêm mới thành công", "message");
			request.getRequestDispatcher("/views/admin/video-edit.jsp").forward(request, response);
		} else {
			request.setAttribute("Thêm mới thất bại", "message");
			request.getRequestDispatcher("/views/admin/video-edit.jsp").forward(request, response);
		}
	}

}

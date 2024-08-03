package com.poly.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.constant.SessionAttr;
import com.poly.dao.impl.staffServiceImpl;
import com.poly.dto.UserDto;
import com.poly.dto.VideoLikedInfo;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.staffService;
import com.poly.service.userService;
import com.poly.service.videoService;
import com.poly.service.impl.userServiceImpl;
import com.poly.service.impl.videoServiceimpl;

@WebServlet(urlPatterns = { "/admin",  "/admin/favorites" }, name = "/homeControllerOfAdmin")
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private staffService staffService = new staffServiceImpl();
	private userService userService = new userServiceImpl();
	private videoService videoService = new videoServiceimpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionParam = request.getParameter("action");
		HttpSession session = request.getSession();
		User CurrentUser = (User) session.getAttribute(SessionAttr.CurrentUser);

		if (CurrentUser != null && CurrentUser.getIsAdmin() == Boolean.TRUE) {
			String path = request.getServletPath();
			switch (path) {
			case "/admin":
				doGetHome(request, response);
				break;
			case "/admin/favorites":
				doGetFavorites(request, response);
				break;
			}
		} else {
			response.sendRedirect("homeController");
		}
	}

	private void doGetFavorites(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		String videoHref = request.getParameter("href");
		List<UserDto> users = userService.findUsersLikedByVideoHref(videoHref);
		if(users.isEmpty()) {
			response.setStatus(400);
		}else {
			ObjectMapper mapper = new ObjectMapper();
			String dataResponse = mapper.writeValueAsString(users);
			response.setStatus(200);
			out.print(dataResponse);
			out.flush();
		}
	}

	private void doGetHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<VideoLikedInfo> videos = staffService.findVideoLikedInfo();
		request.setAttribute("videos", videos);
		request.getRequestDispatcher("/views/admin/home.jsp").forward(request, response);

	}
}

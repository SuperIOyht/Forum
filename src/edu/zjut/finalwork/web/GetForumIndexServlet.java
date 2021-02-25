package edu.zjut.finalwork.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zjut.finalwork.dao.commentDAO;
import edu.zjut.finalwork.dao.postDAO;
import edu.zjut.finalwork.dao.userDAO;
import edu.zjut.finalwork.model.commentBean;
import edu.zjut.finalwork.model.postBean;

/**
 * Servlet implementation class GetMainPostServlet
 */
@WebServlet("/GetMainPostServlet")
public class GetForumIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetForumIndexServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int postId = Integer.parseInt(request.getParameter("postId"));
		int totalNum = 0, totalPage = 0;
		int thisPage = 1;
		int pageSize = 10;
		Boolean isChecking = false;
		commentDAO commentDao = new commentDAO();
		postDAO postDao = new postDAO();
		postBean post = new postBean();

		boolean isAdmin = false;
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		boolean hasLogin = false;
		String userInfo = "";
		String name = "";
		String id = "";
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				cookie = cookies[i];
				if (cookie.getName().equals("name")) {
					name = cookie.getValue();
					hasLogin = true;
				}
				if (cookie.getName().equals("id")) {
					id = cookie.getValue();
					hasLogin = true;
				}
				if (cookie.getName().equals("isAdmin")) {
					isAdmin = true;
					hasLogin = true;
				}
			}
		}

		post = postDao.getPostByIdForAdmin(postId);
		isChecking = post.isChecking();

		List<commentBean> allComments = commentDao.getComByPost(post);
		List<commentBean> comments = new ArrayList<commentBean>();
		if (!isChecking) {
			if (allComments == null) {
				totalNum = 0;
			} else {
				totalNum = allComments.size();
			}
			totalPage = totalNum / pageSize + 1;
			if (request.getParameter("page") != null && Integer.parseInt(request.getParameter("page")) <= totalPage
					&& Integer.parseInt(request.getParameter("page")) > 0) {
				thisPage = Integer.parseInt(request.getParameter("page"));
			}
			comments = commentDao.getPageCom((thisPage - 1) * pageSize, pageSize, post);
		}

		if (hasLogin) {
			userDAO userDao = new userDAO();
			String icon = userDao.getIcon(Integer.parseInt(id));
			userInfo = "<div id=\"userInfo\">\r\n" + "<div class=\"avt y\"><a href=\"Manage.do?id=" + id
					+ "\"><img src=\"" + icon + "\"></a></div>" + "				<p>\r\n"
					+ "					<!-- 用户登录或用户信息 -->\r\n"
					+ "					<strong class=\"username\"><a href=\"\" target=\"_blank\"\r\n"
					+ "						title=\"访问我的空间\">" + name
					+ "</a></strong> <span class=\"pipe\">|</span> <a\r\n"
					+ "						href=\"Manage.do?id=" + id + "\">我的</a>\r\n"
					+ "<span class=\"pipe\">|</span>" + "						<a href='Logout.do'>注销</a>	"
					+ "				</p>\r\n" + "			</div>";
		} else {
			userInfo = "<div id=\"scbar_hot\">\r\n" + "				<a href='register.html'  class=\"xi2\">注册</a>\r\n"
					+ "				<a href='login.html' class=\"xi2\">登录</a>\r\n" + "			</div>";
		}
		request.setAttribute("isChecking", isChecking);
		request.setAttribute("isAdmin", isAdmin);
		request.setAttribute("comments", comments);
		request.setAttribute("post", post);
		request.setAttribute("totalNum", Integer.valueOf(totalNum));
		request.setAttribute("totalPage", Integer.valueOf(totalPage));
		request.setAttribute("thisPage", Integer.valueOf(thisPage));
		request.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("/forumIndex.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

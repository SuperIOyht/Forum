package edu.zjut.finalwork.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.zjut.finalwork.*;
import edu.zjut.finalwork.dao.postDAO;
import edu.zjut.finalwork.dao.userDAO;
import edu.zjut.finalwork.model.postBean;

import java.util.*;

/**
 * Servlet implementation class mainPage
 */
@WebServlet("/mainPage")
public class GetPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetPostServlet() {
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
		int totalNum, totalPage;
		int thisPage = 1;
		int pageSize = 20;
		String result = "";

		List<postBean> allPosts = new ArrayList<postBean>();
		List<postBean> posts = new ArrayList<postBean>();

		postDAO postDao = new postDAO();
		allPosts = postDao.getAllPost();
		totalNum = allPosts.size();
		totalPage = totalNum / pageSize + 1;
		if (request.getParameter("page") != null && Integer.parseInt(request.getParameter("page")) <= totalPage
				&& Integer.parseInt(request.getParameter("page")) > 0) {
			thisPage = Integer.parseInt(request.getParameter("page"));
		}
		posts = postDao.getPagePost((thisPage - 1) * pageSize, pageSize);
		request.setAttribute("totalNum", Integer.valueOf(totalNum));
		request.setAttribute("totalPage", Integer.valueOf(totalPage));
		request.setAttribute("thisPage", Integer.valueOf(thisPage));
		for (int i = 0; i < posts.size(); i++) {
			result += "<tbody id='" + posts.get(i).getId() + "'>\r\n" + "							<tr>\r\n"
					+ "								<!-- 帖子标题 -->\r\n"
					+ "								<th class=\"common\"><a\r\n"
					+ "									href=\"GetForumIndex.do?postId=" + posts.get(i).getId() + "\"\r\n"
					+ "									class=\"s xst\">" + posts.get(i).getTitle() + "</a></th>\r\n"
					+ "								<!-- 帖子标题 -->\r\n"
					+ "								<!--  -->	\r\n"
					+ "								<td class=\"by\">\r\n"
					+ "									<!-- 发帖人 -->\r\n"
					+ "									<cite> <span\r\n"
					+ "										c=\"1\"\r\n"
					+ "										mid=\"card_9027\">" + posts.get(i).getAuthor()
					+ "</span>\r\n" + "									</cite>\r\n"
					+ "									<!-- 发帖人 -->\r\n"
					+ "									<!-- 发帖时间 --> \r\n"
					+ "									<em><span>" + posts.get(i).getReleaseDate() + "</span>\r\n"
					+ "									</em>\r\n"
					+ "									<!-- 发帖时间 -->\r\n" + "								</td>\r\n"
					+ "								<!-- 评论数 -->\r\n"
					+ "								<td class=\"num\">\r\n"
					+ "									<span class=\"xi2\">" + posts.get(i).getFloor() + "</span>\r\n"
					+ "								</td>\r\n" + "								<!-- 评论数 -->\r\n"
					+ "							</tr>\r\n" + "						</tbody>";
		}
		request.setAttribute("result", result);

		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		boolean hasLogin = false;
		String userInfo = "";
		String name = "";
		String id = "";
		if(cookies!=null) {
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
				
			}
		}
			if(hasLogin) {
				userDAO userDao = new userDAO();
				String icon = userDao.getIcon(Integer.parseInt(id));
				userInfo = "<div id=\"userInfo\">\r\n"
						+ "<div class=\"avt y\"><a href=\"Manage.do?id="+ id +"\"><img src=\""+ icon +"\"></a></div>"
						+ "				<p>\r\n" + "					<!-- 用户登录或用户信息 -->\r\n"
						+ "					<strong class=\"username\"><a href=\"\" target=\"_blank\"\r\n"
						+ "						title=\"访问我的空间\">" + name
						+ "</a></strong> <span class=\"pipe\">|</span> <a\r\n" + "						href=\"Manage.do?id="
						+ id + "\">我的</a>\r\n" + "<span class=\"pipe\">|</span>"
						+ "						<a href='Logout.do'>注销</a>	" + "				</p>\r\n"
						+ "			</div>";
			}
			else {
				userInfo = "<div id=\"scbar_hot\">\r\n" + "				<a href='register.html'  class=\"xi2\">注册</a>\r\n"
						+ "				<a href='login.html' class=\"xi2\">登录</a>\r\n" + "			</div>";
			}
		request.setAttribute("userInfo", userInfo);
		request.getRequestDispatcher("/mainpage.jsp").forward(request, response);
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

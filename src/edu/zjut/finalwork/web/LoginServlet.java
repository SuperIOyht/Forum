package edu.zjut.finalwork.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.servlet.http.Cookie;

import edu.zjut.finalwork.dao.userDAO;
import edu.zjut.finalwork.model.userBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		userDAO userDao = new userDAO();
		//PrintWriter out = response.getWriter(); 
		userBean user = userDao.validLogin(name, password);
		if(user!=null) {
			Cookie nameCookie = new Cookie("name",URLEncoder.encode(request.getParameter("name"),"UTF-8"));
			Cookie idCookie = new Cookie("id",String.valueOf(user.getId()));
			response.addCookie(nameCookie);
			response.addCookie(idCookie);
			if(user.isIsadmin()) {
				Cookie isAdmin = new Cookie("isAdmin","1");
				response.addCookie(isAdmin);
			}
			response.sendRedirect("GetPost.do"); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

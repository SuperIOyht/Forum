package edu.zjut.finalwork.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zjut.finalwork.dao.userDAO;

/**
 * Servlet implementation class ChangeIconServlet
 */
@WebServlet("/ChangeIconServlet")
public class ChangeIconServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeIconServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String iconURL="";
		int id=Integer.parseInt(request.getParameter("userid"));
		if(request.getParameter("iconURL") == null) {
			iconURL = "img/defaulticon.png";
		}else {
			iconURL=request.getParameter("iconURL");
		}
		userDAO userDao = new userDAO();
		userDao.setIcon(iconURL, id);
		request.getRequestDispatcher("/Manage.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

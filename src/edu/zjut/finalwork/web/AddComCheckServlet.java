package edu.zjut.finalwork.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.zjut.finalwork.dao.commentDAO;
import edu.zjut.finalwork.dao.postDAO;
import edu.zjut.finalwork.model.commentBean;
import edu.zjut.finalwork.model.postBean;

/**
 * Servlet implementation class AddComCheckServlet
 */
@WebServlet("/AddComCheckServlet")
public class AddComCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddComCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int postId = Integer.parseInt(request.getParameter("postId"));
		int comId = Integer.parseInt(request.getParameter("comId"));
		commentBean comment = new commentBean();
		comment.setId(comId);
		commentDAO commentDao = new commentDAO();
		commentDao.setChecking(comment);
		request.getRequestDispatcher("/GetForumIndex.do?"+postId).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

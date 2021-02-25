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
 * Servlet implementation class AddCommentServlet
 */
@WebServlet("/AddCommentServlet")
public class AddCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCommentServlet() {
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
		String content = request.getParameter("message");
		String username = request.getParameter("username");
		int forumpostId = Integer.parseInt(request.getParameter("postId"));
		commentDAO commentDao = new commentDAO();
		commentBean comment = new commentBean();
		postBean post = new postBean();
		postDAO postDao = new postDAO();
		post = postDao.getPostById(forumpostId);
		postDao.addFloor(post);
		comment.setAuthor(username);
		comment.setContent(content);
		comment.setForumpostId(forumpostId);
		commentDao.setComment(comment);
		request.getRequestDispatcher("/GetForumIndex.do").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

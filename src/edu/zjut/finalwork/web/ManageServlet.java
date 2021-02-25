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
import edu.zjut.finalwork.dao.iconDAO;
import edu.zjut.finalwork.dao.postDAO;
import edu.zjut.finalwork.dao.userDAO;
import edu.zjut.finalwork.model.commentBean;
import edu.zjut.finalwork.model.iconBean;
import edu.zjut.finalwork.model.postBean;
import edu.zjut.finalwork.model.userBean;

/**
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
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
		
		boolean isAdmin = false;
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		boolean hasLogin = false;
		String userInfo = "";
		String name = "";
		String id = "";
		String icon = "";
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
			
			if(hasLogin) {
				userDAO userDao = new userDAO();
				icon = userDao.getIcon(Integer.parseInt(id));
				userInfo = "<div id=\"userInfo\">\r\n"
						+ "<div class=\"avt y\"><a href=\"Manage.do?id="+ id +"\"><img src=\""+ icon +"\"></a></div>"
						+ "				<p>\r\n" + "					<!-- �û���¼���û���Ϣ -->\r\n"
						+ "					<strong class=\"username\"><a href=\"\" target=\"_blank\"\r\n"
						+ "						title=\"�����ҵĿռ�\">" + name
						+ "</a></strong> <span class=\"pipe\">|</span> <a\r\n" + "						href=\"Manage.do?id="
						+ id + "\">�ҵ�</a>\r\n" + "<span class=\"pipe\">|</span>"
						+ "						<a href='Logout.do'>ע��</a>	" + "				</p>\r\n"
						+ "			</div>";
			}
			else {
				request.getRequestDispatcher("/login.html").forward(request, response);
			}
		
		request.setAttribute("isAdmin", isAdmin);
		request.setAttribute("userInfo", userInfo);
		
		String mod = request.getParameter("mod");
		String result = "";
		if(mod == null) {
			mod = "icon";
		}
		if(mod.equals("icon")) {
			iconDAO iconDao = new iconDAO();
			List<iconBean> allIcons = new ArrayList<iconBean>();
			allIcons = iconDao.getAllIcon();		
			result = 
					"<h1 class=\"mt\">�޸�ͷ��\r\n" + 
					"</h1>\r\n" + 
					
					"<form id=\"avatarform\" method=\"post\" action=\"ChangeIcon.do\">\r\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" class=\"tfm\">\r\n" + 
					"<caption>\r\n" + 
					"<span id=\"retpre\" class=\"y xi2\"></span>\r\n" + 
					"<h2 class=\"xs2\">��ǰ�ҵ�ͷ��</h2>\r\n" + 
					"<p>�������û�������Լ���ͷ��ϵͳ����ʾΪĬ��ͷ����ѡ��һ��ͷ������Ϊ�Լ��ĸ���ͷ�� </p>\r\n" + 
					"</caption>\r\n" + 
					"<tbody><tr>\r\n" + 
					"<td><img class=\"nowicon\" src=\""+ icon +"\"></td>\r\n" + 
					"</tr>\r\n" + 
					"</tbody></table>\r\n" + 
					"\r\n" + 
					"<table cellspacing=\"0\" cellpadding=\"0\" class=\"tfm\">\r\n" + 
					"<caption>\r\n" + 
					"<h2 class=\"xs2\">�����ҵ���ͷ��</h2>\r\n" + 
					"<p>��ѡ��һ��ͷ�� </p>\r\n" + 
					"</caption>\r\n" + 
					"<tbody><tr>\r\n" + 
					"<td>\r\n";
			for(int i=0; i < allIcons.size(); i++) {
				result += "<input type=\"radio\" name = \"iconURL\" value='"+allIcons.get(i).getUrl()+"'><img src='"+ allIcons.get(i).getUrl() +"'>";
			}
					
					result+=
					"</td>\r\n" + 
					"</tr>\r\n" + 
					"</tbody></table>\r\n" + 
					"<input type=\"hidden\" name=\"userid\" value=\""+ id +"\">\r\n" + 
					"<input type=\"submit\">�ύ"+
					"</form>\r\n";

		}
		else if(mod.equals("allPost")) {
			int totalNum, totalPage;
			int thisPage = 1;
			int pageSize = 20;

			List<postBean> allPosts = new ArrayList<postBean>();
			List<postBean> posts = new ArrayList<postBean>();
			userBean user = new userBean();
			user.setUsername(name);
			postDAO postDao = new postDAO();
			allPosts = postDao.getAllUserPost(user);
			if(allPosts==null) {
				result="��û�з�����¼";
				}else {
			totalNum = allPosts.size();
			totalPage = totalNum / pageSize + 1;
			if (request.getParameter("page") != null && Integer.parseInt(request.getParameter("page")) <= totalPage
					&& Integer.parseInt(request.getParameter("page")) > 0) {
				thisPage = Integer.parseInt(request.getParameter("page"));
			}
			posts = postDao.getUserPagePost((thisPage - 1) * pageSize, pageSize,user);
			result +="<span>����"+ totalNum +"��</span></br>";
			for(int i = 0;i < totalPage;i++) {
				result+="<a href=\" Manage.do?mod=allPost&page="+ (i+1) +"\">["+ (i+1) +"]</a>";
			}
			result +="<div>"
					+ "<table cellspacing=\"10\">"
					+ "<tr class='headinfo'>"
					+ "<td>���ӱ���</td><td>����ʱ��</td><td>������</td>"
					+ "</tr>";
			for (int i = 0; i < posts.size(); i++) {
				result +="<tr>"
						+"<td><a href=\"GetForumIndex.do?postId=" + posts.get(i).getId()+"\">" + posts.get(i).getTitle() + "</a></td>"
						+"<td><em><span>" + posts.get(i).getReleaseDate() + "</span></em></td>"
						+"<td><span >" + posts.get(i).getFloor() + "</span></td>"
						+"</tr>";
			}
			result += "</table></div>"; 
				}
		}
		else if(mod.equals("allCom")) {
			int totalNum, totalPage;
			int thisPage = 1;
			int pageSize = 10;
			commentDAO commentDao = new commentDAO();
			userBean user = new userBean();
			user.setId(Integer.parseInt(id));
			user.setUsername(name);
			List<commentBean> allComments = commentDao.getComByUser(user);
			List<commentBean> comments = new ArrayList<commentBean>();
			if(allComments == null) {
				totalNum = 0;
			}else {
				totalNum = allComments.size();
			}
			if(allComments == null) {
				result="��û�з�����¼";
			}
			else {
			totalPage = totalNum / pageSize + 1;
			if (request.getParameter("page") != null && Integer.parseInt(request.getParameter("page")) <= totalPage
					&& Integer.parseInt(request.getParameter("page")) > 0) {
				thisPage = Integer.parseInt(request.getParameter("page"));
			}
			comments = commentDao.getPageCom((thisPage-1)*pageSize, pageSize,user);
			result +="<span>����"+ totalNum +"��</span>";
			for(int i = 0;i < totalPage;i++) {
				result+="<a href=\" Manage.do?mod=allCom&page="+ (i+1) +"\">["+ (i+1) +"]</a>";
			}
			result += "<table><tbody>";
			for(int i = 0;i <comments.size();i++) {
				result += "<tr><td>"
						+ "<a href = \"GetForumIndex.do?postId="+comments.get(i).getForumpostId() +"\">"+comments.get(i).getContent()+"</a>"
						+ "</td></tr>";
						
			}
			result += "</tbody></table>";
			}
		}
		else if(mod.equals("checkPost")) {
			int totalNum, totalPage;
			int thisPage = 1;
			int pageSize = 20;

			List<postBean> allPosts = new ArrayList<postBean>();
			List<postBean> posts = new ArrayList<postBean>();
			postDAO postDao = new postDAO();
			allPosts = postDao.getCheckingPost();
			if(allPosts==null) {
				result="û����Ҫ��˵ķ���";
				}else {
			totalNum = allPosts.size();
			totalPage = totalNum / pageSize + 1;
			if (request.getParameter("page") != null && Integer.parseInt(request.getParameter("page")) <= totalPage
					&& Integer.parseInt(request.getParameter("page")) > 0) {
				thisPage = Integer.parseInt(request.getParameter("page"));
			}
			posts = postDao.getPageCheckPost((thisPage - 1) * pageSize, pageSize);
			result +="<span>����"+ totalNum +"��</span></br>";
			for(int i = 0;i < totalPage;i++) {
				result+="<a href=\" Manage.do?mod=checkPost&page="+ (i+1) +"\">["+ (i+1) +"]</a>";
			}
			result +="<div>"
					+ "<table cellspacing=\"10\">"
					+ "<tr class='headinfo'>"
					+ "<td>���ӱ���</td><td>����ʱ��</td><td>¥��</td><td>����</td>"
					+ "</tr>";
			for (int i = 0; i < posts.size(); i++) {
				result +="<tr>"
						+"<td><a href=\"GetForumIndex.do?postId=" + posts.get(i).getId()+"\">" + posts.get(i).getTitle() + "</a></td>"
						+"<td><em><span>" + posts.get(i).getReleaseDate() + "</span></em></td>"
						+"<td><span >" + posts.get(i).getAuthor() + "</span></td>"
						+"<td><a href ='RemovePostCheck.do?id="+posts.get(i).getId()+"'>ͨ�����</a></td>"
						+"</tr>";
			}
			result += "</table></div>"; 
				}
		}
		else if(mod.equals("checkCom")) {
			int totalNum, totalPage;
			int thisPage = 1;
			int pageSize = 20;

			List<commentBean> allComments = new ArrayList<commentBean>();
			List<commentBean> comments = new ArrayList<commentBean>();
			commentDAO commentDao = new commentDAO();
			allComments = commentDao.getAllCheckCom();
			if(allComments==null) {
				result="û����Ҫ��˵�����";
				}else {
			totalNum = allComments.size();
			totalPage = totalNum / pageSize + 1;
			if (request.getParameter("page") != null && Integer.parseInt(request.getParameter("page")) <= totalPage
					&& Integer.parseInt(request.getParameter("page")) > 0) {
				thisPage = Integer.parseInt(request.getParameter("page"));
			}
			comments = commentDao.getCheckPageCom((thisPage - 1) * pageSize, pageSize);
			result +="<span>����"+ totalNum +"��</span></br>";
			for(int i = 0;i < totalPage;i++) {
				result+="<a href=\" Manage.do?mod=checkCom&page="+ (i+1) +"\">["+ (i+1) +"]</a>";
			}
			result +="<div>"
					+ "<table cellspacing=\"10\">"
					+ "<tr class='headinfo'>"
					+ "<td>��������</td><td>����ʱ��</td><td>����</td><td>����</td>"
					+ "</tr>";
			for (int i = 0; i < comments.size(); i++) {
				result +="<tr>"
						+"<td><a href=\"GetForumIndex.do?postId=" + comments.get(i).getForumpostId()+"\">" + comments.get(i).getContent() + "</a></td>"
						+"<td><em><span>" + comments.get(i).getReleaseDate() + "</span></em></td>"
						+"<td><span >" + comments.get(i).getAuthor() + "</span></td>"
						+"<td><a href ='RemoveComCheck.do?id="+comments.get(i).getId()+"'>ͨ�����</a></td>"
						+"</tr>";
			}
			result += "</table></div>"; 
				}
		}
		request.setAttribute("result", result);
		request.getRequestDispatcher("/manage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

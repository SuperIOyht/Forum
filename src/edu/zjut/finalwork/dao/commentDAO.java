package edu.zjut.finalwork.dao;
import java.util.*;
import edu.zjut.finalwork.model.*;
import java.sql.*;

public class commentDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bbssystem?characterEncoding=utf-8";
	private static final String ACCOUNT = "root";
	private static final String PASSWORD = "12345";
	public List<commentBean> getComByPost(postBean post) {
		Connection conn = null;
		try {
			List<commentBean> comments = new ArrayList<commentBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM comment where forumpostId = "+ post.getId()+" order by releaseDate ASC";
			//String sql = "SELECT * FROM comment where forumpostId = "+ post.getId()+" and checking = 0  order by releaseDate ASC";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				commentBean comment = new commentBean();
				comment.setAuthor(rs.getString("author"));
				comment.setReleaseDate(rs.getString("releaseDate"));
				comment.setChecking(rs.getBoolean("checking"));
				comment.setContent(rs.getString("content"));
				comment.setForumpostId(rs.getInt("forumpostId"));
				comments.add(comment);
			}
			return comments;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public List<commentBean> getComByUser(userBean user) {
		Connection conn = null;
		try {
			List<commentBean> comments = new ArrayList<commentBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM comment where author='"+ user.getUsername()+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				commentBean comment = new commentBean();
				comment.setAuthor(rs.getString("author"));
				comment.setReleaseDate(rs.getString("releaseDate"));
				comment.setChecking(rs.getBoolean("checking"));
				comment.setContent(rs.getString("content"));
				comment.setForumpostId(rs.getInt("forumpostId"));
				comments.add(comment);
			}
			return comments;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public List<commentBean> getAllCheckCom() {
		Connection conn = null;
		try {
			List<commentBean> comments = new ArrayList<commentBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM comment where checking = 1";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				commentBean comment = new commentBean();
				comment.setAuthor(rs.getString("author"));
				comment.setReleaseDate(rs.getString("releaseDate"));
				comment.setChecking(rs.getBoolean("checking"));
				comment.setContent(rs.getString("content"));
				comment.setForumpostId(rs.getInt("forumpostId"));
				comments.add(comment);
			}
			return comments;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public List<commentBean> getCheckPageCom(int begin,int pagesize){
		Connection conn = null;
		try {
			List<commentBean> comments = new ArrayList<commentBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM comment where checking = 1 order by releaseDate ASC limit "+begin+","+pagesize;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				commentBean comment = new commentBean();
				comment.setId(rs.getInt("id"));
				comment.setAuthor(rs.getString("author"));
				comment.setContent(rs.getString("content"));
				comment.setForumpostId(rs.getInt("forumpostId"));
				comment.setReleaseDate(rs.getString("releaseDate"));
				comment.setChecking(rs.getBoolean("checking"));
				comments.add(comment);
			}
			return comments;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public List<commentBean> getPageCom(int begin,int pagesize,postBean post){
		Connection conn = null;
		try {
			List<commentBean> comments = new ArrayList<commentBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM comment where forumpostId ="+post.getId()+" order by releaseDate ASC limit "+begin+","+pagesize;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				commentBean comment = new commentBean();
				comment.setId(rs.getInt("id"));
				comment.setAuthor(rs.getString("author"));
				comment.setContent(rs.getString("content"));
				comment.setForumpostId(rs.getInt("forumpostId"));
				comment.setReleaseDate(rs.getString("releaseDate"));
				comment.setChecking(rs.getBoolean("checking"));
				comments.add(comment);
			}
			return comments;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public List<commentBean> getPageCom(int begin,int pagesize,userBean user){
		Connection conn = null;
		try {
			List<commentBean> comments = new ArrayList<commentBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM comment where author ='"+user.getUsername()+"' order by releaseDate ASC limit "+begin+","+pagesize;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				commentBean comment = new commentBean();
				comment.setId(rs.getInt("id"));
				comment.setAuthor(rs.getString("author"));
				comment.setContent(rs.getString("content"));
				comment.setForumpostId(rs.getInt("forumpostId"));
				comment.setReleaseDate(rs.getString("releaseDate"));
				comment.setChecking(rs.getBoolean("checking"));
				comments.add(comment);
			}
			return comments;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public void changeComment(commentBean comment){
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE comment SET content = '"+comment.getContent()+"' where author ='" + comment.getAuthor()+"'";
			stmt.executeUpdate(sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public void setComment(commentBean comment) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="INSERT INTO comment(author,forumpostId,content,checking) VALUES ('"+comment.getAuthor()+"',"+ comment.getForumpostId()+",'"+comment.getContent()+"',0)";
			stmt.execute(sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally{
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public void setChecking(commentBean comment) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE comment SET checking = 1 where id =" + comment.getId();
			stmt.executeUpdate(sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	public void removeChecking(commentBean comment) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE comment SET checking = 0 where id =" + comment.getId();
			stmt.executeUpdate(sql);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}	
		}
	}
	
}

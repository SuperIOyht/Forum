package edu.zjut.finalwork.dao;
import java.util.*;
import edu.zjut.finalwork.model.*;
import java.sql.*;

public class postDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bbssystem?characterEncoding=utf-8";
	private static final String ACCOUNT = "root";
	private static final String PASSWORD = "12345";
	
	public List<postBean> getAllPost(){
		Connection conn = null;
		try {
			List<postBean> posts = new ArrayList<postBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where checking = 0 order by releaseDate DESC";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				postBean post = new postBean();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
				posts.add(post);
			}
			return posts;
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
	public List<postBean> getAllUserPost(userBean user){
		Connection conn = null;
		try {
			List<postBean> posts = new ArrayList<postBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where checking = 0 and author = '"+user.getUsername() +"' order by releaseDate DESC";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				postBean post = new postBean();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
				posts.add(post);
			}
			return posts;
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
	public List<postBean> getPagePost(int begin,int pagesize){
		Connection conn = null;
		try {
			List<postBean> posts = new ArrayList<postBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where checking = 0 order by releaseDate DESC limit "+begin+","+pagesize;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				postBean post = new postBean();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
				posts.add(post);
			}
			return posts;
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
	public List<postBean> getUserPagePost(int begin,int pagesize,userBean user){
		Connection conn = null;
		try {
			List<postBean> posts = new ArrayList<postBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where checking = 0 and author = '"+ user.getUsername() +"' order by releaseDate DESC limit "+begin+","+pagesize;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				postBean post = new postBean();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
				posts.add(post);
			}
			return posts;
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
	public postBean getPostById(int id){
		Connection conn = null;
		postBean post = new postBean();
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where checking = 0 and id = "+ id;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
			}
			return post;
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
	public postBean getPostByIdForAdmin(int id){
		Connection conn = null;
		postBean post = new postBean();
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where id = "+ id;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
			}
			return post;
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
	public List<postBean> getCheckingPost() {
		Connection conn = null;
		postBean post = new postBean();
		try {
			List<postBean> posts = new ArrayList<postBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where checking = 1 ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
				posts.add(post);
			}
			return posts;
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
	public List<postBean> getPageCheckPost(int begin,int pagesize){
		Connection conn = null;
		try {
			List<postBean> posts = new ArrayList<postBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where checking = 1 order by releaseDate DESC limit "+begin+","+pagesize;
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				postBean post = new postBean();
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
				posts.add(post);
			}
			return posts;
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
	public void addPost(postBean post) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="INSERT INTO forumpost(title, content, floor, author, checking) VALUES ('"+post.getTitle()+"','"+ post.getContent()+"', 0 ,'"+post.getAuthor()+"',0)";
			stmt.execute(sql);
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
	public void setChecking(postBean post) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE forumpost SET checking = 1 where id =" + post.getId();
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
	public Boolean isChecking(postBean post) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, ACCOUNT,
					PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM forumpost where id = "+ post.getId();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				post.setId(rs.getInt("id"));
				post.setTitle(rs.getString("title"));
				post.setContent(rs.getString("content"));
				post.setFloor(rs.getInt("floor"));
				post.setReleaseDate(rs.getString("releaseDate"));
				post.setAuthor(rs.getString("author"));
				post.setChecking(rs.getBoolean("checking"));
			}
			if(post.isChecking()) {
				return true;
			}else {
				return false;
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
			return false;
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
	public void removeChecking(postBean post) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE forumpost SET checking = 0 where id =" + post.getId();
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
	public void addFloor(postBean post) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE forumpost SET floor=" + (post.getFloor()+1) + " where id =" + post.getId();
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
	public void changeTitle(postBean post) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE forumpost SET title = '"+ post.getTitle() +"' where id =" + post.getId();
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
	public void changeContent(postBean post) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE forumpost SET content = '"+ post.getContent() +"' where id =" + post.getId();
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

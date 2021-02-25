package edu.zjut.finalwork.dao;

import java.util.*;
import edu.zjut.finalwork.model.*;
import java.sql.*;

public class userDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bbssystem?characterEncoding=utf-8";
	private static final String ACCOUNT = "root";
	private static final String PASSWORD = "12345";
	public userBean validLogin(String name, String password) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="SELECT * FROM userdata where username = '"+ name +"'and password = '"+ password +"'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				userBean user = new userBean();
				user.setId(rs.getInt("id"));
				user.setIsadmin(rs.getBoolean("isadmin"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("phoneNumber"));
				user.setRegisterDate(rs.getString("registerDate"));
				user.setIcon(rs.getString("icon"));
				return user;
			}else {
				return null;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return null;
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
	public boolean validAdmin(String name) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="SELECT * FROM userdata where username = '"+ name +"','isAdmin = 1";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
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
	public void setAdmin(userBean user) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql ="UPDATE userdata SET isAdmin = 1 where id =" + user.getId();
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
	public void registerUser(String name,String password,String email,String phoneNumber) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO userdata(username, password, phoneNumber, email, isadmin) VALUES ('"+name+"','"+password+"','"+phoneNumber+"','"+email+"',0)";
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
	public boolean validHasSameName(String name) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM userdata where username = '"+ name+ "'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return true;
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
	public void setIcon(String iconURL,int id) {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "UPDATE userdata SET icon = '"+ iconURL + "' where id = "+id;
			stmt.executeUpdate(sql);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public String getIcon(String username) {
		Connection conn = null;
		String icon = "img/defaulticon.png";
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM userdata where username = '"+ username+ "'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				icon = rs.getString("icon");
			}
			return icon;
		}catch(Exception ex) {
			ex.printStackTrace();
			return icon;
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
	public String getIcon(int id) {
		Connection conn = null;
		String icon = "img/defaulticon.png";
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM userdata where id = "+ id;
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				icon = rs.getString("icon");
			}
			return icon;
		}catch(Exception ex) {
			ex.printStackTrace();
			return icon;
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
	public userBean getUserByName(String username) {
		Connection conn = null;
		userBean user = new userBean();
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM userdata where username = '"+ username+ "'";
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				user.setUsername(rs.getString("username"));
				user.setId(rs.getInt("id"));
				user.setIsadmin(rs.getBoolean("isadmin"));
				user.setIcon(rs.getString("icon"));
			}
			return user;
		}
		catch(Exception ex){
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
}

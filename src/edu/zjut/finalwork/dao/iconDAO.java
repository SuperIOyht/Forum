package edu.zjut.finalwork.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.zjut.finalwork.model.commentBean;
import edu.zjut.finalwork.model.iconBean;


public class iconDAO {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bbssystem?characterEncoding=utf-8";
	private static final String ACCOUNT = "root";
	private static final String PASSWORD = "12345";
	public List<iconBean> getAllIcon() {
		Connection conn = null;
		try {
			List<iconBean> icons = new ArrayList<iconBean>();
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL,ACCOUNT,PASSWORD);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM icon ";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				iconBean icon = new iconBean();
				icon.setId(rs.getInt("id"));
				icon.setUrl(rs.getString("url"));
				icons.add(icon);
			}
			return icons;
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
}

package com.ceshi.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn = null;
	private static String url = "jdbc:mysql://192.168.85.44:3306/fieldworkmarket";
	private static String username = "root";
	private static String password = "000000";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}

	public static void closeConnection(Connection conn) {
		if (conn != null) {
           try {      	   
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public static void main(String[] args) {
		Connection connection = DBUtil.getConnection();
        String sql = "select enterprise_id from t_enterprise_client";
        PreparedStatement prepareStatement;
		try {
			prepareStatement = connection.prepareStatement(sql);
			ResultSet r = prepareStatement.executeQuery();
			while(r.next()){
				String id = r.getString("enterprise_id");
				System.out.println(id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} 
		
	}
}

package com.Ep.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//Singleton class
public class DBconnect {

	private static DBconnect single;

	public Connection getConnection() {
		Connection con = null;
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = (Connection) DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/ep?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&allowPublicKeyRetrieval=true&useSSL=false");
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static DBconnect getInstance() {
		return (single == null) ? single = new DBconnect() : single;
	}
}

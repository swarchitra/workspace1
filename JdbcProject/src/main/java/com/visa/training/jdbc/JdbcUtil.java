package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
// don't import com.mysql

public class JdbcUtil {

	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/visa", "visa", "secret");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

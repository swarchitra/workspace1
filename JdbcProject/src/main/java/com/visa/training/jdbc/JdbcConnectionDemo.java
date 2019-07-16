package com.visa.training.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

public class JdbcConnectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = JdbcUtil.getConnection();
		try {
			DatabaseMetaData metaData = c.getMetaData();
			System.out.println("Product is " + metaData.getDatabaseProductName());
			System.out.println("Version is " + metaData.getDatabaseProductVersion());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

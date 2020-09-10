package com.learning.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
		private static Database db = new Database();
		private static final String URL = "jdbc:mysql://localhost:3306/people";
		
		private static Connection conn;
		
		public static Database instance() {
			return db;
		}
		
		private Database() {
			
		}
		
		public void connect() throws SQLException {
			 conn = DriverManager.getConnection(URL , "root" , "e386c34b");
		}
		
		public void close() throws SQLException {
			conn.close();
		}
		
}

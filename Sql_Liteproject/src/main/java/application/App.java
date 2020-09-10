package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int[] ids = {0 , 1 ,2};
		String[] names = {"sue" , "bob" , "charlie"};
		
		
		//Class.forName("org.sqlite.JDBC");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String dbUrl = "jdbc:mysql://localhost:3306/people";
		Connection conn = DriverManager.getConnection(dbUrl , "root" , "e386c34b");
		
		Statement stmt = conn.createStatement();
		
		conn.setAutoCommit(false);
				
		var sql = "insert into user (id , name) values (? , ?)";
		
		var insertStmnt = conn.prepareStatement(sql);
		for(int i=0 ; i<ids.length ; i++) {
			insertStmnt.setInt(1, ids[i]);
			insertStmnt.setString(2, names[i]);
			
			//insertStmnt.executeUpdate();
		}
		conn.commit();
		insertStmnt.close();
		
		sql = "select id  , name from user";
		var rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			
			System.out.println(id + " " + name);
		}
		
				stmt.close();
		
		conn.close();

	}

}

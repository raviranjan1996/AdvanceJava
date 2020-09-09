package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		int[] ids = {0 , 1 ,2};
		String[] names = {"sue" , "bob" , "charlie"};
		
		
		Class.forName("org.sqlite.JDBC");
		String dbUrl = "jdbc:sqlite:people.db";
		Connection conn = DriverManager.getConnection(dbUrl);
		
		Statement stmt = conn.createStatement();
		
		conn.setAutoCommit(false);
		var sql = "create table if not exists user (id integer primary key , name text not null)";
		stmt.execute(sql);
		
		sql = "insert into user (id , name) values (? , ?)";
		
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
		
		sql = "drop table user";
		//stmt.execute(sql);
		stmt.close();
		
		conn.close();

	}

}

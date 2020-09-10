package com.learning.mysql;

import java.sql.SQLException;

public class App 
{
    public static void main( String[] args )
    {
       
        
        var db = Database.instance();
        try {
        	db.connect();
        }
        catch(SQLException e) {
        	System.out.println("Cannot connect to the db");
        }
        System.out.println("connected");
        try {
			db.close();
		} catch (SQLException e) {
			System.out.println("cannot close the db");
			e.printStackTrace();
		}
        
        
    }
}

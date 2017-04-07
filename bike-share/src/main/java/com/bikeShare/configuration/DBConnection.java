package com.bikeShare.configuration;

import java.sql.Connection;
import java.sql.DriverManager;

	public class DBConnection {
	    public static Connection getConnection() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sp_bikeshare","root", "");
	            return con;
	        } catch (Exception ex) {
	            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
	            return null;
	        }
	    }
	 
	    public void close(Connection con) {
	        try {
	            con.close();
	        } catch (Exception ex) {
	        }
	    }
	}
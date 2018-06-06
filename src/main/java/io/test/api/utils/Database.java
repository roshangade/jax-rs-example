package io.test.api.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.inject.Singleton;

@Singleton
public class Database {
	
	//TODO: load configuration per environment
	private final String url = "jdbc:postgresql://localhost:5433/demo";
    private final String user = "postgres";
    private final String password = "test123";
    
    private Statement db = null;
    
    public Database() {
    	try {
    		System.out.println("Connecting db...");
			Class.forName("org.postgresql.Driver");
			db = DriverManager.getConnection(url, user, password).createStatement();
		} catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
			// TODO: handle exception
		}
    }
    
    public ResultSet execute(String query) throws SQLException {
    	return db.executeQuery(query);
    }
    
}

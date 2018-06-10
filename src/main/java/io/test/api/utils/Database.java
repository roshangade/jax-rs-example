package io.test.api.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.inject.Singleton;

@Singleton
public class Database {

	// TODO: load configuration per environment
	private final String url = "jdbc:postgresql://localhost:5433/demo";
	private final String user = "postgres";
	private final String password = "test123";

	private Connection db = null;

	public Database() {
		try {
			System.out.println("Connecting db...");
			Class.forName("org.postgresql.Driver");
			db = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			// TODO: handle exception
		}
	}

	public ResultSet find(String query) throws SQLException {
		return db.createStatement().executeQuery(query);
	}

	public void write(String sql, ArrayList<Object> data) throws SQLException {
		PreparedStatement stmt = db.prepareStatement(sql);
		int i = 1;
		for (Object d : data) {
			stmt.setObject(i++, d);
		}
		stmt.executeUpdate();
	}

}

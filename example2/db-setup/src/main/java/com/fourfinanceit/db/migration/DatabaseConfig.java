package com.fourfinanceit.db.migration;

import com.dieselpoint.norm.Database;

public class DatabaseConfig {

	private final Database db;

	public DatabaseConfig(String url, String port, String databaseName, String user, String password) {
		db = new Database();
		db.setJdbcUrl("jdbc:mysql://" + url + ":" + port + "/" + databaseName + "?parseTime=true&useSSL=false");
		db.setUser(user);
		db.setPassword(password);
	}

	public Database db() {
		return db;
	}
}

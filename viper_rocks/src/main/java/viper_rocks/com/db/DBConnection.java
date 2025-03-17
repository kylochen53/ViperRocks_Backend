package viper_rocks.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(
				DBConfig.getUrl(),
				DBConfig.getUser(),
				DBConfig.getPassword()
				);
				
	}
}

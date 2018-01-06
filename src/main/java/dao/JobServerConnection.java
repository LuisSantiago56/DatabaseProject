package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.Controller;

public class JobServerConnection {

	private final static Logger logger = LogManager.getLogger(Controller.class);
	private String username = "appusr";
	private String password = "appusr";
	private String dbname = "appdb2";
	
	public Connection jobServerInit() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			logger.info("There is no Postgresql Driver in library path.");
		}
		try {
			return conn = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/" + dbname, username, password);
		} catch (SQLException e) {
			logger.info("Connection failed.");
			return null;
		}
		
	}
}

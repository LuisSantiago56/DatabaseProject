package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.Controller;

public class JobServerConnection {

	private final static Logger logger = LogManager.getLogger(Controller.class);
	private String username = "root";
	private String password = "123pescao";
	private String dbname = "drdb";
	
	public Connection jobServerInit() {
		Connection conn = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			logger.info("There is no Postgresql Driver in library path.");
		}
		try {
			return conn = DriverManager.getConnection(
					"jdbc:postgresql://dr.cewezyn180mr.us-east-2.rds.amazonaws.com:5432/" + dbname +"?user="+username+"&password="+password);
					//"jdbc:postgresql://localhost:5432/" + dbname +"?user="+username+"&password="+password);
		} catch (SQLException e) {
			logger.info("Connection failed.");
			return null;
		}
		
	}
}

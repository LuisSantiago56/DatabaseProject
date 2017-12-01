package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class JobServerConnection {

	public String jobServerConnection() {
		
		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return "Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!";

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://127.0.0.1:5432/appdb", "appusr",
					"appusr");
			System.out.println("PostgreSQL JDBC Connected!");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return "Connection Failed! Check output console";

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
		
		return "PostgreSQL JDBC Connected!";
	}
}

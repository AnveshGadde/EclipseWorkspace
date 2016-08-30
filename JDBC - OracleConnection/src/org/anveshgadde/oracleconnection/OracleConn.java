package org.anveshgadde.oracleconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConn {

	public static void main(String[] args) {

		try {

			// Loading the driver class and specifying class name
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Creating the connection object
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@san-dev-ora-03:1521:SANSIT101",
					"san_dit_rptaggr52_admin", "san_dit_rptaggr52_admin");

			// Creating a statement object to execute
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			// Query
			ResultSet rs = stmt.executeQuery("Select * from deployment Order by id desc");

			System.out.println("Results deprived from Oracle Database are.......");

			rs.absolute(4);
			System.out.println(rs.getInt(1) + " : " + rs.getString(2).toUpperCase());

			conn.close();

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found exception failed due to: " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("SQL exception failed due to: " + e.getMessage());
		}
	}
}

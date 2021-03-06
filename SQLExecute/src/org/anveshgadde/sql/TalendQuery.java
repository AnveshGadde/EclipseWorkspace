package org.anveshgadde.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TalendQuery {

	String tOracleConn = "jdbc:oracle:thin:@san-dev-ora-03:1521:SANSIT101";

	java.sql.Connection conn = null;

	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String DB_URL = "jdbc:oracle:thin:@torsav-prod-ora-03:1521:SAVDW102";

	static final String USER = "SAV_RPT53_READ";
	static final String PASS = "SAV_RPT53_READ";

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		try {

			// Registering JDBC Driver for connection
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Opening a connection
			System.out.println("Connecting to Database.....");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// Executing the Query
			System.out.println("Creating statement......");
			stmt = conn.createStatement();
			String sql;
			sql = "Select SCHEMA_FILE_NAME , SCHEMA_FILE FROM REPORTING_EVENT_VERSION WHERE version not IN (0) AND event_id = 2";
			ResultSet rs = stmt.executeQuery(sql);

			int i = 0;
			// Data display

			while (i <= 10 && rs.next()) {
				int id = rs.getInt("id");
				int deployment_id = rs.getInt("deployment_id");
				String run_status = rs.getString("run_status");

				System.out.println("Id: " + id);
				System.out.println("Dep_Id: " + deployment_id);
				System.out.println("Run_Status: " + run_status);
				i++;
			}

			// Clean-up environment

			rs.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Connection Ended!");
	}
}

package org.anveshgadde.sql;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OraclePreprdStmt {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@san-dev-ora-03:1521:SANSIT101";
	private static final String DB_USER = "san_dit_rptaggr52_admin";
	private static final String DB_PASSWORD = "san_dit_rptaggr52_admin";

	public static void main(String[] argv) {

		try {
			updateRecordToTable();
		} catch (SQLException e) {

			System.out.println("From main method: " + e.getMessage());
		}
	}

	private static void updateRecordToTable() throws SQLException {

		Connection dbConn = null;
		PreparedStatement preparedStatement = null;

		String updateTableSQL = "Select SCHEMA_FILE_NAME , SCHEMA_FILE FROM REPORTING_EVENT_VERSION WHERE version not IN (0) AND event_id %s";

		try {
			
			dbConn = getDBConnection();
			preparedStatement = dbConn.prepareStatement(updateTableSQL);

			preparedStatement.setBigDecimal(1, new BigDecimal(153510));
			preparedStatement.setBigDecimal(2, new BigDecimal(153511));
			preparedStatement.setBigDecimal(3, new BigDecimal(153512));
			preparedStatement.setBigDecimal(4, new BigDecimal(153513));
			preparedStatement.setBigDecimal(5, new BigDecimal(153514));
			preparedStatement.setBigDecimal(6, new BigDecimal(153510));
			preparedStatement.setBigDecimal(7, new BigDecimal(153511));
			preparedStatement.setBigDecimal(8, new BigDecimal(153512));
			preparedStatement.setBigDecimal(9, new BigDecimal(153513));
			preparedStatement.setBigDecimal(10, new BigDecimal(153514));
			
			
			
			// execute statement

			preparedStatement.executeUpdate();

			System.out.println("Records have been updated in JOB_STATUS Table!");

		} catch (SQLException e) {
			System.out.println("SQL Exception: " +e.getMessage());
			System.out.println(e.getLocalizedMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConn != null) {
				dbConn.close();
			}

		}

	}

	private static Connection getDBConnection() {

		Connection dbConn = null;

		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("From getDBConn: " + e.getMessage());
		}

		try {
			dbConn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

			return dbConn;
		} catch (SQLException e) {
			System.out.println("From driverMngr: " + e.getMessage());
		}

		return dbConn;
	}

}

/**
 * 
 */
package org.anveshgadde.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author anveshg
 *
 */
public final class Query {

	private Object[] headers;
	private Object[][] data;
	@SuppressWarnings("unused")
	private final String query;
	private final Connection connection;

	public Query(Connection connection, String query) throws SQLException {
		// TODO Auto-generated constructor stub

		this.query = query;
		this.connection = connection;

		getQueryResults();
	}

	public Object[] getHeaders() {
		return this.headers;
	}

	public Object[][] getData() {
		return this.data;
	}

	private void getQueryResults() throws SQLException {

		Statement stmt = null;
		ResultSet rs;

		ArrayList<Object> tempTable = new ArrayList<>();

		ArrayList<Object> tempRow;

		try {
			stmt = connection.createStatement();

			String query = "";
			rs = stmt.executeQuery(query);

			ResultSetMetaData rsmd = rs.getMetaData();

			int columnCount = rsmd.getColumnCount();

			headers = new String[columnCount];

			for (int i = 1; i < columnCount; i++) {

				String name = rsmd.getColumnName(i);
				headers[i - 1] = name;
			}

			int row = 0;

			while (rs.next()) {
				tempRow = new ArrayList<>();

				for (int i = 0; i < columnCount; i++) {

					String r = rs.getString(i + 1);
					tempRow.add(r);
				}

				row++;

				tempTable.add(tempRow);
			}

			data = new Object[row][columnCount];

			for (int rowi = 0; rowi < tempTable.size(); rowi++) {
				@SuppressWarnings("unchecked")
				ArrayList<Object> rr = (ArrayList<Object>) tempTable.get(rowi);
				for (int i = 0; i < columnCount; i++) {
					data[rowi][i] = rr.get(i);
				}
			}

		} catch (SQLException e) {
			SQLExceptionPrint(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}

	}

	private void SQLExceptionPrint(SQLException sqle) {
		// TODO Auto-generated method stub
		while (sqle != null) {
			System.out.println("\n---SQLException Caught---\n");
			System.out.println("SQLState: " + (sqle).getSQLState());
			System.out.println("Severity: " + (sqle).getErrorCode());
			System.out.println("Message: " +(sqle).getMessage());
			sqle.printStackTrace();
			sqle = sqle.getNextException();
		}

	}
}

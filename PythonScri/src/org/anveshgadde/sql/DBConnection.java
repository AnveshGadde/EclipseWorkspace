/**
 * 
 */
package org.anveshgadde.sql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.TimeZone;

/**
 * @author anveshg
 *
 */
public class DBConnection {

	Properties prop = new Properties();

	public DBConnection(String propFilePath) throws FileNotFoundException, IOException {
		// TODO Auto-generated constructor stub

		prop.load(new FileInputStream(propFilePath));
	}

	public static Connection connectDB(Environment environment) throws Exception {

		@SuppressWarnings("unused")
		Connection connection;

		switch (environment) {
		case DIT:
			connection = DBConnection.getDITRPTOracle();
			break;

		case SIT:
			connection = DBConnection.getSITRPTOracle();
			break;

		case PROD:
			connection = DBConnection.getProdRPTOracle();
			break;

		default:
			throw new InvalidParameterException("Unknown environment: '" + environment + "'");
		}

		return null;

	}

	public static java.sql.Connection getDITRPTOracle() throws SQLException {
		// TODO Auto-generated method stub

		@SuppressWarnings("unused")
		Connection conn;

		TimeZone timeZone = TimeZone.getTimeZone("GMT");

		TimeZone.setDefault(timeZone);

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(-1);
		}

		return conn = DriverManager.getConnection("jdbc:oracle:thin:@san-dev-ora-03:1521:DIT", "san_dit_rptaggr52_admin", "san_dit_rptaggr52_admin");
	}

	public static Connection getSITRPTOracle() throws SQLException {
		// TODO Auto-generated method stub

		@SuppressWarnings("unused")
		Connection conn;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.exit(-1);
		}

		return conn = DriverManager.getConnection("jdbc:oracle:thin:@san-dev-ora-01:1521:SIT", "san_rpt53_read", "san_rpt53_read");
	}

	public static java.sql.Connection getProdRPTOracle() throws Exception {
		Connection conn;

		TimeZone timeZone = TimeZone.getTimeZone("GMT");

		TimeZone.setDefault(timeZone);

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {
			System.exit(-1);
		}

		conn = DriverManager.getConnection("jdbc:oracle:thin:@10.82.0.12:1521:SAVDW102", "SAV_RPT53_READ", "SAV_RPT53_READ");
		return conn;

	}

}

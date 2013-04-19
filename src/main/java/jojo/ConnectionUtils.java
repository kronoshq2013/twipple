package jojo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtils {
	private static String RESOURCE_NAME = "java:comp/env/jdbc/oracle";
	private static String ERROR_MESSAGE = "ルックアップリソース名が違うか、JDBCドライバがクラスパスにロードされていません";
	
	public static Connection getConnection() throws SQLException {
		Connection con = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup(RESOURCE_NAME);
			con = ds.getConnection();
		} catch (NamingException e) {
			String message = ERROR_MESSAGE;
			throw new SQLException(e.getMessage() + message);
		}
		return con;
	}
}

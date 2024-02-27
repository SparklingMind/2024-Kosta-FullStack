package db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 로드, 연결, 닫기, 제공
 */
public class DBmanager {

	/**
	 * 로드
	 */
	static {
		try {
			Class.forName(DBProperties.DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 연결
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DBProperties.URL, DBProperties.USER_ID, DBProperties.USER_PASS);
	}

	/**
	 * 닫기(DML, DDL인 경우)
	 */

	public static void dbClose(Connection con, Statement st) {

		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {                                                         
			e.printStackTrace();
		}

	}

	/**
	 * 닫기(Select인 경우)
	 */
	public static void dbClose(Connection con, Statement st, ResultSet rs) {

		try {
			if (rs != null) rs.close();
			dbClose(con, st);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}


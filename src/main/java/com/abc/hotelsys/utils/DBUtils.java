/**
 *
 */
package com.abc.hotelsys.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author joeyang-ong
 *
 */
public class DBUtils {

	private static final String CONN_URL
			="jdbc:mysql://localhost:3306/db2104?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
	private static final String USERNAME="d2104user";
	private static final String PWD = "abc123";

	public static Connection getConn(){

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(CONN_URL,USERNAME,PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	/**
	 * ÊÍ·Å×ÊÔ´
	 * @param conn
	 * @param pstmt
	 * @param rset
	 */
	public static void releaseRes(Connection conn,PreparedStatement pstmt, ResultSet rset){


		try {
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}

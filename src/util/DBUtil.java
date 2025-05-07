package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.InputStream;
import java.util.Properties;

public class DBUtil {

	// DB 연결
	public static Connection getConnection() {
		Connection conn = null;

		try (InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
			Properties prop = new Properties();
			prop.load(input);

			String url = prop.getProperty("db.url");
			String userid = prop.getProperty("db.user");
			String userpass = prop.getProperty("db.password");

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, userid, userpass);

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println("db.properties 파일을 읽을 수 없습니다.");
			e.printStackTrace();
		}

		return conn;
	}

	// DB 연결 해제
	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (st != null) st.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class sqlconnection {
	public static void main(String[] args) {
		Connection con = null;
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/world";
			String username = "root";
			String password = "tiger";
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection Succes");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

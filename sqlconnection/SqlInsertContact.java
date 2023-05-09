package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SqlInsertContact {

	private void insertContactWithStatement(Connection con) {
		Statement st = null;
		String[] cates = { "friend", "family", "coworker", "etc" };
		Random rd = new Random();
		int totcnt = 1000000;

		try {
			st = con.createStatement();
			for (int i = 0; i <= totcnt; i++) {
				String name = "name" + i;
				String cate = cates[rd.nextInt(4)];
				String addr = "addr" + i;
				String company = "company" + i;
				String birth = String.format("%4d-%02d-%02d", rd.nextInt(1950, 2023), rd.nextInt(1, 13),
						rd.nextInt(1, 29));
				String phone = "010-"+String.format("%4d-%4d", rd.nextInt(1000,9999), rd.nextInt(1000,9999));
				String sql = String.format("insert into contact (cid, cname, type, adress, work, birthday, phone)"
						+ "values (%d, '%s', '%s', '%s', '%s', '%s', '%s')", i, name, cate, addr, company, birth, phone);
				System.out.println(String.format("%.2f:%d/%d", i * 100 / (double) totcnt, i, totcnt));
				//System.out.println(sql);
				st.executeUpdate(sql);
			}
		} catch (SQLException e) {
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
	
	public static void main(String[] args) {
		Connection con = null;
		SqlInsertContact ic = new SqlInsertContact();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "scott", "");
			System.out.println("DB 연결");
			ic.insertContactWithStatement(con);
		} catch(Exception e) {
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

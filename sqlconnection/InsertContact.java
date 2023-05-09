package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class InsertContact {

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
				String sql = String.format("insert into contact (cid, cname, type, adress, work, birthday)"
						+ "values (%d, '%s', '%s', '%s', '%s', '%s')", i, name, cate, addr, company, birth);
				System.out.println(String.format("%.2f:%d/%d", i * 100 / (double) totcnt, i, totcnt));
				System.out.println(sql);
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
//	private boolean connectDB() {
//		Connection con = null;
//		try {
//			Class.forName("org.h2.Driver");
//			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/telephone", "scott", "tiger");
//			System.out.println("DB 연결");
//			return ;
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		return ;
//	}

	public static void main(String[] args) {
		Connection con = null;
		InsertContact ic = new InsertContact();
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/telephone", "scott", "tiger");
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

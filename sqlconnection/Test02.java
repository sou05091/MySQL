package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

//Statement : 완결된 Qurey문장을 실행할 떄
//PreparedStatement : 변수로 값을 추가할수 있는 Qurey문을 실행할 떄
//select ==> exeuteQuery : "PrepareStatement = Statment
//insert/delete/update ==> exeuteUpdate : preparedStatment, STatment

public class Test02 {
	Connection con = null;

	private void insertDeptStatement(String dno, String dname, int budget) {

		String sql = String.format("insert into dept (dno, dname, budget) values ('%s','%s','%d')", dno, dname, budget);
		try {
			Statement ps = con.createStatement();
			ps.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB 입력되었습니다.");
	}

	private void insertDept(String dno, String dname, int budget) {
		String sql = "insert into dept (dno, dname, budget) values (?,?,?)";
		// String sql = String.format("insert into dept (dno, dname, budget) values
		// ('%s','%s','%d')",dno,dname,budget);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dno);
			ps.setString(2, dname);
			ps.setInt(3, budget);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB 입력되었습니다.");
	}

	private boolean connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "scott", "");
			System.out.println("DB 연결되었습니다.");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	private void closeDB() {
		try {
			con.close();
			System.out.println("DB 닫혔습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void deleteDepttriggerStatement(int from, int to) {
		try {
			Statement ps = con.createStatement();
			int cnt = ps.executeUpdate(String.format("delete from depttrigger where %d <= id and id <= %d", from, to));
			System.out.println("DB" + cnt + "개가 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deleteDepttriggerPreparedStatement(int from, int to) {
		// String sql = "insert into dept (dno, dname, budget) values (?,?,?)";
		String sql = "delete from depttrigger where ? <= id and id <= ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, from);
			ps.setInt(2, to);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("DB 삭제되었습니다.");
	}

	private void updateDeptStatement(String dno, String dname, int budget) {
		try {
			Statement ps = con.createStatement();
			int cnt = ps.executeUpdate(
					String.format("update dept set dname = '%s', budget = '%d' where dno = '%s'", dname, budget, dno));
			System.out.println("DB" + cnt + "개가 업데이트되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void updateDeptPreparedStatement(String dno, String dname, int budget) {
		try {
			PreparedStatement ps = con.prepareStatement("update dept set dname=?, budget =? where dno =?");
			ps.setString(1, dname);
			ps.setInt(2, budget);
			ps.setString(3, dno);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Test02 tt = new Test02();
		if (tt.connectDB()) {
//			tt.insertDeptStatement("D6", "kim", 24);
//			tt.deleteDepttriggerPreparedStatement(8, 10);
			tt.updateDeptStatement("d1", "home", 10);
			tt.closeDB();
		}
	}
}

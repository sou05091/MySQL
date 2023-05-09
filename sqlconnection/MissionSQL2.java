package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Scanner;

class SQLexe1 {
	int num;
	String text;

	SQLexe1(int num, String text) {
		this.num = num;
		this.text = text;
	}

	int getNum() {
		return num;
	}

	String getText() {
		return text;
	}
}

public class MissionSQL2 {

	public static void main(String[] args) {
		ArrayList<SQLexe1> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		list.add(new SQLexe1(1, "번 문제 : London 프로잭트 이름"));
		list.add(new SQLexe1(2, "번 문제 : 프로젝트 j1 공급자 이름"));
		while (true) {
			System.out.println("선택<0 = exit>");
			int sel = sc.nextInt();
			for (SQLexe1 qe : list) {
				System.out.println(String.format("%d, %s", qe.getNum(), qe.getText()));
			}
			if (sel == 1) {
				sqlexe(1,"select jno, jname, city from j where city = 'London'");
			} else if (sel == 2) {
				sqlexe(2,"select spj.jno, spj.sno, s.sname from spj, s where spj.sno = s.sno");
			} else if (sel == 99) {
				String input = sc.next();
				sqlexe(99, input);
			}
			else if (sel == 0) {
				break;
			}
		}
		
	}

	private static void sqlexe(int num, String text) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "scott", "");
			pstmt = con.prepareStatement(text);
			System.out.println("DB 연결");
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();
			while (rs.next()) {
				if (num == 1) {
				System.out.println(String.format("jno: %s, jname: %s, city: %s",rs.getString("jno"), rs.getString("jname"), rs.getString("city")));
				}else if (num == 2)
				System.out.println(String.format("%s,%s,%s", rs.getString("sno"), rs.getString("jno"), rs.getString("sname")));
				else {
					for(int i = 1; i <= numColumns; i++) {
						String columnName = rsmd.getColumnName(i); 
						String columnType = rsmd.getColumnName(i);
						if(columnType.equals("VARCHAR") || columnType.equals("CHAR")) {
							String value = rs.getString(i);
							System.out.println(columnName + ": " + value);
						}else if (columnType.equals("INTEGER") || columnType.equals("DECIMAL")) {
							int value = rs.getInt(i);
							System.out.println(columnName + ": " + value);
						}else {
							System.out.println(columnName + ": " + "Unsupported");
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
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

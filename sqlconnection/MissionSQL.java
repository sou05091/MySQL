package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;


class QueryExe {
	int num;
	String text;
	QueryExe(int num, String text) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/warehouse", "scott", "");
			pstmt = con.prepareStatement(text);
			pstmt.executeQuery();
			System.out.println("DB 연결");
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

public class MissionSQL {
	public static void main(String[] args) {
		
		ArrayList<QueryExe> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		list.add(new QueryExe(1,"select jno, jname, city from j where city = 'London'"));
		while (true) {
			System.out.println("선택<0 = exit>");
			int sel = sc.nextInt();
			for (QueryExe qe : list) {
				System.out.println(String.format("%d, %s", qe.getNum(), qe.getText()));
			} if (sel == 1) {
				
			}
			else if (sel == 0)
				break;
		}
	}
}

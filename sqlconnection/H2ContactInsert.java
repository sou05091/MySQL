package sqlconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class H2ContactInsert {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/telephone", "scott", "tiger");
            pstmt = conn.prepareStatement("INSERT INTO contact (CID, cname, type, adress, work, birthday) VALUES (?, ?, ?, ?,?,?)");
            
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("id를 입력하세요: ");
            int num = scanner.nextInt();
            pstmt.setInt(1, num);
            
            System.out.print ("이름을 입력하세요: ");
            String cname = scanner.next();
            pstmt.setString(2, cname);
            
            System.out.print("분류를 입력하세요 (분류 종류 : friend, coworker, family, etc)");
            String type = scanner.next();
            pstmt.setString(3, type);
            
            System.out.print("주소를 입력하세요");
            String adress = scanner.next();
            pstmt.setString(4, adress);
            
            System.out.print("직장을 입력하세요");
            String work = scanner.next();
            pstmt.setString(5, work);
            
            System.out.print("생일을 입력해주세요 예시(1999-01-04)");
            String birthday = scanner.next();
            Date dd = Date.valueOf(birthday);
            pstmt.setDate(6, dd);

            //stmt.executeUpdate("INSERT INTO contact (CID, cname, type, adress, work, birthday) VALUES (1, 'ilbeom', 'friend', 'Busan','no job','1900-05-04')");
//            stmt.executeUpdate("INSERT INTO phone (CID, Seq, number, type) VALUES (1, 1, 'private', 'etc')");
        	pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

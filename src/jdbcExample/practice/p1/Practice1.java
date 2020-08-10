package jdbcExample.practice.p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Practice1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		String url = "jdbc:oracle:thin:@localhost:51521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE writer_id='Lee'";
//		String sql = "INSERT INTO notice VALUES(4, '지금 성공한거야?', 'Lee', 'realy?', sysdate, 4, '')";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "test1", "1234");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
//		int result = st.executeUpdate(sql);
		
//		if(result == 1) {
//			System.out.println("insert success");
//		} else {
//			System.out.println("insert fail");
//		}

		while(rs.next()) {
			String title = rs.getString("TITLE");
			System.out.println(title);
		}
		
//		rs.close();
		st.close();
		con.close();
		
	}
	
}

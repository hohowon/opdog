package com.opdogkl.shop;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager {
		
		// ����
	public static Connection connect() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		return DriverManager.getConnection(url,"c##lkl1004","lkl1004");
		
		
	}

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		try {
			
			if (rs != null) {
				rs.close();
			}
			pstmt.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
package day_02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection con = null;
		
		String file = "c://dbinfo.prperties"; 
		Properties p = new Properties();
		try {
			p.load(new FileInputStream(file));
			
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user= p.getProperty("user");
			String pw = p.getProperty("pw");

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pw);
			
			//System.out.println("success");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		return con;
	}
	
	public static void close(ResultSet rs, 
								PreparedStatement ps, Connection con) {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(con != null) con.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

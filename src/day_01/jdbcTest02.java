package day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcTest02 {

	public static void main(String[] args) {					
		String sql = "select ename, sal, hiredate from emp"
				+ " where ename like '%'||?||'%'"
				+ " order by sal";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user= "SCOTT";
			String pw = "TIGER";
			
			con = DriverManager.getConnection(url, user, pw);
			ps = con.prepareStatement(sql);
			ps.setString(1, args[0]);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("sal") + "\t");
				System.out.print(rs.getDate("hiredate") + "\n");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver fail...\n" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("JDBC driver fail...\n" + e.getMessage());
		} catch (Exception e) {
			System.out.println("JDBC driver fail...\n" + e.getMessage());
		} finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("======== Main End =========");
		
	}

}

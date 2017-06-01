package day_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcTest01 {

	public static void main(String[] args) {		
		/*JDBC ���� ����
		 * 1. ����̹� �ε�
		 * 2. Connection ����
		 * 3. sql�� ���� ��ü ���� Statement
		 * 4. sql�� ����
		 */
				
		String sql = "select ename, sal, hiredate "
				+ " from emp where ename = '" + args[0] + "'"
				+ " order by sal";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			// 1. ����̹� �ε�
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user= "SCOTT";
			String pw = "TIGER";
			// 2. Connection ����
			con = DriverManager.getConnection(url, user, pw);
			// 3. sql�� ���� ��ü ���� Statement
			ps = con.prepareStatement(sql);
			// 4. sql�� ����
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString("ename") + "\t");
				System.out.print(rs.getString("sal") + "\t");
				System.out.print(rs.getDate("hiredate") + "\n");
			}
			
			//System.out.println("JDBC driver success!!");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver fail... " + e.getMessage());
		} catch (SQLException e) {
			System.out.println("JDBC driver fail..." + e.getMessage());
		} catch (Exception e) {
			System.out.println("JDBC driver fail..." + e.getMessage());
		} finally {
			try {
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		System.out.println("======== Main End =========");
		
	}

}

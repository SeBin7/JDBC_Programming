package day_02;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

public class Test02 {

	public static void main(String[] args) {
		String sql = "insert into dept (DEPTNO, DNAME, LOC) "
				+ "values (?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setString(1, args[0]);
			ps.setString(2, args[1]);
			ps.setString(3, args[2]);
			
			result = ps.executeUpdate();
			
			System.out.println(result + " rows »ý¼º");
			
			JdbcUtil.close(null, ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	

}

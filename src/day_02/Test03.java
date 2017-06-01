package day_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test03 {

	public static void main(String[] args) {
		String sql = "delete from dept where deptno=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;		
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, args[0]);
			ps.setString(2, args[1]);

			result = ps.executeUpdate();
			
			System.out.println(result + " rows update");
			
			JdbcUtil.close(null, ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}	

}

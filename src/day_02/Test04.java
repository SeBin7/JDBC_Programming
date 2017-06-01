package day_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test04 {

	public static void main(String[] args) {
		String sql = "update dept set loc=? where deptno=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		
		try {
			con = JdbcUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, Integer.parseInt(args[0]));

			result = ps.executeUpdate();
			
			System.out.println(result + " rows ªË¡¶");
			
			JdbcUtil.close(null, ps, con);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}

}

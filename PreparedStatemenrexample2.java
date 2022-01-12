package study.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatemenrexample2 {

	public static void main(String[] args) throws SQLException {

		Connection con=clientexample2.makeconnection();
		String sql="select * from books where Cost<?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, 200);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next())
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getNString(3)+" "+rs.getInt(4));
	}

}

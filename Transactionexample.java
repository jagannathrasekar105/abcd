package study.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Transactionexample {

	public static void main(String[] args) throws SQLException {

		Connection con=clientexample2.makeconnection();
		String sql="update account set balance=? where accnumber=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		con.setAutoCommit(false);
		try {
		pstmt.setInt(1, 700);
		pstmt.setInt(2,100 );
		pstmt.executeUpdate();
		System.out.println("with succes");
		Scanner sc=new Scanner(System.in);
		System.out.println("any any character to continue");
		sc.hasNext();
		
		pstmt.setInt(1, 50000);
		pstmt.setInt(2,101 );
		int howmanyrow=pstmt.executeUpdate();
		if(howmanyrow==0) {
			throw new SQLException();
		}
		System.out.println("dept success");
		System.out.println("committing");
		con.commit();
		}catch(SQLException e)
		{
			System.out.println("roolin back"+e);
			con.rollback();
		}
	}

}

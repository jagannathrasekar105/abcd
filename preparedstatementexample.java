package study.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class preparedstatementexample {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub


		Connection con=clientexample2.makeconnection();
		Scanner sc=new Scanner(System.in);
		//		System.out.println("enter id,name,course,cost");
		//		String input=sc.nextLine();
		//		String[] values=input.split(",");
		String sql="insert into books value(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		while(true) {
			System.out.println("enter id");
			int id=sc.nextInt();
			System.out.println("enter name");
			String name=sc.next();
			System.out.println("enter course");
			String course=sc.next();
			System.out.println("enter cost");
			int cost=sc.nextInt();
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setString(3,course);
			pstmt.setInt(4,cost);
			pstmt.executeUpdate();

			//PreparedStatement pstmt=con.prepareStatement(sql);
		}
	}

}

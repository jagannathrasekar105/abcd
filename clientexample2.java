package study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class clientexample2 {

	public static void main(String[] args) {

		Connection connect=makeconnection();
		showallrecord(connect);
	}
	public static void showallrecord(Connection con)
	{
		try {
			Statement stmt=con.createStatement();
			String sql="select * from books";
			ResultSet rs=stmt.executeQuery(sql);
			//processing the result set
			while(rs.next())
			{
				int id=rs.getInt(1);
				String bookname=rs.getNString(2);
				String name=rs.getString(3);
				int cost=rs.getInt(4);
				System.out.println(id+" "+bookname+" "+name+" "+cost);
			}
		}
		catch(SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection makeconnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("the driver class is not found");
		}
		String jdbc_url ="jdbc:mysql://localhost:3306/db1";
		String uname="root";
		String pass="jayhanuman105";
		Connection con=null;
		try {
			con= DriverManager.getConnection(jdbc_url, uname, pass);
		} catch (SQLException e) {
			System.out.println("could not connect to database"+e);
		}
		return con;
	}

}

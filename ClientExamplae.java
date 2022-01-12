package study.jdbc;

import java.io.IOException;
//import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class ClientExamplae {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, UnknownHostException, IOException{
//load the driver class and static block executed
//		Socket socket=new Socket("localhost",3306);
//		System.out.println(socket);
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url ="jdbc:mysql://localhost:3306/db1";
		String uname="root";
		String pass="jayhanuman105";
		
		Connection con= DriverManager.getConnection(jdbc_url, uname, pass);
		System.out.println("connection succesfull"+con);
		Statement stmt =con.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter id,name,course,cost");
		String input=sc.nextLine();
		String[] values=input.split(",");
		String sql="insert into books values("+Integer.parseInt(values[0])+","+values[1]+","+values[2]+","+Integer.parseInt(values[3])+")";
		stmt.executeUpdate(sql);
//		String sql1="select * from books;";
		String sql1="select * from books";
		ResultSet rs=stmt.executeQuery(sql1);
//		stmt.executeUpdate(sql1);

		
	}

}

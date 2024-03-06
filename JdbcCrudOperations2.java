package com.anudip7304;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcCrudOperations2
{

	static Connection con=null;
	static Scanner sc=new Scanner(System.in);
	
	static void insertOperation() throws SQLException
	{
		/*
		Statement st=con.createStatement();
		String sqlquery="INSERT INTO student(id,studentname,marks) VALUES (1,'Arun',78.56)";
		int rows=st.executeUpdate(sqlquery);
		if(rows>0)
		{
			System.out.println("data inserted successfully");
		}
		else
		{
			System.out.println("data insert failed");
		}
		*/
		
		
		String sqlquery="INSERT INTO student(id,studentname,marks) VALUES (?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sqlquery);
		System.out.println("Enter student id");
		ps.setInt(1, sc.nextInt());
		System.out.println("Enter student name");
		ps.setString(2, sc.next());
		System.out.println("Enter student marks");
		ps.setFloat(3, sc.nextFloat());
		int rows=ps.executeUpdate();
		if(rows>0)
		{
			System.out.println("data inserted successfully");
		}
		else
		{
			System.out.println("data insert failed");
		}
		
		ps.close();
		
	}
	static void updateOperation() throws SQLException
	{
		Statement st=con.createStatement();
		String sqlquery="UPDATE student set studentname='harish' WHERE id=2";
		int rows=st.executeUpdate(sqlquery);
		if(rows>0)
		{
			System.out.println("data updated successfully");
		}
		else
		{
			System.out.println("data update failed");
		}
	}
	static void deleteOperation() throws SQLException
	{
		Statement st=con.createStatement();
		String sqlquery="DELETE FROM student WHERE id=3";
		int rows=st.executeUpdate(sqlquery);
		if(rows>0)
		{
			System.out.println("data deleted successfully");
		}
		else
		{
			System.out.println("data delete failed");
		}
	}
	
	static void selectOperation() throws SQLException
	{
		Statement st=con.createStatement();
		String sqlquery="SELECT * FROM student";
		ResultSet rs=st.executeQuery(sqlquery);
		while(rs.next())
		{
			System.out.println(rs.getInt(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getFloat(3));
			System.out.println("=========");
		}
	}
	

	public static void main(String[] args)
	{
		try
		{
			String url="jdbc:mysql://localhost:3306/anpc7304";
			String username="root";
			String password="Soumya@1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			
			
			System.out.println("Enter your choice");
			int choice=sc.nextInt();
			switch(choice)
			{
			
			case 1:
				insertOperation();
				break;
			case 2:
				updateOperation();
				break;
			case 3:
				deleteOperation();
				break;
			case 4:
				selectOperation();
				break;
				
			}
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}

package com.anudip7304;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatchProcessing2 
{

	public static void main(String[] args) 
	{
		Connection con=null;
		ResultSet rs=null;
		
		try
		{
			String url="jdbc:mysql://localhost:3306/anpc7304";
			String username="root";
			String password="Soumya@1234";
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			//System.out.println(con);
			con.setAutoCommit(false);
			
			String query1="INSERT INTO student(id,studentname,marks) VALUES (8,'xyz',67.45)";
			String query2="INSERT INTO student(id,studentname,marks) VALUES (9,'abc',89.23)";
			String query3="UPDATE student SET marks=89.23 WHERE id=9";
			String query4="DELETE FROM student where id=7";
			Statement st=con.createStatement();
			st.addBatch(query1);
			st.addBatch(query2);
			st.addBatch(query3);
			st.addBatch(query4);
			st.executeBatch();
			con.rollback();
			
			//con.commit();
			System.out.println("Batch executed sucessfully");
			
			
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

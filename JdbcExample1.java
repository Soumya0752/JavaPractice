package com.anudip7304;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample1 
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
			
			Statement st=con.createStatement();
			String sqlquery="SELECT * FROM student";
			rs=st.executeQuery(sqlquery);
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getFloat(3));
				System.out.println("=========");
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

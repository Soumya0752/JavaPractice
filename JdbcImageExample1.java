package com.anudip7304;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcImageExample1 
{

	public static void main(String[] args) throws IOException
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
		
			File file=new File("C:\\Users\\Mahitha\\Desktop\\02-03-2024\\iostreams\\dsad.jpg");
			FileInputStream fis=new FileInputStream(file);
			byte[] bytes=new byte[(int) file.length()];
			fis.read(bytes);
			fis.close();
			
			String sqlquery="INSERT INTO imagetable(imageid,imagename,pic) VALUES(?,?,?)";
			PreparedStatement ps=con.prepareStatement(sqlquery);
			
			ps.setInt(1, 101);
			ps.setString(2, "switzerland");
			ps.setBytes(3, bytes);
			
			ps.executeUpdate();
			ps.close();
			System.out.println("image added sucessfully");
			
			
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

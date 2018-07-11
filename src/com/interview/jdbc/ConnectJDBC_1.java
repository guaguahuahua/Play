package com.interview.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConnectJDBC_1 {

	private static void connectJDBC(){
		String user="root";
		String password="111111";
		String url="jdbc:mysql://localhost:3306/jdbc";
		String driver="com.mysql.jdbc.Driver";
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName(driver);
			conn=(Connection) DriverManager.getConnection(url, user, password);
			ps=(PreparedStatement) conn.prepareStatement("select * from employee where id=?");
			ps.setInt(1, 2);
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println(rs.getObject(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" ");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		connectJDBC();

	}

}

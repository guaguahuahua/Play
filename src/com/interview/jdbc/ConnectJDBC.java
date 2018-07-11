package com.interview.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJDBC {

	/**
	 * 连接数据库
	 */
	private static void connectJDBC(){
		String user="root";
		String password="111111";
		String url="jdbc:mysql://localhost:3306/jdbc";
		String driver="com.mysql.jdbc.Driver";
		Connection conn=null;
		//建立执行sql语句的statement对象
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			//加载数据库驱动，并将其注册到DriverManager当中
			Class.forName(driver);
			//建立数据库连接
			conn=DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();
			//执行sql语句
			stmt.execute("insert into employee values(1, 'james', 25)");
			stmt.execute("insert into employee values(2, 'dante', 26)");
			//保存sql语句执行的结果
			rs=stmt.executeQuery("select * from employee");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//关闭数据库连接，释放掉所占用的资源，因为数据库sql在底层都是使用网络IO来实现的
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
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

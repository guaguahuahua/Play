package com.interview.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectJDBC {

	/**
	 * �������ݿ�
	 */
	private static void connectJDBC(){
		String user="root";
		String password="111111";
		String url="jdbc:mysql://localhost:3306/jdbc";
		String driver="com.mysql.jdbc.Driver";
		Connection conn=null;
		//����ִ��sql����statement����
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
			//�������ݿ�������������ע�ᵽDriverManager����
			Class.forName(driver);
			//�������ݿ�����
			conn=DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();
			//ִ��sql���
			stmt.execute("insert into employee values(1, 'james', 25)");
			stmt.execute("insert into employee values(2, 'dante', 26)");
			//����sql���ִ�еĽ��
			rs=stmt.executeQuery("select * from employee");
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			//�ر����ݿ����ӣ��ͷŵ���ռ�õ���Դ����Ϊ���ݿ�sql�ڵײ㶼��ʹ������IO��ʵ�ֵ�
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

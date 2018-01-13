package com.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		PrintWriter pw=null;
		try {
			ServerSocket server=new ServerSocket(2000);
			Socket socket=server.accept();
			//��ȡ������
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//��ȡ�����
			pw=new PrintWriter(socket.getOutputStream());
			String s=br.readLine();
			pw.println();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ͷ���Դ
			try {
				br.close();
				pw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}

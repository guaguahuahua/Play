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
			//获取输入流
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//获取输出流
			pw=new PrintWriter(socket.getOutputStream());
			String s=br.readLine();
			pw.println();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
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

package com.interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 这块是socket客户端
 * @author 22847
 *
 */
public class SocketClient {
	public static void main(String []args){
		BufferedReader br=null;
		PrintWriter pw=null;
		try {
			Socket socket=new Socket("localhost", 2000);
			//获取输入流和输入流
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw=new PrintWriter(socket.getOutputStream(), true);
			//向服务器发送数据
			pw.println("hello server! ");
			String s=null;
			while(true){
				s=br.readLine();				
				if(s!=null){
					break;
				}
			}
			System.out.println(s);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.close();
		}
		
	}
}

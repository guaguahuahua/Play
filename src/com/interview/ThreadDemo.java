package com.interview;

public class ThreadDemo extends Thread{
	
	public void run(){
		System.out.println("ThreadDemo:begin");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ThreadDemo:end");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

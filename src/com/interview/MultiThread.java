package com.interview;

public class MultiThread extends Thread{
	
	//实际是对Thread中run方法的重写
	public void run(){
		long a=0;
		for(int i=0; i<Integer.MAX_VALUE; i++){
			a+=i;
		}
		System.out.println("finish execute!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiThread thread=new MultiThread();
		thread.run();
	}

}

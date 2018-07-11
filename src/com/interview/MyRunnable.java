package com.interview;
/**
 * 继承接口Runnable的方式实现
 * @author 22847
 */
public class MyRunnable implements Runnable{

	//执行体
	public void run(){
		long a=0;
		for(int i=0; i<Integer.MAX_VALUE; i++){
			a+=i;
		}
		System.out.println("finish execute");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyRunnable thread=new MyRunnable();
		thread.run();
	}

}

package com.interview;

public class DeamonThread extends Thread{

	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+":begin");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":end");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test begin");
		Thread thread=new DeamonThread();
		//将用户线程设置为守护线程，并启动线程
		thread.setDaemon(true);
		thread.start();
		System.out.println("Test end");
	}

}

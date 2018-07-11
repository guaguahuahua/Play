package com.interview;

public class FinishThread_1 extends Thread{

	@Override
	public void run(){
		System.out.println("线程进入阻塞");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("线程在阻塞状态被终止");
//			e.printStackTrace();
		}
		System.out.println("线程执行结束");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinishThread_1 thread=new FinishThread_1();
		thread.start();
		//终止线程的执行
		thread.interrupt();
	}

}

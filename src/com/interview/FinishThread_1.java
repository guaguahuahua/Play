package com.interview;

public class FinishThread_1 extends Thread{

	@Override
	public void run(){
		System.out.println("�߳̽�������");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("�߳�������״̬����ֹ");
//			e.printStackTrace();
		}
		System.out.println("�߳�ִ�н���");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinishThread_1 thread=new FinishThread_1();
		thread.start();
		//��ֹ�̵߳�ִ��
		thread.interrupt();
	}

}

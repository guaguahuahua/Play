package com.interview;
/**
 * �̳нӿ�Runnable�ķ�ʽʵ��
 * @author 22847
 */
public class MyRunnable implements Runnable{

	//ִ����
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

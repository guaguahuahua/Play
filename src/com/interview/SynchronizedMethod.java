package com.interview;

import java.util.concurrent.SynchronousQueue;

public class SynchronizedMethod {
	
	public synchronized void synchronizedMethod(){
		System.out.println("��ʼ����ͬ������");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("���Ƕ����һ��ͬ������");
	}

	public synchronized void generalMethod(){
		System.out.println("���Ƕ���ķ�ͬ������");
	}
}

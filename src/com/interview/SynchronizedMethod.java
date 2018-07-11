package com.interview;

import java.util.concurrent.SynchronousQueue;

public class SynchronizedMethod {
	
	public synchronized void synchronizedMethod(){
		System.out.println("开始调用同步方法");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("这是对象的一个同步方法");
	}

	public synchronized void generalMethod(){
		System.out.println("这是对象的非同步方法");
	}
}

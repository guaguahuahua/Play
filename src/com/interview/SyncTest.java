package com.interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {
	private int value=0;
	Lock lock=new ReentrantLock();
	
	//ʹ��synchronized�ؼ��ַ�ʽ�޸ı�����ֵ
	public synchronized void addValueSync(){
		this.value++;
		System.out.println(Thread.currentThread().getName()+": "+value);
	}
	
	//ʹ��lock�ķ�ʽ�޸ı�����ֵ
	public void addValueLock(){
		lock.lock();
		value++;
		System.out.println(Thread.currentThread().getName()+": "+value);
		lock.unlock();
	}
}

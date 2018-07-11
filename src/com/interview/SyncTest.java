package com.interview;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncTest {
	private int value=0;
	Lock lock=new ReentrantLock();
	
	//使用synchronized关键字方式修改变量的值
	public synchronized void addValueSync(){
		this.value++;
		System.out.println(Thread.currentThread().getName()+": "+value);
	}
	
	//使用lock的方式修改变量的值
	public void addValueLock(){
		lock.lock();
		value++;
		System.out.println(Thread.currentThread().getName()+": "+value);
		lock.unlock();
	}
}

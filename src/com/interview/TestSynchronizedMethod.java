package com.interview;

/**
 * 下面的测试说明了某个对象内部如果既有同步方法和非同步方法的时候，线程1如果执行了该对象的同步方法
 * 那么其他的线程也是可以执行该对象的非同步方法，并不会产生冲突
 * @author 22847
 *
 */
public class TestSynchronizedMethod {

	//创建一个同步方法中的对象
	private static final SynchronizedMethod syncObj=new SynchronizedMethod();
	
	public static void main(String[] args) {
		
		//线程1执行的是SynchronizedMethod方法的同步方法
		Thread t1=new Thread(){
			@Override 
			public void run(){
				syncObj.synchronizedMethod();
			}
		};
		
		//线程2执行的是SynchronizedMethod方法的非同步方法
		Thread t2=new Thread(){
			@Override
			public void run(){
				syncObj.generalMethod();
			}
		};
		
		t1.start();
		t2.start();
	}

}

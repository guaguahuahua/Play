package com.interview;

public class ThreadTest {

	public static void test1(){
		System.out.println("test1:begin");
		Thread t1=new ThreadDemo();
		t1.start();
		System.out.println("test1:end");
		System.out.println();
	}
	
	public static void test2(){
		System.out.println("test2:begin");
		Thread t2=new ThreadDemo();
		t2.run();
		System.out.println("test2:end");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test2();
	}

}

package com.interview;

public class TestExtendAndImplements extends Thread implements Runnable{

	public void run(){
		System.out.println("runnable and Thread");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestExtendAndImplements thread=new TestExtendAndImplements();
		thread.run();
	}

}

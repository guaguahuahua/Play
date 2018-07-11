package com.interview;

public class TestJoin implements Runnable{

	@Override 
	public void run(){
		System.out.println("test join begin");
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("test join end");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread=new Thread(new TestJoin());
		thread.start();
		try {
			//如果在join之前的线程没有执行完，那么thread会进入阻塞线程，
			//之后等join之后的线程运行结束之后，再次进入thread线程，执行完剩余的
			//任务
			thread.join(2000);
			if(thread.isAlive()){
				System.out.println("thread has not finished");
			}else{
				System.out.println("thread has finished");
			}
			System.out.println("join finish");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

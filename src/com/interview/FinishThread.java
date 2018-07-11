package com.interview;

public class FinishThread implements Runnable{

	private boolean flag=true;
	private int count=0; //这块是为了方便调用终止方法
	
	@Override
	public void run(){
		while(flag){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("执行线程");
			count++;
			//如果计数器达到了10以上，调用终止方法停止正在运行的线程
			if(count>10){
				myStop();
			}
		}
	}
	
	public void myStop(){
		this.flag=false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FinishThread thread=new FinishThread();
		thread.run();
	}

}

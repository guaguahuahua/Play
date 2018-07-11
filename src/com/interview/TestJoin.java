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
			//�����join֮ǰ���߳�û��ִ���꣬��ôthread����������̣߳�
			//֮���join֮����߳����н���֮���ٴν���thread�̣߳�ִ����ʣ���
			//����
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

package com.interview;

public class FinishThread implements Runnable{

	private boolean flag=true;
	private int count=0; //�����Ϊ�˷��������ֹ����
	
	@Override
	public void run(){
		while(flag){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("ִ���߳�");
			count++;
			//����������ﵽ��10���ϣ�������ֹ����ֹͣ�������е��߳�
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

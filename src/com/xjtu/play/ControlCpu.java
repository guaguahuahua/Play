package com.xjtu.play;

public class ControlCpu {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		method2();
	}
	public static void method1(){
		/**
		 * ����1s �յ�1s�������������ʾ�50%
		 */
		for(;;){
			
			for(int i=0;i<1160000000;i++){
				
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * ������ͼ
	 * @throws InterruptedException 
	 */
	public static void method2() throws InterruptedException{
		double step=0.01;
		double []busy=new double[10000];
		double []idle=new double[10000];
		int end=200;//�������ݵĽ�ֵֹ
		int viberate=300;//�������
		int half=viberate/2;
		double index=0;
		for(int i=0;i<10000;i++){
			busy[i]=half*Math.sin(Math.PI*index)+half;
			idle[i]=viberate-busy[i];
			index+=step;
		}
		for(int i=0;i<idle.length;i++){//test para
			System.out.print(busy[i]+"��");
		}
		while(true){
			int i=0;
			i%=10000;
			long start=System.currentTimeMillis();
			while((System.currentTimeMillis()-start)<=busy[i]){
				;
			}
			Thread.sleep((long) idle[i]);
			i++;
		}
		
	}

}

package com.interview;

public class SychronizeAndLock {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SyncTest st=new SyncTest();
		Thread t1=new Thread(new Runnable(){
			public void run(){
				for(int i=0; i<5; i++){
					st.addValueSync();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			}
		});
		
		Thread t2=new Thread(new Runnable(){
			@Override
			public void run(){
				for(int i=0; i<5; i++){
					st.addValueLock();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});
		
		t1.start();
		t2.start();
	}

}

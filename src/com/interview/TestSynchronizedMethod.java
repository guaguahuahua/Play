package com.interview;

/**
 * ����Ĳ���˵����ĳ�������ڲ��������ͬ�������ͷ�ͬ��������ʱ���߳�1���ִ���˸ö����ͬ������
 * ��ô�������߳�Ҳ�ǿ���ִ�иö���ķ�ͬ�������������������ͻ
 * @author 22847
 *
 */
public class TestSynchronizedMethod {

	//����һ��ͬ�������еĶ���
	private static final SynchronizedMethod syncObj=new SynchronizedMethod();
	
	public static void main(String[] args) {
		
		//�߳�1ִ�е���SynchronizedMethod������ͬ������
		Thread t1=new Thread(){
			@Override 
			public void run(){
				syncObj.synchronizedMethod();
			}
		};
		
		//�߳�2ִ�е���SynchronizedMethod�����ķ�ͬ������
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

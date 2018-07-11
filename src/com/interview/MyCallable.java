package com.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * ���̵߳�callable�ӿڵ�ʵ��
 * @author 22847
 */
public class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "HelloWorld";
	}

	/**
	 * ���������callable�ӿ�
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���һ�������̵߳Ĵ���������
		ExecutorService threadPool=Executors.newSingleThreadExecutor();
		//����Ҫ���е��̼߳��ص������������ϣ�������һ��Future����
		Future<String>future=threadPool.submit(new MyCallable());
		try {
			System.out.println("wait thread to finish");
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}

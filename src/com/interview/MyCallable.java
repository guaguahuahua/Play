package com.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 多线程的callable接口的实现
 * @author 22847
 */
public class MyCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "HelloWorld";
	}

	/**
	 * 测试上面的callable接口
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获得一个处理线程的处理器对象
		ExecutorService threadPool=Executors.newSingleThreadExecutor();
		//将需要运行的线程加载到处理器对象上，并返回一个Future对象
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

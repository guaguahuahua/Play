package com.interview;

public class TestGC {
	
	/**
	 * 这块是测试一下垃圾回收机制的东西
	 * @param args
	 */
	public static void main(String []args){
		Integer i=new Integer(4);
		Integer j=new Integer(5);
		j=i;
		System.gc();
	}
}

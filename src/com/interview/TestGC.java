package com.interview;

public class TestGC {
	
	/**
	 * ����ǲ���һ���������ջ��ƵĶ���
	 * @param args
	 */
	public static void main(String []args){
		Integer i=new Integer(4);
		Integer j=new Integer(5);
		j=i;
		System.gc();
	}
}

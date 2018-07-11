package com.interview;

public class FindMaxWithoutComparetion {

	/**
	 * �ҵ��������е����ֵ����ʹ�ñȽϵķ�ʽ
	 * @param a int
	 * 			����
	 * @param b int
	 * 			���� 
	 * @return	int
	 * 			���ֵ
	 */
	public static int findMaxWithoutComparetion(int a, int b){
		return (int)((long)a+(long)b+Math.abs((long)a-(long)b))/2;
	}
	
	public static int findMinWithoutComparetion(int a, int b){
		return (int)((long)a+(long)b-Math.abs((long)a-(long)b))/2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=3;
		int b=5;
		int max=findMaxWithoutComparetion(a, b);
		System.out.println("max:"+max);
		int min=findMinWithoutComparetion(a, b);
		System.out.println("min:"+min);
		System.out.println(0x10==16);
//		for(int i=010; i==10; i+=0){
//			System.out.println("infinite");
//		}
//		for(int i=10; (i++^--i)==0; i+=0){
//			System.out.println("infinite");
//		}
	}

}

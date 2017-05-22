package com.xjtu.play;

import java.util.Arrays;

public class FindTheOnlyOne {
	private static char[]origin={'a','a','b','b','c','c','d','d','e','e','f','f'};
	private static int sum=0;
	public static void main(String[] args){
		// TODO Auto-generated method stub
		//ͳ��Ԫ����������ܺ��Ƕ���
		for(int i=0;i<origin.length;i++){
			sum+=origin[i];
		}
		System.out.println(sum);
		char []source={'a','a','b','b','c','d','d','e','e','f'};
		Character ch='c';
		Character ci='f';
		System.out.println("c_binary:"+Integer.toBinaryString(ch));
		System.out.println("f_binary:"+Integer.toBinaryString(ci));
		System.out.println(Integer.toBinaryString(ch^ci));
		
		findTheOnlyOne_2(source);
//		findTheOnlyOne_1(source);
//		findTheOnlyOne(source);
	}
	/**
	 * ʹ�����ķ������������г��ֵĵ���Ԫ��
	 * @param source
	 */
	public static void findTheOnlyOne(char []source){
		int result=0;
		for(int i=0;i<source.length;i++){
			result^=source[i];
		}
		System.out.println((char)result);
	}
	/**
	 * ʹ�úͱȽϷ�������Ԫ�ؽ�����������ȡ����
	 * @param source
	 */
	public static void findTheOnlyOne_1(char []source){
		int count=0;
		for(int i=0;i<source.length;i++){
			count+=source[i];
		}	
		count=sum-count;//�õ�������Ԫ��
		System.out.println((char)count);
	}
	/**
	 * ʹ�����ķ�ʽ�Ҵ���2��������Ԫ��
	 * @param source
	 */
	public static void findTheOnlyOne_2(char []source){
		int r1=0;
		int r2=0;
		for(int i=0;i<source.length;i++){
			if((source[i]&0000001)==0000001){//ʹ��mask������Ķ����Ƶ����һλ����mask���Ի����Ҫ���κ�λ��ֵ��
				r1^=source[i];
			}else{
				r2^=source[i];
			}
		}
		System.out.println((char)r1);
		System.out.println((char)r2);
	}
}

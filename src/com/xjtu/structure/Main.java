package com.xjtu.structure;

import java.util.Scanner;

public class Main {

	/**
	 * �ü��ַ���
	 * @param s	�ַ���
	 * @param len	Ҫ�ü��ĳ���
	 */
	public static void fun(String s, int len){
		//����ַ���Ϊ�գ�ֱ���˳�
		if(s.equals("")){
			System.out.println();
			return ;
		}
		
		//���ü�0���ֽ�ʱ
		if(len<=0){
			System.out.println();
			return;
		}
		
		StringBuilder sb=new StringBuilder();
		//����ַ����ϵ�����
		for(int i=0; i<s.length(); i++){
			char c=s.charAt(i);
			if(!(c>='0' && c<='9')){
				sb.append(c);
			}
		}
		
		//�������֮����ַ���
		String str=sb.toString();
		
		//����ֽ���Խ�磬ֱ���˳�
		if(len>str.getBytes().length){
			System.out.println();
			return;
		}
		
		//�ü�
		int i;
		for(i=0; i<str.length(); i++){
			char c=str.charAt(i);
			if(c>='һ' && c<='��'){ //�ұ߽����
				len=len-2;
			}else{
				len=len-1;
			}
			
			if(len<=0){
				break;
			}
		}
		System.out.println((str.getBytes()).length);
		String res=str.substring(0, i+1);
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="��HUAΪ3423fdgdfgfs";
//		String s="";
		int len=6;
//		String s;
//		int len;
//		Scanner sc=new Scanner(System.in);
//		s=sc.nextLine();
//		len=sc.nextInt();
		fun(s, len);
		
//		int a=19968;
//		System.out.println((char)a);
		
//		char c='��';
//		System.out.println((int)c);
		
//		int a=40869;
//		System.out.println((char)a);
		
		System.out.println(0x4e00);
		System.out.println(0x9fa5);
	}

}

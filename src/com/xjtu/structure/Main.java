package com.xjtu.structure;

import java.util.Scanner;

public class Main {

	/**
	 * 裁剪字符串
	 * @param s	字符串
	 * @param len	要裁剪的长度
	 */
	public static void fun(String s, int len){
		//如果字符串为空，直接退出
		if(s.equals("")){
			System.out.println();
			return ;
		}
		
		//仅裁剪0个字节时
		if(len<=0){
			System.out.println();
			return;
		}
		
		StringBuilder sb=new StringBuilder();
		//清掉字符串上的数字
		for(int i=0; i<s.length(); i++){
			char c=s.charAt(i);
			if(!(c>='0' && c<='9')){
				sb.append(c);
			}
		}
		
		//清掉数字之后的字符串
		String str=sb.toString();
		
		//如果字节数越界，直接退出
		if(len>str.getBytes().length){
			System.out.println();
			return;
		}
		
		//裁剪
		int i;
		for(i=0; i<str.length(); i++){
			char c=str.charAt(i);
			if(c>='一' && c<='龥'){ //右边界待定
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
		String s="华HUA为3423fdgdfgfs";
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
		
//		char c='周';
//		System.out.println((int)c);
		
//		int a=40869;
//		System.out.println((char)a);
		
		System.out.println(0x4e00);
		System.out.println(0x9fa5);
	}

}

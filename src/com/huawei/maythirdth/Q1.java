package com.huawei.maythirdth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Q1 {

	
	public static void removeDuplicates(String n){
		//ת��Ϊ�ַ���
		String s=n+"";
		//ȥ���ظ���Ԫ��
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			//��õ�ǰλ���ַ�
			char c=s.charAt(i);
			//��ȡ���ַ����ִ���
			int times=map.getOrDefault(c, 0);
			if(times==0){
				map.put(c, 1);
			}else{
				continue;
			}			
		}
		//���ȥ�غ������
		char []c=new char[map.size()];
		int i=0;
		for(Entry e: map.entrySet()){
			c[i++]=(char) e.getKey();
		}

		//��������
		Arrays.sort(c);
		String t="";
		for(int j=0; j<c.length; j++){
			t=t+c[j];
		}
		//��Ҫ�����ֽ�������ȡ��Сֵ
		int a=Integer.parseInt(t);		
		System.out.println(a);
	}
	
	public static void removeDuplicates(long n){
		//ת��Ϊ�ַ���
		String s=n+"";
		//ȥ���ظ���Ԫ��
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			//��õ�ǰλ���ַ�
			char c=s.charAt(i);
			//��ȡ���ַ����ִ���
			int times=map.getOrDefault(c, 0);
			if(times==0){
				map.put(c, 1);
			}else{
				continue;
			}			
		}
		//���ȥ�غ������
		char []c=new char[map.size()];
		int i=0;
		for(Entry e: map.entrySet()){
			c[i++]=(char) e.getKey();
		}
		//��������
		Arrays.sort(c);
		String t="";
		for(int j=0; j<c.length; j++){
			t=t+c[j];
		}
		//��Ҫ�����ֽ�������ȡ��Сֵ
		int a=Integer.parseInt(t);		
		System.out.println(a);
	}
	
	public static void show(char []c){
		for(int i=0; i<c.length; i++){
			System.out.print(c[i]+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
//		String n=sc.nextLine();
		
//		long n=sc.nextLong();
		//n������10λС�ڻ��ߵ���10λ
		long n=7667389839420l;
//		int n=00000;
		removeDuplicates(n);
//		System.out.println(Integer.MAX_VALUE);
	}

}

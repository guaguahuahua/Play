package com.huawei.maythirdth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Q2 {
	
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
		String t=""; 
		for(Entry e: map.entrySet()){
			t=t+e.getKey();
		}
		//��Ҫ�����ֽ�������ȡ��Сֵ
		int a=Integer.parseInt(t);		
		System.out.println(a);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long n;
//		Scanner sc=new Scanner(System.in);		
//		n=sc.nextLong();
		
		
		//n������10λС�ڻ��ߵ���10λ
//		int n=98766730;
		long n=8888888888l;
		removeDuplicates(n);
		System.out.println(Long.MAX_VALUE);
	}

}

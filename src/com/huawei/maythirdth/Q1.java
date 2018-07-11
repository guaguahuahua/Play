package com.huawei.maythirdth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Q1 {

	
	public static void removeDuplicates(String n){
		//转化为字符串
		String s=n+"";
		//去掉重复的元素
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			//获得当前位置字符
			char c=s.charAt(i);
			//获取该字符出现次数
			int times=map.getOrDefault(c, 0);
			if(times==0){
				map.put(c, 1);
			}else{
				continue;
			}			
		}
		//获得去重后的数字
		char []c=new char[map.size()];
		int i=0;
		for(Entry e: map.entrySet()){
			c[i++]=(char) e.getKey();
		}

		//重新排列
		Arrays.sort(c);
		String t="";
		for(int j=0; j<c.length; j++){
			t=t+c[j];
		}
		//需要对数字进行排序，取最小值
		int a=Integer.parseInt(t);		
		System.out.println(a);
	}
	
	public static void removeDuplicates(long n){
		//转化为字符串
		String s=n+"";
		//去掉重复的元素
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			//获得当前位置字符
			char c=s.charAt(i);
			//获取该字符出现次数
			int times=map.getOrDefault(c, 0);
			if(times==0){
				map.put(c, 1);
			}else{
				continue;
			}			
		}
		//获得去重后的数字
		char []c=new char[map.size()];
		int i=0;
		for(Entry e: map.entrySet()){
			c[i++]=(char) e.getKey();
		}
		//重新排列
		Arrays.sort(c);
		String t="";
		for(int j=0; j<c.length; j++){
			t=t+c[j];
		}
		//需要对数字进行排序，取最小值
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
		//n不超过10位小于或者等于10位
		long n=7667389839420l;
//		int n=00000;
		removeDuplicates(n);
//		System.out.println(Integer.MAX_VALUE);
	}

}

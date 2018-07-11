package com.huawei.maythirdth;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Q2 {
	
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
		String t=""; 
		for(Entry e: map.entrySet()){
			t=t+e.getKey();
		}
		//需要对数字进行排序，取最小值
		int a=Integer.parseInt(t);		
		System.out.println(a);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		long n;
//		Scanner sc=new Scanner(System.in);		
//		n=sc.nextLong();
		
		
		//n不超过10位小于或者等于10位
//		int n=98766730;
		long n=8888888888l;
		removeDuplicates(n);
		System.out.println(Long.MAX_VALUE);
	}

}

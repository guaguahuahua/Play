package com.huawei.maythirdth;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Q3 {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
//		long n=sc.nextLong();
		long n=9;
		
		String t=n+"";
		HashSet<Character> set=new HashSet<Character>();
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<t.length(); i++){
			char c=t.charAt(i);
			if(set.add(c)){
				sb.append(c);
			}
		}
		String res=sb.reverse().toString();
		char []c=res.toCharArray();
		Arrays.sort(c);
		String sorted="";
		for(int i=0; i<res.length(); i++){
			sorted=sorted+res.charAt(i);
		}
		System.out.println(Long.parseLong(sorted));
	}

}

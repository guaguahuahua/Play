package com.huawei.maythirdth;

import java.util.HashSet;
import java.util.Scanner;

public class Main {	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();

		
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
		System.out.println(Integer.parseInt(res));
	}

}



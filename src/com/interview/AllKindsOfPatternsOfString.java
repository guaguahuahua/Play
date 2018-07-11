package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllKindsOfPatternsOfString {

	/**
	 * 输出字符串的所有的组合的形式
	 * @param s String
	 * 			输入字符串
	 */
	private static void allKindsOfPatternOfString(String s){
		//如果字符串为空，那么就退出
		if(s.length()==0){
			return ;
		}
		//建立存放字符串各种形式的集合
		List<String> results=new ArrayList<String>();
		//首先获得字符串的长度，然后计算字符串的各种形式的个数
		int kinds=(int) Math.pow(2, s.length());
		//从0开始遍历到最大的数量
		for(Integer i=0; i<kinds; i++){
			//将i转化为二进制字符串的形式
			String temp=i.toBinaryString(i);
			//这块是将所有的字符串补齐长度，因为上一行的返回的二进制字符串是最简形式，
			//所以最终字符串长度不一定一样，所以需要补齐操作。
			while(temp.length()<s.length()){
				temp="0"+temp;
			}
			System.out.println(temp);
			//将不为0的部分的的字符提取出来转化为字符串的形式
			String t="";
			for(int j=0; j<temp.length(); j++){
				if(temp.charAt(j)!='0'){
					t=t+s.charAt(j);
				}
			}
			//将得到的字符串添加到集合当中去
			results.add(t);
		}
		Collections.sort(results);
		for(String K : results){
			System.out.println(K);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abc";
		allKindsOfPatternOfString(s);
	}

}

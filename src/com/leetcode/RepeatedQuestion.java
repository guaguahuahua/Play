package com.leetcode;

public class RepeatedQuestion{	
	
//	double a=3.14d;
//	Byte b=-128;
//	static long l=0xfffl;
//	
//	static float c=3.22f;
//	static float d=2.33F;
	String str=new String("good");
	char[] ch={'a', 'b', 'c'};
	
	public void change(String str, char[] ch){
		str="test ok";
		ch[0]='g';
	}
	
	static String string=new String("wang");
	
	public void modify(String s){
		s+=" jun";
	}
	
	static StringBuffer sb=new StringBuffer("wang");
	
	public void sbModify(StringBuffer sb){
		sb.append("jun");
	}
	
	
	public static void main(String[] args) {

		RepeatedQuestion rp=new RepeatedQuestion();
//		rp.change(rp.str, rp.ch);
//		System.out.println(rp.str+"and");
//		System.out.println(rp.ch);
		
		rp.modify(string);
		System.out.println(string);
		
		rp.sbModify(sb);
		System.out.println(sb.toString());
		
	}

}

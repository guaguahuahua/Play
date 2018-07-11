package com.interview;

import java.io.UnsupportedEncodingException;

public class PatternTranslate {

	/**
	 * 将字符串转化格式后输出
	 * @param str String
	 * @return String
	 */
	private static String translate(String str){
		
		String result="";
		try {
			//阅读源码注释之后发现这是将字符串字节数组转化为自己想要的格式，
			result=new String(str.getBytes("ISO-8859-1"), "GBK");
			result=result.trim();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str=new String("我叫周雅东");
		String str=new String("我叫ya dong zhou");
		String res=translate(str);
		System.out.println(res);
	}

}

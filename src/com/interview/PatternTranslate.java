package com.interview;

import java.io.UnsupportedEncodingException;

public class PatternTranslate {

	/**
	 * ���ַ���ת����ʽ�����
	 * @param str String
	 * @return String
	 */
	private static String translate(String str){
		
		String result="";
		try {
			//�Ķ�Դ��ע��֮�������ǽ��ַ����ֽ�����ת��Ϊ�Լ���Ҫ�ĸ�ʽ��
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
//		String str=new String("�ҽ����Ŷ�");
		String str=new String("�ҽ�ya dong zhou");
		String res=translate(str);
		System.out.println(res);
	}

}

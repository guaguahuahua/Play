package com.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllKindsOfPatternsOfString {

	/**
	 * ����ַ��������е���ϵ���ʽ
	 * @param s String
	 * 			�����ַ���
	 */
	private static void allKindsOfPatternOfString(String s){
		//����ַ���Ϊ�գ���ô���˳�
		if(s.length()==0){
			return ;
		}
		//��������ַ���������ʽ�ļ���
		List<String> results=new ArrayList<String>();
		//���Ȼ���ַ����ĳ��ȣ�Ȼ������ַ����ĸ�����ʽ�ĸ���
		int kinds=(int) Math.pow(2, s.length());
		//��0��ʼ��������������
		for(Integer i=0; i<kinds; i++){
			//��iת��Ϊ�������ַ�������ʽ
			String temp=i.toBinaryString(i);
			//����ǽ����е��ַ������볤�ȣ���Ϊ��һ�еķ��صĶ������ַ����������ʽ��
			//���������ַ������Ȳ�һ��һ����������Ҫ���������
			while(temp.length()<s.length()){
				temp="0"+temp;
			}
			System.out.println(temp);
			//����Ϊ0�Ĳ��ֵĵ��ַ���ȡ����ת��Ϊ�ַ�������ʽ
			String t="";
			for(int j=0; j<temp.length(); j++){
				if(temp.charAt(j)!='0'){
					t=t+s.charAt(j);
				}
			}
			//���õ����ַ�����ӵ����ϵ���ȥ
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

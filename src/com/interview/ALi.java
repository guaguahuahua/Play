package com.interview;

import java.util.ArrayList;
import java.util.Collections;

public class ALi {
	
	public static String quchong(String s){
		//ǿ���ҵ��ظ��ַ���
		for(int len=1; len<s.length(); len++){
			for(int i=0; i<s.length()-len+1; i++){
				//���һ���ַ���
				String str=s.substring(i, i+len);
				//Ѱ�Ҹ��ַ������������еĳ��ִ���
				int ti=times(s, str);
				//�������Σ�ȥ��
				if(ti!=1){
					int start=s.indexOf(str);
//					if(){
//						
//					}
				}
				System.out.println(str);				
			}
		}
		return null;
	}

	/**
	 * �ҵ��ַ������ִ���
	 * @param s
	 * @param str
	 * @return
	 */
	public static int times(String s, String str){
		
		int count=0;
		for(int i=0; i<s.length()-str.length()+1; i++){
			int j;
			for(j=0; j<str.length(); j++){
				if(str.charAt(j)!=str.charAt(i)){
					break;
				}
			}
			if(j==str.length()){
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abbbcb";
		quchong(s);
		ArrayList a=new ArrayList();
		a.add(3);
		a.add(4);
		Collections.reverse(a);
	}

}

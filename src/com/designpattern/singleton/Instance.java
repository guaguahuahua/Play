package com.designpattern.singleton;

public class Instance {
	
	private Instance(){}; //���췽��
	
	private static Instance newInstance=new Instance(); //�����ʵ�ʵĴ���
	
	public Instance getInstance(){ //���󴴽����ṩ���ⲿ�Ľӿ�
		return newInstance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}

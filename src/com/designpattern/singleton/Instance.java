package com.designpattern.singleton;

public class Instance {
	
	private Instance(){}; //构造方法
	
	private static Instance newInstance=new Instance(); //对象的实际的创建
	
	public Instance getInstance(){ //对象创建的提供给外部的接口
		return newInstance;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	}

}

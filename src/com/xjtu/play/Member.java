package com.xjtu.play;

public class Member {
	private int a;//如果是成员变量的话，系统自动完成初始化
	
	public int getA(){
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member sl=new Member();
		System.out.println(sl.getA());
	}
	
}

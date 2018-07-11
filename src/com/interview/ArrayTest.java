package com.interview;

public class ArrayTest {

	static{
		String []args={"args1", "args2", "args3"};
		System.out.println("first");
		main(args);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a={1,2,3,45};
		int []b=a.clone();
		for(int K:b){
			System.out.print(K+"\t");
		}
		System.out.println();
		
		System.out.println("second");
		for(String K:args){
			System.out.print(K+"\t");
		}
	}

}

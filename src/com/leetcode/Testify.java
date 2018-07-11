package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Testify extends Thread implements Runnable{

	public void run(){
		System.out.println("run this program!");
	}
//	static int []arr=new int[10];
//	static String []s=new String[10];
	
//	class Dog{
//		private int age;
//		private String name;
//		private int step;
//		
//		Dog(String s, int a){
//			name=s;
//			age=a;
//			step=0;
//		}
//		public void run(Dog fast){
//			fast.step++;
//		}
//	}
	static String s="hello";
	static String t="hello";
	static char c[]={'h', 'e', 'l', 'l', 'o'};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int intArray[];
		intArray=new int[3];
		intArray[1]=1;
		int [][]a=new int [2][];
		a[0]=new int[3];
		a[1]=new int[3];
		
//		System.out.println(s.equals(t));
//		System.out.println(t.equals(c));
//		System.out.println(s==t);
//		System.out.println(t.equals(new String("hello")));
//		int x=3;
		
//		Testify tf=new Testify();
//		Dog dog=tf.new Dog("tommy", 3); 
//		dog.step=25;
//		dog.run(dog);
//		System.out.println(dog.step);
			
		
//		Thread thread=new Thread(new Testify());
//		thread.start();
//		System.out.println(arr[1]);
//		System.out.println(s[9]);
//		String s1="ÄãºÃ";
//		int i=3;
//		s1+=i;
//		s1=i+s1;
//		System.out.println(s1);
//		Double a=1.0;
//		example();
//		int x,a=2, b=3, c=4;
//		x=(++a)+(b++)+(c++);
//		System.out.println(x);
//		Set set=new HashSet();
//		set.add(new Testify());
//		set.add(new Testify());
//		set.add(new Testify());
//		set.add(new Testify());
//		System.out.println(set.size());
	}
	public int hashCode(){
		return 1;
	}
	public boolean equals(Object obj){
		return true;
	}
	
	
	
	
	public static void example(){
		try{
			int a=1/0;
			System.out.println("test1");
		}catch (Exception e){
			System.out.println("test2");

			System.out.println("test4");
		}finally{
			System.out.println("test3");
		}
	}

}

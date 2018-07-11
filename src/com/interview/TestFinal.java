package com.interview;

public class TestFinal {
	
	public String name;
	public int age;
	public String sex;
	
	public TestFinal(String name, int age, String sex){
		this.name=name;
		this.age=age;
		this.sex=sex;
	}
	
	@Override
	public boolean equals(Object obj){
		if(!(obj instanceof TestFinal)){
			return false;
		}
		TestFinal temp=(TestFinal) obj;
		if(temp.name.equals(name) && temp.age==age && temp.sex.equals(sex)){
			return true;
		}else{
			return false;	
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TestFinal tf=new TestFinal();
//		TestFinal.innerClass inner=tf.new innerClass();
//		System.out.println(inner.a);
//		System.out.println(inner.name);
		TestFinal tf=new TestFinal("dante", 26, "male");
//		TestFinal tf1=new TestFinal("zyd", 34, "male");
		TestFinal tf1=new TestFinal("dante", 26, "male");
		boolean res=tf1.equals(tf);
		System.out.println(res);
	}

}

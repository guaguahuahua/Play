package com.interview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class People implements Serializable{
	private String name;
	private int age;
	
	public People(){
		this.name="Lili";
		this.age=26;
	}
	
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	@Override
	public String toString(){
		return name+", "+age;
	}
	
	/**
	 * 将这个类进行持久化过程
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		People p=new People();
		ObjectOutputStream oos=null;
		ObjectInputStream ois=null;
		try {
			FileOutputStream fos=new FileOutputStream("people.out");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(p);
			oos.close();
		} catch (Exception e){
			
		}
		
		People pl;
		try {
			FileInputStream fis=new FileInputStream("people.out");
			ois=new ObjectInputStream(fis);
			pl=(People) ois.readObject();
			System.out.println("name: "+pl.getName());
			System.out.println("age: "+pl.getAge());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		People p=new People();
		System.out.println(p);
	}
}



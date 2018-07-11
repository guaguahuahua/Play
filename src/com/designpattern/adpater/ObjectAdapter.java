package com.designpattern.adpater;

public class ObjectAdapter implements Targetable{
	
	private Source source;
	
	public ObjectAdapter(Source source){
		this.source=source;
	}
	
	public void method1(){
		this.source.method1();
	}
	
	public void method2(){
		System.out.println("this is object adapter method");
	}
	
}

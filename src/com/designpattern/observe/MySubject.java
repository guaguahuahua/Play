package com.designpattern.observe;

public class MySubject extends AbstraceSubject{
	
	public void operations(){
		System.out.println("update self");
		notifyObservers();
	}
}

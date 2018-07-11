package com.designpattern.observe;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public abstract class AbstraceSubject implements Subject{
	
//	private Vector<Observer> vector=new Vector<Observer>();
	private List<Observer> list=new ArrayList<Observer>();
	
	public void add(Observer observer){
//		vector.add(observer);
		list.add(observer);
	}
	
	public void del(Observer observer){
//		vector.remove(observer);
		list.remove(observer);
	}
	
	public void notifyObservers(){
//		Enumeration<Observer> enu=vector.elements();
//		while(enu.hasMoreElements()){
//			enu.nextElement().update();
//		}
		for(Observer o:list){
			o.update();
		}
	}
	
}

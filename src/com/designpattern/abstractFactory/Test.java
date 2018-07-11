package com.designpattern.abstractFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendSmsFactory ssf=new SendSmsFactory();
		Sender sender=ssf.produce();
		sender.sender();
	}

}

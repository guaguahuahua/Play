package com.designpattern.simpleFactory;

public class SendFactory_1 {
	
	public Sender produceSms(){
		return new SendSms();
	}
	
	public Sender produceMail(){
		return new SendMail();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SendFactory_1 sf=new SendFactory_1();
		Sender sender=sf.produceSms();
		sender.sender();
	}

}

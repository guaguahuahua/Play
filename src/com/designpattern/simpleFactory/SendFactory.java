package com.designpattern.simpleFactory;

public class SendFactory {
	public Sender produce(String str){
		if(str.equals("sendMail")){
			return new SendMail();
		}else if(str.equals("sendSms")){
			return new SendSms();
		}else{
			return null;
		}
	}
	
	public static void main(String []args){
		SendFactory sf=new SendFactory();
		Sender sender=sf.produce("sendMail");
		sender.sender();		
	}
}

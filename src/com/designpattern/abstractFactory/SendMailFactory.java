package com.designpattern.abstractFactory;

public class SendMailFactory implements Provider{
	public Sender produce(){
		return new SendMail();
	}
}

package com.designpattern.abstractFactory;

public class SendSmsFactory implements Provider{
	public Sender produce(){
		return new SendSms();
	}
}

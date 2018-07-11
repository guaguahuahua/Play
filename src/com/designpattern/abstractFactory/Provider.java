package com.designpattern.abstractFactory;

/**
 * 抽象工厂类的好处是对于彻底解耦和，对于新添加的类，只要创建新的类就行，
 * 毋庸修改原来的代码，
 * @author 22847
 *
 */
public interface Provider {
	public Sender produce();
}

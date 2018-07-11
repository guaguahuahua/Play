package com.designpattern.adpater;

/**
 * 也就是说现在已经存在了一些合适的类的方法实现了我们需要的功能，
 * 随后要做的是不修改该类的前提下进行扩展，使用接口和多继承的方式
 * 创建一个adpater类，该类在继承原有的类的基础上面，通过实现接口的方式实现了最终的所有功能
 * 所以对于系统的扩展和代码的复用来说是非常好的一种形式
 * @author 22847
 *
 */
public class AdapterTest {
	public static void main(String []args){
		Adapter adapter=new Adapter();
		adapter.method1();
		adapter.method2();
	}
}

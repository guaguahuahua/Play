package com.designpattern.adpater;

/**
 * 对象适配器摆脱了多继承带来的高耦合的影响
 * 对于原始类以对象的形式进行使用，同时实现了
 * @author 22847
 *
 */
public class ObjectAdapterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		ObjectAdapter oAdapter=new ObjectAdapter(new Source());
		oAdapter.method1();
		oAdapter.method2();
	}

}

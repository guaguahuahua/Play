package com.interview;

public class TestClassLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//获得自定义类的类加载器
		ClassLoader classLoader=TestClassLoader.class.getClassLoader();
		System.out.println(classLoader);
		//获得扩展类的类加载器
		ClassLoader extendClassLoader=classLoader.getParent();
		System.out.println(extendClassLoader);
		//获得系统类的类加载器
		ClassLoader systemLoader=extendClassLoader.getParent();
		System.out.println(systemLoader);
		
	}

}

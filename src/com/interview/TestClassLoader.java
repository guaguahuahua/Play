package com.interview;

public class TestClassLoader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Զ�������������
		ClassLoader classLoader=TestClassLoader.class.getClassLoader();
		System.out.println(classLoader);
		//�����չ����������
		ClassLoader extendClassLoader=classLoader.getParent();
		System.out.println(extendClassLoader);
		//���ϵͳ����������
		ClassLoader systemLoader=extendClassLoader.getParent();
		System.out.println(systemLoader);
		
	}

}

package com.designpattern.adpater;

/**
 * ���������������˶�̳д����ĸ���ϵ�Ӱ��
 * ����ԭʼ���Զ������ʽ����ʹ�ã�ͬʱʵ����
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

package com.designpattern.adpater;

/**
 * Ҳ����˵�����Ѿ�������һЩ���ʵ���ķ���ʵ����������Ҫ�Ĺ��ܣ�
 * ���Ҫ�����ǲ��޸ĸ����ǰ���½�����չ��ʹ�ýӿںͶ�̳еķ�ʽ
 * ����һ��adpater�࣬�����ڼ̳�ԭ�е���Ļ������棬ͨ��ʵ�ֽӿڵķ�ʽʵ�������յ����й���
 * ���Զ���ϵͳ����չ�ʹ���ĸ�����˵�Ƿǳ��õ�һ����ʽ
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

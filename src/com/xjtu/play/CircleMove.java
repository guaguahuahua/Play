package com.xjtu.play;

public class CircleMove {

	/**
	 * �ж�ѭ����λ�Ƿ��ܹ�ʵ��
	 * @param args
	 */
	public static void main(String []args){
		String m="abcd";
		String t="cdaa";
		boolean r=circleMove(m,t);
		System.out.println(r);
	}
	/**
	 * ͨ����ĸ��ѭ����λ���ж��Ƿ���������Ӵ���������������򷵻�true�����򷵻�false
	 * �㷨�����ڱ��֮������Ϊѭ����λ��ʱ�������λ����Ŀ�ﵽ�˴��ı���ĳ��ȣ���ôҲ��˵��λ֮����Ǳ���
	 * ���Կ��Խ�ÿ����λ�Ľ�������������������һ��2�����ȵ�ĸ����������������а������Ӵ�����ô˵��
	 * �Ӵ�����ͨ��ĸ��ѭ����λ�õ��������С�
	 * @param m ĸ��
	 * @param t �Ӵ�
	 */
	public static boolean circleMove(String m,String t){
		m=m+m;
		if(m.contains(t)){
			return true;
		}
		return false;
	}
}

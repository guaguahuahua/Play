package com.designpattern.observe;

/**
 * �۲���ģʽ�У����ӻ�����ɾ���۲��߶��Ƕ����ģ�ֻҪ���ӻ���ɾ���༴�ɴﵽ��
 * �����޸�Դ����
 * @author 22847
 *
 */
public class ObserverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subject sub=new MySubject();
		Observer1 observer1=new Observer1();
		sub.add(observer1);
		sub.add(new Observer2());
		sub.operations();
		sub.del(observer1);
		sub.operations();
	}

}

package com.xjtu.play;

import com.xjtu.structure.LQueue;

public class MyLQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LQueue lqueue=new LQueue();
		//����isEmpty
		boolean r=lqueue.isEmpty(lqueue);
		System.out.println(r);
		//������Ӳ�����ȡ��ͷԪ��
		lqueue.append(lqueue, 2);
		lqueue.append(lqueue, 3);
		boolean r1=lqueue.isEmpty(lqueue);
		System.out.println(r1);
		int r2=lqueue.getTop(lqueue);
		System.out.println("��ǰ��ͷԪ��Ϊ��"+r2);
		//���Գ��Ӳ�����
		lqueue.delete(lqueue);
		int r3=lqueue.getTop(lqueue);
		System.out.println("��ǰ��ͷԪ��Ϊ��"+r3);
		lqueue.delete(lqueue);
		boolean r4=lqueue.isEmpty(lqueue);
		System.out.println(r4);
		int s=lqueue.getSize(lqueue);
		System.out.println("��ǰ���еĳ���Ϊ��"+s);
	}
}

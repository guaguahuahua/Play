package com.xjtu.play;

import com.xjtu.structure.LSNode;

public class MyLinkedStack {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LSNode head=new LSNode(0);
		//isEmpty����
		boolean r1=head.isEmpty(head);
		System.out.println(""+r1);
		//��ջ��������
		head.stackPush(head, 2);
		head.stackPush(head, 3);
		int r6=head.getSize(head);
		System.out.println("��ǰ��ջ�߶��ǣ�"+r6);
		//ȡջ��Ԫ�ز���
		int r2=head.getTop(head);
		System.out.println("ջ��Ԫ��Ϊ��"+r2);
		//��ջ��������
		int r3=head.stackPop(head);
		System.out.println("��ջԪ��Ϊ: "+r3);
		int r4=head.getTop(head);
		System.out.println("��ջ֮��ջ��Ԫ��Ϊ��"+r4);
		//���ö�ջ�ĸ߶�
		int r5=head.getSize(head);
		System.out.println("��ǰ��ջ�߶��ǣ�"+r5);
	}

}

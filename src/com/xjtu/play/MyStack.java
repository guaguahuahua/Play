package com.xjtu.play;

import com.xjtu.structure.SeqStack;

/**
 * �����Ҫʵ��˳���ջ
 * @author 22847
 *
 */
public class MyStack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeqStack stack=new SeqStack();
		//����isEmpty ����
		boolean r=stack.isEmpty(stack);
		System.out.println(r);
		//������ջ����
		stack.stackPush(stack, 1);
		stack.stackPush(stack, 3);
		System.out.println("the heigth of the stack is : "+stack.top);
		//����ȡջ��Ԫ�غ���
		int r1=stack.getTop(stack);
		System.out.println("top of the stack is: "+r1);
		//���Գ�ջ����
		int r2=stack.stackPop(stack);
		System.out.println("��ջԪ��Ϊ��"+r2+", ��ջ��߶�Ϊ�� "+stack.top);
		
	}

}

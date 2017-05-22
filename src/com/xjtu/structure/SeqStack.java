package com.xjtu.structure;

public class SeqStack {
	private static int N=20;
	public int []elements=new int[N];
	public int top=0; 
	
	/**
	 * �ж϶�ջ�Ƿ�Ϊ��
	 * @param stack
	 * @return
	 */
	public static boolean isEmpty(SeqStack stack){
		return stack.top==0;
	}
	/**
	 * ��ջ
	 * @param stack
	 * @param value
	 * @return
	 */
	public static boolean stackPush(SeqStack stack,int value){
		if(stack.top>=N){
			System.out.println("��ջ����");
			return false;
		}
		stack.elements[stack.top++]=value;
		return true;
	} 
	/**
	 * ��ջ
	 * @param stack
	 * @return
	 */
	public static int stackPop(SeqStack stack){
		
		if(stack.top==0){
			System.out.println("��ջ�ѿ�");
			return 0;
		}
		int value=stack.elements[--stack.top];//��Ϊջ���ǿյģ�����Ҫ����һ����ȡ����ջԪ�ص�ͬʱ��Ҳ��ջ�ĸ߶Ƚ���
		return value;
	}
	/**
	 * ȡջ��Ԫ��
	 * @param stack
	 * @return
	 */
	public static int getTop(SeqStack stack){
		if(stack.top==0){
			System.out.println("ջ�ǿյ�");
			return 0;
		}
		
		return stack.elements[stack.top];
	}
}

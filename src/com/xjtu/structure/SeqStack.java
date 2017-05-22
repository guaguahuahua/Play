package com.xjtu.structure;

public class SeqStack {
	private static int N=20;
	public int []elements=new int[N];
	public int top=0; 
	
	/**
	 * 判断堆栈是否为空
	 * @param stack
	 * @return
	 */
	public static boolean isEmpty(SeqStack stack){
		return stack.top==0;
	}
	/**
	 * 进栈
	 * @param stack
	 * @param value
	 * @return
	 */
	public static boolean stackPush(SeqStack stack,int value){
		if(stack.top>=N){
			System.out.println("堆栈已满");
			return false;
		}
		stack.elements[stack.top++]=value;
		return true;
	} 
	/**
	 * 出栈
	 * @param stack
	 * @return
	 */
	public static int stackPop(SeqStack stack){
		
		if(stack.top==0){
			System.out.println("堆栈已空");
			return 0;
		}
		int value=stack.elements[--stack.top];//因为栈顶是空的，所以要先退一个，取出退栈元素的同时，也将栈的高度降低
		return value;
	}
	/**
	 * 取栈顶元素
	 * @param stack
	 * @return
	 */
	public static int getTop(SeqStack stack){
		if(stack.top==0){
			System.out.println("栈是空的");
			return 0;
		}
		
		return stack.elements[stack.top];
	}
}

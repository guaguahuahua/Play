package com.xjtu.play;

import com.xjtu.structure.SeqStack;

/**
 * 这块主要实现顺序堆栈
 * @author 22847
 *
 */
public class MyStack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeqStack stack=new SeqStack();
		//测试isEmpty 函数
		boolean r=stack.isEmpty(stack);
		System.out.println(r);
		//测试入栈函数
		stack.stackPush(stack, 1);
		stack.stackPush(stack, 3);
		System.out.println("the heigth of the stack is : "+stack.top);
		//测试取栈顶元素函数
		int r1=stack.getTop(stack);
		System.out.println("top of the stack is: "+r1);
		//测试出栈函数
		int r2=stack.stackPop(stack);
		System.out.println("出栈元素为："+r2+", 出栈后高度为： "+stack.top);
		
	}

}

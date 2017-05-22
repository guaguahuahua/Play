package com.xjtu.play;

import com.xjtu.structure.LSNode;

public class MyLinkedStack {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LSNode head=new LSNode(0);
		//isEmpty测试
		boolean r1=head.isEmpty(head);
		System.out.println(""+r1);
		//入栈函数测试
		head.stackPush(head, 2);
		head.stackPush(head, 3);
		int r6=head.getSize(head);
		System.out.println("当前堆栈高度是："+r6);
		//取栈顶元素测试
		int r2=head.getTop(head);
		System.out.println("栈顶元素为："+r2);
		//出栈方法测试
		int r3=head.stackPop(head);
		System.out.println("出栈元素为: "+r3);
		int r4=head.getTop(head);
		System.out.println("出栈之后栈顶元素为："+r4);
		//后获得堆栈的高度
		int r5=head.getSize(head);
		System.out.println("当前堆栈高度是："+r5);
	}

}

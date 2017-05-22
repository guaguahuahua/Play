package com.xjtu.play;

import com.xjtu.structure.LQueue;

public class MyLQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LQueue lqueue=new LQueue();
		//测试isEmpty
		boolean r=lqueue.isEmpty(lqueue);
		System.out.println(r);
		//测试入队操作，取队头元素
		lqueue.append(lqueue, 2);
		lqueue.append(lqueue, 3);
		boolean r1=lqueue.isEmpty(lqueue);
		System.out.println(r1);
		int r2=lqueue.getTop(lqueue);
		System.out.println("当前队头元素为："+r2);
		//测试出队操作，
		lqueue.delete(lqueue);
		int r3=lqueue.getTop(lqueue);
		System.out.println("当前队头元素为："+r3);
		lqueue.delete(lqueue);
		boolean r4=lqueue.isEmpty(lqueue);
		System.out.println(r4);
		int s=lqueue.getSize(lqueue);
		System.out.println("当前队列的长度为："+s);
	}
}

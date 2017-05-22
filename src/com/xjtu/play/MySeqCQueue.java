package com.xjtu.play;

import com.xjtu.structure.SeqCQueue;

public class MySeqCQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeqCQueue queue=new SeqCQueue();
		//测试isEmpty函数
		boolean r=queue.isEmpty(queue);
		System.out.println(r);
		//测试入队
		queue.append(queue, 2);
		queue.append(queue, 3);
		queue.append(queue, 5);
		System.out.println(queue.getSize(queue));
		//测试出队
		queue.delete(queue);
		System.out.println("当前队头元素为："+queue.getFront(queue));
		System.out.println("当前队列长度为："+queue.getSize(queue));
		//测试取队头元素
		queue.delete(queue);
		System.out.println("队头元素为："+queue.getFront(queue));
	}
}

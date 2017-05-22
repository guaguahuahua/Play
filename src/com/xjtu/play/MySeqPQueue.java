package com.xjtu.play;

import com.xjtu.structure.SeqNode;
import com.xjtu.structure.SeqPNode;

/**
 * 测试顺序优先级队列
 * @author 22847
 *
 */
public class MySeqPQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeqPNode pqueue=new SeqPNode();
		SeqNode node =new SeqNode(22,3);
		SeqNode node1 =new SeqNode(33,2);
		SeqNode node2 =new SeqNode(44,1);
		//测试isEmpty方法
		boolean r=pqueue.isEmpty(pqueue);
		System.out.println(r);
		//测试入队方法
		pqueue.append(pqueue, node1);
		pqueue.append(pqueue, node);
		pqueue.append(pqueue,node2);
		boolean r2=pqueue.isEmpty(pqueue);
		System.out.println(r2);
		System.out.println("当前队列的长度为："+pqueue.getSize(pqueue));
		//测试出队方法,取最高优先级方法
		SeqNode r1=pqueue.getHPrior(pqueue);
		System.out.println("优先级最高的节点"+", 优先级："+r1.getPrior()+"， 值为："+r1.getValue());
		SeqNode r5=pqueue.delete(pqueue);
		System.out.println("删除节点："+r5.getValue()+", "+r5.getPrior());
		int r4=pqueue.getSize(pqueue);
		System.out.println("当前队列的长度为："+r4);
		SeqNode r3=pqueue.getHPrior(pqueue);
		System.out.println("优先级最高的节点"+", 优先级："+r3.getPrior()+"， 值为："+r3.getValue());
	}

}

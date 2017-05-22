package com.xjtu.structure;

public class LQueue {
	LQNode front;
	LQNode rear;
	int size;//用来计量队列的长度
	
	/**
	 * 判断链式队列是否为空
	 * @param lqueue
	 * @return
	 */
	public static boolean isEmpty(LQueue lqueue){
		if(lqueue.front==null){//如果队头指针为空，那么队列为空
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 链式队列的入队
	 * @param lqueue
	 * @param value
	 * @return
	 */
	public static boolean append(LQueue lqueue,int value){
		
		LQNode node=new LQNode(value);//先将入队元素放入到一个节点中
		if(lqueue.front==null){//如果队头为空，那么直接将该元素放置在队头即可
			lqueue.front=node;//直接让引用指向该节点
			lqueue.rear=node;
		}
		//如果队列里面至少有一个元素的时候
		node.next=lqueue.rear.next;//其实可有可无，因为在java类的成员变量会自动的初始化，引用类型会自动的初始化为null
		lqueue.rear.next=node;//将新元素添加进队列
		lqueue.rear=node;//让队列的尾指针放置在新插入的元素之上
		lqueue.size++;
		return false;
	}
	/**
	 * 删除队头元素，出队
	 * @param lqueue
	 * @return
	 */
	public static int delete(LQueue lqueue){
		
		if(lqueue.front==null){
			System.out.println("队列已空");
			return 0;
		}
		int tmp=lqueue.front.value;//首先获得队头指针的值;
		if(lqueue.front==lqueue.rear){//如果队列中只有一个元素
			lqueue.front=lqueue.rear=null;
		}else{//队列中至少有两个元素
			lqueue.front=lqueue.front.next;//将队头指针后移
		}	
		lqueue.size--;
		return tmp;
	}
	/**
	 * 获取队头元素
	 * @param lqueue
	 * @return
	 */
	public static int getTop(LQueue lqueue){
		
		if(lqueue.front==null){
			System.out.println("队列已空");
			return 0;
		}
		int tmp=lqueue.front.value;//获得队头元素的值
		return tmp;
	}
	public static int getSize(LQueue lqueue){
		return lqueue.size;
	}
}


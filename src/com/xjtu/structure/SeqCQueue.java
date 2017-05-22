package com.xjtu.structure;
/**
 * 顺序循环队列的结构和函数，使用的是计数器来实现循环队列
 * @author 22847
 *
 */
public class SeqCQueue {
	private static int N=10;
	int []elements=new int[N];
	int front;//头指针的位置
	int rear;//尾指针位置
	int count;//统计队列中的元素个数
	
	/**
	 * 判断队列是否为空
	 * @param queue
	 * @return
	 */
	public static boolean isEmpty(SeqCQueue queue){
		if(queue.count==0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 入队
	 * @param queue
	 * @param value
	 * @return
	 */
	public static boolean append(SeqCQueue queue,int value){
		if(queue.count==N){//队列已满
			System.out.println("队列已满");
			return false;
		}
		queue.elements[queue.rear]=value;//将元素插入到队列的末尾
		queue.rear=(queue.rear+1)%N;//这是为了保证顺序循环队列防止假溢出
		queue.count++;
		return true;
	}
	/**
	 * 出队
	 * @param queue
	 * @return  //返回出队的元素
	 */
	public static int delete(SeqCQueue queue){
		if(queue.count==0){
			System.out.println("队列已空");
			return 0;
		}
		int tmp=queue.elements[queue.front];//取出头元素
		queue.front=(queue.front+1)%N;//将头指针向后移动
		queue.count--;
		return tmp;
	}
	/**
	 * 取队头元素
	 * @param queue
	 * @return
	 */
	public static int getFront(SeqCQueue queue){
		if(queue.count==0){
			System.out.println("队列已空");
			return 0;
		}
		int tmp=queue.elements[queue.front];
		return tmp;
	}
	/**
	 * 返回一个队列的长度
	 * @param queue
	 * @return
	 */
	public static int getSize(SeqCQueue queue){
		return queue.count;
	}
	
}

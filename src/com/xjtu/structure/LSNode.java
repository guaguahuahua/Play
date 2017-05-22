package com.xjtu.structure;

public class LSNode {
	int value;
	LSNode next;
	static int size; 
	/**
	 * 构造函数，添加新节点的时候便于初始化的过程
	 * @param value
	 */
	public LSNode(int value){
		this.value=value;
	}
	/**
	 * 判断堆栈是否为空
	 * @param head
	 * @return
	 */
	public static boolean isEmpty(LSNode head){
		if(head.next==null){
			System.out.println("堆栈是空的");
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 进栈，使用的是头插法，这样可以保证最小的查找次数
	 * @param head 头节点
	 * @param value 插入节点的值
	 * @return
	 */
	public static boolean stackPush(LSNode head,int value){
		LSNode node =new LSNode(value);
		node.next=head.next;
		head.next=node;
		size++;
		return true;
	}
	/**
	 * 出栈
	 * @param head
	 * @return 返回出栈的元素
	 */
	public static int stackPop(LSNode head){
		if(head.next==null){
			System.out.println("堆栈已空");
			return 0;
		}
		int value=head.next.value;//取出数据元素
		head.next=head.next.next;//删除该节点
		size--;
		return value;
	}
	/**
	 * 取栈顶元素
	 * @param head
	 * @return
	 */
	public static int getTop(LSNode head){
		if(head.next==null){
			System.out.println("堆栈已空");
			return 0;
		}
		return head.next.value;
	}
	public static int getSize(LSNode head){
		return size;
	}
}

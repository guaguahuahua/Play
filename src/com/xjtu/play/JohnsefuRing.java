package com.xjtu.play;

import com.xjtu.structure.Linkednode;

public class JohnsefuRing {
	/**
	 * 插入一个节点，虽然是循环单链表，但是可以采用统一操作完成
	 * 采用头插法，因为约瑟夫环会使用到单循环链表，所以头插法更合适
	 * @param head
	 * @param value
	 */
	public static void insert(Linkednode head,int value){
		Linkednode node =new Linkednode(value);//先创建一个节点
		node.next=head.next;
		head.next=node;
	}
	/**
	 * 初始化函数，将最后一个节点的指针指向头结点
	 */
	public static void initial(Linkednode head){
		head.next=head;
	}
	/**
	 * 该函数主要是为了实现约瑟夫环的主要功能，也就是根据节点数值经过该循环次数之后删掉某个节点
	 * 算法思想，双层for循环，内层循环为了达到阈值m，外层循环主要是为了保证节点最终只剩下一个
	 * @param head
	 */
	public static void realize(Linkednode head,int random){
		int count=1;
		int value=random;
		Linkednode curr=head;
		Linkednode pre=curr;
		while(curr.next!=curr){//删除会一直进行直到仅剩下一个节点为止
			
			while(count!=value){//给定数字位置的节点
				pre=curr;
				curr=curr.next;
				count++;
			}
			//删除该节点
			value=curr.value;//取出其中的值
			System.out.print(value+"\t");
			pre.next=curr.next;//删除该节点
			curr=pre.next;
			count=1;
		}
		System.out.print(curr.value+"\t");
	}
	public static void show(Linkednode head){
		Linkednode p=head;
		while(p.next!=head){
			System.out.print(p.value+"\t");
			p=p.next;
		}
		System.out.println(p.value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//插入测试
		Linkednode head=new Linkednode(3);
		JohnsefuRing.initial(head);
		JohnsefuRing.insert(head, 4);
		JohnsefuRing.insert(head, 8);
		JohnsefuRing.insert(head, 4);
		JohnsefuRing.insert(head, 2);
		JohnsefuRing.insert(head, 7);
		JohnsefuRing.insert(head, 1);		
		
		//输出所有的元素
		JohnsefuRing.show(head);
		//测试约瑟夫环实现函数
		JohnsefuRing.realize(head, 5);
	}

}

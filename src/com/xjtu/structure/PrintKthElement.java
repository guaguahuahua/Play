package com.xjtu.structure;

/**
 * 输出单链表中倒数第k个元素
 * @author 22847
 *
 */
public class PrintKthElement {

	/**
	 * 两个指针分别保持k个间距，当右侧的指针到达链表的末尾的时候，左侧的指针指向了倒数第k个元素
	 * @param head
	 * @param k
	 * @return
	 */
	public static Linkednode printKthElement(Linkednode head, int k){
		
		Linkednode left=head;
		Linkednode right=head;
		//右侧指针先走k个单位长度
		while(right!=null && k>0){
			right=right.next;
			k--;
		}
		//判断现在k是否已经为0
		if(k!=0){
			System.out.println("参数k越界！");			
			return null;
		}
		while(right!=null){
			left=left.next;
			right=right.next;
		}
		return left;
	} 

	/**
	 * 2次遍历，第一次遍历得到数组的长度，并计算出需要遍历的次数delta，第二次遍历delta，获得第k个元素
	 * @param head
	 * @param k
	 * @return
	 */
	public static Linkednode printKthElement_1(Linkednode head, int k){
		int len=0;
		Linkednode h=head;
		while(h!=null){
			len++;
			h=h.next;
		}
		int delta=len-k;
		if(delta<0){
			System.out.println("参数k越界");			
			return null;
		}
		h=head;
		while(delta>0){
			h=h.next;
			delta--;
		}
		return h;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Linkednode head=new Linkednode(0);
		Linkednode n1=new Linkednode(1);
		Linkednode n2=new Linkednode(2);
		Linkednode n3=new Linkednode(3);
		Linkednode n4=new Linkednode(4);
		Linkednode n5=new Linkednode(5);
		Linkednode n6=new Linkednode(6);
		head.next=n1;
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		Linkednode res=printKthElement_1(head, 6);
		if(res!=null){
			System.out.println(res.value);
		}
		
	}

}

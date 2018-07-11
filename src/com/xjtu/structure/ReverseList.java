package com.xjtu.structure;
/**
 * 逆置单链表
 * @author 22847
 *
 */
public class ReverseList {

	/**
	 * 方法1原地逆置
	 * @param head
	 * @return
	 */
	public static Linkednode reverseList(Linkednode head){
		
		if(head.next==null){
			return head;
		}
		
		Linkednode p=head.next;
		//当前的头节点变成尾节点
		head.next=null;
		Linkednode q=p.next;
		while(p!=null){
			p.next=head;
			head=p;
			p=q;
			if(q!=null){
				q=q.next;
			}
		}		
		return head;
	}
	
	/**
	 * 根据链表头节点输出所有的元素值
	 * @param head
	 */
	public static void show(Linkednode head){
		Linkednode h=head;
		while(h!=null){
			System.out.print(h.value+"\t");
			h=h.next;
		}
		System.out.println();
	}
	
	public static void main(String []args){
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
		show(head);
		Linkednode node =reverseList(head);
		show(node);
	}
}

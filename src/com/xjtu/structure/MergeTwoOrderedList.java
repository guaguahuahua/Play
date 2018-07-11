package com.xjtu.structure;
/**
 * 合并两个有序单链表
 * @author 22847
 *
 */
public class MergeTwoOrderedList {

	
	public static Linkednode mergeTwoOrderedList(Linkednode h1, Linkednode h2){
		//新链表节点指向原链表中表头值较小的那个
		Linkednode head=h1.value > h2.value ? h2 : h1;
		Linkednode pre=h1;
		Linkednode p=h1;
		Linkednode q=h2;
		
		while(p!=null && q!=null){
			//向后寻找，直到所有小于q的节点都被遍历过
			while(p!=null && p.value<q.value){
				pre=p;
				p=p.next;
			}
			if(p==null){
				pre.next=q;
				break;
			}
			pre.next=q;
			Linkednode temp=p;
			p=q;
			q=temp;
		}
		
		return head;
	}
	
	public static void show(Linkednode head){
		Linkednode h=head;
		while(h!=null){
			System.out.print(h.value+"\t");
			h=h.next;
		}
		System.out.println();
	}
	
	public static void main(String []args){
		Linkednode head1=new Linkednode(0);
		Linkednode n1=new Linkednode(2);
		Linkednode n2=new Linkednode(4);
		
		Linkednode head2=new Linkednode(1);
		Linkednode n4=new Linkednode(3);
		Linkednode n5=new Linkednode(5);
		Linkednode n6=new Linkednode(7);
		
		head1.next=n1;
		n1.next=n2;
		
		head2.next=n4;
		n4.next=n5;
		n5.next=n6;
		Linkednode node = mergeTwoOrderedList(head1, head2);
		show(node);
	}
	
}

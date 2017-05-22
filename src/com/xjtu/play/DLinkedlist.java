package com.xjtu.play;

/**
 * 完成双向循环链表，插入，删除函数
 * @author 22847
 *
 */
public class DLinkedlist {

	class Dnode{
		int value;
		Dnode pre;
		Dnode post;
		
		public Dnode(int value){
			this.value=value;
			this.pre=null;
			this.post=null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//插入流程的测试
		DLinkedlist dl=new DLinkedlist();
		Dnode head=dl.new Dnode(0);
		boolean r=dl.insert(head, 0, 23);
		System.out.println(r);
		
	}
	/**
	 * 双向循环链表的插入流程
	 * @param head
	 * @param position
	 * @param value
	 * @return
	 */
	public boolean insert(Dnode head,int position,int value){
		if(position<0){
			System.out.println("位置越界");
			return false;
		}
		int count=0;
		Dnode point=head.post;//空指针异常的原因在这块，主要是因为head的下一个位置是空的，所以导致
		while(point!=head && count<position){//寻找插入的位置
			point=point.post;
			count++;
		}
		if(count!=position){
			System.out.println("位置越界");
			return false;
		}
		Dnode node=new Dnode(value);
		node.post=point.post;
		point.post.pre=node;
		node.pre=point;
		point.post=node;
		return true;
	}

}

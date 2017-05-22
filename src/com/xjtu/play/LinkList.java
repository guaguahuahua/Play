package com.xjtu.play;

/**
 * 表的链式存储的实现，包括三个，返回链表的长度，在某个位置插入元素，删除某个元素，取出某个位置的元素
 * 实践操作的过程中使用的是带有头结点的单链表
 * @author 22847
 *
 */
public class LinkList {

	class linkednode{
		int value;
		linkednode next;
		public linkednode(int value){
			this.value=value;
			this.next=null;
		}
	}
	
	
	/**
	 * 将单链表就地进行排序
	 * @param head
	 */
	public void sort(linkednode head){
		linkednode pre=new linkednode(0);
		pre=head;
		while(head!=null){
			linkednode p=head.next;
			int element=p.value;
			head.next=head.next.next;
			
			head=head.next;
		}
	}
	
	/**
	 * 按照升序插入元素保证元素插入后链表是有序的。
	 * @param head
	 * @param element
	 */
	public void ascendInsert(linkednode head, int element){
		linkednode p=head;
		while(p!=null){
			if(p.next.value>element){//找到位置
				linkednode node=new linkednode(element);
				node.next=p.next;
				p.next=node;
				break;
			}
			p=p.next;
		}
	}

	/**
	 * 在链表上插入一个节点
	 * @param head
	 * @param position
	 * @param value
	 * @return
	 */
	public boolean insert(linkednode head,int position,int value){
		if(position<0){
			System.out.println("位置越界");
			return false;
		}
		int count=0;
		while(head!=null){//这块解释了为什么插入位置必须从0开始，因为插入之前必须经历从头结点遍历过程，所以如果一开始插入位置不是0，那么头结点上就会出现空指针异常。
			if(count==position){//找到位置
				linkednode node=new linkednode(value);
				node.next=head.next;
				head.next=node;
				return true;
			}
			head=head.next;
			count++;
		}
		if(count!=position){
			System.out.println("位置信息错误");
		}
		return false;
	}
	/**
	 * 删除一个节点
	 * @param head
	 * @param position
	 * @return
	 */
	public static boolean delete(linkednode head,int position){
		if(position<0){
			System.out.println("位置越界");
			return false;
		}
		int count=0;
		linkednode pre=head,post=head;
		while(pre!=null){
			if(count==position){
				pre.next=post.next;
				return true;
			}
			pre=post;
			post=post.next;
			count++;
		}
		if(count!=position){
			System.out.println("位置信息错误");
		}
		return false;
	}

	/**
	 * 返回单链表的长度
	 * @param head
	 * @return
	 */
	public int getSize(linkednode head){
		int size=0;
		while(head.next!=null){
			size++;
			head=head.next;
		}
		return size;
	}
	
	public static int getElement(linkednode head,int position){
		if(position<0){
			System.out.println("位置越界");
		}
		int count=0;
		while(head!=null){
			if(count==position){
				return head.value;
			}
			head=head.next;
			count++;
		}
		if(count!=position){
			System.out.println("位置信息错误");
		}
		return 0;
	}
	/**
	 * 合并两个单链表，结果非常的漂亮
	 * @param h1
	 * @param h2
	 */
	public static void merge(linkednode h1,linkednode h2){
		
		linkednode pre,q,p;
		if(h1.next.value < h2.next.value){
			q=h1.next;
			p=h2.next;
		}else{
			q=h2.next;
			p=h1.next;
		}//这是保证让p指向的节点总是最小的，主要是为了做开头
		pre=q;
		h1=pre;//主要是找到一个链表的头
//		p=(q==h1) ? h2 : h1 ;//让p指向较大的开头
		while(p!=null && q!=null){
			while(q!=null && q.value<p.value){
				pre=q;
				q=q.next;
			}
			pre.next=p;
			pre=p;
			p=q;
			q=pre;
		}
		System.out.println("merge:");
		while(h1!=null){
			System.out.print(h1.value+"\t");
			h1=h1.next;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList ll=new LinkList();
		linkednode head=ll.new linkednode(0);
		int value=22;
		//插入测试
		boolean r1=ll.insert(head, 0, value);
		ll.insert(head, 1, 34);
		ll.insert(head, 2, 41);
		ll.insert(head, 3, 45);
		ll.insert(head, 4, 49);
		
		LinkList l2=new LinkList();
		linkednode h2=l2.new linkednode(0);
		l2.insert(h2, 0, 2);
		l2.insert(h2, 1, 55);
		l2.insert(h2, 2, 71);
		l2.insert(h2, 3, 89);
		l2.insert(h2, 4, 90);
		
		int r=ll.getSize(head);
		System.out.println("size="+r);
		System.out.println("r1="+r1);
		linkednode p=head;
		while(p!=null){
			System.out.print(p.value+"\t");
			p=p.next;
		}
		System.out.println();
		//删除测试
//		boolean r2=ll.delete(head, 1);
//		System.out.println("r2="+r2);
//		p=head;
//		while(p!=null){
//			System.out.print(p.value+"\t");
//			p=p.next;
//		}
		System.out.println();
		//测试取长度函数
		int r3=ll.getSize(head);
		System.out.println("size="+r3);
		//测试取元素方法
		int r4=ll.getElement(head, 2);
		System.out.println("r4="+r4);
		
		//测试有序插入
		ll.ascendInsert(head,33);
		linkednode p1=head;
		while(p1!=null){
			System.out.print(p1.value+"\t");
			p1=p1.next;
		}
		System.out.println();
		//测试就地逆置单链表
//		ll.sort(head);
		linkednode p2=head;
		while(p2!=null){
			System.out.print(p2.value+"\t");
			p2=p2.next;
		}
		System.out.println();
		
		//测试合并函数
		linkednode p3=h2;
		while(p3!=null){
			System.out.print(p3.value+"\t");
			p3=p3.next;
		}
		System.out.println();
		merge(head,h2);
	}

}

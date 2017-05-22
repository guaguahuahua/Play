package com.xjtu.play;

/**
 * �����ʽ�洢��ʵ�֣�������������������ĳ��ȣ���ĳ��λ�ò���Ԫ�أ�ɾ��ĳ��Ԫ�أ�ȡ��ĳ��λ�õ�Ԫ��
 * ʵ�������Ĺ�����ʹ�õ��Ǵ���ͷ���ĵ�����
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
	 * ��������͵ؽ�������
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
	 * �����������Ԫ�ر�֤Ԫ�ز��������������ġ�
	 * @param head
	 * @param element
	 */
	public void ascendInsert(linkednode head, int element){
		linkednode p=head;
		while(p!=null){
			if(p.next.value>element){//�ҵ�λ��
				linkednode node=new linkednode(element);
				node.next=p.next;
				p.next=node;
				break;
			}
			p=p.next;
		}
	}

	/**
	 * �������ϲ���һ���ڵ�
	 * @param head
	 * @param position
	 * @param value
	 * @return
	 */
	public boolean insert(linkednode head,int position,int value){
		if(position<0){
			System.out.println("λ��Խ��");
			return false;
		}
		int count=0;
		while(head!=null){//��������Ϊʲô����λ�ñ����0��ʼ����Ϊ����֮ǰ���뾭����ͷ���������̣��������һ��ʼ����λ�ò���0����ôͷ����Ͼͻ���ֿ�ָ���쳣��
			if(count==position){//�ҵ�λ��
				linkednode node=new linkednode(value);
				node.next=head.next;
				head.next=node;
				return true;
			}
			head=head.next;
			count++;
		}
		if(count!=position){
			System.out.println("λ����Ϣ����");
		}
		return false;
	}
	/**
	 * ɾ��һ���ڵ�
	 * @param head
	 * @param position
	 * @return
	 */
	public static boolean delete(linkednode head,int position){
		if(position<0){
			System.out.println("λ��Խ��");
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
			System.out.println("λ����Ϣ����");
		}
		return false;
	}

	/**
	 * ���ص�����ĳ���
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
			System.out.println("λ��Խ��");
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
			System.out.println("λ����Ϣ����");
		}
		return 0;
	}
	/**
	 * �ϲ���������������ǳ���Ư��
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
		}//���Ǳ�֤��pָ��Ľڵ�������С�ģ���Ҫ��Ϊ������ͷ
		pre=q;
		h1=pre;//��Ҫ���ҵ�һ�������ͷ
//		p=(q==h1) ? h2 : h1 ;//��pָ��ϴ�Ŀ�ͷ
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
		//�������
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
		//ɾ������
//		boolean r2=ll.delete(head, 1);
//		System.out.println("r2="+r2);
//		p=head;
//		while(p!=null){
//			System.out.print(p.value+"\t");
//			p=p.next;
//		}
		System.out.println();
		//����ȡ���Ⱥ���
		int r3=ll.getSize(head);
		System.out.println("size="+r3);
		//����ȡԪ�ط���
		int r4=ll.getElement(head, 2);
		System.out.println("r4="+r4);
		
		//�����������
		ll.ascendInsert(head,33);
		linkednode p1=head;
		while(p1!=null){
			System.out.print(p1.value+"\t");
			p1=p1.next;
		}
		System.out.println();
		//���Ծ͵����õ�����
//		ll.sort(head);
		linkednode p2=head;
		while(p2!=null){
			System.out.print(p2.value+"\t");
			p2=p2.next;
		}
		System.out.println();
		
		//���Ժϲ�����
		linkednode p3=h2;
		while(p3!=null){
			System.out.print(p3.value+"\t");
			p3=p3.next;
		}
		System.out.println();
		merge(head,h2);
	}

}

package com.xjtu.structure;

/**
 * ����������е�����k��Ԫ��
 * @author 22847
 *
 */
public class PrintKthElement {

	/**
	 * ����ָ��ֱ𱣳�k����࣬���Ҳ��ָ�뵽�������ĩβ��ʱ������ָ��ָ���˵�����k��Ԫ��
	 * @param head
	 * @param k
	 * @return
	 */
	public static Linkednode printKthElement(Linkednode head, int k){
		
		Linkednode left=head;
		Linkednode right=head;
		//�Ҳ�ָ������k����λ����
		while(right!=null && k>0){
			right=right.next;
			k--;
		}
		//�ж�����k�Ƿ��Ѿ�Ϊ0
		if(k!=0){
			System.out.println("����kԽ�磡");			
			return null;
		}
		while(right!=null){
			left=left.next;
			right=right.next;
		}
		return left;
	} 

	/**
	 * 2�α�������һ�α����õ�����ĳ��ȣ����������Ҫ�����Ĵ���delta���ڶ��α���delta����õ�k��Ԫ��
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
			System.out.println("����kԽ��");			
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

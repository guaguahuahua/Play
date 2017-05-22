package com.xjtu.play;

import com.xjtu.structure.Linkednode;

public class JohnsefuRing {
	/**
	 * ����һ���ڵ㣬��Ȼ��ѭ�����������ǿ��Բ���ͳһ�������
	 * ����ͷ�巨����ΪԼɪ�򻷻�ʹ�õ���ѭ����������ͷ�巨������
	 * @param head
	 * @param value
	 */
	public static void insert(Linkednode head,int value){
		Linkednode node =new Linkednode(value);//�ȴ���һ���ڵ�
		node.next=head.next;
		head.next=node;
	}
	/**
	 * ��ʼ�������������һ���ڵ��ָ��ָ��ͷ���
	 */
	public static void initial(Linkednode head){
		head.next=head;
	}
	/**
	 * �ú�����Ҫ��Ϊ��ʵ��Լɪ�򻷵���Ҫ���ܣ�Ҳ���Ǹ��ݽڵ���ֵ������ѭ������֮��ɾ��ĳ���ڵ�
	 * �㷨˼�룬˫��forѭ�����ڲ�ѭ��Ϊ�˴ﵽ��ֵm�����ѭ����Ҫ��Ϊ�˱�֤�ڵ�����ֻʣ��һ��
	 * @param head
	 */
	public static void realize(Linkednode head,int random){
		int count=1;
		int value=random;
		Linkednode curr=head;
		Linkednode pre=curr;
		while(curr.next!=curr){//ɾ����һֱ����ֱ����ʣ��һ���ڵ�Ϊֹ
			
			while(count!=value){//��������λ�õĽڵ�
				pre=curr;
				curr=curr.next;
				count++;
			}
			//ɾ���ýڵ�
			value=curr.value;//ȡ�����е�ֵ
			System.out.print(value+"\t");
			pre.next=curr.next;//ɾ���ýڵ�
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
		//�������
		Linkednode head=new Linkednode(3);
		JohnsefuRing.initial(head);
		JohnsefuRing.insert(head, 4);
		JohnsefuRing.insert(head, 8);
		JohnsefuRing.insert(head, 4);
		JohnsefuRing.insert(head, 2);
		JohnsefuRing.insert(head, 7);
		JohnsefuRing.insert(head, 1);		
		
		//������е�Ԫ��
		JohnsefuRing.show(head);
		//����Լɪ��ʵ�ֺ���
		JohnsefuRing.realize(head, 5);
	}

}

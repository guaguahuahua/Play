package com.xjtu.structure;

public class LSNode {
	int value;
	LSNode next;
	static int size; 
	/**
	 * ���캯��������½ڵ��ʱ����ڳ�ʼ���Ĺ���
	 * @param value
	 */
	public LSNode(int value){
		this.value=value;
	}
	/**
	 * �ж϶�ջ�Ƿ�Ϊ��
	 * @param head
	 * @return
	 */
	public static boolean isEmpty(LSNode head){
		if(head.next==null){
			System.out.println("��ջ�ǿյ�");
			return false;
		}else{
			return true;
		}
	}
	/**
	 * ��ջ��ʹ�õ���ͷ�巨���������Ա�֤��С�Ĳ��Ҵ���
	 * @param head ͷ�ڵ�
	 * @param value ����ڵ��ֵ
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
	 * ��ջ
	 * @param head
	 * @return ���س�ջ��Ԫ��
	 */
	public static int stackPop(LSNode head){
		if(head.next==null){
			System.out.println("��ջ�ѿ�");
			return 0;
		}
		int value=head.next.value;//ȡ������Ԫ��
		head.next=head.next.next;//ɾ���ýڵ�
		size--;
		return value;
	}
	/**
	 * ȡջ��Ԫ��
	 * @param head
	 * @return
	 */
	public static int getTop(LSNode head){
		if(head.next==null){
			System.out.println("��ջ�ѿ�");
			return 0;
		}
		return head.next.value;
	}
	public static int getSize(LSNode head){
		return size;
	}
}

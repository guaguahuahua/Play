package com.xjtu.structure;

public class LQueue {
	LQNode front;
	LQNode rear;
	int size;//�����������еĳ���
	
	/**
	 * �ж���ʽ�����Ƿ�Ϊ��
	 * @param lqueue
	 * @return
	 */
	public static boolean isEmpty(LQueue lqueue){
		if(lqueue.front==null){//�����ͷָ��Ϊ�գ���ô����Ϊ��
			return true;
		}else{
			return false;
		}
	}
	/**
	 * ��ʽ���е����
	 * @param lqueue
	 * @param value
	 * @return
	 */
	public static boolean append(LQueue lqueue,int value){
		
		LQNode node=new LQNode(value);//�Ƚ����Ԫ�ط��뵽һ���ڵ���
		if(lqueue.front==null){//�����ͷΪ�գ���ôֱ�ӽ���Ԫ�ط����ڶ�ͷ����
			lqueue.front=node;//ֱ��������ָ��ýڵ�
			lqueue.rear=node;
		}
		//�����������������һ��Ԫ�ص�ʱ��
		node.next=lqueue.rear.next;//��ʵ���п��ޣ���Ϊ��java��ĳ�Ա�������Զ��ĳ�ʼ�����������ͻ��Զ��ĳ�ʼ��Ϊnull
		lqueue.rear.next=node;//����Ԫ����ӽ�����
		lqueue.rear=node;//�ö��е�βָ��������²����Ԫ��֮��
		lqueue.size++;
		return false;
	}
	/**
	 * ɾ����ͷԪ�أ�����
	 * @param lqueue
	 * @return
	 */
	public static int delete(LQueue lqueue){
		
		if(lqueue.front==null){
			System.out.println("�����ѿ�");
			return 0;
		}
		int tmp=lqueue.front.value;//���Ȼ�ö�ͷָ���ֵ;
		if(lqueue.front==lqueue.rear){//���������ֻ��һ��Ԫ��
			lqueue.front=lqueue.rear=null;
		}else{//����������������Ԫ��
			lqueue.front=lqueue.front.next;//����ͷָ�����
		}	
		lqueue.size--;
		return tmp;
	}
	/**
	 * ��ȡ��ͷԪ��
	 * @param lqueue
	 * @return
	 */
	public static int getTop(LQueue lqueue){
		
		if(lqueue.front==null){
			System.out.println("�����ѿ�");
			return 0;
		}
		int tmp=lqueue.front.value;//��ö�ͷԪ�ص�ֵ
		return tmp;
	}
	public static int getSize(LQueue lqueue){
		return lqueue.size;
	}
}


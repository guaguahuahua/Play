package com.xjtu.structure;
/**
 * ˳��ѭ�����еĽṹ�ͺ�����ʹ�õ��Ǽ�������ʵ��ѭ������
 * @author 22847
 *
 */
public class SeqCQueue {
	private static int N=10;
	int []elements=new int[N];
	int front;//ͷָ���λ��
	int rear;//βָ��λ��
	int count;//ͳ�ƶ����е�Ԫ�ظ���
	
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @param queue
	 * @return
	 */
	public static boolean isEmpty(SeqCQueue queue){
		if(queue.count==0){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * ���
	 * @param queue
	 * @param value
	 * @return
	 */
	public static boolean append(SeqCQueue queue,int value){
		if(queue.count==N){//��������
			System.out.println("��������");
			return false;
		}
		queue.elements[queue.rear]=value;//��Ԫ�ز��뵽���е�ĩβ
		queue.rear=(queue.rear+1)%N;//����Ϊ�˱�֤˳��ѭ�����з�ֹ�����
		queue.count++;
		return true;
	}
	/**
	 * ����
	 * @param queue
	 * @return  //���س��ӵ�Ԫ��
	 */
	public static int delete(SeqCQueue queue){
		if(queue.count==0){
			System.out.println("�����ѿ�");
			return 0;
		}
		int tmp=queue.elements[queue.front];//ȡ��ͷԪ��
		queue.front=(queue.front+1)%N;//��ͷָ������ƶ�
		queue.count--;
		return tmp;
	}
	/**
	 * ȡ��ͷԪ��
	 * @param queue
	 * @return
	 */
	public static int getFront(SeqCQueue queue){
		if(queue.count==0){
			System.out.println("�����ѿ�");
			return 0;
		}
		int tmp=queue.elements[queue.front];
		return tmp;
	}
	/**
	 * ����һ�����еĳ���
	 * @param queue
	 * @return
	 */
	public static int getSize(SeqCQueue queue){
		return queue.count;
	}
	
}
